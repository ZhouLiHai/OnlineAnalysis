package main.com.neptune8.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 比较完善的锁逻辑
 * 每一个线程都等待前一个线程完成任务，形成任务链，如此循环10次
 * 主线程首先给出第一个任务的signal，从而开始任务链
 *
 * 注意：signal不能直接给出，signal的作用范围必须是lock.lock()和lock.unlock()之间。
 *
 * @author zhou
 */
public class TestReeTrantLock {

	private static Lock lock = new ReentrantLock();
	private static Condition signalA = lock.newCondition();
	private static Condition signalB = lock.newCondition();
	private static Condition signalC = lock.newCondition();


	@SuppressWarnings("AlibabaAvoidManuallyCreateThread")
	public static void main(String[] args) {
		new Thread(new Animal()).start();
		new Thread(new Bat()).start();
		new Thread(new Cat()).start();

		lock.lock();
		try {
			signalA.signal();
		} catch (IllegalMonitorStateException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	static class Animal implements Runnable {

		private static Integer N = 10;

		@Override
		public void run() {
			lock.lock();

			try {
				for (int i = 0; i < N; i++) {
					signalA.await();
					System.out.println(Thread.currentThread().getName() + "-" + i);
					signalB.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	static class Bat implements Runnable {

		private static Integer N = 10;

		@Override
		public void run() {
			lock.lock();

			try {
				for (int i = 0; i < N; i++) {
					signalB.await();
					System.out.println(Thread.currentThread().getName() + "-" + i);
					signalC.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}

	static class Cat implements Runnable {

		private static Integer N = 10;

		@Override
		public void run() {
			lock.lock();

			try {
				for (int i = 0; i < N; i++) {
					signalC.await();
					System.out.println(Thread.currentThread().getName() + "-" + i);
					signalA.signal();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
	}
}
