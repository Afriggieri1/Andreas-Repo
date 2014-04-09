package com.pest.demo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestCalculator {

	Calculator calc;
	
	@Before
	public void setUp() throws Exception {
		calc = new Calculator();
	}

	@Test
	public void testAddPositiveNumbers() {
		assertEquals(6, calc.add(2, 3));
	}
	
	@Test
	public void testAddNegativeNumbers() {
		assertEquals(-6, calc.add(-3, -3));
	}
	
	@Test
	public void testSubtraction() {
		assertEquals(2, calc.subtract(10, 8));
	}
        
        @Test
	public void testDivide() {
		assertEquals(10, calc.divide(25, 5));
	}
        
        @Test
	public void testDivBy0() {
		assertEquals(1, calc.divide(20, 0));
	}
        
        @Test
	public void testMessage() {
		assertEquals("Hello World!! ", calc.getMessage(2));
	}

}
