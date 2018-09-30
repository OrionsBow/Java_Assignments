/*
 * Christopher D'Arcy-Morkan
 * 16431304
 */

package assignment3;
public class Test {
	
	public static void main(String args[]) {		
		for(Planet p : Planet.values()) //Cycles through enums and prints them
		System.out.println(p);
		
		System.out.println("\nThe circumference of Mars = " + Planet.MARS.getCircumference(0) + "km"); //Prints circumference. int modifiers are for rounding
		System.out.println("The volume of Mercury = " + Planet.MERCURY.getVolume(-7) + "km^3\n");
	
		
		Rational r1 = new Rational(149, 624);
		Rational r2 = new Rational(450, 46);
		Rational r3 = new Rational(60, 97);
		Rational r4 = new Rational(64, 218);
		
		Rational r5 = new Rational(7,3);
		Rational r6 = new Rational(7,3);
		
		System.out.println(Rational.simplify(15, 40));
		r1.plus(r2);
		r2.minus(r3);
		r3.multipliedBy(r4);
		r4.dividedBy(r1);
		
		System.out.println(Rational.simplify(13, 40));
		r5.multipliedBy(r6);
			
	}
	
	
	
}
