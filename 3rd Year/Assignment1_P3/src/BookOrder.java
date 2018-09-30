/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
import java.util.ArrayList;

public class BookOrder {
	
	private  ArrayList<Book> bookOrder = new ArrayList<Book>(50); //Stores book order
	
	// adds books to customer's book order
	public void addBookToOrder(Book b) {
		bookOrder.add(b);
	}
	
	//Gets how many books in order
    public int getNumBooksInOrder() {
        return bookOrder.size();
    }
    
  //Calculates total cost of order with book type and book age discounts included
  	public double calculateTotalCost() {
      	Book book;
      	double total = 0;
      	      	
      	for(int i=0; i<bookOrder.size(); i++) {
      		book = bookOrder.get(i);
      		
      		book.checkForAndApplyDiscount(); //Checks and applies discount if there is one
      		
      		if(book.getDiscountPrice() <= 0) //If there is a discount, add that price to total cost of order
      			total+= book.getBookCost();
      		else {
      			total += book.getDiscountPrice(); // Else add base cost
      		}
      	}
          return total;
      }
  	
  	public void listBooksInBookOrder() {
  		System.out.println("\n\nList of books in Order:\n");
  		for(int i=0; i<bookOrder.size(); i++) 
  			System.out.println(bookOrder.get(i));
  	}
}
