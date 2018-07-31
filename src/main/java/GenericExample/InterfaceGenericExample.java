package GenericExample;

import org.springframework.web.bind.annotation.InitBinder;

interface Inter<T> {
	public void show(T t);
}

// 可以在实现这个接口的时候定义类型
class A implements Inter<String> {
	@Override
	public void show(String s) {
		System.out.println(s);
	}
}

// 也可以在实现的时候仍然使用泛型，在实例化的时候再指定类型
class B<T> implements Inter<T> {
	@Override
	public void show(T t) {
		System.out.println(t);
	}
}


public class InterfaceGenericExample {
	public static void main(String[] args) {
		// 已经知道A的类型
		A a = new A();
		a.show("hello");

		// 实例化的时候指定B的类型
		B<String> b = new B<>();
		b.show("world");
	}
}
