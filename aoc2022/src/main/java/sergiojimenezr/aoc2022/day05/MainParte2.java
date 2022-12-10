package sergiojimenezr.aoc2022.day05;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte2 {

	public static void main(String[] args) throws FileNotFoundException {

		final int NUM_PILAS = 9;
		final int TAMANO_INICIAL = 8;

		List<Deque<Character>> pilas = new ArrayList<>();
		for (int i = 0; i < NUM_PILAS; i++)
			pilas.add(new ArrayDeque<>());

		List<String> lineas = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day5/input.txt");

		MainParte1.parse(lineas.subList(0, TAMANO_INICIAL), pilas);
		MainParte1.ejecutar(lineas.subList(TAMANO_INICIAL + 2, lineas.size()), pilas, false);

		StringBuilder str = new StringBuilder("");
		for (Deque<Character> pila : pilas)
			str.append(pila.peek());
		Printer.print(str.toString());
	}

}
