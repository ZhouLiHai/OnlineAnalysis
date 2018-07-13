package SpringExample.EventExample;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;

// 首先实现接口，然后再Beans.xml中定义
public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent> {
	@Override
	public void onApplicationEvent(ContextStoppedEvent contextStoppedEvent) {
		System.out.println("Context stop.");
	}
}
