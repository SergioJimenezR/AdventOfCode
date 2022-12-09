package sergiojimenezr.aoc2022.day7;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sergiojimenezr.utilities.utils.Lector;

public class MainWithMap {

	public static void main(String[] args) throws FileNotFoundException {
		Map<String, Integer> map = new HashMap<>();
		List<String> lineas = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day7/input.txt");

		String directorioActual = "";
		for (String comando : lineas) {
			System.out.println(comando);
			if (comando.startsWith("$ cd")) {
				String strDirectorio = comando.substring(5);
				if (strDirectorio.equals("/")) {
					directorioActual = "";
				} else if (strDirectorio.equals("..")) {
					directorioActual = directorioActual.substring(0, directorioActual.lastIndexOf('/'));
				} else {
					directorioActual += "/" + strDirectorio;
				}
				map.putIfAbsent(directorioActual, 0);
			} else if (!comando.equals("$ ls")) {
				String[] info = comando.split(" ");
				if (info[0].equals("dir")) {
					map.putIfAbsent(directorioActual + "/" + info[1], 0);
				} else {

					for (String strAux = directorioActual; true; strAux = strAux.substring(0,
							strAux.lastIndexOf('/'))) {
						map.replace(strAux, map.get(strAux) + Integer.parseInt(info[0]));
						if (strAux.equals(""))
							break;
					}
				}
			}
		}
		System.out.println(map);

	}

}