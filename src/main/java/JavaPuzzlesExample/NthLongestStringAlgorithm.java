package JavaPuzzlesExample;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class NthLongestStringAlgorithm {
	public static void main(String[] args) {
		int n = 0;
		List<String> list = new ArrayList<String>();
		list.add("Yuri");
		list.add("Ron");
		list.add("Interview");
		list.add("Longest");
		list.add("List");
		list.add("Contain");

		System.out.println(findNthLongestElement(list, 1));
		System.out.println(findNthLongestElement(list, 2));
		System.out.println(findNthLongestElement(list, 3));
	}

	private static List<String> findNthLongestElement(List<String> list, int n) {
		if (n < 1) {
			return null;
		}

		TreeMap<Integer, List<String>> treeMap = new TreeMap<>();

		/**
		 * 使用map存一个list，通过descendingKeySet方法进行排序
		 * 生成array之后，直接给出第几个元素即可。
		 */
		for (String str : list) {
			Integer length = str.length();
			List<String> tempList = treeMap.get(length) != null ? treeMap.get(length) : new ArrayList<>();
			tempList.add(str);
			treeMap.put(length, tempList);
		}

		return treeMap.get(treeMap.descendingKeySet().toArray()[n - 1]);
	}
}
