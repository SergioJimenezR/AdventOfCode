package sergiojimenezr.utilities.utils;

public final class Printer {

	private Printer() {
	}

	public static void print(String s) {
		System.out.print(s);
	}

	public static void println(String s) {
		print(s + "\n");
	}

	public static void println(int i) {
		print(i + "\n");
	}

	public static void imprimirMatriz(char[][] pantalla) {
		for (int fila = 0; fila < pantalla.length; fila++) {
			for (int columna = 0; columna < pantalla[0].length; columna++)
				print(pantalla[fila][columna] + "");
			print("\n");
		}
	}

}
