package JavaPuzzlesExample;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {
	public static void main(String[] args) {
		Integer[] array = {1,2,3,4,5,6,7,8};
		int size = array.length;

		/**
		 * 算法原理：
		 * set在调用add方法的时候如果失败，则返回false
		 * 如果返回false那么即意味着有重复，就把重复项添加到duplicates集合中
		 * 因为duplicates是一个HashSet，所以不能元素重复，所以在原array中不管重复几次都可以保证输出一次。
		 */
		Set<Integer> set = new HashSet<>();
		Set<Integer> duplicates = new HashSet<>();

		for (int i = 0; i < size; i++) {
			if (set.add(array[i]) == false) {
				duplicates.add(array[i]);
			}
		}

		if (duplicates.size() == 0) {
			duplicates.add(-1);
		}

		System.out.println(duplicates);
	}
}
