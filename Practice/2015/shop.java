/* Author - Catalin Alexandru
This file was created as a start template
*/

import java.util.*; // it imports the entire java util library and makes it available to use

public class shop
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	final int noItems = 50;
    	int[] items = new int[noItems];
    	String[] itemsName = new String[noItems];
    	int[] itemsNumber = new int[noItems];
    	int[] itemsPrice = new int[noItems];

    	for(int i = 0; i < items.length; i++)
    	{
    		items[i] = i+1;
    		String ans = InputString("ITEM: " + items[i]);
    		if(ans.equalsIgnoreCase("EXIT"))
    			break;
    		else{}
    		itemsName[i] = ans;
    		itemsNumber[i] = InputInt("How many " + itemsName[i] + " have you brought?");
    		itemsPrice[i] = InputInt("How much does a " + itemsName[i] + " cost in GBP?");
    	}

    	printStatement(items, itemsName, itemsNumber, itemsPrice);

    	System.exit(0);
    }   // END Main

    public static void printStatement(int[] items, String[] itemsName, int[] itemsNumber, int[] itemsPrice)
    {
    	int total;
    	for(int j = 0; j < items.length; j++)
    	{
    		if(itemsName[j] == null)
    			break;
    		else{}
    		print(items[j] + ": " + itemsName[j] + ": " + itemsNumber[j] + " left at " + itemPrice[j] + " GBP");
    		total = total + itemprice[j];

    	}
    	int sold = InputInt("What have you just sold?");
    	return;
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