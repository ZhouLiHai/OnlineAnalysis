package GuavaExample;

import com.google.common.base.CharMatcher;

import javax.print.DocFlavor;

public class CharMatcherExample {
	public static void main(String[] args) {
		// 过滤出其中的数字
		System.out.println(CharMatcher.DIGIT.retainFrom("haha123HI456"));
		// 过滤前后的特殊字符
		System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("   OK HI   , KiSS  #", ' '));
		// 使用特定的字符替换特定类型的字符
		System.out.println(CharMatcher.JAVA_DIGIT.replaceFrom("haha123", '*'));
		//可以使用or、and来链接规则，使用or表示满足任意一个
		System.out.println(CharMatcher.JAVA_DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("hello123"));
		//使用and表示两个都需要同时满足
		System.out.println(CharMatcher.JAVA_DIGIT.and(CharMatcher.JAVA_LOWER_CASE).retainFrom("hello123"));
	}
}
