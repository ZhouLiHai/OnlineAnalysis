package SmartBootExample;

import org.smartboot.socket.transport.AioQuickServer;

import java.io.IOException;

public class IntegerServer {
	public static void main(String[] args) throws IOException {
		AioQuickServer<Integer> server = new AioQuickServer<Integer>(8888, new IntegerProtocal(), new IntegerServerProcessor());
		server.start();
	}
}