package sergiojimenezr.aoc2022.day10;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lista = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day10/input.txt");
		int x = 1;
		List<Integer> valores = new ArrayList<>();

		for (String linea : lista) {
			if (linea.equals("noop"))
				valores.add(x);
			else {
				valores.add(x);
				valores.add(x);
				x += Integer.parseInt(linea.split(" ")[1]);
			}
		}

		int signalStrength = 0;
		for (int i = 19; i < valores.size(); i += 40)
			signalStrength += (i + 1) * valores.get(i);
		System.out.println(signalStrength);

	}

}
