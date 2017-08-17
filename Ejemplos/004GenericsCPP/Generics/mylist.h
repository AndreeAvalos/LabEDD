#ifndef MYLIST_H
#define MYLIST_H
#include <QtDebug>
#include "mynode.h"

/*
 * Lista simplemente enlazada que utiliza tipos genericos (llamados template),
 * utiliza dos atributos para tener el inicio y el contador de elementos y cuenta
 * con tres metodos.
 *
 * MyList() esta lista cuenta con un constructor
 * add(T val) un metodo para agregar nuevos elementos
 * print() un metodo para recorrer la lista e imprimir sus valores en consola.
 *
 * IMPORTANTE: La clase MyNode tambien esta "tipada" con el typename T.
 */


template <typename T> //Definicion del tipo generico T (template en C++)
class MyList
{
public:

    /*
     * Constructor de la clase MyList
     */
    MyList() {
        first = nullptr;
        size = 0;
    }

    /*
     * Inserta un nuevo nodo al inicio de la lista
     */
    void add(T val) {
        MyNode<T> *theNew = new MyNode<T>(val);
        if(first==nullptr){
            qInfo() << "Primer elemento de la lista";
            first = theNew;
            size++;
            return;
        }

        //Actualmente solo hay un elemento en la lista
        if(first->next == nullptr) {
            //Se compara el valor nuevo a insertar contra el unico valor que existe en la lista
            int comparison = val.compare(first->getVal());

            //Si el valor nuevo es mayor que el unico valor de la lista,
            //insertar despues del primero, en otras palabras INSERTAR AL FINAL
            if(comparison > 0) {
                qInfo() << "Insertar directamente al final";
                first->next = theNew;
                size++;
                return;
            }

            //Si el valor nuevo es menor que el unico valor de la lista,
            //insertar antes del primero, en otras palabras INSERTAR AL INICIO
            if(comparison < 0) {
                qInfo() << "Insertar directamente al inicio";
                theNew->next = first;
                first = theNew;
                size++;
                return;
            }

            //Si no es mayor, ni tampoco es menor, entonces los elementos son iguales...
            qInfo() << "Elemento repetido";
            return;
        }

        //Nodo auxiliar para recorrer la lista, se busca el punto de insercion correcto
        //Como la lista esta ordenada la nueva insercion tiene que ser justo antes del
        //primer elemento que sea "menor" que el valor nuevo.
        MyNode<T> *aux = first;
        MyNode<T> *ant = nullptr;
        while(aux->next != nullptr){
            int comparison = val.compare(aux->getVal());

            //Es necesario evaluar el siguiente elemento
            if(comparison > 0) {
                ant = aux;
                aux = aux->next;
                continue;
            }

            //El nuevo elemento va entre el elemento apuntado por ANT y AUX
            if(comparison < 0) {
                if(ant==nullptr) {
                    qInfo() << "Insertando al inicio, antes de: " << aux->getVal().toString();
                    theNew->next = first;
                    first = theNew;
                } else {
                    qInfo() << "Insertando entre: " << ant->getVal().toString() << " y " << aux->getVal().toString();
                    ant->next = theNew;
                    theNew->next = aux;
                }
                size++;
                return;
            }

            qInfo() << "Elemento repetido";
            return;
        }

        qInfo() << "Insertado al final";
        aux->next = theNew;
        size++;
    }

    /*
     * Recorre la lista, imprimiendo sus valores en consola
     */
    void print() {
        MyNode<T> *aux = first;
        while (aux != nullptr) {
            qInfo() << aux->getVal().toString();
            aux = aux->next;
        }
    }

private:
    MyNode<T> *first;
    int size;
};

#endif // MYLIST_H
