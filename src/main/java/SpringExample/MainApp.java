package SpringExample;

import SpringExample.Beans.Driver;
import SpringExample.Beans.LazyLoad;
import SpringExample.Beans.Messenger;
import SpringExample.Beans.RealConfig;
import SpringExample.JDBCExample.StudentJDBCTemplate;
import SpringExample.aop.Student;
import SpringExample.config.ConfigExample;
import SpringExample.config.DependencyConfigExample;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.beans.Beans;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainApp {
	public static void main(String[] args) {
		// 这里的classpath为“main/java”目录
		// Spring 容器是 Spring 框架的核心。容器将创建对象，把它们连接在一起，配置它们，并管理他们的整个生命周期从创建到销毁。
		ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
		//手动激活start时事件
		((ClassPathXmlApplicationContext) context).start();
		Messenger messenger = (Messenger)context.getBean("messenger");
		System.out.println(messenger.getMessage());

		// spring默认作用域是singleton，这里获取的是同一个对象
		Messenger messenger_another = (Messenger)context.getBean("messenger");
		System.out.println("same object: " + (messenger == messenger_another));

		Student student = (Student)context.getBean("student");
		student.getName();
		student.getAge();
		try {
			student.printThrowException();
		} catch (Exception e) {
			// 什么都不需要做，这里就是演示一下对异常的监控
		}

		// studentJDBCTemplate是有spring自动装配的，一旦装配成功使用非常方便
		// 重点在于studentJDBCTemplate是如何装配的
		StudentJDBCTemplate studentJDBCTemplate =
				(StudentJDBCTemplate)context.getBean("studentJDBCTemplate");
		System.out.println("------Records Creation--------" );
		studentJDBCTemplate.create("Zara", 11);
		studentJDBCTemplate.create("Nuha", 2);
		studentJDBCTemplate.create("Ayan", 15);
		System.out.println("------Listing Multiple Records--------" );
		List<SpringExample.JDBCExample.Student> students = studentJDBCTemplate.listStudents();
		for (SpringExample.JDBCExample.Student record : students) {
			System.out.print("Id : " + record.getId());
			System.out.print(", Name : " + record.getName() );
			System.out.println(", Age : " + record.getAge());
		}
		System.out.println("----Updating Record with ID = 2 -----" );
		studentJDBCTemplate.update(2, 20);
		System.out.println("----Listing Record with ID = 2 -----" );
		SpringExample.JDBCExample.Student student1 = studentJDBCTemplate.getStudent(2);
		System.out.print("ID : " + student1.getId() );
		System.out.print(", Name : " + student1.getName() );
		System.out.println(", Age : " + student1.getAge());


		// 使用prototype作用于，每次生成的对象不同
		System.out.println("same object: " +
				(context.getBean("person") == context.getBean("person"))
		);

		// 设置懒加载的bean到这里还没有开始加载
		System.out.println("lazy load bean not init yet.");
		// 生成
		LazyLoad lazyLoad = (LazyLoad) context.getBean("lazyLoad");

		System.out.println("==========");

		// 这时driver的person属性已经被初始化好了
		Driver driver = (Driver) context.getBean("driver");
		driver.drive();

		// 手动激活stop事件
		((ClassPathXmlApplicationContext) context).stop();
		// 迫使spring调用bean销毁程序
		((ClassPathXmlApplicationContext) context).registerShutdownHook();

		System.out.println("==========");

		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigExample.class);

		// 在这里如果使用jdk10会出现如下问题：
		// An illegal reflective access operation has occurred
		// jdk8中则没有这个问题
		// "JDK 9 对于第一次反射都有警告，也许在下一些版本会对反射方面做出更好的优化和限制，现在请忽略警告"
		// 应为java配置方式使用了注解，必然使用了反射，所以才会出现这个警告
		// 这里使用java的配置方式和使用xml是一样的效果
		RealConfig realConfig = (RealConfig) ctx.getBean("realConfig");
		realConfig.printConfig();

		// 使用注解方式的bean生成，driver存在类之间的依赖，如何处理请看DependencyConfigExample
		ctx = new AnnotationConfigApplicationContext(DependencyConfigExample.class);
		Driver driver_a = (Driver) ctx.getBean(Driver.class);
		driver_a.drive();

		((AnnotationConfigApplicationContext) ctx).registerShutdownHook();
	}
}
