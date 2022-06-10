package io.javabrains.varun;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MathUtilsTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		//System.out.println("This test ran by varun");
		MathUtils mathUtils = new MathUtils();
		int expected =4;
		int actual = mathUtils.add(1,44);
		assertEquals(expected,actual,"The add method should add two numbers");
	}

}
