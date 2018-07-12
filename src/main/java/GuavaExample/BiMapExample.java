package GuavaExample;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapExample {
	public static void main(String[] args) {
		BiMap<Integer, String> biMap = HashBiMap.create();
		biMap.put(101,"a");
		biMap.put(102,"b");
		biMap.put(103,"c");

		//可以根据value求key
		System.out.println(biMap.inverse().get("b"));
	}
}
