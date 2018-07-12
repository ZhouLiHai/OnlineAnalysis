package GuavaExample;

import com.google.common.math.IntMath;

import java.math.RoundingMode;

public class IntMathExample {
	public static void main(String[] args) {
		try {
			// 有检查的加法
			System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MIN_VALUE + 1));
			// 这里会报错
			// System.out.println(IntMath.checkedAdd(Integer.MAX_VALUE, Integer.MAX_VALUE));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		//这里选择无法整除之后的策略
		System.out.println(IntMath.divide(100, 5, RoundingMode.UNNECESSARY));

		try {
			// 这里应为100无法整除3，而且设置RoundingMode.UNNECESSARY 所以会报错。
			// System.out.println(IntMath.divide(100, 3, RoundingMode.UNNECESSARY));
			// 向上取整
			System.out.println(IntMath.divide(100, 3, RoundingMode.CEILING));
			// 向下取整
			System.out.println(IntMath.divide(100, 3, RoundingMode.FLOOR));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}

		System.out.println(IntMath.log2(3, RoundingMode.HALF_EVEN));

		// 计算最大公约数
		System.out.println(IntMath.gcd(100, 9));

		//计算取模
		System.out.println(IntMath.mod(100, 9));

		// 计算斐波那契累加和
		System.out.println(IntMath.factorial(5));

		/**
		 * Long、BigInteger与Int都相似
		 */
	}
}
