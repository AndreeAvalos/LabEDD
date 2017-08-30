class ArbolBinario implements Arbolito {
	
	Nodo raiz;

	ArbolBinario() {
		raiz = null;
	}

	public static void main(String[] args) {
		ArbolBinario arbol = new ArbolBinario();
		arbol.insertar(50);
		arbol.insertar(10);
		arbol.insertar(98);
		arbol.insertar(90);
		arbol.insertar(23);
		System.out.println("InOrden:");
		arbol.inOrden();
		System.out.println("PreOrden:");
		arbol.preOrden();
		System.out.println("PostOrden:");
		arbol.postOrden();
	}

	/* Aquí va la implementación de los métodos de la interface, pueden definir métodos adicionales. */

}

class Nodo {
	int valor;
	Nodo izq;
	Nodo der;

	Nodo(int valor){
		this.valor = valor;
		izq = null;
		der = null;
	}
}


interface Arbolito {

	void insertar(int nuevo);

	void inOrden();

	void preOrden();

	void postOrden();
	
}