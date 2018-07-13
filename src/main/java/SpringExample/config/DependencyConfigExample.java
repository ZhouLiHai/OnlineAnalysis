package SpringExample.config;

import SpringExample.Beans.Driver;
import SpringExample.Beans.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DependencyConfigExample {
	@Bean
	public Driver driver() {
		//这里存在bean的依赖，直接调用即可
		return new Driver(person(), 1, "Arrow");
	}

	@Bean
	public Person person() {
		return new Person();
	}
}
