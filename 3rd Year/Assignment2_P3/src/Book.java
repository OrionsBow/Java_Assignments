/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public abstract class Book {

    private String bookTitle;
    private String bookAuthor;
    private double discountPrice;
    
    private static int idNumGenerator = 100; //ID numbers gen for books
    private int bookIdNum;
    
    private String dateFormat = "dd-MM-uuuu"; //Regular expression set to find date in string
    private LocalDate publishDate;
    
    //Looks for regular expression in string when called. Resolver type set to strict to stop auto-correcting errors to allow exception handling
    private DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.STRICT);; 
  
    public Book(String title, String author, String pubDate) throws InvalidDateException {
        bookTitle = title;
        bookAuthor = author;
        
        try { //Catches exception created by LocalDate and converts it to generic InvalidDateException
    		setPubDate(LocalDate.parse(pubDate, dateTimeFormatter));
    	}catch(java.time.format.DateTimeParseException c){
    		throw new InvalidDateException("Error in book: \"" + getBookTitle() + "\" - Publish Date " + c.getMessage()); 
    	}
        bookIdNum = idNumGenerator++; //Assigns book ID
    }
  
    //Determines validity of publish date and sets it if valid
    public void setPubDate(LocalDate pubDate) throws InvalidDateException {
    	LocalDate dateNow = LocalDate.now();
    	LocalDate minDate = LocalDate.of(1200, 1, 1);  //Any date before this is invalid
    	
    	Period bookAge = Period.between(pubDate, dateNow);  //Gets age of book
    	Period minDateCheck = Period.between(minDate, pubDate); //Gets period between min date and published date

    	DayOfWeek dayOfWeek = pubDate.getDayOfWeek(); //Gets day of week of date
  	
    	if(bookAge.isNegative())  //Future date check
    		throw new InvalidDateException("Error in book: \"" + getBookTitle() + "\" - Publish Date \"" +pubDate +"\" Invalid. Date cannot be set in future");
    	else if(minDateCheck.isNegative()) //Minimum date check
    		throw new InvalidDateException("Error in book: \"" + getBookTitle() + "\" - Publish Date \"" +pubDate +"\" Invalid. Date cannot be set before 1st January 1200");
    	else if(dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) //Weekend check
    		throw new InvalidDateException("Error in book: \"" + getBookTitle() + "\" - Publish Date \"" +pubDate +"\" Invalid. Books are not published on weekends");
    	
    	else{publishDate = pubDate;}
    }
        
    public abstract double checkForAndApplyDiscount();
    
    //For implementation in child classes
    public abstract double getBookCost();
    
    //Sets discount price independent to base cost. In case discount is removed.
    public void setDiscountPrice(double price) {
        discountPrice = price;
    }
    
    public double getDiscountPrice() {
       return discountPrice;
    }
    
    public String getBookTitle() {
        return bookTitle;
    }
    
    public String getBookAuthor() {
        return bookAuthor;
    }
    
    public LocalDate getPublishDate() {
        return publishDate;
    }
    
    public int getBookIdNumber() {
        return bookIdNum;
    }
    
    // get String representation of Book's details (without cost)
    public String toString() {
        return bookTitle + " by " + bookAuthor + "\n"
        	   + "Published: "  + publishDate + "\n"
        	   + "Book ID #" + bookIdNum + "\n";
    }
} //end of Book class
