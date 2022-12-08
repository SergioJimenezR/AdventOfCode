package sergiojimenezr.aoc2022.day7;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1Y2 {

	static boolean modoLs = false;

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lineas = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day7/input.txt");
		lineas.remove(0);
		List<Directorio> listaDirectorios = new ArrayList<>();
		Directorio directorioActual = new Directorio("/");
		listaDirectorios.add(directorioActual);

		for (String comando : lineas)
			if (comando.startsWith("$ cd")) {
				String strDirectorio = comando.substring(5);
				if (strDirectorio.equals(".."))
					directorioActual = directorioActual.getDirectorioPadre();
				else
					directorioActual = directorioActual.getDirectoriosInternos().get(strDirectorio);
			} else if (!comando.equals("$ ls")) {
				String[] info = comando.split(" ");
				if (info[0].equals("dir")) {
					Directorio nuevoDirectorio = new Directorio(info[1]);
					listaDirectorios.add(nuevoDirectorio);
					directorioActual.addDirectorio(nuevoDirectorio);
				} else
					directorioActual.addFile(info[1], Integer.parseInt(info[0]));
			}

		while (directorioActual.getDirectorioPadre() != null)
			directorioActual = directorioActual.getDirectorioPadre();
		directorioActual.contarTamano();

		Collections.sort(listaDirectorios);
		int sumParte1 = 0;
		for (Directorio d : listaDirectorios)
			if (d.getTamanoTotal() <= 100000)
				sumParte1 += d.getTamanoTotal();
			else
				break;
		Printer.print("Parte 1: " + sumParte1);

		int necessary = directorioActual.getTamanoTotal() - 40000000;
		for (Directorio d : listaDirectorios)
			if (d.getTamanoTotal() >= necessary) {
				Printer.print("Parte 2: " + d.getTamanoTotal());
				break;
			}

	}

}