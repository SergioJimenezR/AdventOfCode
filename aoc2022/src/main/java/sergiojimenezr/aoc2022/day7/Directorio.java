package sergiojimenezr.aoc2022.day7;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class Directorio {

	private Directorio directorioPadre = null;
	private String nombre;
	private Map<String, Integer> ficheros = new HashMap<>();
	private Map<String, Directorio> directorios = new HashMap<>();

	public Directorio(String nombre) {
		this.nombre = nombre;
	}

	public Directorio getDirectorioPadre() {
		return directorioPadre;
	}

	public void setDirectorioPadre(Directorio directorioPadre) {
		this.directorioPadre = directorioPadre;
	}

	public String getNombre() {
		return nombre;
	}

	public Map<String, Directorio> getDirectoriosInternos() {
		return directorios;
	}

	public void addFile(String nombre, Integer tamano) {
		ficheros.putIfAbsent(nombre, tamano);
	}

	public void addDirectorio(Directorio d) {
		d.setDirectorioPadre(this);
		directorios.putIfAbsent(d.getNombre(), d);
	}

	public static int sumaGlobal = 0;

	public int contarTamano() {
		int sumatorio = 0;

		Iterator<Entry<String, Integer>> iteratorFicheros = ficheros.entrySet().iterator();
		while (iteratorFicheros.hasNext())
			sumatorio += iteratorFicheros.next().getValue();

		Iterator<Entry<String, Directorio>> iteratorDirectorios = directorios.entrySet().iterator();
		while (iteratorDirectorios.hasNext())
			sumatorio += iteratorDirectorios.next().getValue().contarTamano();

		if (sumatorio <= 100000)
			sumaGlobal += sumatorio;

		return sumatorio;
	}

}
