/* Author - Catalin Alexandru
trying to sort an array
*/

import java.util.*; // it imports the entire java util library and makes it available to use

public class sorting
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	//sorting1(createarray()); // simple bubblesort
    	sorting2(createarray()); // advanced bubblesort
    	System.exit(0);
    }   // END Main

    public static void sorting2(int[] numbers)
    {
    	PrintInt(numbers[0]);
    	PrintInt(numbers[1]);
    	PrintInt(numbers[2]);
    	PrintInt(numbers[3]);
    	PrintInt(numbers[4]);

    	boolean sorted=false;
    	while(!sorted)
    	{
    		sorted = true; //array potentially sorted
    		for(int i=0; i<numbers.length-1; i++)
    		{
    			if(numbers[i] > numbers[i+1]) //swap them
    			{
    				int tmp = numbers[i+1];
    				numbers[i+1] = numbers[i];
    				numbers[i] = tmp;
    				sorted = false; // array wasn't sorted
    			}
    		}
    	}

    	Print("\nSorted\n");
		PrintInt(numbers[0]);
		PrintInt(numbers[1]);
		PrintInt(numbers[2]);
		PrintInt(numbers[3]);
		PrintInt(numbers[4]);
		Print("\nEND\n");

    	return;
    }

    public static void sorting1(int[] numbers)
    {
    	PrintInt(numbers[0]);
    	PrintInt(numbers[1]);
    	PrintInt(numbers[2]);
    	PrintInt(numbers[3]);
    	PrintInt(numbers[4]);

    	for(int pass=0; pass<=numbers.length-1; pass++)
		{
			for(int i=0; i<numbers.length-1-pass; i++)
			{
				if(numbers[i]>numbers[i+1])
				swap(numbers, i ,i+1);
			}
		}

		Print("\nSorted\n");
		PrintInt(numbers[0]);
		PrintInt(numbers[1]);
		PrintInt(numbers[2]);
		PrintInt(numbers[3]);
		PrintInt(numbers[4]);
		Print("\nEND\n");

    	return;
    }

    public static int[] createarray()
    {
    	int[] numbers = new int[5];
    	numbers[0] = 5;
    	numbers[1] = 58;
    	numbers[2] = 4;
    	numbers[3] = 60;
    	numbers[4] = -15;

    	return numbers;
    }

    public static void swap(int[]a, int i, int j)
	{
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
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

} // END class sorting