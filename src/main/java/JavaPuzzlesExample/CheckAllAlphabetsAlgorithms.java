package JavaPuzzlesExample;

public class CheckAllAlphabetsAlgorithms {
	public static void main(String[] args) {
		System.out.println(checkAllChars("qwertyuioplkjhgfdsAzxcvbnm"));
		System.out.println(checkAllChars("123"));
		System.out.println(checkAllChars("ejuxggfstsqwertyuioplkjhgfdsAzxcvbnm"));
		System.out.println(checkAllChars("wyyga"));
	}

	private static String checkAllChars(String intput) {
		if (intput.length() < 26) {
			return "FALSE";
		}

		/**
		 * 最核心的部分就是String的indexOf方法了
		 */
		for (char ch = 'A'; ch < 'Z'; ch++) {
			if (intput.indexOf(ch) < 0 && intput.indexOf((char) (ch + 32)) < 0) {
				return "FALSE";
			}
		}

		return "TRUE";
	}
}
