package sergiojimenezr.aoc2022.day08;

import java.io.FileNotFoundException;

import sergiojimenezr.utilities.utils.Converter;
import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {
		int[][] bosque = Converter.convertStringMatrixToIntegerMatrix(
				Lector.leerMatriz("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day8/input.txt", ""));

		int contador = 2 * (bosque.length + bosque[0].length) - 4;
		for (int f = 1; f < bosque.length - 1; f++)
			for (int c = 1; c < bosque[0].length - 1; c++)
				if (visibleDesdeArriba(f, c, bosque) || visibleDesdeAbajo(f, c, bosque)
						|| visibleDesdeIzquierda(f, c, bosque) || visibleDesdeDerecha(f, c, bosque))
					contador++;
		Printer.print(contador);
	}

	private static boolean visibleDesdeArriba(int f, int c, int[][] bosque) {
		for (int i = f - 1; i >= 0; i--)
			if (bosque[i][c] >= bosque[f][c])
				return false;
		return true;
	}

	private static boolean visibleDesdeAbajo(int f, int c, int[][] bosque) {
		for (int i = f + 1; i < bosque.length; i++)
			if (bosque[i][c] >= bosque[f][c])
				return false;
		return true;
	}

	private static boolean visibleDesdeIzquierda(int f, int c, int[][] bosque) {
		for (int j = c - 1; j >= 0; j--)
			if (bosque[f][j] >= bosque[f][c])
				return false;
		return true;
	}

	private static boolean visibleDesdeDerecha(int f, int c, int[][] bosque) {
		for (int j = c + 1; j < bosque[0].length; j++)
			if (bosque[f][j] >= bosque[f][c])
				return false;
		return true;
	}

}
