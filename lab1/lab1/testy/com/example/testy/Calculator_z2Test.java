package com.example.testy;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Calculator_z2Test {
	Calculator_z2 calc = new Calculator_z2();
	
	@Test
	public void checkAdding(){
		assertEquals(5,calc.add(2, 3),0.0);
		System.out.println("ADDING "+calc);
	}
	@Test
	public void checkSub(){
		assertEquals(2,calc.sub(5, 3),0.0);
		System.out.println("SUB "+calc);
	}

	@Test
	public void checkMulti(){
		assertEquals(4,calc.multi(2, 2),0.0001);
		System.out.println("multi "+calc);
	}
	@Test
	public void checkDiv(){
		assertEquals(5,calc.div(5, 1),0.0001);
		System.out.println("div "+calc);
	}
	
	@Test(expected = ArithmeticException.class)
	public void checkSubExpection(){
		calc.div(5, 0);
	}
	
	@Test
	public void checkGreaterTrue(){
		assertTrue("failure - should be true",calc.greater(5, 3));
		System.out.println("greater true "+calc);
	}
	@Test
	public void checkGreaterFalse(){
		assertFalse("failure - should be true",calc.greater(5, 7));
		System.out.println("greater false "+calc);
	}
}
