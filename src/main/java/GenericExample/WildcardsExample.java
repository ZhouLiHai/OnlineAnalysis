package GenericExample;

import java.util.LinkedList;
import java.util.List;

class WildcardsProfile {
	public static void ProfileNone(List<?> list) {
		for (Object o : list) {
			System.out.println(o);
		}
	}

	// 只能接受Number以及Number的子类，因为它们至少是Number类，所以Number的操作都可以执行
	public static Double ProfileUp(List<? extends Number> list) {
		Double res = 0.0;

		for (Number n : list) {
			res += n.doubleValue();
		}
		return res;
	}

	// 当然因为能保证所给的list最多是一个Integer，所以可以向list中添加Integer的子类元素
	public static void ProfileDown(List<? super Number> list) {
		list.add(1);
		list.add(1.1);
	}
}

public class WildcardsExample {
	public static void main(String[] args) {
		List<Integer> listOne = new LinkedList<>();
		listOne.add(1);
		listOne.add(2);
		listOne.add(3);
		WildcardsProfile.ProfileNone(listOne);

		List<Number> listTwo = new LinkedList<>();
		listTwo.add(1.2);
		listTwo.add(1);
		listTwo.add(2);
		System.out.println(WildcardsProfile.ProfileUp(listTwo));

		WildcardsProfile.ProfileDown(listTwo);
		System.out.println(WildcardsProfile.ProfileUp(listTwo));
	}
}
