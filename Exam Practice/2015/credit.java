import java.util.*;

public class credit
{
	public static int MAX_CUSTO = 1000;

	public static void main(String[] args)
	{
		String[] name = new String[MAX_CUSTO];
		String[] dob = new String[MAX_CUSTO];
		int[] rating = new int[MAX_CUSTO];

		menu(name, dob, rating);
	}

	public static void menu(String[] name, String[] dob, int[] rating)
	{
		int counter = 0;
		while(true)
		{
			print("\n***** Main Menu *****\n");
			String ans = input("Choose one of the options:\n(1)Input a new customer name, date of birth and credit rating\n(2)Change the credit rating of a given customer\n(3)Find and print a given customer’s credit rating\n(4)Close down the program");
			
			if(ans.equals("1"))
				counter = newCustomer(name, dob, rating, counter);
			else if(ans.equals("2"))
				changeRating(name, rating);
			else if(ans.equals("3"))
				findPrint(name, dob, rating);
			else if(ans.equals("4"))
				System.exit(0);
			else
				print("Please input a number which coresponds to one of the options.");
		}
		
	}

	public static void changeRating(String[] name, int[] rating)
	{
		String ans = input("Input the customer name.");
		int key = findCustomer(name, ans);

		rating[key]=Integer.parseInt(input("Input the new credit rating"));
	}

	public static int findCustomer(String[] name, String ans)
	{
		int key = -1;
		for(int i=0; i<name.length; i++)
		{
			if(name[i].equalsIgnoreCase(ans))
			{
				key=i;
				break;
			}
			else 
				key= -1;
		}

		if(key==-1)
		{
			String again = input("Can't find that name. Do you want to try again? Yes/No");
			if(again.equalsIgnoreCase("Yes") || again.equals("y"))
				key = findCustomer(name, ans);
			else
				return -1;
		}
		
		return key;
	}

	public static void findPrint(String[] name, String[] dob, int[] rating)
	{
		String ans = input("Input the customer name.");
		int key = findCustomer(name, ans);
		
		if(key==-1)
			return;
		else
		{
			print("\nFound it!");
			print("Name: "+name[key]);
			print("Date of Birth: "+dob[key]);
			print("Credit Rating: "+rating[key]);
			print("\nPrinting...\n");
		}
	}

	public static int newCustomer(String[] name, String[] dob, int[] rating, int counter)
	{
		int i = counter;

			print("Customer Number(id) "+i);
			name[i]=input("Input a name:");
			dob[i]=input("Input Date of Birth. eg. 01.02.1990");
			
			while(true)
			{
				int rate = Integer.parseInt(input("Input credit rating. 1,2 or 3"));
				if(rate>3 || rate<1)
					print("The credit rating must be 1,2 or 3");
				else
				{
					rating[i]=rate;
					break;
				}
			}
		counter++;
		
		print("Total number of customers: "+counter);
		return counter;
	}	

	public static void print(String m) {System.out.println(m);}

	public static String input(String m)
	{
		Scanner sc = new Scanner(System.in);
		print(m);
		return sc.nextLine();
	}
}