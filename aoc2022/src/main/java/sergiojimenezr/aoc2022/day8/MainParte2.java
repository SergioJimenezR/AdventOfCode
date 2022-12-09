package sergiojimenezr.aoc2022.day8;

import java.io.FileNotFoundException;

import sergiojimenezr.utilities.utils.Converter;
import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte2 {

	public static void main(String[] args) throws FileNotFoundException {
		int[][] bosque = Converter.convertStringMatrixToIntegerMatrix(
				Lector.leerMatriz("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day8/input.txt", ""));

		int puntuacionMaxima = 0;
		for (int f = 1; f < bosque.length - 1; f++)
			for (int c = 1; c < bosque[0].length - 1; c++) {
				int puntuacion = puntuacionHaciaArriba(f, c, bosque) * puntuacionHaciaAbajo(f, c, bosque)
						* puntuacionHaciaIzquierda(f, c, bosque) * puntuacionHaciaDerecha(f, c, bosque);
				if (puntuacion > puntuacionMaxima)
					puntuacionMaxima = puntuacion;
			}
		Printer.print(puntuacionMaxima);
	}

	private static int puntuacionHaciaArriba(int f, int c, int[][] bosque) {
		int contador = 0;
		for (int i = f - 1; i >= 0; i--)
			if (bosque[i][c] < bosque[f][c])
				contador++;
			else {
				contador++;
				break;
			}
		return contador;
	}

	private static int puntuacionHaciaAbajo(int f, int c, int[][] bosque) {
		int contador = 0;
		for (int i = f + 1; i < bosque.length; i++)
			if (bosque[i][c] < bosque[f][c])
				contador++;
			else {
				contador++;
				break;
			}
		return contador;
	}

	private static int puntuacionHaciaIzquierda(int f, int c, int[][] bosque) {
		int contador = 0;
		for (int j = c - 1; j >= 0; j--)
			if (bosque[f][j] < bosque[f][c])
				contador++;
			else {
				contador++;
				break;
			}
		return contador;
	}

	private static int puntuacionHaciaDerecha(int f, int c, int[][] bosque) {
		int contador = 0;
		for (int j = c + 1; j < bosque[0].length; j++)
			if (bosque[f][j] < bosque[f][c])
				contador++;
			else {
				contador++;
				break;
			}
		return contador;
	}

}
