/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 3: Making Decisions
On the 3rd of October 2017 
This program will ask the user what drink he or she wants and will print 3 options.
Te program will wait for the user's input and will match the number inputed with the drink.
If the user inputs a different number or string instead of integer the program will print and error.
When the user input the right number the name of the product and the price will be printed in the terminal.
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use

public class drink2
{
    public static void main (String[] param)
    {
        ask();
        choice();
        System.exit(0);
    } // END main

    // Will ask the user what drink he or she wants
    public static void ask()
    {
    	System.out.println("What drink do you want?");
    	System.out.println("Type 1 for Coffee, 2 for Tea or 3 for Chocolate");
    	return;
    }

    // Will get the input from the user and will check if it is a integer or not.
    public static int userdrink()
    {
    	int number;
      
        // loop until INTEGER is entered
         while(true)
         {
            try
            {
               // Gets the input from the user
               Scanner scanner = new Scanner(System.in);
               number = scanner.nextInt();
               // if we dont use break, program will loop forever
               break;
            } 
            catch(Exception e)
            {
                // error: String found inside integer
        	    System.out.println("WRONG INPUT - Please try again");
            }

        }
	  return number;
    } // END userdrink

    // Will match the input with a drink and will print the name and price
    public static void choice()
    {
    	int order;
    	order = userdrink();
    	
    	
    		if (order == 1)
    			System.out.println("Coffee costs 3.50");
    		else
    		if (order == 2)
    			System.out.println("Tea costs 2.50");
    		else
    		if (order == 3)
    			System.out.println("Chocolate costs 3.00");
    		else
    		if (order < 1 || order > 3)
    			System.out.println("I do not have a drink for number " + order + " right now.");
    } // END choice

} // END class drink
