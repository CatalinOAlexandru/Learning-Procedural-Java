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
		Print("\nTell me 5 movies you love and how much each has taken at the box office (in millions of dollars).\n");
		return;
	} // END ask

	// Will set the Movie name in arrays
	public static String[] moviesArray()
	{
		String[] Movies = new String[arrayNumber];
		Movies[0]="Despicable Me 3";
		Movies[1]="Wonder Woman";
		Movies[2]="It";
		Movies[3]="Cars 3";
		Movies[4]="Hidden Figures";

		return Movies;
	} // END movieArray

	// It will ask the user to input the amount of money the movie maid and will save the data into an array
	public static int[] moneyArray(String[] Movies)
	{
		int[] Money = new int[arrayNumber];

		Scanner scanner = new Scanner(System.in);

		for(int i = 0; i<Movies.length; i++)
		{

			Print(Movies[i]);
			Print("How much monney did " + Movies[i] + " take in millions of dollars?");
			Money[i] = Integer.parseInt(scanner.nextLine());
			Print("");
		}
		return Money;
	} // END moneyArray

	// It will print the final message with the movie names and the user input amount
	public static void finalPrint(String[] Movies, int[] Money)
	{

		Print("The films' takings are:");

		for(int fl = 0; fl < Movies.length; fl++)
		{
			Print(Movies[fl] + ", " + Money[fl]);
		}
		Print("");
		return;
	} // END finalPrint

	// this method will print the highest grossing film
	public static void highest(String[] Movies, int[] Money)
	{
		int maxValue = Money[0];
	    for (int i = 1; i < Money.length; i++) 
	    {
	        if (Money[i] > maxValue) 
	        {
	            maxValue = Money[i];
	        }
	    }

	    for(int jj=0; jj < Money.length; jj++)
	    {
	    	if(maxValue == Money[jj])
	    	{
	    		Print("The highest grossing film is currently " + Movies[jj]);
	    	}
	    }
		return;
	} // END highest

	// calculate the total income of all movies
	public static void overall(int[] Money)
	{
		int total = 0;
		for(int o = 0; o < Money.length; o++)
		{
			total = total + Money[o];
		}
		Print("The overall income of all these movies is " + total + " million of dollars.\n");
		return;
	} // END overall

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
