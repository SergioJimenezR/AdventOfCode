package sergiojimenezr.aoc2022.day3;

import java.io.FileNotFoundException;

import sergiojimenezr.utilities.utils.Lector;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {
		int sumatorio = 0;
		for (String s : Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day3/input.txt"))
			sumatorio += prioridadUnicoCaracterComun(s.substring(0, s.length() / 2), s.substring(s.length() / 2));
		System.out.println(sumatorio);
	}

	public static int prioridadUnicoCaracterComun(String... cadenas) {
		for (char c : cadenas[0].toCharArray()) {
			boolean enTodas = true;
			for (int i = 1; i < cadenas.length && enTodas; i++)
				enTodas = cadenas[i].contains(c + "");
			if (enTodas)
				return c >= 'a' ? c - 'a' + 1 : c - 'A' + 27;
		}
		return 0;
	}

}
