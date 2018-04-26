import java.util.*;

public class squares
{
	public static void main(String[] args)
	{
		int lines = Integer.parseInt(Input("\nHow many lines"));
		String symbol = Input("\nWhat symbol?");
		String sym = Input("\nSymmetry? Yes/No");

		Print("");
		System.out.println(lines);
		Print(symbol);
		Print(sym);
		Print("");

		squares(lines, symbol);
		symmetry(lines, sym);
		squaresDes(lines, symbol);

	} //end main

	public static void squares(int lines, String symbol)
	{
		for(int i=1; i<=lines; i++)
		{
			symbols(i, symbol);
		}
	}

	public static void symbols(int lines, String symbol)
	{
		for(int i=1; i<=lines; i++)
		{
			printSymbols(lines, symbol);
		}
	}

	public static void printSymbols(int lines, String symbol)
	{
		for(int i=1; i<=lines; i++)
		{
			System.out.print(symbol);
		}
		Print("");
	}

	public static void symmetry(int lines, String sym)
	{
		if(sym.equalsIgnoreCase("Yes") || sym.equalsIgnoreCase("y"))
		{
			for(int i=1; i<=(lines*2); i++)
			{
				System.out.print("-");
			}
			Print("");
		}
		else{}
	}

	public static void squaresDes(int lines, String symbol)
	{
		for(int i=lines; i>=1; i--)
		{
			symbolsDes(i, symbol);
		}
	}

	public static void symbolsDes(int lines, String symbol)
	{
		for(int i=lines; i>=1; i--)
		{
			printSymbols(lines, symbol);
		}
	}

	public static void Print(String m)
	{
		System.out.println(m);
	}

	public static String Input(String m)
	{
		Scanner scanner = new Scanner(System.in);
		Print(m);
		return scanner.nextLine();
	}

} //end class
