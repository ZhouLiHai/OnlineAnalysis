package executor.impls;

import executor.base.Customer;

/**
 * @author zhou
 */
public class SimpleCustomer implements Customer<Integer> {
	@Override
	public void consume(Integer item) {
		System.out.println("consume a product " + item);
	}
}
