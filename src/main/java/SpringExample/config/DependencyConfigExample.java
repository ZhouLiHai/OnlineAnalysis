package SpringExample.config;

import SpringExample.Beans.Driver;
import SpringExample.Beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(ConfigExample.class) // 生命这个配置类需要依赖于另一个配置类所定义的bean
public class DependencyConfigExample {
	//这里指定bean的初始化的清除函数
	@Bean(initMethod = "init", destroyMethod = "destroy")
	//同样可以指定生命周期
	@Scope("prototype")
	public Driver driver() {
		//这里存在bean的依赖，直接调用即可
		return new Driver(person(), 1, "Arrow");
	}

	@Bean
	public Person person() {
		return new Person();
	}
}
