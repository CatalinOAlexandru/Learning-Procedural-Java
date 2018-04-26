import java.util.*;

class Icsquares
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	int size = 0;
    	while(size <= 0)
    	{
    		size = InputInt("What size? Bigger than 0");
    	}

    	String symbol = InputString("What character?");

    	String ans = InputString("Do you want a line of -'s as a line of symmetry? Yes/No");

    	printSquares(size, symbol, ans);

    	System.exit(0);
    }   // END Main


    public static void printSquares(int size, String symbol, String ans)
    {
    	for(int i = 1; i<=size; i++)
    	{
    		for(int ii = 1; ii<=i; ii++)
 			{
				printLine(i, symbol);
			} 
    	}

    	printSymmetry(size, ans);

    	for(int i = size; i >= 1; i--)
    	{
    		for(int ii = 1; ii<=i; ii++)
 			{
				printLine(i, symbol);
			} 
    	}
    }

    public static void printLine(int len, String symbol)
    {
    	for(int i = 1; i <= len; i++)
    	{
    		System.out.print(symbol);
    	}
    	System.out.println();
    }

    public static void printSymmetry(int n, String ans)
    {
    	if(ans.equalsIgnoreCase("Yes"))
    	{
    		printLine(2*n, "-");
    	}
    }

    // a method which will allow me to print messages faster
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
	public static int InputInt(String message)
	{
		Scanner scanner = new Scanner(System.in);
		Print(message);
		return Integer.parseInt(scanner.nextLine());
	} // END Input Integer

} // END class 