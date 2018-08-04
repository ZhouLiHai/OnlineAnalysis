package main.com.neptune8.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhou
 */
public class TestCountDownLatch {
	final static private Integer THREAD_NUMBER = 10;

	@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
	public static void main(String[] args) {
		CountDownLatch countDownLatch = new CountDownLatch(10);
		LatchWorker latchWorker = new LatchWorker(countDownLatch);

		long start = System.currentTimeMillis();
		for (int i = 0; i < THREAD_NUMBER; i++) {
			new Thread(latchWorker).start();
		}

		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();

		System.out.println("Consume time: " + (end - start));


	}
}

class LatchWorker implements Runnable {
	private CountDownLatch latch;
	private final static Integer SUM = 500;

	public LatchWorker(CountDownLatch latch) {
		this.latch = latch;
	}

	@Override
	public void run() {
//		synchronized (this) {
			try {
				for (int i = 0; i < SUM; i++) {
					System.out.println(i);
				}
			} finally {
				latch.countDown();
			}
//		}
	}
}

