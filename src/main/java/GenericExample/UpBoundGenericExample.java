package GenericExample;

class UpBoundBox {
	public <Q extends Number> void inspect(Q q) {
		System.out.println(q.getClass().getName());
	}
}

public class UpBoundGenericExample {
	public static void main(String[] args) {
		UpBoundBox upBoundBox = new UpBoundBox();

		// 有界类规定了泛型所能接受的类型范围：T以及T的子类
		upBoundBox.inspect(123);
		upBoundBox.inspect(123.456);
		upBoundBox.inspect((short)123);
		upBoundBox.inspect((float)123);
	}
}
