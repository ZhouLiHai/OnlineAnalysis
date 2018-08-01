package generic;

class NumberBox<T extends Number> {
	private T t;

	public NumberBox(T t) {
		this.t = t;
	}

	public void print(T t) {
		System.out.println(t);
	}

	public T getT() {
		return this.t;
	}
}

/**
 * 在明确继承numberBox<Number>之后，就可以想main函数中写的那样使用了
 */
class IntegerBox<Integer> extends NumberBox<Number> {
	public IntegerBox(Integer t) {
		super((Number) t);
	}
}

class Tools {
	public static void show(NumberBox<Number> numberBox) {
		numberBox.print(numberBox.getT());
	}
}

/**
 * @author zhou
 */
public class HeirGenericExample {
	public static void main(String[] args) {
		Tools.show(new NumberBox<Number>(100));

		// 原因是：虽然Integer是Number的子类，但是numberBox<Integer>并不是numberBox<Number>的子类
		Tools.show(new IntegerBox<Integer>(101));
	}
}
