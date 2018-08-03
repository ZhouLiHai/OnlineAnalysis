package executor.impls;

import executor.base.Producer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhou
 */
public class SimpleProducer implements Producer<Integer> {

	final AtomicInteger counter = new AtomicInteger(1);

	@Override
	public Integer product(Integer integer) {
		return this.counter.get();
	}
}
