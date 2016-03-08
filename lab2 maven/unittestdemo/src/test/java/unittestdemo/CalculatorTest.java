package unittestdemo;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	Calculator calc = new Calculator();
	
	@Test
	public void checkAdding(){
		assertEquals(5,calc.add(2, 3));
		System.out.println("ADDING "+calc);
	}
	@Test
	public void checkSub(){
		assertEquals(2,calc.sub(5, 3));
		System.out.println("SUB "+calc);
	}

	@Test
	public void checkMulti(){
		assertEquals(4,calc.multi(2, 2));
		System.out.println("multi "+calc);
	}
	@Test
	public void checkDiv(){
		assertEquals(5,calc.div(5, 1));
		System.out.println("div "+calc);
	}
	
	@Test(expected = ArithmeticException.class)
	public void checkSubExpection(){
		calc.div(5, 0);
	}
}
