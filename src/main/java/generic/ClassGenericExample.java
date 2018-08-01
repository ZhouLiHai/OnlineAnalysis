package generic;

class Box<T> {
	private T obj;

	public Box() {
	}

	public T getObj() {
		return obj;
	}

	public void setObj(T obj) {
		this.obj = obj;
	}

	public Box(T obj) {
		super();
		this.obj = obj;
	}
}

/**
 * @author zhou
 */
public class ClassGenericExample {
	public static void main(String[] args) {
		Box<String> box = new Box<>();
		box.setObj("hello");
		String world = box.getObj();
	}
}
