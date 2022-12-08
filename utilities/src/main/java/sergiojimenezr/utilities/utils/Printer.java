package sergiojimenezr.utilities.utils;

public final class Printer {

	private Printer() {
	}

	public static void print(String s) {
		System.out.println(s);
	}

	public static void print(int i) {
		print(i + "");
	}

}
