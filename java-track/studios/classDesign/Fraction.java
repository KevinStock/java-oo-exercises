package classDesign;

public class Fraction {

	private int numerator, denominator;
	
	public Fraction(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction fAdd(Fraction that) {
		int commonDenominator = 0;
		
		if (this.denominator == that.denominator) {
			return new Fraction((this.numerator + that.numerator), this.denominator);
		}
		else {
			commonDenominator = this.denominator * that.denominator;
			int newNumerator1 = this.numerator * that.denominator;
			int newNumerator2 = that.numerator * this.denominator;
			return new Fraction((newNumerator1 + newNumerator2), commonDenominator);
		}
	}
	
	public Fraction fMult(Fraction that) {
		return new Fraction((this.numerator * that.numerator), (this.denominator * that.denominator));
	}
	
	public Fraction fRecip() {
		return new Fraction(this.denominator, this.numerator);
	}
	
	public Fraction fSimple() {
		int greatestCommonFactor = 0;
		if (this.denominator > this.numerator) {
			greatestCommonFactor = this.numerator;
		}
		else {
			greatestCommonFactor = this.denominator;
		}

		for (int i = greatestCommonFactor - 1; i > 0; i--) {
			if (this.denominator % i == 0 && this.numerator % i == 0) {
				greatestCommonFactor = i;
				return new Fraction(this.numerator / greatestCommonFactor, this.denominator / greatestCommonFactor);
			}
		}
		return new Fraction(this.numerator, this.denominator);
	}
	
	public static void main(String[] args) {
		Fraction f1 = new Fraction(1, 6);
		Fraction f2 = new Fraction(2, 7);

		Fraction f3 = f1.fAdd(f2);
		System.out.println(f3.numerator + "/" + f3.denominator);
		
		Fraction f4 = f1.fMult(f2);
		System.out.println(f4.numerator + "/" + f4.denominator);
		
		Fraction f5 = f1.fRecip();
		System.out.println(f5.numerator + "/" + f5.denominator);
		
		Fraction f6 = new Fraction(32, 86);
		Fraction f7 = f6.fSimple();
		System.out.println(f7.numerator + "/" + f7.denominator);
	}

}
