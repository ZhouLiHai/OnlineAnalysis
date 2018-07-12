package GuavaExample;

import com.google.common.base.Objects;

public class ObjectsExample {
	public static void main(String[] args) {
		Student s1 = new Student("a", "b", 3, "1");
		Student s2 = new Student("c", "d", 2, "2");

		System.out.println(s1.equals(s2));
		System.out.println(s1.hashCode());
	}
}

class Student {
	private String firstName;
	private String lastName;
	private int rollNo;
	private String className;

	public Student(String firstName, String lastName, int rollNo, String className) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.rollNo = rollNo;
		this.className = className;
	}

	@Override
	public int hashCode() {
		//不需要自己编写hash函数
		return Objects.hashCode(rollNo);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student) || obj == null) {
			return false;
		}

		Student student = (Student)obj;

		//不需要额外判断属性是否为null
		return Objects.equal(firstName, student.firstName)
				&& Objects.equal(lastName, student.lastName)
				&& Objects.equal(rollNo, student.rollNo)
				&& Objects.equal(className, student.className);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}
}
