package SpringExample.EventExample;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;

// 首先实现接口，然后再Beans.xml中定义
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent> {
	@Override
	public void onApplicationEvent(ContextStartedEvent contextStartedEvent) {
		System.out.println("Context start.");
	}
}
