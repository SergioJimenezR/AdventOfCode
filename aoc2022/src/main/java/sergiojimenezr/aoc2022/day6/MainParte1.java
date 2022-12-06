package sergiojimenezr.aoc2022.day6;

import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Set;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {
		Printer.printAndFinish(
				metodo(Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day6/input.txt").get(0), 4));
	}

	public static int metodo(String cadena, int tamano) {
		Set<Character> set = new HashSet<>();
		for (int i = tamano; i < cadena.length(); i++) {
			for (int j = i - tamano; j < i; j++)
				if (!set.contains(cadena.charAt(j)))
					set.add(cadena.charAt(j));
			if (set.size() == tamano)
				return i;
			set.clear();
		}
		return 0;
	}

}
