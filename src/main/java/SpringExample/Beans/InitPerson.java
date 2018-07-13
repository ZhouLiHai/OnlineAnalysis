package SpringExample.Beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;


// 原本以为与特定的bean绑定，试验发现是全局的
public class InitPerson implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		// 感觉这种实现不太好，暂时解决方案
		// TODO:寻找BeanPostProcessor的最佳实践
		// 使用Lazyload使打印不那么混乱
		if (bean instanceof LazyLoad) {
			System.out.println("postProcessBeforeInitialization");
		}
		return null;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof LazyLoad) {
			System.out.println("postProcessAfterInitialization");
		}
		return null;
	}

	public int value() {
		return 0;
	}
}
