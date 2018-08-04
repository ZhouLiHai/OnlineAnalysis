package main.com.neptune8.juc;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 你发现每个任务都会延迟指定的时间（这里是3秒）再执行。
 * @author zhou
 */
public class TestScheduledThreadPool {

	final static private Integer N = 10;

	public static void main(String[] args) throws Exception {
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);

		for (int i = 0; i < N; i++) {

			Future<Integer> result = executor.schedule(new Callable<Integer>() {
				@Override
				public Integer call() {
					int num = new Random().nextInt(100);
					System.out.println("random number: " + num);
					return num;

				}
			}, 3, TimeUnit.SECONDS);

			System.out.println(result.get());
		}
	}
}




