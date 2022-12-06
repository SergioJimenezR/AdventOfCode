package sergiojimenezr.utilities.utils;

public class Printer {

	private Printer() {
	}

	public static void printAndFinish(String s) {
		System.out.println(s);
		System.exit(0);
	}

	public static void printAndFinish(int i) {
		printAndFinish(i + "");
		System.exit(0);
	}

}
