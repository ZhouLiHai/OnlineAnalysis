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
