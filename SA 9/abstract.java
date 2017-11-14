/* Author - Catalin Alexandru
Shourt assessment 9
*/

import java.util.*; // it imports the entire java util library and makes it available to use

public class abstract
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	
    	System.exit(0);
    }   // END Main

    // a method which will allow me to print messages faster
    public static void Print(String p)
	{
		System.out.println(p);
		return;
	} // END Print

	// a method which will allow me to get a string input from the user faster
	public static String InputString(String s)
	{
		Scanner scanner = new Scanner(System.in);
		Print(s);
		return scanner.nextLine();
	} // END Input String

} // END abstract