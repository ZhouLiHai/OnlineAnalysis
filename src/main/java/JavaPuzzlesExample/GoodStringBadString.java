package JavaPuzzlesExample;

public class GoodStringBadString {
	public static void main(String[] args) {
		String intput = "Good Oops, bad Oops.";

		// TODO: java的正则表达式
		String output = intput.replaceAll("(?i)(\\p{L})\\1", "$1");
		System.out.println(output);
	}
}
