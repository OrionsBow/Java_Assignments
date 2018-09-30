/*
 * Christopher D'Arcy-Morkan
 * 16431304
 */

package assignment3;
import java.text.DecimalFormat;
import java.math.BigInteger;

public class Rational {
	DecimalFormat df2 = new DecimalFormat("#.##"); //How many decimal places to print
	
	private int numerator;
	private int denominator; //Instance variables
	private String decimal;
	
	public Rational(int num, int denom) {
		numerator = num;
		denominator = denom;
		decimal = df2.format((double)num/denom); //Formats to two decimal places
	}
	
	public void plus(Rational addedTo) { //adds numbers
		int newNum = (numerator*addedTo.getDenominator()) + (denominator*addedTo.getNumerator());
		int newDenom = denominator*addedTo.getDenominator(); 
		String simp = simplify(newNum,newDenom); //tries to simplify fraction
		
		printEq(addedTo, simp, " + "); //prints equation
	}

	public void multipliedBy(Rational multBy) { //multiplies numbers
		int newNum = (numerator*multBy.getNumerator());
		int newDenom = denominator*multBy.getDenominator(); 
		String simp = simplify(newNum,newDenom);

		printEq(multBy, simp, " * ");
	}
	
	public void dividedBy(Rational divBy) { //divides numbers
		int newNum = numerator*divBy.getDenominator();
		int newDenom = denominator*divBy.getNumerator(); 
		String simp = simplify(newNum,newDenom);
		
		printEq(divBy, simp, " / ");
	}
		
	public void minus(Rational takeFrom) { //subtracts numbers
		int newNum = (numerator*takeFrom.getDenominator()) - (denominator*takeFrom.getNumerator());
		int newDenom = denominator*takeFrom.getDenominator(); 
		String simp = simplify(newNum,newDenom);
		
		printEq(takeFrom, simp, " - ");
	}
	
	public static String simplify(int numerator, int denominator) { //Overloaded method that allows input of Rational and non Rational fractions
		Rational rat = new Rational(numerator, denominator); //Converts non Rational to Rational
		return simplify(rat);
	}
	
	public static String simplify(Rational toSimp) { 
		BigInteger num = BigInteger.valueOf(toSimp.getNumerator());
	    BigInteger denom = BigInteger.valueOf(toSimp.getDenominator());
	    int gcd = num.gcd(denom).intValue(); //Uses BigInteger to find Greatest Common Denominator
	   
		if(gcd == 1) //if gcd is one, cannot simplify fraction further
			return toSimp + " = " + toSimp.getDecimal(); //Only print original fraction and decimal
		Rational simp = new Rational(toSimp.getNumerator()/gcd, toSimp.getDenominator()/gcd); //Creates simplified Rational fraction
		return toSimp + " = " + simp + " = "+ simp.getDecimal(); //Otherwise simplify fraction then print the previous fraction, the simplified fraction and the decimal value
	}
	
	private int getNumerator() {
		return numerator;
	}
	
	private int getDenominator() {
		return denominator;
	}
	
	private String getDecimal() {
		return decimal;
	}
	
	public String toString() { //toString of fraction
		return "("+getNumerator() +"/" +getDenominator() +")";
	}
	
	public void printEq(Rational second, String simp, String operator) { //prints the equation
		System.out.println(toString() + operator + second + " = " + simp);
	}
}
