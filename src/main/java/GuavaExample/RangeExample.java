package GuavaExample;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;

public class RangeExample {
	public static void main(String[] args) {
		RangeExample rangeExample = new RangeExample();
		rangeExample.testRange();
	}

	private void testRange() {
		// jre10会出问题
		// 换成jdk8 仍然出现同样的问题， maven的锅，在maven中配置jdk版本即可
		Range<Integer> range1 = Range.closed(0,9);
		System.out.println("[0,9]:");
		printRange(range1);

		System.out.println();

		// 闭开区间
		Range<Integer> range2 = Range.closedOpen(0,9);
		System.out.println("[0, 9):");
		printRange(range2);

		System.out.println();

		//可以定义一个9到无限大的数组，可以知道range应该没有被预先分配
		Range<Integer> range3 = Range.greaterThan(9);
		//有最小值
		System.out.println(range3.lowerEndpoint());
		//但是没有最大值
		System.out.println(range3.hasUpperBound());

		System.out.println("=========");

		// 只要有交集计算是链接的
		System.out.println(range1.isConnected(Range.closed(8, 20)));
		System.out.println(range1.isConnected(Range.closed(9, 20)));
		// 哪怕是开区间
		System.out.println(range1.isConnected(Range.openClosed(9, 20)));
		System.out.println(range1.isConnected(Range.closed(10, 20)));

		System.out.println("=========");

		Range<Integer> range8 = Range.closed(5, 15);
		// 交集
		System.out.println(range1.intersection(range8));
		// 合集
		System.out.println(range1.span(range8));

	}

	private void printRange(Range<Integer> range) {
		System.out.print("[");
		for (int grade : ContiguousSet.create(range, DiscreteDomain.integers()))
		{
			System.out.print(grade + " ");
		}
		System.out.print("]");
	}
}
