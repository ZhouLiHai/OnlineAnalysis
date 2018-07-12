package SmartBootExample;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;

public class IntegerServerProcessor implements MessageProcessor<Integer> {
	@Override
	public void process(AioSession<Integer> aioSession, Integer integer) {
		Integer respMsg = integer + 1;
		try {
			aioSession.write(respMsg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stateEvent(AioSession<Integer> aioSession, StateMachineEnum stateMachineEnum, Throwable throwable) {

	}
}
