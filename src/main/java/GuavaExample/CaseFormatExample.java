package GuavaExample;

import com.google.common.base.CaseFormat;

public class CaseFormatExample {
	public static void main(String[] args) {
		// 从短横线转换为 首字母小写的camel格式
		System.out.println(CaseFormat.LOWER_HYPHEN.to(CaseFormat.LOWER_CAMEL, "test-data"));

		// 从下划线转换为 首字母小写的camel格式
		System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "test_data"));

		// 从下划线转换为 首字母大写的camel格式
		System.out.println(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, "test_data"));

	}
}
