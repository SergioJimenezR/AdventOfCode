package sergiojimenezr.aoc2021.day25;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {
		List<String> lineas = Lector.leerArchivo("../aoc2021/src/main/java/sergiojimenezr/aoc2021/day25/input.txt");
		char[][] matriz = new char[lineas.size()][lineas.get(0).length()];
		for (int f = 0; f < matriz.length; f++)
			for (int c = 0; c < matriz[0].length; c++)
				matriz[f][c] = lineas.get(f).charAt(c);

		for (int etapa = 1; true; etapa++)
			if (desplazamientosDrcha(matriz) + desplazamientosAbajo(matriz) == 0) {
				System.out.println(etapa);
				break;
			}
	}

	private static int desplazamientosDrcha(char[][] matriz) {
		List<int[]> cambios = new ArrayList<>();
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
		List<int[]> cambios = new ArrayList<>();
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
}
