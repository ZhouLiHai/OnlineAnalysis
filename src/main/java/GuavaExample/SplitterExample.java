package GuavaExample;

import com.google.common.base.CharMatcher;
import com.google.common.base.Splitter;

public class SplitterExample {
	public static void main(String[] args) {
		// 可以通过 CharMatcher.is('.') 来指定需要裁剪的字符范围，但是仍旧会有predicate包找不到的问题。
		// maven 的坑，maven配置的时候需要指定编译和运行的jdk版本。
		System.out.println(Splitter.on(" ")
		.trimResults(CharMatcher.is('.'))
		.omitEmptyStrings()
		.split("this is a quick review of splitter example."));
	}
}
