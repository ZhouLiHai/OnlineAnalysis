package JavaPuzzlesExample;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapPut {
	public static void main(String[] args) {
		Map map = new TreeMap();

		map.put("1", "a");
		map.put("2", "b");

		// 如果key存在，则返回value，如果key不存在，返回null，如果
		System.out.println(map.put("2", "b"));
		System.out.println(map.put("2", "d"));
		System.out.println(map.put("3", "c"));
	}
}
