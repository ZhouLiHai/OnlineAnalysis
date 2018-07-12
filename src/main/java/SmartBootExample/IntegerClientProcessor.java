package SmartBootExample;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

public class IntegerClientProcessor implements MessageProcessor<Integer> {

	private AioSession<Integer> session;

	@Override
	public void process(AioSession<Integer> aioSession, Integer integer) {
		System.out.println(integer);
	}

	@Override
	public void stateEvent(AioSession<Integer> aioSession, StateMachineEnum stateMachineEnum, Throwable throwable) {
		switch (stateMachineEnum) {
			case NEW_SESSION:
				this.session = aioSession;
				break;
			default:
				System.out.println("other state: " + stateMachineEnum);
		}
	}

	public AioSession<Integer> getSession() {
		return session;
	}
}
