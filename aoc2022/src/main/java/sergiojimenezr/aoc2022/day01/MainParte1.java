package sergiojimenezr.aoc2022.day01;

import java.io.FileNotFoundException;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lista = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day01/input.txt");

		int maximo = 0;
		int sumatorio = 0;

		for (String strNum : lista)
			if (!strNum.equals(""))
				sumatorio += Integer.parseInt(strNum);
			else {
				if (sumatorio > maximo)
					maximo = sumatorio;
				sumatorio = 0;
			}

		Printer.print(maximo);

	}

}
