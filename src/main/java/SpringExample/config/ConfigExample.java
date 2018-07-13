package SpringExample.config;

import SpringExample.Beans.RealConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigExample {
	@Bean
	public RealConfig realConfig() {
		return new RealConfig();
	}
}

/**
 * 以上代码等同于以下配置
 * <beans>
 *    <bean id="helloWorld" class="com.tutorialspoint.HelloWorld" />
 * </beans>
 */
