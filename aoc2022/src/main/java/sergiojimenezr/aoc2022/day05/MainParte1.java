package sergiojimenezr.aoc2022.day05;

import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		final int NUM_PILAS = 9;
		final int TAMANO_INICIAL = 8;

		List<Deque<Character>> pilas = new ArrayList<>();
		for (int i = 0; i < NUM_PILAS; i++)
			pilas.add(new ArrayDeque<>());

		List<String> lineas = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day5/input.txt");

		parse(lineas.subList(0, TAMANO_INICIAL), pilas);
		ejecutar(lineas.subList(TAMANO_INICIAL + 2, lineas.size()), pilas, true);

		StringBuilder str = new StringBuilder("");
		for (Deque<Character> pila : pilas)
			str.append(pila.peek());
		Printer.print(str.toString());
	}

	public static void parse(Iterable<String> lineas, List<Deque<Character>> pilas) {
		for (String linea : lineas)
			for (int p = 0; p < pilas.size(); p++) {
				char c = linea.charAt(4 * p + 1);
				if (c != ' ')
					pilas.get(p).addLast(c);
			}
	}

	public static void ejecutar(Iterable<String> lineas, List<Deque<Character>> pilas, boolean fifo) {
		for (String linea : lineas) {
			String[] lineaSplit = linea.split(" ");

			mover(pilas.get(Integer.parseInt(lineaSplit[3]) - 1), pilas.get(Integer.parseInt(lineaSplit[5]) - 1),
					Integer.parseInt(lineaSplit[1]), fifo);
		}
	}

	private static void mover(Deque<Character> pilaOrigen, Deque<Character> pilaDestino, int cantidad, boolean fifo) {
		if (fifo)
			for (int i = 0; i < cantidad; i++)
				pilaDestino.push(pilaOrigen.pop());
		else {
			List<Character> aux = new ArrayList<>();
			for (int i = 0; i < cantidad; i++)
				aux.add(pilaOrigen.pop());
			for (int i = aux.size() - 1; i >= 0; i--)
				pilaDestino.push(aux.get(i));
		}
	}

}
