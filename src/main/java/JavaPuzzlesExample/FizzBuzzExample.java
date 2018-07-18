package JavaPuzzlesExample;

import java.util.stream.IntStream;

public class FizzBuzzExample {
	public static void main(String[] args) {
		fizzBuzzBeforeJava8(100);
		fizzBuzzAfterJava8(100);
	}

	public static void fizzBuzzBeforeJava8(int num) {
		for (int i = 0; i < num; i++) {
			if (i % 5 == 0 && i % 7 == 0) {
				System.out.println("Fizz Buzz");
			} else if (i % 5 == 0) {
				System.out.println("Fizz");
			} else if (i % 7 == 0) {
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}

	public static void fizzBuzzAfterJava8(int num) {
		IntStream.rangeClosed(1, 100)
				.mapToObj(i -> i % 5 == 0 ? (i % 7 == 0 ? "Fizz Buzz" : "Fizz") : (i % 7 == 0) ? "Buzz" : i)
				.forEach(System.out::println);
	}
}
