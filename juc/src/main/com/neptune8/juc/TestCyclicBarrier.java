package main.com.neptune8.juc;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

/**
 * @author zhou
 */
public class TestCyclicBarrier {

	private static CyclicBarrier cyclicBarrier;

	private static final Integer SIZE = 5;

	public static void main(String[] args) {
		cyclicBarrier = new CyclicBarrier(SIZE, new Runnable() {
			@Override
			public void run() {
				System.out.println("let's begin!");
			}
		});

		for (int i = 0; i < SIZE; i++) {
			new Thread(new Task()).start();
		}
	}

	static class Task implements Runnable {
		@Override
		public void run() {
			Random random = new Random();
			Integer rand = random.nextInt(1000);
			System.out.println("let's wait " + rand + " !");

			try {
				Thread.sleep(rand);
				cyclicBarrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
