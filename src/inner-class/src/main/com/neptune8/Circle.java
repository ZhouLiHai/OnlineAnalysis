package main.com.neptune8;

/**
 * @author zhou
 */
public class Circle {
	private double radius = 0;
	private static int counter= 0;

	public Circle(double radius) {
		this.radius = radius;
		getDrawInstance().drawShape();
	}

	private Draw getDrawInstance() {
		return new Draw();
	}


	class Draw {
		public void drawShape() {
			System.out.println(radius + ", " + counter);
		}
	}
}
