class abstract NodoOrtogonal {
	NodoOrtogonal arriba;
	NodoOrtogonal abajo;
	NodoOrtogonal izq;
	NodoOrtogonal der;

	NodoOrtogonal() {
		this.arriba = null;
		this.abajo = null;
		this.izq = null;
		this.der = null;
	}
	
}