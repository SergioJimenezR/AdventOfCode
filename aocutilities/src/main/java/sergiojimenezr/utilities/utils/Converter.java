package sergiojimenezr.utilities.utils;

public final class Converter {

	private Converter() {
	}

	public static int[][] convertStringMatrixToIntegerMatrix(String[][] strM) {
		int[][] intM = new int[strM.length][strM[0].length];
		for (int i = 0; i < strM.length; i++)
			for (int j = 0; j < strM[0].length; j++)
				intM[i][j] = Integer.parseInt(strM[i][j]);
		return intM;
	}

}
