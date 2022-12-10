package sergiojimenezr.aoc2022.day03;

import java.io.FileNotFoundException;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte2 {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lista = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day3/input.txt");

		int sumatorio = 0;
		for (int i = 0; i < lista.size(); i += 3)
			sumatorio += MainParte1.prioridadUnicoCaracterComun(lista.get(i), lista.get(i + 1), lista.get(i + 2));
		Printer.print(sumatorio);

	}

}
