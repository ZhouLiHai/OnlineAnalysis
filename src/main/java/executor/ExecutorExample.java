package executor;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhou
 */
public class ExecutorExample {

	private static ExecutorService executor;
	private static volatile Future taskOneResults = null;
	private static volatile Future taskTwoResults = null;

	@SuppressWarnings("AlibabaThreadPoolCreation")
	public static void main(String[] args) {
		BlockingQueue<Runnable> taskQueue = new LinkedBlockingDeque<>();

		ThreadPoolExecutor pool = new ThreadPoolExecutor(1,1,10L,TimeUnit.SECONDS,taskQueue);
		pool.prestartAllCoreThreads();

		pool.shutdown();
	}
}

class MyThreadFactory implements ThreadFactory {
	private static AtomicInteger number = new AtomicInteger(1);

	@Override
	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setName("thread from my thread factory No." + (number.incrementAndGet()));
		return t;
	}
}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println(r.toString() + ": I'm been rejected!");
	}
}