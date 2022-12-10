package sergiojimenezr.aoc2022.day07;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class Directorio implements Comparable<Directorio> {

	private Directorio directorioPadre = null;
	private String nombre;
	private Map<String, Integer> ficheros = new HashMap<>();
	private Map<String, Directorio> directorios = new HashMap<>();
	private int tamanoTotal = 0;

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

	public int getTamanoTotal() {
		return tamanoTotal;
	}

	public int contarTamano() {

		Iterator<Entry<String, Integer>> iteratorFicheros = ficheros.entrySet().iterator();
		while (iteratorFicheros.hasNext())
			tamanoTotal += iteratorFicheros.next().getValue();

		Iterator<Entry<String, Directorio>> iteratorDirectorios = directorios.entrySet().iterator();
		while (iteratorDirectorios.hasNext())
			tamanoTotal += iteratorDirectorios.next().getValue().contarTamano();

		return tamanoTotal;
	}

	@Override
	public int hashCode() {
		return Objects.hash(directorioPadre, directorios, ficheros, nombre, tamanoTotal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Directorio other = (Directorio) obj;
		return Objects.equals(directorioPadre, other.directorioPadre) && Objects.equals(directorios, other.directorios)
				&& Objects.equals(ficheros, other.ficheros) && Objects.equals(nombre, other.nombre)
				&& tamanoTotal == other.tamanoTotal;
	}

	@Override
	public int compareTo(Directorio d2) {
		if (tamanoTotal < d2.getTamanoTotal())
			return -1;
		else
			return 1;
	}

}