import java.util.*;

public class symmetry
{
	public static void main(String[] some)
	{
		int size = Integer.parseInt(input("What size? 1 or higher"));
		String symbol = input("What symbol?");
		String sym = input("Line of symmetry? Yes/No");

		stackUpper(size, symbol);
		symmetry(size, sym);
		stackLower(size, symbol);

		System.exit(0);
	}

	public static void stackUpper(int size, String symbol)
	{
		for(int i=1; i<=size; i++)
		{
			for(int ii=1; ii<=i; ii++)
			{
				stackPrint(i, symbol);
			}
		}
	}

	public static void stackLower(int size,String symbol)
	{
		for(int i=size; i>=1; i--)
		{
			for(int ii=i; ii>=1; ii--)
			{
				stackPrint(i, symbol);
			}
		}
	}

	public static void stackPrint(int size, String symbol)
	{
		for(int i=1; i<=size; i++)
		{
			System.out.print(symbol);
		}
		print("");
	}

	public static void symmetry(int size, String sym)
	{
		if(sym.equalsIgnoreCase("yes") || sym.equalsIgnoreCase("y"))
		{
			for(int i=1; i<=(size*2); i++)
			{
				System.out.print("-");
			}
			print("");
		}
	}

	public static String input(String m)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(m);
		return scanner.nextLine();
	}

	public static void print(String m)
	{
		System.out.println(m);
	}
}