/*
 * Christopher D'Arcy-Morkan
 * 16431304
 */

package assignment3;
import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Planet { //Declare enums

	EARTH(1, 12756),
    MERCURY(0.0553, 4878),
    VENUS(0.815, 12104),
    MARS(0.11, 6794),
    JUPITER(317.8, 142984),
    SATURN(95.2, 120536),
    URANUS(14.6, 51118),
    NEPTUNE(17.2, 49532);
    
    private final double mass;   // in kilograms
    private final double diameter; // in meters
    
    Planet(double mass, double diameter) {
        this.mass = mass;
        this.diameter = diameter;
    }
    
    public double getCircumference(int round){ //Overloaded method to calculate circumference. Allows user defined rounding
    	BigDecimal circ = new BigDecimal(2 * Math.PI * getRadius());
    	circ = circ.setScale(round, RoundingMode.HALF_UP);
    	return circ.doubleValue(); 	
    }
    public double getCircumference(){
    	return 2 * Math.PI * getRadius();
    }
    
    public double getVolume(int round){ //Overloaded method to calculate Volume. Allows user defined rounding
    	BigDecimal volume = new BigDecimal(4 * Math.PI/3 *Math.pow(getRadius(), 3));
    	volume = volume.setScale(round, RoundingMode.HALF_UP);
    	return volume.doubleValue();
    }
    public double getVolume(){
    	return 4 * Math.PI/3 *Math.pow(getRadius(), 3);
    }
    
    public double getRadius(){
    	return (diameter/2);
    }
    
    public double getDiameter(){
    	return diameter;
    }
    
    public double getMass(){
    	return mass;
    }
    
    public String toString(){ //toString of enums
    	return name() + "\t" + mass + " E-mass" + "\t" + diameter + "km" ;
    }
}


