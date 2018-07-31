package ThreadExample.impls;

import ThreadExample.base.Producer;

import java.util.Random;

public class SimpleProducer<T> implements Producer<T> {
	final static Random random = new Random();

	@Override
	public T product(T t) {
		return t;
	}
}
