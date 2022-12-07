package sergiojimenezr.aoc2022.day7;

import java.io.FileNotFoundException;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;

public class MainParte1 {

	static boolean modoLs = false;

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lineas = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day7/input.txt");
		lineas.remove(0);
		Directorio dirActual = new Directorio("/");

		for (String comando : lineas)
			if (comando.startsWith("$ cd")) {
				String strDirectorio = comando.substring(5);
				if (strDirectorio.equals(".."))
					dirActual = dirActual.getDirectorioPadre();
				else
					dirActual = dirActual.getDirectoriosInternos().get(strDirectorio);
			} else if (!comando.equals("$ ls")) {
				String[] info = comando.split(" ");
				if (info[0].equals("dir"))
					dirActual.addDirectorio(new Directorio(info[1]));
				else
					dirActual.addFile(info[1], Integer.parseInt(info[0]));
			}

		while (dirActual.getDirectorioPadre() != null)
			dirActual = dirActual.getDirectorioPadre();

		dirActual.contarTamano();
		System.out.println(Directorio.sumaGlobal);
	}

}
