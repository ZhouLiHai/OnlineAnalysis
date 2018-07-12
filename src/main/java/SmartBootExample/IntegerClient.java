package SmartBootExample;

import org.smartboot.socket.transport.AioQuickClient;

public class IntegerClient {
	public static void main(String[] args) throws Exception {
		IntegerClientProcessor processor = new IntegerClientProcessor();
		AioQuickClient<Integer> aioQuickClient = new AioQuickClient<Integer>("localhost", 8888, new IntegerProtocal(), processor);
		aioQuickClient.start();
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			processor.getSession().write(1);
		}
		long stop = System.currentTimeMillis();
		System.out.println(stop - start);
		aioQuickClient.shutdown();
	}
}
