package main.com.neptune8.juc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * @author zhou
 */
public class TestExchanger {
	public static void main(String[] args) {
		List<String> buffer1 = new ArrayList<String>();
		List<String> buffer2 = new ArrayList<String>();

		Exchanger<List<String>> exchanger = new Exchanger<>();

		new Thread(new Producer(buffer1, exchanger)).start();
		new Thread(new Consumer(buffer2, exchanger)).start();
	}

	static class Producer implements Runnable {

		private List<String> buffer;
		private Exchanger<List<String>> exchanger;

		public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
			this.buffer = buffer;
			this.exchanger = exchanger;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				System.out.println("producer " + i + "th times supply.");
				for (int j = 0; j < 3; j++) {
					System.out.println("producer packager " + j);
					buffer.add(j + "th");
				}

				System.out.println("buffer is full.");
				try {
					exchanger.exchange(buffer);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	static class Consumer implements Runnable {
		private List<String> buffer;
		private Exchanger<List<String>> exchanger;

		public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
			this.buffer = buffer;
			this.exchanger = exchanger;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					buffer = exchanger.exchange(buffer);
				} catch (Exception e) {
					e.printStackTrace();
				}

				for (int j = 0; j < 3; j++) {
					System.out.println("consumer" + buffer.get(0));
					buffer.remove(0);
				}
			}
		}
	}
}
