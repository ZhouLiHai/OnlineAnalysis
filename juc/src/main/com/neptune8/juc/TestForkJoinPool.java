package main.com.neptune8.juc;


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 可以在任务执行过程中对任务进行拆分，对于多核cpu可能加快处理速度
 * 整体使用二分法，类似于map-reduce的方式来处理任务
 *
 * @author zhou
 */
public class TestForkJoinPool {
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();

		ForkJoinTask<Long> task = new SumCalculator(0, 100000000L);

		Long sum = pool.invoke(task);

		System.out.println(sum);
	}
}

class SumCalculator extends RecursiveTask<Long> {
	private long start;
	private long end;

	private static final long THRESHOLD = 10000L;

	public SumCalculator(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long length = end - start;

		if (length < THRESHOLD) {
			long sum = 0;
			for (long i = start; i < end; i++) {
				sum += i;
			}
			return sum;

		} else {
			long middle = (start + end) / 2;
			SumCalculator left = new SumCalculator(start, middle);
			left.fork();

			SumCalculator right = new SumCalculator(middle, end);
			right.fork();

			return left.join() + right.join();
		}
	}
}
