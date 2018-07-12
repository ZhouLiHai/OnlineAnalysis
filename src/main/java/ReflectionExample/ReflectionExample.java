package ReflectionExample;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionExample {
	public static void main(String[] args) {

		Class pClass1 = null;

		//获取对象
		try {
			//根据类名获取类，同时静态属性会被初始化
			pClass1 = Class.forName("ReflectionExample.Hero");
			System.out.println("---");
			Class pClass2 = Hero.class;
			Class pClass3 = new Hero("zero", 99, 99.99).getClass();
			System.out.println(pClass1 == pClass2);
			System.out.println(pClass2 == pClass3);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Hero h2 = null;

		//创建对象
		try {
			h2 = (Hero) pClass1.getConstructor().newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		//修改属性
		try {
			Field field = h2.getClass().getDeclaredField("name");
			//设置之后，就可以修改这个private属性了。
			field.setAccessible(true);
			//由于name属性是private，所以在这里不能直接修改属性。
			field.set(h2, "super man");
			System.out.println(h2.getName());

		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		//调用方法
		try {
			//调用包含参数的方法
			Method method = h2.getClass().getMethod("setName", String.class);
			method.invoke(h2, "bat man");

			//调用不包含参数的方法
			method = h2.getClass().getMethod("toString");
			System.out.println(method.invoke(h2));

		} catch (Exception e) {
			e.printStackTrace();
		}

		//从配置文件中创建
		File config = new File("spring.cfg"); //文件相对路径就是项目的根路径
		Properties properties = new Properties();

		try {
			//载入配置文件
			properties.load(new FileInputStream(config));
		} catch (Exception e) {
			e.printStackTrace();
		}

		String className = properties.getProperty("class");
		String methodName = properties.getProperty("method");

		try {
			//获取类、方法
			Class cHero = Class.forName(className);
			Method method = cHero.getMethod(methodName);
			//获取实例
			//获取有参构造函数，并使用参数初始化
			Object service = cHero.getConstructor(String.class, int.class, double.class).newInstance("hi", 98, 9.8);
			//对实例调用方法
			System.out.println(method.invoke(service));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
