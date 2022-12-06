package sergiojimenezr.aoc2021.day25;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;

public class MainParte1 {

	static String[] historial = null;
	static List<int[]> cambios = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {

		char[][] matriz = montarMatriz(
				Lector.leerArchivo("../aoc2021/src/main/java/sergiojimenezr/aoc2021/day25/input.txt"));
		imprimirMatriz(matriz, 0, 0);
		prepararHistorial(matriz, 0);

		for (int etapa = 1; true; etapa++) {
			int movs = desplazamientosDrcha(matriz) + desplazamientosAbajo(matriz);

			imprimirMatriz(matriz, etapa, movs);
			prepararHistorial(matriz, etapa);

			if (movs == 0)
				break;
		}
		for (String s : historial)
			System.out.println(s);

	}

	private static int desplazamientosDrcha(char[][] matriz) {
		cambios.clear();
		for (int f = 0; f < matriz.length; f++)
			for (int c = 0; c < matriz[0].length; c++)
				if (matriz[f][c] == '>' && matriz[f][(c + 1) % matriz[0].length] == '.')
					cambios.add(new int[] { f, c });
		for (int[] fc : cambios) {
			matriz[fc[0]][(fc[1] + 1) % matriz[0].length] = '>';
			matriz[fc[0]][fc[1]] = '.';
		}
		return cambios.size();
	}

	private static int desplazamientosAbajo(char[][] matriz) {
		cambios.clear();
		for (int f = 0; f < matriz.length; f++)
			for (int c = 0; c < matriz[0].length; c++)
				if (matriz[f][c] == 'v' && matriz[(f + 1) % matriz.length][c] == '.')
					cambios.add(new int[] { f, c });
		for (int[] fc : cambios) {
			matriz[(fc[0] + 1) % matriz.length][fc[1]] = 'v';
			matriz[fc[0]][fc[1]] = '.';
		}
		return cambios.size();
	}

	private static char[][] montarMatriz(List<String> lineas) {
		char[][] matriz = new char[lineas.size()][lineas.get(0).length()];
		historial = new String[matriz.length + 1];
		for (int f = 0; f < matriz.length; f++) {
			historial[f] = "";
			for (int c = 0; c < matriz[0].length; c++)
				matriz[f][c] = lineas.get(f).charAt(c);
		}
		historial[historial.length - 1] = "";
		return matriz;
	}

	private static void prepararHistorial(char[][] matriz, int etapa) {
		historial[0] += etapa + "\t";
		for (int i = 0; i < matriz[0].length - 1; i++)
			historial[0] += " ";

		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[0].length; c++)
				historial[f + 1] += matriz[f][c];
			historial[f + 1] += "\t";
		}
	}

	private static void imprimirMatriz(char[][] matriz, int etapa, int movs) {
		StringBuilder str = new StringBuilder("Etapa: " + etapa + "\n");
		for (int f = 0; f < matriz.length; f++) {
			for (int c = 0; c < matriz[0].length; c++)
				str.append(matriz[f][c]);
			str.append("\n");
		}
		str.append(movs + " movs.\n");
		System.out.println(str);
	}

}
