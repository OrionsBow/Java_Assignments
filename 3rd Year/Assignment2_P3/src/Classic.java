/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
public final class Classic extends Book {
    private double bookCost; 

    public Classic(String title, String author, double cost, String pubDate) throws IllegalArgumentException, InvalidDateException {
        super(title, author, pubDate); 
        setBookCost(cost);
    }

    // set Classic's cost. If negative, throw exception.
    public void setBookCost(double cost) throws IllegalArgumentException{
    	if(cost > 0) //Checks if negative
    		bookCost = cost;
    		else
    			throw new IllegalArgumentException("Invalid cost:\"" + cost + "\" | \"" + this.getBookTitle() + "\" Classic" + " cost cannot be negative.");
    }

    public double getBookCost() {
        return bookCost;
    }
    
    //Checks for discount
    public double checkForAndApplyDiscount() {
    	return Discount.checkForDiscount(this);
    }
    
    // get String representation of EducationBook's details
    public String toString() {
        return "Classic: " + super.toString() + "Book Cost(before discounts): " + bookCost + "\n";
    }
}// End Classic class
