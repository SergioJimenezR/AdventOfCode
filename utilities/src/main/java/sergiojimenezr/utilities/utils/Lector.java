package sergiojimenezr.utilities.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public final class Lector {

	private Lector() {
	}

	public static List<String> leerArchivo(String ruta) throws FileNotFoundException {
		List<String> lectura = new ArrayList<>();
		Scanner sc = new Scanner(new File(ruta));
		while (sc.hasNextLine())
			lectura.add(sc.nextLine());
		sc.close();
		return lectura;
	}

	public static String[][] leerMatriz(String ruta, String splitter) throws FileNotFoundException {
		List<String[]> lectura = new ArrayList<>();
		Scanner sc = new Scanner(new File(ruta));
		while (sc.hasNextLine())
			lectura.add(sc.nextLine().split(splitter));
		sc.close();
		return lectura.toArray(new String[0][0]);
	}

}
