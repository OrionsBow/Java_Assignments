/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
public final class EducationBook extends Book {
    private double bookCost; 

    public EducationBook(String title, String author, double cost, String pubDate) throws IllegalArgumentException, InvalidDateException{
        super(title, author, pubDate); // call superclass constructor
        setBookCost(cost);
    }

    // set EducationBook's cost. If negative, throw exception.
    public void setBookCost(double cost) throws IllegalArgumentException{
    	if(cost > 0) //Checks if negative
    		bookCost = cost;
    		else
    			throw new IllegalArgumentException("Invalid cost:\"" + cost + "\" | \"" + this.getBookTitle() + "\" Education Book" + " cost cannot be negative.");
    }
    
    // determine EducationBook's total cost
    public double getBookCost() {
        return bookCost;
    }
    
    //Checks for discount
    public double checkForAndApplyDiscount() {
    	return Discount.checkForDiscount(this);
    }
    
    // get String representation of EducationBook's details
    public String toString() {
        return "Education Book: " + super.toString() + "Book Cost(before discounts): " + bookCost + "\n";
    }
} // end class EducationBook
