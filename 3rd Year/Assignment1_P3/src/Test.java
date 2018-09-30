/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
import java.text.DecimalFormat;

public class Test {
    public static void main(String args[]) throws IllegalArgumentException, ClassNotFoundException {
       	BookOrder SarahsOrder = new BookOrder(); //Create new BookOrder
       	
       	
/****************************************** Discount Creation ******************************************************/      	
       	//Discount with error in Class argument. Throws exception
       	try {
           	Discount brokenDiscount1 = new Discount (50,35, "lassic");
           	}catch(IllegalArgumentException e){
           		System.err.println("IllegalArgumentException: " + e.getMessage());
           	}
       	
        //Discount with error in percentage argument. Throws exception
       	try {
           	Discount brokenDiscount2 = new Discount (50,-35, "Classic");
           	}catch(IllegalArgumentException e){
           		System.err.println("IllegalArgumentException: " + e.getMessage());
           	}
       	
       	//Next three discounts are correct. No exceptions
       	try {
       	Discount classicDiscount = new Discount (50,35, "Classic");
       	System.out.println("#1 worked!");
       	}catch(IllegalArgumentException e){
       		System.err.println("IllegalArgumentException: " + e.getMessage());
       	}   	
       	
       	try {
       	Discount educationDiscount = new Discount(5,12, "EducationBook");
       	System.out.println("#2 worked!");
    	}catch(IllegalArgumentException e){
    		System.err.println("IllegalArgumentException: " + e.getMessage());
    	}
       	
       	try {
       	Discount novelDiscount = new Discount(5,12, "Novel");
       	System.out.println("#3 worked!");
    	}catch(IllegalArgumentException e){
    		System.err.println("IllegalArgumentException: " + e.getMessage());
    	}
       	
       	
/****************************************** Book Creation ******************************************************/  
       	
       	
    	//Negative Novel cost tried. Exception occurs and book not added to order
        try { 
        	Novel novel = new Novel("Harry Potter", "J.K Rowling", -20.0, "31-12-2008");
        	SarahsOrder.addBookToOrder(novel);
        }catch(IllegalArgumentException e){
        	System.err.println("IllegalArgumentException: " + e.getMessage());
        }
        
        //Negative Education Book cost tried. Exception occurs, book not added
        try {
        	EducationBook educationbook = new EducationBook("My Maths 3", "James Jones", -15.6, "10-01-2018");
        	SarahsOrder.addBookToOrder(educationbook);
        }catch(IllegalArgumentException e){
        	System.err.println("IllegalArgumentException: " + e.getMessage());
        }
        
        
        
        
        //Education Book tried with eligibility for discount. Added to order with discount.
        try {
            EducationBook educationbook1 = new EducationBook("My Geo 4", "Bill Gates", 34,"15-08-2010");
            SarahsOrder.addBookToOrder(educationbook1);
        }catch(IllegalArgumentException e){
        	System.err.println("IllegalArgumentException: " + e.getMessage());
        }
        
        //Classic book tried with no discount eligibility. Added to order with no discount.
        try {    
            Classic classic = new Classic("The Great Gatsby", "F. Scott Fitzgerald", 35.0, "14-09-2000");
            SarahsOrder.addBookToOrder(classic);
        }catch(IllegalArgumentException e){
        	System.err.println("IllegalArgumentException: " + e.getMessage());
        }
        
        //Classic book tried with discount eligibility. Added to order with discount.
        try {
            Classic classic1 = new Classic("Ulysses", "Unknown", 135.0, "14-09-1900");
            SarahsOrder.addBookToOrder(classic1);
        }catch(IllegalArgumentException e){
        	System.err.println("IllegalArgumentException: " + e.getMessage());
        }
        
        //Novel tried with discount eligibility. Added to order with discount.
        try { 
        	Novel novel1 = new Novel("Up", "Mr.Bean", 16.0, "09-02-2004");
        	SarahsOrder.addBookToOrder(novel1);
        }catch(IllegalArgumentException e){
        	System.err.println("IllegalArgumentException: " + e.getMessage());
        }
        
      //Novel tried with no discount eligibility. Added to order with no discount.
        try { 
        	Novel novel2 = new Novel("DownUp", "Mr.Green", 24.0, "09-02-2018");
        	SarahsOrder.addBookToOrder(novel2);
        }catch(IllegalArgumentException e){
        	System.err.println("IllegalArgumentException: " + e.getMessage());
        }
        
        
        
        SarahsOrder.listBooksInBookOrder();
        DecimalFormat precision2 = new DecimalFormat("0.00");

        String out = "Number of books in order: "+ SarahsOrder.getNumBooksInOrder() + "\n" + "Total cost of book order is: " 
        			 + precision2.format(SarahsOrder.calculateTotalCost())  
        			 + "(including discounts)";
        			 
        			 
        System.out.print(out);
        
        System.exit(0);
    }
} // end class Test
