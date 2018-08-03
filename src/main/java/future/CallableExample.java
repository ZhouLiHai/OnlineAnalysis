package future;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @author zhou
 */
public class CallableExample {

	/**
	 * 任务数量
	 */
	final static private int TASKS = 4;

	public static void main(String[] args) {
		BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>(10);
		List<Future<Integer>> resultList = new ArrayList<Future<Integer>>();

		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.SECONDS, blockingQueue,
				new MyThreadFactory());
		Random random = new Random();

		for (int i = 0; i < TASKS; i++) {
			FactorialCalculator factorialCalculator = new FactorialCalculator(random.nextInt(10));
			Future<Integer> result = executor.submit(factorialCalculator);
			resultList.add(result);
		}

		System.out.println("waiting line.");

		for (Future<Integer> result : resultList) {
			try {
				result.get();
				// 获取线程计算的结果，因为result.get()是阻塞的，因此result.isDone()的返回值在没有异常的情况下一定是true。
				System.out.println("Future result is: " + result.get() + " and state is: " + result.isDone());
			} catch (InterruptedException | ExecutionException e) {
				e.fillInStackTrace();
			}
		}

		// 关闭线程池
		executor.shutdown();
	}
}

class MyThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setName("Callable example thread.");
		thread.setDaemon(true);
		thread.setPriority(Thread.NORM_PRIORITY);
		return thread;
	}
}
