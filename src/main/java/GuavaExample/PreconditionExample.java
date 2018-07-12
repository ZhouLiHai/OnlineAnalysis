package GuavaExample;

import com.google.common.base.Preconditions;

public class PreconditionExample {
	public static void main(String[] args) {
		try {
			System.out.println(sqrt(-2.0));
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(sum(null, 10));
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

		try {
			System.out.println(getValue(10));
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	public static double sqrt(double input) throws IllegalArgumentException {
		//判断布尔条件
		Preconditions.checkArgument(input > 0.0, "Illegal Argument passed %s.", input);
		return Math.sqrt(input);
	}

	public static int sum(Integer a, Integer b) {
		//判断非空
		a = Preconditions.checkNotNull(a, "Argument is null.");
		b = Preconditions.checkNotNull(b, "Argument is Null.");

		return a + b;
	}

	public static int getValue(int input) {
		int[] data = {1,2,3,4,5};
		//判断元素边界
		Preconditions.checkElementIndex(input, data.length, "Illegal index.");
		return data[input];
	}
}
