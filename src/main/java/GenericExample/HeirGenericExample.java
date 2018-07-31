package GenericExample;

import org.omg.PortableInterceptor.INACTIVE;

class numberBox<T extends Number> {
	private T t;

	public numberBox(T t) {
		this.t = t;
	}

	public void print(T t) {
		System.out.println(t);
	}

	public T getT() {
		return this.t;
	}
}

class ingeterBox<Integer> extends numberBox<Number> {
	public ingeterBox(Integer t) {
		super(t);
	}
}

class Tools {
	public static void show(numberBox<Number> numberBox) {
		numberBox.print(numberBox.getT());
	}
}

public class HeirGenericExample {
	public static void main(String[] args) {
		Tools.show(new numberBox<Number>(100));
		/**
		 * 你会发现这样不行：
		 * Tools.show(new numberBox<Integer>(100));
		 * 原因是：虽然Integer是Number的子类，但是numberBox<Integer>并不是numberBox<Number>的子类
		 */
		Tools.show(new ingeterBox<Integer>(101));
	}
}
