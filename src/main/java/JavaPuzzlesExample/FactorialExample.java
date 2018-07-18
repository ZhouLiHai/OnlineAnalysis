package JavaPuzzlesExample;

import CallableFutureExample.FactorialCalculator;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class FactorialExample {
	public static void main(String[] args) {
		System.out.println(FactorialByStreams(5));

		System.out.println(FactorialByStreams(20));
		// 因为太大越界，这是需要用到BigInteger
		System.out.println(FactorialByStreams(21));

		// BigInteger究竟有多大？ 看看232就知道了，我也不知道极限在哪里
		System.out.println(FactorialByStreamsBig(21));
		System.out.println(FactorialByStreamsBig(232));
	}

	public static long FactorialByStreams(int n) {
		// TODO: Longstream又是什么东西？
		return LongStream.rangeClosed(1, n).reduce(1, (long a, long b) -> a * b);
	}

	public static BigInteger FactorialByStreamsBig(int n) {
		BigInteger result = BigInteger.ONE;

		for (int i = 1; i < n; i++) {
			result = result.multiply(BigInteger.valueOf(i));
		}

		return result;
	}
}
