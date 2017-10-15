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
		arbol.insertar(75);
		arbol.insertar(60);
		arbol.insertar(88);
		arbol.insertar(73);
		arbol.insertar(20);
		arbol.insertar(30);
		arbol.insertar(51);
		arbol.insertar(41);
		arbol.insertar(12);
		arbol.insertar(45);
		System.out.println("InOrden:");
		arbol.inOrden();
		System.out.println("PreOrden:");
		arbol.preOrden();
		System.out.println("PostOrden:");
		arbol.postOrden();
	}

	public void insertar(int nuevo) {
		if(raiz == null){
			raiz = new Nodo(nuevo);
			return;			
		}
		insertar(raiz, nuevo);
	}

	private void insertar(Nodo pivote, int nuevo) {
		if(nuevo > pivote.valor) {
			if(pivote.der == null)
				pivote.der = new Nodo(nuevo);
			else
				insertar(pivote.der, nuevo);
			return;
		}
		if(nuevo < pivote.valor) {
			if(pivote.izq == null)
				pivote.izq = new Nodo(nuevo);
			else
				insertar(pivote.izq, nuevo);
			return;
		}
		System.out.println("Nodo repetido: " + nuevo);
	}

	public void inOrden() {
		inOrden(raiz);
	}

	private void inOrden(Nodo pivote) {
		if(pivote==null)
			return;
		inOrden(pivote.izq);
		System.out.println("\t" + pivote.valor);
		inOrden(pivote.der);
	}

	public void preOrden() {
		preOrden(raiz);
	}

	private void preOrden(Nodo pivote) {
		if(pivote==null)
			return;
		System.out.println("\t" + pivote.valor);
		preOrden(pivote.izq);
		preOrden(pivote.der);
	}

	public void postOrden() {
		postOrden(raiz);
	}

	private void postOrden(Nodo pivote) {
		if(pivote==null)
			return;
		postOrden(pivote.izq);
		postOrden(pivote.der);
		System.out.println("\t" + pivote.valor);
	}


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