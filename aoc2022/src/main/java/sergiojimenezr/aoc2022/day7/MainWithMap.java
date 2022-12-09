package sergiojimenezr.aoc2022.day7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainWithMap {

	static final String DIR_INICIAL = "/";

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> map = reconocimiento(
				Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day7/input.txt"));

		List<Integer> tamanos = new ArrayList<>(map.values());
		Collections.sort(tamanos);

		int sumaParte1 = 0;
		for (int t : tamanos)
			if (t <= 100000)
				sumaParte1 += t;
			else
				break; // Eficiencia.
		Printer.print("Parte 1: " + sumaParte1);

		int necessary = map.get(DIR_INICIAL) - 40000000;
		for (int d : tamanos)
			if (d >= necessary) {
				Printer.print("Parte 2: " + d);
				break;
			}

	}

	private static Map<String, Integer> reconocimiento(List<String> lineas) {
		Map<String, Integer> map = new HashMap<>();
		String directorioActual = "";
		for (String comando : lineas)
			if (comando.startsWith("$ cd")) {
				String strDirectorio = comando.substring(5);
				if (strDirectorio.equals("/"))
					directorioActual = DIR_INICIAL;
				else if (strDirectorio.equals(".."))
					directorioActual = directorioActual.substring(0, directorioActual.lastIndexOf('/'));
				else
					directorioActual = new StringBuilder(directorioActual).append("/").append(strDirectorio).toString();
				map.putIfAbsent(directorioActual, 0);
			} else if (!comando.equals("$ ls")) {
				String[] info = comando.split(" ");
				if (info[0].equals("dir"))
					map.putIfAbsent(directorioActual + "/" + info[1], 0);
				else {
					for (String strAux = directorioActual; !strAux.equals(DIR_INICIAL); strAux = strAux.substring(0,
							strAux.lastIndexOf('/')))
						map.replace(strAux, map.get(strAux) + Integer.parseInt(info[0]));
					map.replace(DIR_INICIAL, map.get(DIR_INICIAL) + Integer.parseInt(info[0]));
				}
			}
		return map;
	}

}