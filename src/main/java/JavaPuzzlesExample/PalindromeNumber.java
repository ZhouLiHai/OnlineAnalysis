package JavaPuzzlesExample;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(checkPalindromeNumber(1001));
		System.out.println(checkPalindromeNumber(1000));
		System.out.println(checkPalindromeNumber(450005));
		System.out.println(checkPalindromeNumber(4500054));
	}

	public static boolean checkPalindromeNumber(Integer number) {
		boolean isPalindromeNumber = false;

		if (number == reverse(number)) {
			isPalindromeNumber = true;
		}

		return isPalindromeNumber;
	}

	public static int reverse(int number) {
		int reverse = 0;
		int remainder = 0;

		do {
			remainder = number % 10;
			reverse = reverse * 10 + remainder;
			number = number / 10;
		} while (number > 0);

		return reverse;
	}
}
