package GuavaExample;

import com.google.common.base.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		Integer value1 = null;
		Integer value2 = 10;

		//fromNullable允许值为null, of不允许、会出现NullPointerException.
		System.out.println(OptionalExample.sum(Optional.fromNullable(value1), Optional.of(value2)));
	}

	public static Integer sum(Optional<Integer> a, Optional<Integer> b) {
		//确认a、b是否有值
		System.out.println(a.isPresent());
		System.out.println(b.isPresent());

		//如果a、b没有值，则使用默认值
		Integer value1 = a.or(0);
		Integer value2 = b.get();

		return value1 + value2;
	}
}
