public class ArrayTest {

	public static void main(String[] args) {
		arregloInstanciado();
		arregloIniciado();
		matriz();
		matrizCubicaIrregular();
	}

	private static void matrizCubicaIrregular() {
		//Una matriz irregular
		double[][][] decMatrix = {
			{
				{5.8, 2.9, 3.4},
				{3.14},
				{1, 2.5, 1, 0.5}
			},{
				{3.2, 3.2},
				{5.4, 2.0, 1, 2.4, 2.5},
				{1.0, 2.0, 3.0, 3.4}
			}
		};
		for (int i = 0; i < decMatrix.length; i++) {
			System.out.println(i + " => [");
			for (int j = 0; j < decMatrix[i].length; j++ ) {
				System.out.print("\t" + j + " => [ ");
				for(int k = 0; k < decMatrix[i][j].length; k ++){
					System.out.print(String.format("%.2f ", decMatrix[i][j][k]));
				}
				System.out.println("]");
			}
			System.out.println("]");
		}		
	}

	private static void matriz() {
		//Una matriz
		int[][] intMatrix = {
			{-3, 21, 30, 55},
			{20, 51, 41, 19},
			{13, -5, 14, 34}
		};
		for (int i = 0; i < intMatrix.length; i++) {
			System.out.print(i + " => [ ");
			for (int j = 0; j < intMatrix[i].length; j++ ) {
				System.out.print(intMatrix[i][j] + " ");
			}
			System.out.println("]");
		}
	}

	private static void arregloIniciado() {
		//Un arreglo, inicializado
		String[] strArray = {"Kardia", "Albafica", "Sísifo", "Regulus"};
		for(String str : strArray) {
			System.out.println("[n.n] " + str);
		}
	}

	private static void arregloInstanciado() {
		//Un arreglo, instanciado
		int[] intArray = new int[5];
		for (int i = 0; i < intArray.length; i++) {
			System.out.println("intArray["+i+"]="+intArray[i]);
		}
	}
	
}