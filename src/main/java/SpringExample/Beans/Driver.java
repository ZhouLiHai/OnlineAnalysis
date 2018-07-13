package SpringExample.Beans;

public class Driver {
	private Person person;
	private int id;
	private String type;

	public Driver(Person person, int id, String type) {
		this.person = person;
		this.id = id;
		this.type = type;
	}

	public void drive() {
		System.out.println("No." + id + " is type of " + type + ".");
		person.drive();
	}
}
