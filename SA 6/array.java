/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 6: Arrays
On the
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use
import java.util.ArrayList;

public class array
{ 
	public static void main(String[] args) 
    {
  		ask();
    	System.exit(0);
	
	} // end main

	public static void ask()
	{
		Print("Tell me 5 movies you love and how much each has taken at the box office (in millions of dollars).");
		return;
	}

	public static void Print(String p)
	{
		System.out.println(p);
		return;
	} // END Print

	public static String InputString(String s)
	{
		Scanner scanner = new Scanner(System.in);
		Print(s);
		return scanner.nextLine();
	} // END Input String

} // end class array
