import java.util.*;

public class bills
{
	public static final int NO_YEARS = 10;

	public static void main(String[] args)
	{
		int[] years = new int[NO_YEARS];
		double[] gas = new double[NO_YEARS];
		double[] electricity = new double[NO_YEARS];
		int counter = 0;

		menu(years, gas, electricity, counter);
	}

	public static void menu(int[] years, double[] gas, double[] electricity, int counter)
	{
		while(true)
		{
			print("\n***** MAIN MENU *****\n");
			String ans = input("Choose one of the options:\n(1)Add Bills\n(2)Find & Print\n(3)EXIT");
			if(ans.equalsIgnoreCase("Add Bills") || ans.equals("1"))
			{
				counter = getInput(years, gas, electricity, counter);
			}
			else if(ans.equalsIgnoreCase("Find & Print") || ans.equals("2"))
			{
				findPrint(years, gas, electricity, counter);
			}
			else if(ans.equalsIgnoreCase("Exit") || ans.equals("3"))
			{
				System.exit(0);
			}
			else {print("Please input the name of the number of an option.");}
		}
	}

	public static void findPrint(int[] years, double[] gas, double[] electricity, int counter)
	{
		int ans = Integer.parseInt(input("What year are you looking for?"));
		int key = -1;
		for(int i=0; i<years.length; i++)
		{
			if(years[i]==ans)
			{
				key=i;
				break;
			}
			else 
				key= -1;
		}

		if(key==-1)
		{
			String again = input("Can't find that year. Do you want to try again? Yes/No");
			if(again.equalsIgnoreCase("Yes") || again.equals("y"))
				findPrint(years, gas, electricity, counter);
		}
		else
		{
			print("\nFound it!");
			print("Year: "+years[key]);
			print("Gas: "+gas[key]);
			print("Electricity: "+electricity[key]);
			print("\nPrinting...\n");
		}

	}

	public static int getInput(int[] years, double[] gas, double[] electricity, int counter)
	{
		if(counter == 9)
		{
			counter=0;
			print("ALTER: We will overwrite your oldest bills.\n");
		}

		years[counter] = Integer.parseInt(input("What year are the bills?"));
		gas[counter] = Double.parseDouble(input("How much is the gas bill?"));
		electricity[counter] = Double.parseDouble(input("How much is the electricity bill?"));
		counter++;

		String ans = input("Do you want to add more bills for different years? Yes/No");
		if(ans.equalsIgnoreCase("Yes") || ans.equals("y"))
			counter = getInput(years, gas, electricity, counter);
		
		return counter;
	}

	public static void print(String m) {System.out.println(m);}

	public static String input(String m)
	{
		Scanner scanner = new Scanner(System.in);
		print(m);
		return scanner.nextLine();
	}
}