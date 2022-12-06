package sergiojimenezr.aoc2022.day1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte2 {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lista = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day1/input.txt");

		List<Integer> sumatorios = new ArrayList<>();

		int sumatorio = 0;
		for (String strNum : lista)
			if (!strNum.equals(""))
				sumatorio += Integer.parseInt(strNum);
			else {
				sumatorios.add(sumatorio);
				sumatorio = 0;
			}

		Collections.sort(sumatorios);

		Printer.printAndFinish(sumatorios.get(sumatorios.size() - 1) + sumatorios.get(sumatorios.size() - 2)
				+ sumatorios.get(sumatorios.size() - 3));

	}

}
