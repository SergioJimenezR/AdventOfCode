package sergiojimenezr.aoc2022.day09;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte2 {

	public static void main(String[] args) throws IOException {

		int[] h = new int[2];
		int[][] nudos = new int[9][2];
		Set<String> pasos = new HashSet<>();

		for (String comando : Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day09/input.txt")) {
			String[] partes = comando.split(" ");
			char direccion = partes[0].charAt(0);
			int movs = Integer.parseInt(partes[1]);

			for (int i = 0; i < movs; i++) {
				MainParte1.moverH(h, direccion);
				moverNudos(h, nudos);
				pasos.add(nudos[8][0] + "-" + nudos[8][1]);
			}
		}
		Printer.println(pasos.size());
	}

	/*
	 * El enunciado solamente viene a querer decir que los nudos se muevan (en
	 * orden) solamente si necesitan moverse (teniendo en cuenta sus posiciones
	 * anteriores) para acercarse (para seguir respetando la cercanía del i e i+1)
	 * tras haberse movido el primero.
	 */
	public static void moverNudos(int[] h, int[][] nudos) {
		MainParte1.acercarseConRespectoA(nudos[0], h);
		for (int i = 1; i < 9; i++)
			MainParte1.acercarseConRespectoA(nudos[i], nudos[i - 1]); // Segundo nudo con respecto al primero.
	}

}