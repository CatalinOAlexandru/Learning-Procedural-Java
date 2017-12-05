/* Author - Catalin Alexandru
trying to sort an array
*/

import java.util.*; // it imports the entire java util library and makes it available to use

public class sorting
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	sorting(createarray());
    	System.exit(0);
    }   // END Main

    public static void sorting(int[] numbers);
    {
    	Print(numbers[0]);
    	Print(numbers[1]);
    	Print(numbers[2]);
    	Print(numbers[3]);
    	Print(numbers[4]);
    	Print("");

    	For(int i=0; i<=numbers.length-2; i++)
		{
			If(a[i] > a[i+1])
			Swap(a, I, i+1)
		}

    	return;
    }

    public static int createarray();
    {
    	int[] numbers = new int[5];
    	numbers[0] = 5;
    	numbers[1] = 58;
    	numbers[2] = 4;
    	numbers[3] = 6;
    	numbers[4] = -15;

    	return numbers;
    }

    public static void swap(int[]a, int I, int j)
	{
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
	}

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

	// a method which will allow me to get a integer input from the user faster
	public static int InputInt (String message)
	{
		Scanner scanner = new Scanner(System.in);
		Print(message);
		return Integer.parseInt(scanner.nextLine());
	} // END Input Integer

} // END class sorting