package JunitExample;

import com.google.common.collect.Range;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 都是非常简单的断言，尽量使用语义接近的断言。
 */

public class AllAssertExample {
	@Test
	public void assertEqualsExample() {
		Assertions.assertEquals(1, 1, "They are not equal.");
	}

	@Test
	public void assertTrueExample() {
		Assertions.assertTrue(true, "True");
	}

	@Test
	public void assertFalseExample() {
		Assertions.assertFalse(false, "False");
	}

	@Test
	public void assertNotNullExample() {
		Assertions.assertNotNull(new Object(), "Is null.");
	}

	@Test
	public void assertSameExample() {
		Object obj = new Object();
		Assertions.assertSame(obj, obj, "There are not same.");
	}

	@Test
	public void assertSameArrayExample() {
		// TODO: 能转换为list？
		Range<Integer> range = Range.closed(1, 10);

		Integer[] list = {1, 2, 3, 4, 5};
		Assertions.assertArrayEquals(list, list, "There are not same list.");
	}

	@Test
	public void assertExpectedThrowExample() {
		Assertions.assertThrows(NumberFormatException.class, () -> {
			Integer.parseInt("One");
		});
	}
}
