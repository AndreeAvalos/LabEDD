class ListaDoble <T extends NodoListaDoble> {
	private T ini;
	private T fin;
	private int contador;

	ListaDoble() {
		ini = null;
		fin = null;
		contador = 0;
	}

	public void agrear(T val) {
		if(ini==null) {
			ini = fin = val;
			contador++;
			return;
		}
		fin.sig = val;
		val.ant = fin;
		fin = val;
	}

	public void recorrer() {
		T aux = ini;
		while(aux != null) {
			System.out.println(">>> " + aux.toString());
			aux = aux.sig;
		}
	}

	public static void main(String[] args) {
		
	}
	
}