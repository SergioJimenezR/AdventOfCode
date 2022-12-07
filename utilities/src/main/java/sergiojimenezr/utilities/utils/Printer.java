package sergiojimenezr.utilities.utils;

public final class Printer {

	private Printer() {
	}

	public static void printAndFinish(String s) {
		System.out.println(s);
		System.exit(0);
	}

	public static void printAndFinish(int i) {
		printAndFinish(i + "");
	}

}
