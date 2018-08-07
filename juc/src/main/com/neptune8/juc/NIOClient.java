package main.com.neptune8.juc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOClient {
	private static ByteBuffer sendbuffer = ByteBuffer.allocate(1024);
	private static ByteBuffer receivebuffer = ByteBuffer.allocate(1024);

	public static void main(String[] args) throws IOException {
		SocketChannel socketChannel = SocketChannel.open();

		socketChannel.configureBlocking(false);

		Selector selector = Selector.open();

		socketChannel.register(selector, SelectionKey.OP_CONNECT);

		socketChannel.connect(new InetSocketAddress("127.0.0.1", 8080));

		Set<SelectionKey> selectionKeys;
		Iterator<SelectionKey> iterator;
		SelectionKey selectionKey;
		SocketChannel client;
		String receiveText;
		String sendText;
		int count;

		while (true) {
			selector.select();

			selectionKeys = selector.selectedKeys();
			iterator = selectionKeys.iterator();

			while (iterator.hasNext()) {
				selectionKey = iterator.next();
				if (selectionKey.isConnectable()) {
					System.out.println("client connect.");
					client = (SocketChannel) selectionKey.channel();
					if (client.isConnectionPending()) {
						client.finishConnect();
						System.out.println("finish connect.");
						sendbuffer.clear();
						sendbuffer.put("hello server".getBytes());
						sendbuffer.flip();
						client.write(sendbuffer);
					}
					client.register(selector, SelectionKey.OP_READ);
				} else if (selectionKey.isReadable()) {
					client = (SocketChannel) selectionKey.channel();
					receivebuffer.clear();
					count = client.read(receivebuffer);
					if (count > 0) {
						receiveText = new String(receivebuffer.array(), 0, count);
						System.out.println(" client get data resource. " + receiveText);
						client.register(selector, SelectionKey.OP_WRITE);
					}

				} else if (selectionKey.isWritable()) {
					sendbuffer.clear();
					client = (SocketChannel) selectionKey.channel();
					sendText = "message form client.";

					sendbuffer.put(sendText.getBytes());
					sendbuffer.flip();
					client.write(sendbuffer);

					System.out.println("client send data. " + sendText);
					client.register(selector, SelectionKey.OP_READ);
				}
			}
			selectionKeys.clear();
		}

	}
}
