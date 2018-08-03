package main.com.neptune8;

/**
 * @author zhou
 */
public class App {
	public static void main(String[] args) {
		Circle circle = new Circle(5);
		Circle.Draw drawer = circle.new Draw();
		drawer.drawShape();

		System.out.println("----------- end -----------");

		Man man = new Man();
		man.getSuperMan().introduce();

		System.out.println("----------- end -----------");

		(new Person() {
			@Override
			public void introduce() {
				System.out.println("I'm a anonymous class.");
			}
		}).introduce();

		System.out.println("----------- end -----------");

		Monster.Zombie zombie= new Monster.Zombie();
		zombie.noise();
	}
}
