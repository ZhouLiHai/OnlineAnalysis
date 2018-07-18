package JavaPuzzlesExample;

import java.util.Stack;
import java.util.StringTokenizer;

public class ReverseString {
	public static void main(String[] args) {
		String sh = "HowtodoInJava";

		// TODO: 了解StringBuilder的功能
		System.out.println(sh + " --> " + new StringBuilder(sh).reverse());

		String s = "Java technology blog for smart java concepts and coding practices.";
		System.out.println(ReverseByWord(s));
	}

	public static String ReverseByWord(String s) {
		Stack<String> myStack = new Stack<>();
		// TODO: StringTokenizer貌似可以切分string，应该还有其它功能
		StringTokenizer st = new StringTokenizer(s, " ");
		while (st.hasMoreTokens()) {
			myStack.push(st.nextToken());
		}

		StringBuilder reverseString = new StringBuilder();

		while (!myStack.empty()) {
			reverseString.append(myStack.pop() + " ");
		}
		return reverseString.toString();
	}
}
