package main.com.neptune8.juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 测试原则性
 * @author zhou
 */
public class TestAtomic {
	private final static Integer THREAD_NUMBER = 10;

	@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
	public static void main(String[] args) {
		AtomicWorker atomicWorker = new AtomicWorker();

		for (int i = 0; i < THREAD_NUMBER; i++) {
			//noinspection AlibabaAvoidManuallyCreateThread
			new Thread(atomicWorker).start();
		}

	}
}

class AtomicWorker implements Runnable {
	private AtomicInteger serialNumber = new AtomicInteger(0);

	@Override
	public void run() {
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(Thread.currentThread().getName() + ":" + getSerialNumber());
	}

	Integer getSerialNumber() {
		return serialNumber.getAndIncrement();
	}
}