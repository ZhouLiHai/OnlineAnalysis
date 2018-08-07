package main.com.neptune8.juc;


import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * @author zhou
 */
public class TestSemaphore {
	static final Integer CAPACITY = 3;

	static Semaphore semaphore = new Semaphore(CAPACITY);

	public static void main(String[] args) {

		for (int i = 0; i < 5; i++) {
			new Thread(new Car()).start();
		}
	}

	static class Car implements Runnable {
		@Override
		public void run() {

			System.out.println("Waiting...");
			long start = System.currentTimeMillis();
			try {
				semaphore.acquire();
				long end = System.currentTimeMillis();
				System.out.println("total wait " + (end - start) + " ms.");
				long time = new Random().nextInt(3 * 1000);
				System.out.println("get in.");
				Thread.sleep(time);
				System.out.println("get out. total parking " + time + " ms.");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				semaphore.release();
			}
		}
	}
}

