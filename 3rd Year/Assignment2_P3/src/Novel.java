/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
public final class Novel extends Book {
    private double bookCost;

    public Novel(String title, String author, double cost, String pubDate) throws IllegalArgumentException, InvalidDateException {
        super(title, author, pubDate);
        setBookCost(cost);
    }

    // set Novel's cost. If negative number is set, throw exception
    public void setBookCost(double cost) throws IllegalArgumentException{
    	if(cost > 0) //Checks if negative number.
    		bookCost = cost;
    		else
    			throw new IllegalArgumentException("Invalid cost:\"" + cost + "\" | \"" + this.getBookTitle() + "\" Novel" + " cost cannot be negative.");
    }

    // determine Novel's total cost
    public double getBookCost() {
        return bookCost;
    }
    
    //Checks for discount
    public double checkForAndApplyDiscount() {
    	return Discount.checkForDiscount(this);
    }

    // get String representation of book details
    public String toString() {
        return "Novel: " + super.toString() + "Book Cost(before discounts): " + bookCost + "\n";
    }
} // end class Novel
