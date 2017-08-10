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
        if(first==nullptr)
            first = theNew;
        else{
            theNew->next = first;
            first = theNew;
        }
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
