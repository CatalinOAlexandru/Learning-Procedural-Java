/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 4: Records
On the 23th of October 2017 
This program will ask the user to input a number to procced with the song.
The program will read the input, and will create a loop based on the number and will substract 1 everytime a loop is made untill the number gets to 0.
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use

public class bottle
{ 
	public static void main(String[] args) 
    {
    	looper();
    	System.exit(0);
	} // end main

	// Will ask the user to input a number
	public static int ask()
	{
		System.out.println("How many bottles?");
		Scanner scanner = new Scanner(System.in);
		int number = Integer.parseInt(scanner.nextLine());
		return number;
	} // end ask

	
	// a method which makes the print procces much easier
	public static void Print(String p)
	{
		System.out.println(p);
		return;
	}

	// will create a loop to print... things
	public static void looper()
	{
		
		int bottles;

		for (bottles = ask(); bottles >= 0; bottles--)
		{

			if (bottles > 1)
			{
				Print(bottles + " green bottles, hanging on the wall,");
				Print(bottles + " green bottles, hanging on the wall,");	
				Print("But if 1 green bottles should accidentally fall,");
				Print("There will be . . .");
				Print(" "); // empty line to have a much cleaner look in terminal
			}
			else if (bottles == 1)
			{
				Print(bottles + " green bottle, hanging on the wall,");
				Print(bottles + " green bottle, hanging on the wall,");	
				Print("But if 1 green bottles should accidentally fall,");
				Print("There will be . . .");
				Print(" "); // empty line to have a much cleaner look in terminal
			}
			else if (bottles == 0)
			{
				Print("No green bottles hanging on the wall.");
				Print(" "); // empty line to have a much cleaner look in terminal
			}
			else
			{
				Print("ERROR: Negative number...");
				Print(" "); // empty line to have a much cleaner look in terminal
			}
				

		} // End the for loop


	} // end looper

} // end class
