package com.promineotech.uta;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import com.promineotech.uta.TestDemo;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("TestDemoJUnitTest#argumentsForAddPositive")

	void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class)
					.hasMessage("Both parameters must be positive!");
		}

	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(Arguments.arguments(2, 4, 6, false), Arguments.arguments(0, 4, 0, true),
				Arguments.arguments(-2, 4, 0, true), Arguments.arguments(5, 5, 10, false));

	}

	@Test
	void assertThatNumberSquaredIsCorrect() {
		// Create a mocked instance of TestDemo
		TestDemo testDemo = spy(new TestDemo());

		// Stub the getRandomInt method to return 5
		doReturn(5).when(testDemo).getRandomInt();

		// Call the method under test
		int result = testDemo.randomNumberSquared();

		// Assert the result
		assertEquals(25, result);
	}

	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
		assertThat(testDemo.addPositive(7, 7)).isEqualTo(14);
	}

	@Test
	void testCheckEvenOrOdd() {

		String result = testDemo.checkEvenOrOdd(5);
		assertEquals("Odd", result);
		// Test with even numbers
		assertThat(testDemo.checkEvenOrOdd(2)).isEqualTo("Even");
		assertThat(testDemo.checkEvenOrOdd(10)).isEqualTo("Even");
		assertThat(testDemo.checkEvenOrOdd(0)).isEqualTo("Even");

		// Test with odd numbers
		assertThat(testDemo.checkEvenOrOdd(3)).isEqualTo("Odd");
		assertThat(testDemo.checkEvenOrOdd(9)).isEqualTo("Odd");
		assertThat(testDemo.checkEvenOrOdd(-5)).isEqualTo("Odd");
	}
}