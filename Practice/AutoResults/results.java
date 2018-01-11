import java.util.*;
import java.io.File; 
//import jxl.*; 

class results
{
	public static void main(String[] param)
	{
		String ans = ask();
		int id = checkid();
	}
	
	public static String ask()
	{
		while(true)
		{
			String ans = InputString("Which results do you want to see? Mid Term/Exit Test/Final");
			if(ans.equalsIgnoreCase("Mid Term"))
			{
				return ans;
			}
			else
				Print("Hmm... Thats not something I know about. Please try again.\n");
		}
	}

	public static int checkid()
	{
		while(true)
		{
			int ans = InputInt("What is your Student ID Number?");
			return ans;
		}
	}

	// a method which will allow me to print string messages faster
    public static void Print(String p)
	{
		System.out.println(p);
		return;
	} // END Print

	// a method which will allow me to print numbers faster
	public static void PrintInt(int pi)
	{
		System.out.println(pi);
		return;
	} // END Print

	// a method which will allow me to get a string input from the user faster
	public static String InputString(String s)
	{
		Scanner scanner = new Scanner(System.in);
		Print(s);
		return scanner.nextLine();
	} // END Input String

	// a method which will allow me to get a integer input from the user faster
	public static int InputInt (String message)
	{
		Scanner scanner = new Scanner(System.in);
		Print(message);
		return Integer.parseInt(scanner.nextLine());
	} // END Input Integer
}