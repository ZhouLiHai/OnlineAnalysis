package SpringExample;

import SpringExample.Beans.LazyLoad;
import SpringExample.Beans.Messenger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		// 这里的classpath为“main/java”目录
		// Spring 容器是 Spring 框架的核心。容器将创建对象，把它们连接在一起，配置它们，并管理他们的整个生命周期从创建到销毁。
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		Messenger messenger = (Messenger)context.getBean("messenger");
		System.out.println(messenger.getMessage());

		// spring默认作用域是singleton，这里获取的是同一个对象
		Messenger messenger_another = (Messenger)context.getBean("messenger");
		System.out.println("same object: " + (messenger == messenger_another));

		// 使用prototype作用于，每次生成的对象不同
		System.out.println("same object: " +
				(context.getBean("person") == context.getBean("person"))
		);

		// 设置懒加载的bean到这里还没有开始加载
		System.out.println("lazy load bean not init yet.");
		// 生成
		LazyLoad lazyLoad = (LazyLoad) context.getBean("lazyLoad");

		// 迫使spring调用bean销毁程序
		((ClassPathXmlApplicationContext) context).registerShutdownHook();
	}
}
