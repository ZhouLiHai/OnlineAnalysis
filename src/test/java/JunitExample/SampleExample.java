package JunitExample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SampleExample {
	@Test
	public void shouldBeEqual() {
		Assertions.assertEquals(2, 1 + 1);
		System.out.println("On testing.");
	}
}
