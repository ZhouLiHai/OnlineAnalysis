package generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhou
 */
public class BasicGenericExample {

	public static void main(String[] args) {
		/**
		 * 这是在代码中最常见的泛型形式。
		 * 在不使用泛型的前提下，如果想要实现任意类型的list，那么它的元素必须是object，而且会有强制类型转换的问题。
		 * 有了泛型，就可以实现任意类型的list，而且有元素类型的检查。
		 */
		List<String> list = new ArrayList<>();
		list.add("hello");
		String world = list.get(0);
	}
}
