package sergiojimenezr.aoc2022.day2;

import java.io.FileNotFoundException;

import java.util.Arrays;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lista = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day2/input.txt");

		List<String> listJugadas = Arrays.asList("ZXY", "XYZ", "YZX");

		int sumatorio = 0;

		for (String strJugada : lista) {
			char eleccionOponente = strJugada.charAt(0);
			char miEleccion = strJugada.charAt(2);
			String planteamiento = listJugadas.get(eleccionOponente - 'A');
			sumatorio += planteamiento.indexOf(miEleccion) * 3;
			sumatorio += miEleccion - 'X' + 1;
		}
		Printer.printAndFinish(sumatorio);

	}

}
