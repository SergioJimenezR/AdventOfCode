package sergiojimenezr.utilities.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class LectorTest {

	@Test
	void testLeerArchivo() throws IOException {

		File fichero = new File("test.txt");
		List<String> contenido = Arrays.asList("1", "2", "3", "4", "5");
		PrintWriter escritor = new PrintWriter(fichero);
		for (String linea : contenido)
			escritor.println(linea);
		escritor.close();

		assertEquals(contenido, Lector.leerArchivo(fichero.getPath()));
		fichero.delete();

	}

}
