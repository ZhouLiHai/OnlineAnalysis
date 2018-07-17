package MockJunitExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Null;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MockitoExample {
	@Test
	public void baseTest() {
		// mock一个类
		List list = mock(List.class);
		// 定义它的行为
		when(list.get(1)).thenReturn(0);

		// 测试结果
		Assertions.assertEquals(list.get(1), 0);
	}

	@Test
	public void WhenThenTest() {
		Iterator it = mock(Iterator.class);
		// 定义连续两次的返回
		when(it.next()).thenReturn(1).thenReturn(2);

		//验证这两次返回
		Assertions.assertEquals(it.next(), 1);
		Assertions.assertEquals(it.next(), 2);
	}

	@Test
	public void ReturnSmartNullTest() {
		List list = mock(List.class, RETURNS_SMART_NULLS);
		// 控制台会打印 SmartNull returned by unstubbed get() method on mock
		System.out.println(list.get(0));
	}

	@Test
	public void ThrowExceptionTest() {
		List list = mock(List.class);
		// 抛出异常
		when(list.get(1)).thenThrow(NullPointerException.class);

		// 验证异常
		Assertions.assertThrows(NullPointerException.class, () -> {
			list.get(1);
		});
	}
}
