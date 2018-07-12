package GuavaExample;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.Arrays;

public class JoinerExample {
	public static void main(String[] args) {
		// 拼接array元素
		System.out.println(Joiner.on(",")
		.skipNulls()
		.join(Arrays.asList(1,2,3,4,5,null,6)));
	}
}
