package MockJunitExample;

import com.google.common.base.Verify;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
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
	@Test
	public void WithArgument() {
		Comparable comparable = mock(Comparable.class);

		// 根据不同的输入，产生不同的输出
		when(comparable.compareTo("Test")).thenReturn(1);
		when(comparable.compareTo("Example")).thenReturn(2);

		Assertions.assertEquals(1, comparable.compareTo("Test"));
		Assertions.assertEquals(2, comparable.compareTo("Example"));

		// 没有定义的输入，返回默认值
		Assertions.assertEquals(0, comparable.compareTo("No stub"));
	}

	@Test
	public void WithUnspecifideArguments() {
		List list = mock(List.class);

		// 对于任何输入都会产生固定输出
		when(list.get(anyInt())).thenReturn(1);

		// 验证
		Assertions.assertEquals(1, list.get(1));
		Assertions.assertEquals(1, list.get(2));
		Assertions.assertEquals(1, list.get(3));

		// 注意，mock并不知道对象的内在逻辑，所以下面这样是行不同的，mock的逻辑是一码归一码。
		Assertions.assertTrue(!list.contains(1));
		Assertions.assertTrue(!list.contains(3));
	}

	@Test
	public void RealObjectTest() {
		List<Integer> list = new ArrayList<>();

		// 使用spy封装一层，获取到的是真实对象
		List spy = spy(list);

		spy.add(1);
		spy.add(2);

		// 验证，这是真实对象，真是对象也能做到，有个球用？
		Assertions.assertEquals(1, spy.get(0));
		Assertions.assertEquals(2, spy.get(1));

		// 球用在这，在使用真实对象的同时可以虚拟一些参数。
		doReturn(999).when(spy).size();

		// 验证，这个的作用就是我们需要使用大量的真实对象方法，但一些方法的结果不是很好模拟，就这么用。
		Assertions.assertEquals(999, spy.size());
	}

	class A {
		public int doSomething(int i) {
			return i;
		}
	}

	@Test
	public void CallRealMethodTest() {
		// 使用spy调用真实的api
		List list = spy(new ArrayList());
		Assertions.assertEquals(0, list.size());

		// 使用mock调用真实的api
		A a = mock(A.class);
		when(a.doSomething(anyInt())).thenCallRealMethod();
		Assertions.assertEquals(999, a.doSomething(999));
	}

	@Test
	public void ResetTest() {
		// 首先，测试正常的mock
		List list = mock(ArrayList.class);
		when(list.get(1)).thenReturn(100);
		Assertions.assertEquals(100, list.get(1));

		// 清除所有这个mock对象的属性，然后再测试
		reset(list);
		Assertions.assertEquals(null, list.get(1));
	}

	@Test
	public void VerifyTimesTest() {
		List list = mock(ArrayList.class);

		list.add(1);
		list.add(2);
		list.add(2);

		// 调用了几次
		verify(list, times(1)).add(1);
		verify(list, times(2)).add(2);

		// 一次没调用
		verify(list, never()).add(3);

		// 至少、至多调用了几次
		verify(list, atLeast(2)).add(2);
		verify(list, atMost(1)).add(1);
	}

	@Test
	public void InteractionTest() {
		// 定义了mock
		List list = mock(ArrayList.class);
		when(list.get(1)).thenReturn(1);
		when(list.get(2)).thenReturn(2);

//		Assertions.assertEquals(1, list.get(1));
//		Assertions.assertEquals(2, list.get(2));

		// 确没有调用
		verifyNoMoreInteractions(list);
	}

	@Test
	public void InorderTest() {
		List list1 = mock(ArrayList.class);
		List list2 = mock(ArrayList.class);

		list1.add(1);
		list2.add(4);
		list1.add(5);
		list1.add(1);


		// 验证一个调用顺序
		InOrder inOrder = inOrder(list1, list2);

		// 一下顺序与上方相同，一点都不能有变化
		inOrder.verify(list1).add(1);
		inOrder.verify(list2).add(4);
		inOrder.verify(list1).add(5);
		inOrder.verify(list1).add(1);

	}
}
