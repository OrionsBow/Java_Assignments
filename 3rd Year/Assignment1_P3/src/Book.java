/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Book {

    private String bookTitle;
    private String bookAuthor;
    private double discountPrice;
    
    private static int idNumGenerator = 100; //Used to assign ID numbers to books
    private int bookIdNum;
    
    private LocalDate publishDate;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy"); //Formats what pattern in publishDate string DateTimeFormatter is searching for.
    
    public Book(String title, String author, String pubDate) {
        bookTitle = title;
        bookAuthor = author;
        publishDate = LocalDate.parse(pubDate, dateFormat); //Parses String to LocalDate variable
        bookIdNum = idNumGenerator; //Assigns book ID
        idNumGenerator++; //Increments ID Generator (for unique IDs)
    }
        
    public abstract double checkForAndApplyDiscount();
    
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
    
    //// get String representation of Book's details (without cost)
    public String toString() {
        return bookTitle + " by " + bookAuthor + "\n"
        	   + "Published: "  + publishDate + "\n"
        	   + "Book ID #" + bookIdNum + "\n";
    }
    
    //For implementation in child classes
    public abstract double getBookCost();
} //end of Book class
