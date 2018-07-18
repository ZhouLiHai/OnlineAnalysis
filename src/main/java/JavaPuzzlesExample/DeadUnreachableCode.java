package JavaPuzzlesExample;


/**
 * We all must have been faced compilation errors related to “Unreachable code”
 * and some may have noticed “dead code warning“.
 * Above puzzle is related to them only.
 */
public class DeadUnreachableCode {

	public void method1() {
		System.out.println("how to do");
		return;
		// 会爆出无法访问语句的错误
		//System.out.println("in java.");
	}

	public void method2() {
		System.out.println("how to do");
		if (true) {
			return;
		}
		// 这样却不会有问题
		System.out.println("in java");
	}

	public void method3() {
		System.out.println("how to do");
		while (true) {
			return;
		}
		// 会爆出无法访问语句的错误
		//System.out.println("in java");
	}

	public void method4() {
		System.out.println("how to do");
		// 这样就知道，如果两个条件都走，那么代码可达性检测就会生效
		/*
		if (true) {
			return;
		} else {
			return;
		}*/
		System.out.println("in java");
	}

	public static void main(String[] args) {
		DeadUnreachableCode deadUnreachableCode = new DeadUnreachableCode();

		/**
		 * 编译器会检查代码是否可达，但是if代码块是个例外，如果你只处理了if的一种可能，
		 * 那么编译器就不会去检查可达性
		 */
		deadUnreachableCode.method1();
		deadUnreachableCode.method2();
		deadUnreachableCode.method3();
	}
}
