package com.promineotech.uta;

import java.util.Random;

public class TestDemo {

	int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
	}

	int randomNumberSquared() {
		int randomInt = getRandomInt();
		return randomInt * randomInt;
	}

	public int addPositive(int a, int b) {
		if (a <= 0 || b <= 0) {
			throw new IllegalArgumentException("Both parameters must be positive!");
		}
		return a + b;
	}

	public String checkEvenOrOdd(int number) {
		if (number % 2 == 0) {
			return "Even";
		} else {
			return "Odd";
		}
	}

}