import java.util.*;

public class flag
{
	public static void main(String[] args)
	{
		int h = Integer.parseInt(input("What height?"));
		int w = Integer.parseInt(input("What width?"));

		printFlag(h, w);

		System.exit(0);
	}

	public static void printFlag(int h, int w)
	{
		for(int i=1; i<=h; i++)
		{
			String symbol;
			if((i%2)==0)
			   symbol="*"; // even
			else
			   symbol="="; // odd

			for(int ii=1; ii<=w; ii++)
			{
				System.out.print(symbol);
			}
			System.out.println("");
		}
	}

	public static String input(String m)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println(m);
		return scanner.nextLine();
	}
}