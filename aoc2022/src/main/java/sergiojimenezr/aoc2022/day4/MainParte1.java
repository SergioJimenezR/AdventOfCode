package sergiojimenezr.aoc2022.day4;

import java.io.FileNotFoundException;
import java.util.List;

import sergiojimenezr.utilities.utils.Lector;

public class MainParte1 {

	public static void main(String[] args) throws FileNotFoundException {

		List<String> lista = Lector.leerArchivo("../aoc2022/src/main/java/sergiojimenezr/aoc2022/day4/input.txt");

		int contador = 0;
		for (String linea : lista) {
			int[] par1 = new int[] { Integer.parseInt(linea.split(",")[0].split("-")[0]),
					Integer.parseInt(linea.split(",")[0].split("-")[1]) };
			int[] par2 = new int[] { Integer.parseInt(linea.split(",")[1].split("-")[0]),
					Integer.parseInt(linea.split(",")[1].split("-")[1]) };

			if ((par1[0] <= par2[0] && par2[1] <= par1[1]) || (par2[0] <= par1[0] && par1[1] <= par2[1]))
				contador++;
		}
		System.out.println(contador);

	}

}
