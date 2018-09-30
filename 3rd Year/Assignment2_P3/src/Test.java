/*
 * Name: Christopher D'Arcy
 * Student ID: 16431034
 */
import java.text.DecimalFormat;

public class Test {
    public static void main(String args[]){
       	BookOrder SarahsOrder = new BookOrder(); //Create new BookOrder
       	
/****************************************** Discount Creation ******************************************************/      	
       	try {
       	Discount classicDiscount = new Discount (50,35, "Classic");
       	}catch(IllegalArgumentException e){
       		e.printStackTrace();
       	}catch(ClassNotFoundException b){
       		b.printStackTrace();
       	}catch(NoClassDefFoundError c){
       		c.printStackTrace();
       	}  	
       	
       	try {
       	Discount educationDiscount = new Discount(5,12, "EducationBook");
    	}catch(IllegalArgumentException e){
    		e.printStackTrace();
    	}catch(ClassNotFoundException b){
       		b.printStackTrace();
       	}catch(NoClassDefFoundError c){
       		c.printStackTrace();
       	}
       	
       	try {
       	Discount novelDiscount = new Discount(5,12, "Novel");
    	}catch(IllegalArgumentException e){
    		e.printStackTrace();
    	}catch(ClassNotFoundException b){
       		b.printStackTrace();
       	}catch(NoClassDefFoundError c){
       		c.printStackTrace();
       	} 	
/****************************************** Book Creation ******************************************************/  
        //Date not set as in future. 
        try {
            Novel educationbook3 = new Novel("Hi! I'm Clippy!", "Billy Fence", 34,"30-11-2018");
            SarahsOrder.addBookToOrder(educationbook3);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
        //Date not set as published in future
        try {
            Classic classic4 = new Classic("Who's Romeo's Juliet", "Frank Ocean", 14,"04-08-2020");
            SarahsOrder.addBookToOrder(classic4);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
        //Date set successfully.
        try {
            Classic classic5 = new Classic("King Lear: Resurrection ", "Seymore Leek", 59,"29-02-1996");
            SarahsOrder.addBookToOrder(classic5);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
      //Date not set as month out of bounds. 
        try {
            EducationBook educationbook3 = new EducationBook("Rocks: What are they?", "Adam Loving", 34,"09-13-2010");
            SarahsOrder.addBookToOrder(educationbook3);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
      //Date not set as published on Saturday. 
        try {
            EducationBook educationbook1 = new EducationBook("Why I don't have friends (number 42 may surpise you)", "Steve Jobs", 14.5,"18-01-2003");
            SarahsOrder.addBookToOrder(educationbook1);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
        //Date not set as day is out of bounds of month. 
        try {    
            Classic classic = new Classic("The Great Gooby", " Scotty \"The Swing\" F", 111, "30-02-1999");
            SarahsOrder.addBookToOrder(classic);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
        //Date not set as published before minimum publish date. 
        try {
            Classic classic1 = new Classic("How I scienced wrong", "Dead guy", 135.0, "01-12-1165");
            SarahsOrder.addBookToOrder(classic1);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
        //Date set successfully
        try { 
        	Novel novel1 = new Novel("Up", "Mr.Bean", 16.0, "08-07-2015");
        	SarahsOrder.addBookToOrder(novel1);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
        }
        
        //Date set successfully
        try { 
        	Novel novel2 = new Novel("50 Shades of Green", "Mr.Green", 23.97, "09-02-2018");
        	SarahsOrder.addBookToOrder(novel2);
        }catch(IllegalArgumentException e){
        	e.printStackTrace();
        }catch(InvalidDateException b){
        	b.printStackTrace();
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
