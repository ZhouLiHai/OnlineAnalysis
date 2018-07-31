package ThreadExample.impls;

import ThreadExample.base.Customer;

import java.util.ArrayList;
import java.util.List;

public class SimpleCustomer<T> implements Customer<T> {
	@Override
	public void consume(T t) {
		System.out.println(t);
	}
}
