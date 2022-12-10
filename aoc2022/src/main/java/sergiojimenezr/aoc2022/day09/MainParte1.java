package sergiojimenezr.aoc2022.day09;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		int[] h = new int[2];
		int[] t = h.clone();
		Set<String> pasos = new HashSet<>();

		for (String comando : Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day09/input.txt")) {
			String[] partes = comando.split(" ");
			char direccion = partes[0].charAt(0);
			int movs = Integer.parseInt(partes[1]);

			for (int mov = 0; mov < movs; mov++) {
				moverH(h, direccion);
				acercarseConRespectoA(t, h);
				pasos.add(t[0] + "-" + t[1]);
			}
		}
		Printer.print(pasos.size());
	}

	public static void moverH(int[] h, char direccion) {
		/*
		 * Criterio vigente: [Fila, Columna].
		 * 
		 * El programa queda adaptado para que si se desea modificar el criterio, se
		 * tenga que cambiar solamente aquí.
		 */
		switch (direccion) {
		case 'U': // Arriba
			h[0]--;
			break;
		case 'D': // Abajo
			h[0]++;
			break;
		case 'L': // Izquierda
			h[1]--;
			break;
		default: // Derecha
			h[1]++;
		}
	}

	public static void acercarseConRespectoA(int[] t, int[] h) {
		if (!estanCerca(h, t)) {
			if (h[0] > t[0])
				t[0]++;
			else if (h[0] < t[0])
				t[0]--;

			if (h[1] > t[1])
				t[1]++;
			else if (h[1] < t[1])
				t[1]--;
		}
	}

	private static boolean estanCerca(int[] h, int[] t) {
		return Math.abs(h[0] - t[0]) <= 1 && Math.abs(h[1] - t[1]) <= 1;
	}
}
