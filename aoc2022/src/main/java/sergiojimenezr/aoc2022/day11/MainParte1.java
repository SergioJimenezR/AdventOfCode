package sergiojimenezr.aoc2022.day11;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> archivo = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day11/input.txt");
		List<List<String>> monkeys = reconocimiento(archivo);

		List<Integer> timesAux = new ArrayList<>();
		for (int i = 0; i < monkeys.size(); i++)
			timesAux.add(0);

		for (int round = 0; round < 20; round++)
			for (int monkey = 0; monkey < monkeys.size(); monkey++) {

				String operation = archivo.get(7 * monkey + 2).substring("  Operation: new = old ".length());
				int divisibleBy = Integer
						.parseInt(archivo.get(7 * monkey + 3).substring("  Test: divisible by ".length()));
				int monkeyDestinationIfTrue = Integer
						.parseInt(archivo.get(7 * monkey + 4).substring("    If true: throw to monkey ".length()));
				int monkeyDestinationIfFalse = Integer
						.parseInt(archivo.get(7 * monkey + 5).substring("    If false: throw to monkey ".length()));

				List<String> items = monkeys.get(monkey);
				for (int i = 0; i < items.size(); i++) {
					timesAux.set(monkey, timesAux.get(monkey) + 1);
					int newItem = operate(Integer.parseInt(items.get(i)), operation);
					int destinationMonkey = testDivisibility(newItem, divisibleBy) ? monkeyDestinationIfTrue
							: monkeyDestinationIfFalse;
					monkeys.get(destinationMonkey).add(newItem + "");
					items.remove(i--);
				}
			}

		Collections.sort(timesAux);
		Printer.println(timesAux.get(timesAux.size() - 1) * timesAux.get(timesAux.size() - 2));

	}

	private static boolean testDivisibility(int operate, int divisibleBy) {
		return operate % divisibleBy == 0;
	}

	public static int operate(int worryLevel, String operation) {
		String[] op = operation.split(" ");
		int segundoOperando = op[1].equals("old") ? worryLevel : Integer.parseInt(op[1]);

		if (op[0].equals("+"))
			return (worryLevel + segundoOperando) / 3;
		else
			return worryLevel * segundoOperando / 3;
	}

	public static List<List<String>> reconocimiento(List<String> archivo) {
		List<List<String>> monkeys = new ArrayList<>();
		for (int i = 1; i < archivo.size(); i += 7)
			monkeys.add(new ArrayList<>(
					Arrays.asList(archivo.get(i).substring("  Starting items: ".length()).split(", "))));
		return monkeys;
	}

}
