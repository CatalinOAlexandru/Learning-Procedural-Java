/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 6: Arrays
On the 31.10.2017
This program will ask the user to input how much some movies made in millions of dollars.
*/

import java.util.*; // it imports the entire java util library


public class array
{ 
	// a final variable for an array
	static final int arrayNumber = 5;
	
	// It is the first method, it starts and end the program
	public static void main(String[] param) 
    {

    	String[] lookupMovies;
    	int[] lookupMoney;

  		ask();
  		lookupMovies = moviesArray();
  		lookupMoney = moneyArray(lookupMovies);
  		highest(lookupMovies, lookupMoney);
  		overall(lookupMoney);
  		finalPrint(lookupMovies, lookupMoney);
    	System.exit(0);
	
	} // end main

	// Will print a message for the user
	public static void ask()
	{
		Print("Tell me 5 movies you love and how much each has taken at the box office (in millions of dollars).");
		return;
	}

	// a Method which will help me to print messages faster
	public static void Print(String p)
	{
		System.out.println(p);
		return;
	} // END Print

	// a method which will help me to get a string input froma user faster
	public static String InputString(String s)
	{
		Scanner scanner = new Scanner(System.in);
		Print(s);
		return scanner.nextLine();
	} // END Input String

} // end class array
