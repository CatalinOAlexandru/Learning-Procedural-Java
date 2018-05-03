import java.util.*;

public class taxi
{
	public static final int NO_DAYS = 2;

	public static void main(String[] args)
	{

		int[] days = new int[NO_DAYS];
		setUpDays(days);
		
		String[] stations = new String[NO_DAYS];
		int[] morning = new int[NO_DAYS];
		int[] afternoon = new int[NO_DAYS];
		int[] evening = new int[NO_DAYS];

		getInput(days, stations, morning, afternoon, evening);
		summary(days, stations, morning, afternoon, evening);
		System.exit(0);
	}

	public static void getInput(int[] days, String[] stations, int[] morning, int[] afternoon, int[]evening)
	{
		for(int i=0; i<NO_DAYS; i++)
		{
			print("");
			System.out.println("Day: " + days[i]);

			String confirm;
			String ans = input("In which station did you work?\n(1)Kings Cross/ (2)Liverpool Street/ (3)Paddington/ (4)Euston\nWrite (0)EXIT if you didn't work that day.");
			if(ans.equalsIgnoreCase("Kings Cross") || ans.equals("1"))
			{
				stations[i] = "Kings Cross";
				confirm = input("Did you work in the morning? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					morning[i] = getIncome();
				else
					morning[i] = 0;
				confirm = input("Did you work in the afternoon? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					afternoon[i] = getIncome();
				else
					afternoon[i] = 0;
				confirm = input("Did you work in the evening? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					evening[i] = getIncome();
				else
					evening[i] = 0;
			}
			else if(ans.equalsIgnoreCase("Liverpool Street") || ans.equals("2"))
			{
				stations[i] = "Liverpool Street";
				confirm = input("Did you work in the morning? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					morning[i] = getIncome();
				else
					morning[i] = 0;
				confirm = input("Did you work in the afternoon? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					afternoon[i] = getIncome();
				else
					afternoon[i] = 0;
				confirm = input("Did you work in the evening? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					evening[i] = getIncome();
				else
					evening[i] = 0;
			}
			else if(ans.equalsIgnoreCase("Paddington") || ans.equals("3"))
			{
				stations[i] = "Paddington";
				confirm = input("Did you work in the morning? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					morning[i] = getIncome();
				else
					morning[i] = 0;
				confirm = input("Did you work in the afternoon? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					afternoon[i] = getIncome();
				else
					afternoon[i] = 0;
				confirm = input("Did you work in the evening? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					evening[i] = getIncome();
				else
					evening[i] = 0;
			}
			else if(ans.equalsIgnoreCase("Euston") || ans.equals("4"))
			{
				stations[i] = "Euston";
				confirm = input("Did you work in the morning? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					morning[i] = getIncome();
				else
					morning[i] = 0;
				confirm = input("Did you work in the afternoon? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					afternoon[i] = getIncome();
				else
					afternoon[i] = 0;
				confirm = input("Did you work in the evening? Yes/No");
				if(confirm.equalsIgnoreCase("yes") || confirm.equals("y"))
					evening[i] = getIncome();
				else
					evening[i] = 0;
			}
			else if(ans.equalsIgnoreCase("Exit") || ans.equals("0"))
			{
				stations[i] = "Did not work";
				morning[i] = 0;
				afternoon[i] = 0;
				evening[i] = 0;
			}
			else
			{print("Please input the name or number of the station.");}
		}
		
	}

	public static void summary(int[] days, String[] stations, int[] morning, int[] afternoon, int[] evening)
	{
		print("\n***** SUMMARY *****\n");
		for(int i=0; i<NO_DAYS; i++)
		{
			System.out.println("\nSummary Day "+days[i]);
			System.out.println("Station: "+ stations[i]);
			System.out.println("Morning Income: £"+morning[i]);
			System.out.println("Afternoon Income: £"+afternoon[i]);
			System.out.println("Evening Income: £"+evening[i]);
			System.out.println("Total: £"+ (morning[i]+afternoon[i]+evening[i]+"\n"));
		}
	}

	public static int getIncome()
	{
		while(true)
		{
			int income = Integer.parseInt(input("How much did you earn?"));
			if(income < 0)
			{
				print("Your input cant be negative.");
			}
			else
				return income;
		}	
	}

	public static void setUpDays(int[] days)
	{
		for(int i=0; i<NO_DAYS; i++)
		{
			days[i] = i+1;
		}
	}

	public static void print(String m) {System.out.println(m);}

	public static String input(String m)
	{
		Scanner scanner = new Scanner(System.in);
		print(m);
		return scanner.nextLine();
	}
}