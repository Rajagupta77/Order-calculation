package testing;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	@Test
	public void roundingTest() {
		//return (double)( Math.round((value * 100)) )/ 100;
		double actual = 13.739999771118164;
		double expected = 13.74;
		assertEquals(expected,actual,Math.abs(expected));
		
		
	}
	
	
}
