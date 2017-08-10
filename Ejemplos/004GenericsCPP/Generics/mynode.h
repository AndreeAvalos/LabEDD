#ifndef MYNODE_H
#define MYNODE_H
/*
 * Clase nodo tipada con el typename T
 *
 */
template <typename T> //Definicion del tipo generico T (template en C++)
class MyNode {
public:

    /*
     * Constructor de la clase MyNode
     */
    MyNode(T val) {
        this->val = val;
        this->next = nullptr;
    }

    /*
     * Metodo para obtener el valor del nodo
     */
    T getVal() {
        return this->val;
    }

    // Apuntador al siguiente nodo
    MyNode *next;

private:
    // Valor
    T val;

};

#endif // MYNODE_H
