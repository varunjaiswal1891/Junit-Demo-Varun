package io.javabrains.varun;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.jupiter.api.Assumptions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

@DisplayName("When running MathUtils")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class MathUtilsTest {
	
	MathUtils mathUtils;
	
	@BeforeAll
    void beforeAllInit() {
		System.out.println("this needs to run before all ");
	}
	
	@BeforeEach
	void init() {
		mathUtils = new MathUtils();
	}
	
	@AfterEach
	void cleanup() {
		System.out.println("Cleaning up...");
	}

	@Nested
	@Tag("Math")
	@DisplayName("add method")
	class AddTest {
		
		@Test
		@DisplayName("when adding 2 positive numbers")
		void testAddPositive() {
			//fail("Not yet implemented");
			//System.out.println("This test ran by varun");
			//MathUtils mathUtils = new MathUtils();
			int expected =4;
			int actual = mathUtils.add(1,3);
			assertEquals(expected,actual,"should returns the right sum");
		}
		
		@Test
		@DisplayName("when adding positive/negative numbers")
		void testAddNegative() {
			int expected = -2;
			int actual = mathUtils.add(-1,-1);
			assertEquals(expected,actual, ()-> "should returns"+expected+" but got "+actual);
		}
		
	}
	
	
	
	
	@Test
	@Tag("Math")
	@DisplayName("multiply method")
	void testMultiply() {
		
		//assertEquals(12,mathUtils.multiply(4, 3),"Method should give product of two numbers");

		assertAll(
				() -> assertEquals(12,mathUtils.multiply(4, 3)),
				() -> assertEquals(0,mathUtils.multiply(0, 4)),
				() -> assertEquals(-2,mathUtils.multiply(2,-1))
				);
	}
	
	
	@Test
	@EnabledOnOs(OS.MAC)
	@Tag("Math")
	@DisplayName("Test Divide method")
	void testDivide() {
		
		//MathUtils mathUtils = new MathUtils();
		
		boolean isServerUp = true;
		//value boolean decides whether this test should run or not eg - no need to run this test if server is down
		assumeTrue(isServerUp);
		
		assertThrows(ArithmeticException.class, () -> {mathUtils.divide(2, 0);},"Method to test divide by zero to throw");
		//assertThrows(NullPointerException.class, () -> {mathUtils.divide(2, 0);},"Method to test divide by zero to throw");
	}
	
	@RepeatedTest(3)
	@Tag("CircleTag")
	void testComputeCircleRadius(RepetitionInfo repetitionInfo) {
		//MathUtils mathUtils = new MathUtils();
		System.out.println(repetitionInfo.getCurrentRepetition());
		assertEquals(314,mathUtils.computeCircleArea(10),"This should find circle area");
	}
	
	@Test
	@Disabled
	@DisplayName("TDD Method. Should not run")
	void testDisabled()
	{
		fail("This test should be disabled");
	}

}
