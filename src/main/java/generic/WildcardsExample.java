package generic;

import java.util.LinkedList;
import java.util.List;

class WildcardsProfile {
	@SuppressWarnings("AlibabaLowerCamelCaseVariableNaming")
	public static void profileNone(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

	/**
	 * 只能接受Number以及Number的子类，因为它们至少是Number类，所以Number的操作都可以执行
	 *
	 * @param list
	 * @return
	 */
	public static Double profileUp(List<? extends Number> list) {
		Double res = 0.0;

		for (Number n : list) {
			res += n.doubleValue();
		}
		return res;
	}

	/**
	 * 当然因为能保证所给的list最多是一个Integer，所以可以向list中添加Integer的子类元素
	 * @param list
	 */
	public static void profileDown(List<? super Number> list) {
		list.add(1);
		list.add(1.1);
	}
}

/**
 * @author zhou
 */
public class WildcardsExample {
	public static void main(String[] args) {
		List<Integer> listOne = new LinkedList<>();
		listOne.add(1);
		listOne.add(2);
		listOne.add(3);
		WildcardsProfile.profileNone(listOne);

		List<Number> listTwo = new LinkedList<>();
		listTwo.add(1.2);
		listTwo.add(1);
		listTwo.add(2);
		System.out.println(WildcardsProfile.profileUp(listTwo));

		WildcardsProfile.profileDown(listTwo);
		System.out.println(WildcardsProfile.profileUp(listTwo));
	}
}
