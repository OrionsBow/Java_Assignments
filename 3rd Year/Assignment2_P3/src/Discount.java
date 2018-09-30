/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

public class Discount {
	private Period ageRequirement;
	private double percentDiscount;
	private Class<? extends Book> bookType; //Holds what Class each discount is valid for (Class must extend Book)
	
	private static ArrayList<Discount> discountList = new ArrayList<Discount>(20); //Stores discounts

	public Discount(int age, int pcDiscount, String type) throws ClassNotFoundException, IllegalArgumentException {
		if(age < 0 || pcDiscount < 0)
    		throw new IllegalArgumentException("Invalid discount arguments. Please check your inputs and try again"); //If negative arguments, throw exception
    	
		ageRequirement = Period.ofYears(age); //Sets how old book must be
  		percentDiscount = (double) (1-(pcDiscount * 0.01)); //Sets percentage discount
		
  		bookType =  (Class<? extends Book>) Class.forName(type); //Reads argument and stores as instance variable of current discount	
  		discountList.add(this); //add to discount list
	}
	
	public Class getBookType() {
		return bookType;
	}
	
	public Period getAgeRequirement() {
		return ageRequirement;
	}
	
	//checks for discount on specific book
	public static double checkForDiscount(Book book) {
		Period bookAge = Period.between(book.getPublishDate(), LocalDate.now()); //Gets length of time between published date and present time (book age)
		
		for(int i=0; i<discountList.size(); i++) {
			Discount disc = discountList.get(i);
			if((disc.getBookType() == book.getClass()) && !((bookAge.minus(disc.getAgeRequirement())).isNegative())) {	//Checks if book age meets discount requirements
				return disc.applyDiscount(book); //If does, apply discount and return new price
			}
		}
		return 0; //Else no discount
	}
	
	public double applyDiscount(Book b) {
		b.setDiscountPrice(b.getBookCost() * percentDiscount); //Sets discount
		return (b.getBookCost() * percentDiscount); //Calculates and returns discount.
	}
	
}
