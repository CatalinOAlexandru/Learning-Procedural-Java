
import java.util.Scanner;
class factorial
{
	public static void main(String[]p)
	{
			Scanner scanner = new Scanner(System.in);
			System.out.println("\nEnter a number  ");
			String number = scanner.nextLine();
			int g = Integer.parseInt(number);
			int f = nfactorial(g);
			System.out.println("The number is " + f + "\n");
			System.exit(0);

	}


	public static int nfactorial(int n)
	{
		if(n==1)
		{
			return 1;
		}
		else
		{
		 	return (n * nfactorial(n-1));
		}

	}

}