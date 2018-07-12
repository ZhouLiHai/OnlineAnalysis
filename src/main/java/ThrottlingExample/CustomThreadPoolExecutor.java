package ThrottlingExample;

import java.util.concurrent.*;

public class CustomThreadPoolExecutor extends ThreadPoolExecutor {

	private final Semaphore semaphore;

	public CustomThreadPoolExecutor(int corePoolSize, int maxPoolsize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maxPoolsize, keepAliveTime, unit, workQueue);
		semaphore = new Semaphore(corePoolSize + 50);
	}

	@Override
	public void execute(final Runnable command) {
		boolean acquired = false;

		do {
			try {
				semaphore.acquire();
				acquired = true;
			} catch (final InterruptedException e) {

			}
		} while (!acquired);

		try {
			super.execute(command);
		} catch (final RejectedExecutionException e) {
			e.printStackTrace();
			semaphore.release();
			throw e;
		}

	}

	@Override
	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
	}

	@Override
	protected void afterExecute(Runnable r, Throwable t) {
		super.afterExecute(r, t);
		semaphore.release();
	}
}
