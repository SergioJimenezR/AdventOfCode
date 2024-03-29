package sergiojimenezr.aoc2022.day07;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;
import sergiojimenezr.utilities.utils.Printer;

public class MainParte1Y2 {

	public static void main(String[] args) throws FileNotFoundException {
		List<Directorio> listaDirectorios = new ArrayList<>();
		Directorio directorioActual = reconocimiento(
				Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day07/input.txt"), listaDirectorios);
		directorioActual.contarTamano();

		Collections.sort(listaDirectorios);
		int sumParte1 = 0;
		for (Directorio d : listaDirectorios)
			if (d.getTamanoTotal() <= 100000)
				sumParte1 += d.getTamanoTotal();
			else
				break; // Eficiencia.
		Printer.println("Parte 1: " + sumParte1);

		int necessary = directorioActual.getTamanoTotal() - 40000000;
		for (Directorio d : listaDirectorios)
			if (d.getTamanoTotal() >= necessary) {
				Printer.println("Parte 2: " + d.getTamanoTotal());
				break;
			}
	}

	private static Directorio reconocimiento(List<String> lineas, List<Directorio> listaDirectorios) {

		Directorio directorioInicial = new Directorio("/");
		listaDirectorios.add(directorioInicial);
		Directorio directorioActual = directorioInicial;
		for (String comando : lineas)
			if (comando.startsWith("$ cd")) {
				String strDirectorio = comando.substring(5);
				if (strDirectorio.equals("/"))
					directorioActual = directorioInicial;
				else if (strDirectorio.equals(".."))
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
		return directorioInicial;
	}

}