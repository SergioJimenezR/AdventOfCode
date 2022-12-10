package sergiojimenezr.aoc2022.day10;

import java.io.FileNotFoundException;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte2 {

	public static void main(String[] args) throws FileNotFoundException {
		Printer.imprimirMatriz(dibujarPantalla(MainParte1.calcularValoresSegunCiclos(
				Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day10/input.txt"))));
	}

	private static char[][] dibujarPantalla(List<Integer> valores) {
		char[][] pantalla = new char[6][40];
		for (int f = 0; f < pantalla.length; f++)
			for (int c = 0; c < pantalla[0].length; c++)
				if (Math.abs(valores.get(40 * f + c) - c) <= 1)
					pantalla[f][c] = '#';
				else
					pantalla[f][c] = '.';
		return pantalla;
	}

}
