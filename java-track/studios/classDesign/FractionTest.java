package classDesign;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void fAddTest() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(2,3);
		Fraction f3 = f1.fAdd(f2);
		assertTrue("Problem with numerator", f3.getNumerator() == 7);
		assertTrue("Problem with denominator", f3.getDenominator() == 6);
	}

}
