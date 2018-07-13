package SpringExample.Beans;

public class Person {
	private InnerBean innerBean;

	public InnerBean getInnerBean() {
		return innerBean;
	}

	public void setInnerBean(InnerBean innerBean) {
		this.innerBean = innerBean;
	}

	public void drive() {
		System.out.println("A person is drive.");
	}
}
