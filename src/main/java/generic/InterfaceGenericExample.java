package generic;

/**
 * @param <T>
 */
interface Inter<T> {
	/**
	 * 打印传入参数t
	 * @param t
	 */
	public void show(T t);
}

/**
 * 可以在实现接口的过程中就指定泛型的类型
 */
class AsList implements Inter<String> {
	@Override
	public void show(String s) {
		System.out.println(s);
	}
}

/**
 * 也可以在实现的时候仍然使用泛型，在实例化的时候再指定类型
 *
 * @param <T>
 */
class BiList<T> implements Inter<T> {
	@Override
	public void show(T t) {
		System.out.println(t);
	}
}


/**
 * @author zhou
 */
public class InterfaceGenericExample {
	public static void main(String[] args) {
		// 已经知道A的类型
		AsList a = new AsList();
		a.show("hello");

		// 实例化的时候指定B的类型
		BiList<String> b = new BiList<>();
		b.show("world");
	}
}
