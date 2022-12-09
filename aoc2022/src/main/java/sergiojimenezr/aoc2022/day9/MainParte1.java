package sergiojimenezr.aoc2022.day9;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		int[] h = new int[] { 147, 45 };
		int[] t = new int[] { 147, 45 };
		char[][] matriz = new char[205][227];
		Set<String> pasos = new HashSet<>();

		for (String comando : Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day9/input.txt")) {
			String[] partes = comando.split(" ");
			char direccion = partes[0].charAt(0);
			int movs = Integer.parseInt(partes[1]);

			for (int mov = 0; mov < movs; mov++) {
				moverH(direccion, h);
				if (!estanCerca(h, t)) {
					moverT(direccion, h, t);
					pasos.add(t[0] + "-" + t[1]);
					matriz[t[0]][t[1]] = 'X';
				}
			}
		}
		Printer.print(pasos.size());
	}

	private static void moverH(char direccion, int[] h) {
		switch (direccion) {
		case 'U':
			h[0]--;
			break;
		case 'D':
			h[0]++;
			break;
		case 'L':
			h[1]--;
			break;
		default: // R
			h[1]++;
		}
	}

	private static void moverT(char direccion, int[] h, int[] t) {
		switch (direccion) {
		case 'U':
			t[0] = h[0] + 1;
			t[1] = h[1];
			break;
		case 'D':
			t[0] = h[0] - 1;
			t[1] = h[1];
			break;
		case 'L':
			t[0] = h[0];
			t[1] = h[1] + 1;
			break;
		default: // R
			t[0] = h[0];
			t[1] = h[1] - 1;
		}
	}

	private static boolean estanCerca(int[] h, int[] t) {
		return Math.abs(h[0] - t[0]) <= 1 && Math.abs(h[1] - t[1]) <= 1;
	}
}
