package sergiojimenezr.aoc2022.day9;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import sergiojimenezr.utilities.utils.Lector;

public class MainParte1 {

	static final int TAM_FILAS = 10000;
	static final int TAM_COLUMNAS = 10000;

	static Integer[] coordsH = new Integer[] { 5000, 5000 };
	static Integer[] coordsT = new Integer[] { 5000, 5000 };
	static Map<Integer[], Integer> posicionesT = new HashMap<>();

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lineas = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day9/input.txt");

		for (String comando : lineas) {
			System.out.println("\n" + comando);
			String[] partes = comando.split(" ");
			char direccion = partes[0].charAt(0);
			for (int mov = 1; mov <= Integer.parseInt(partes[1]); mov++) {
				moverH(direccion);
				moverT(direccion);
				//dibujarMatriz();
				posicionesT.putIfAbsent(coordsT, 0);
			}
		}
		System.out.println(posicionesT.keySet().size());
		dibujarMatriz(new ArrayList<>(posicionesT.keySet()));
	}

	private static void dibujarMatriz(List<Integer[]> keySet) {
		char[][] grid = new char[TAM_FILAS][TAM_COLUMNAS];
		for (Integer[] coords : keySet) {
			grid[coords[0]][coords[1]] = 'X';
		}
		int contador = 0;
		for (char[] fila : grid) {
			for (char c : fila) {
				if (c == 'X')
					contador++;
			}
		}
		System.out.println(contador);
	}

	private static void moverH(char direccion) {
		switch (direccion) {
		case 'U':
			coordsH[0]--;
			break;
		case 'D':
			coordsH[0]++;
			break;
		case 'L':
			coordsH[1]--;
			break;
		default: // R
			coordsH[1]++;
		}
	}

	private static void moverT(char direccion) {
		if (!estanCerca())
			switch (direccion) {
			case 'U':
				coordsT = new Integer[] { coordsH[0] + 1, coordsH[1] };
				break;
			case 'D':
				coordsT = new Integer[] { coordsH[0] - 1, coordsH[1] };
				break;
			case 'L':
				coordsT = new Integer[] { coordsH[0], coordsH[1] + 1 };
				break;
			default: // R
				coordsT = new Integer[] { coordsH[0], coordsH[1] - 1 };
			}

	}

	private static void dibujarMatriz() {
		char[][] matriz = new char[TAM_FILAS][TAM_COLUMNAS];
		matriz[coordsH[0]][coordsH[1]] = 'H';
		matriz[coordsT[0]][coordsT[1]] = 'T';
		for (char[] linea : matriz) {
			for (char posicion : linea)
				if (posicion == 'H')
					System.out.print("H ");
				else if (posicion == 'T')
					System.out.print("T ");
				else
					System.out.print(". ");
			System.out.println();
		}
		System.out.println();
	}

	private static boolean estanCerca() {
		return coordsH[0] - 1 <= coordsT[0] && coordsT[0] <= coordsH[0] + 1 && coordsH[1] - 1 <= coordsT[1]
				&& coordsT[1] <= coordsH[1] + 1;
	}

}
