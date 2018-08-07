package main.com.neptune8.juc;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author zhou
 */
public class NIOServer {
	private ByteBuffer sendBuffer = ByteBuffer.allocate(1024);
	private ByteBuffer receiveBuffer = ByteBuffer.allocate(1024);

	private Selector selector;
	private int serverCount;

	public NIOServer(int port) throws IOException {
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

		serverSocketChannel.configureBlocking(false);

		ServerSocket serverSocket = serverSocketChannel.socket();

		serverSocket.bind(new InetSocketAddress(port));

		selector = Selector.open();

		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		System.out.println("Server start ...");
	}

	public void listen() throws IOException {
		while (true) {
			selector.select();
			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			Iterator<SelectionKey> iterator = selectionKeys.iterator();

			while (iterator.hasNext()) {
				SelectionKey selectionKey = iterator.next();
				iterator.remove();
				handlyKey(selectionKey);
			}
		}
	}

	private void handlyKey(SelectionKey selectionKey) throws IOException {
		ServerSocketChannel server;
		SocketChannel client;
		String receiveText;
		String sendText;


		int count = 0;

		if (selectionKey.isAcceptable()) {
			server = (ServerSocketChannel) selectionKey.channel();
			client = server.accept();
			client.configureBlocking(false);
			client.register(selector, SelectionKey.OP_READ);

		} else if (selectionKey.isReadable()) {
			client = (SocketChannel) selectionKey.channel();
			receiveBuffer.clear();
			count = client.read(receiveBuffer);
			if (count > 0) {
				receiveText = new String(receiveBuffer.array(), 0, count);
				System.out.println("server got data " + (serverCount++));
				client.register(selector, SelectionKey.OP_WRITE);
			}
		} else if (selectionKey.isWritable()) {
			sendBuffer.clear();
			client = (SocketChannel) selectionKey.channel();
			sendText = "Silent is god.";
			sendBuffer.put(sendText.getBytes());
			sendBuffer.flip();
			client.write(sendBuffer);
			System.out.println("server send data " + sendText);
			client.register(selector, SelectionKey.OP_READ);

		}
	}

	public static void main(String[] args) throws IOException {
		int port = 8080;
		NIOServer nioServer = new NIOServer(port);
		nioServer.listen();
	}
}
