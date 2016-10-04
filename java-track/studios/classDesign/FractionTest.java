package classDesign;

import static org.junit.Assert.*;

import org.junit.Test;

public class FractionTest {

	@Test
	public void fAddTestSameDenom() {
		Fraction f1 = new Fraction(1,3);
		Fraction f2 = new Fraction(2,3);
		Fraction f3 = f1.fAdd(f2);
		assertTrue("Problem with numerator", f3.getNumerator() == 3);
		assertTrue("Problem with denominator", f3.getDenominator() == 3);
	}
	
	@Test
	public void fAddTestDiffDenom() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(2,3);
		Fraction f3 = f1.fAdd(f2);
		assertTrue("Problem with numerator", f3.getNumerator() == 7);
		assertTrue("Problem with denominator", f3.getDenominator() == 6);
	}

	@Test
	public void fMultTest() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = new Fraction(2,3);
		Fraction f3 = f1.fMult(f2);
		assertTrue("Problem with numerator", f3.getNumerator() == 2);
		assertTrue("Problem with denominator", f3.getDenominator() == 6);
	}
	
	@Test
	public void fRecipTest() {
		Fraction f1 = new Fraction(1,2);
		Fraction f2 = f1.fRecip();
		assertTrue("Problem with numerator", f2.getNumerator() == 2);
		assertTrue("Problem with denomintor", f2.getDenominator() == 1);
	}
	
	@Test
	public void fSimpleTestNotSimplified() {
		Fraction f1 = new Fraction(6,18);
		Fraction f2 = f1.fSimple();
		assertTrue("Problem with numerator", f2.getNumerator() == 1);
		assertTrue("Problem with denominator", f2.getDenominator() == 3);
	}
	
	@Test
	public void fSimpleTestSimplified() {
		Fraction f1 = new Fraction(1,5);
		Fraction f2 = f1.fSimple();
		assertTrue("Problem with numerator", f2.getNumerator() == 1);
		assertTrue("Problem with denominator", f2.getDenominator() == 5);
	}
}
