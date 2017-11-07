/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 7: While Loops
On the 07.11.2017
This program will ask the user to input the cars he or she just saw passing.
The program will loop to the infinite and will only stop when the user type CLOSE.
At the end the program will give 2 statistics about the lorrys which the user saw.
*/

import java.util.*; // it imports the entire java util library


public class whilething
{ 
	// It is the first method, it starts and end the program
	public static void main(String[] param) 
    {
	    whileloop();
	    System.exit(0);
		
	} // end main

	// this method will loop the answers from the users and will calculate 2 statistics
	public static void whileloop()
	{
		int car = 0;
		int van = 0;
		int lorry = 0;
		String ans;

		while(true)
		{
			ans = InputString("\nWhich kind of vehicle passed?\nYou can say: Car, Van, Lorry or Close (to stop the program).  <--- [I'm not case sensitive]");
			Print("");

			if(ans.equalsIgnoreCase("car"))
			{
				car = car + 1;
			}

			else if(ans.equalsIgnoreCase("van"))
			{
				van = van + 1;
			}

			else if(ans.equalsIgnoreCase("lorry"))
			{
				lorry = lorry + 1;
			}

			else if(ans.equalsIgnoreCase("CLOSE"))
			{
				break;
			}
			else
			{
				Print("Hmm... That was not an option... Let's try again!");
			}
		}
			double totalcars = car + lorry + van;
			double perslorry = (lorry / totalcars) * 100;

			perslorry = perslorry * 10;
			perslorry = Math.round(perslorry);
			perslorry = perslorry / 10;

			Print("You saw " + lorry + " lorries. Lorries were " + perslorry + "% of all vehicles seen in this session.");
		
		return;
	} // END whileloop

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

} // end class while
