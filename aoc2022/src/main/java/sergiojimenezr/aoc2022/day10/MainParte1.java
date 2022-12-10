package sergiojimenezr.aoc2022.day10;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {
		Printer.println(medirSignalStrength(calcularValoresSegunCiclos(
				Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day10/input.txt"))));
	}

	public static List<Integer> calcularValoresSegunCiclos(List<String> comandos) {
		int x = 1;
		List<Integer> valoresX = new ArrayList<>();
		for (String comando : comandos)
			if (comando.equals("noop"))
				valoresX.add(x);
			else {
				valoresX.add(x);
				valoresX.add(x);
				x += Integer.parseInt(comando.split(" ")[1]);
			}
		return valoresX;
	}

	private static int medirSignalStrength(List<Integer> valoresX) {
		int signalStrength = 0;
		for (int i = 19; i < valoresX.size(); i += 40)
			signalStrength += (i + 1) * valoresX.get(i);
		return signalStrength;
	}

}
