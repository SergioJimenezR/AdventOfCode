package sergiojimenezr.aoc2022.day6;

import java.io.FileNotFoundException;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte2 {

	public static void main(String[] args) throws FileNotFoundException {
		Printer.print(MainParte1.metodo(
				Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day6/input.txt").get(0), 14) + "");
	}

}
