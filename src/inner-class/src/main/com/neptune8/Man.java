package main.com.neptune8;

/**
 * @author zhou
 */
public class Man {
	public Person getSuperMan() {
		class SuperMan implements Person {
			@Override
			public void introduce() {
				System.out.println("I'm super man!");
			}
		}
		return new SuperMan();
	}
}
