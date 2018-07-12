package GuavaExample;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OrderingEample {
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		Random random = new Random();
		for (int i = 0; i < 10; i++) {
			numbers.add(random.nextInt(100));
		}

		System.out.println("Input list:");
		System.out.println(numbers);

		Ordering ordering = Ordering.natural();
		//ordering是排序规则
		Collections.sort(numbers, ordering);
		System.out.println("After sorted:");
		System.out.println(numbers);

		System.out.println("======================");
		//判断有序、最大值、最小值
		System.out.println("list is sorted? " + ordering.isOrdered(numbers));
		System.out.println("max is " + ordering.max(numbers));
		System.out.println("min is " + ordering.min(numbers));

		//反序
		Collections.sort(numbers, ordering.reverse());
		System.out.println("reverse list:");
		System.out.println(numbers);

		numbers.add(null);
		System.out.println("null is added.");
		System.out.println(numbers);

		//允许null排序，并且可以指定null在头、在尾
		Collections.sort(numbers, ordering.nullsFirst());
		System.out.println("null first list:");
		System.out.println(numbers);

		System.out.println("======================");
		List<String> names = new ArrayList<>();

		names.add("Ram");
		names.add("Shyam");
		names.add("Mohan");
		names.add("Sohan");
		names.add("Ramesh");
		names.add("Suresh");
		names.add("Naresh");
		names.add("Mahesh");
		names.add(null);
		names.add("Vikas");
		names.add("Deepak");

		//链式表达
		Collections.sort(names, ordering.nullsFirst().reverse());
		System.out.println("null first and then list reverse.");
		System.out.println(names);

	}


}
