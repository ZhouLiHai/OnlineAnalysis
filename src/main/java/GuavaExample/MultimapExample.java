package GuavaExample;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class MultimapExample {
	public static void main(String[] args) {
		Multimap<String, String> multimap = getMultimap();

		// 获取一个多重value
		List<String> upperList = (List<String>)multimap.get("upper");
		System.out.println(upperList.toString());

		// 转换为普通的map, 当然值只能是collection
		Map<String, Collection<String>> map = multimap.asMap();

		for (Map.Entry<String, Collection<String>> entry : map.entrySet()) {
			String key = entry.getKey();
			Collection<String> value = multimap.get(key);
			System.out.println("key: " + key + " value: " + value);
		}

		// 获取所有的value，值依然只能是collection
		Collection<String> values = multimap.values();
		System.out.println(values);
	}

	private static Multimap<String, String> getMultimap() {
		Multimap<String, String> multimap = ArrayListMultimap.create();

		multimap.put("lower", "a");
		multimap.put("lower", "b");
		multimap.put("lower", "c");
		multimap.put("upper", "A");
		multimap.put("upper", "B");
		multimap.put("upper", "C");

		return multimap;
	}
}
