package generic;

/**
 * 泛型除了可以定义泛型类还可以定义泛型方法
 * 注意：泛型方法不局限于静态方法，这里只是举例
 */
class StaticBox {
	public static <T> void profile(T t) {
		System.out.println(t);
	}
}

/**
 * @author zhou
 */
public class CheckGenericExample {
	public static void main(String[] args) {
		// 可以明确的告知泛型方法需要的类型
		StaticBox.<String>profile("hello");

		// 也可以采用隐含的方式，告知泛型方法需要的类型
		StaticBox.profile("world");
	}
}
