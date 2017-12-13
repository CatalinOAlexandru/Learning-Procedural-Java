/* Author - Catalin Alexandru
This file was created as a start template
*/

import java.util.*; // it imports the entire java util library and makes it available to use
  
public class market
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	News[] paper = new News[4];
    	for(int i = 1; i <= 3; i++) // runs 3 times for each news paper
    	{
    		paper[i] = new News();
    		newWeek(paper, i);
    	}

    	
    	for(int d = 1; d <= 7; d++) // 7 days a week
    	{
    		Print("Day " + d);
    		for(int ii = 1; ii <= 3; ii++) // runs 3 times for each news paper
    		{
    			String name = getName(paper[ii]);
    			paper[d].quantityBought = quantityBought(paper, ii, name, d);
    			paper[d].quantitySold = quantitySold(paper, ii, name, d);
    		}
    	}

    	for(int iii = 1; iii <= 3; iii++)
    	{
    		printStatement(paper, iii);
    	}	

    	System.exit(0); 
    }   // END Main

    public static void printStatement(News[] paper, int i)
    {
    	int sellPrice = getSellPrice(paper[i]);
    	int buyPrice = getBuyPrice(paper[i]);
    	String name = getName(paper[i]);

    	for(int d = 1; d <= 7; d++)
    	{
    		Print(name);
    		int intake = paper[d].quantitySold * sellPrice;
    		Print("intake: " + intake);
    		int spent = paper[d].quantityBought * buyPrice;
    		Print("spent: " + spent);
    		int profit = intake - spent;
    		Print("profit " + profit);
    	}
    	return;
    }

  	// will ask the user how many copies they bougth for the curent news paper
    public static int[] quantityBought(News[] paper, int i, String name, int d)
    {
    	int[] quantityBought = new int[8];
    	quantityBought[d] = InputInt(name + ": How many copies bought?");
    	return quantityBought;
    } 

  	// will ask the user how many copies they sold for the current news paper
    public static int[] quantitySold(News[] paper, int i, String name, int d)
    {
    	int[] quantitySold = new int[8];
    	quantitySold[d] = InputInt(name + ": How many copies sold?");
    	return quantitySold;
    }

  	// will check which news paper is in use based on the for loop
  	// will set the buy and sell price for the certain news paper
    public static void newWeek(News[] paper, int i)
    {
    	String name = "";
    	if(i == 1)
    		name = "Guardian";
    	else if(i == 2)
    		name = "Times";
    	else if(i == 3)
    		name = "Independent";
    	else
    		Print("Sorry, something is wrong");

    	paper[i] = setName(paper[i], name);
    	paper[i] = setBuyPrice(paper[i], InputInt("What price do you buy the " + name + " at?"));
    	paper[i] = setSellPrice(paper[i], InputInt("What price do you sell the " + name + "at?"));
    	return;
    }

  	// Getter and Setter Methods
    public static String getName(News paper)
    {
    	return paper.name;
    }

    public static int getBuyPrice(News paper)
    {
    	return paper.buyPrice;
    }

    public static int getSellPrice(News paper)
    {
    	return paper.sellPrice;
    }

    public static News setName(News paper, String name)
    {
    	paper.name = name;
    	return paper;
    }

    public static News setBuyPrice(News paper, int price)
    {
    	paper.buyPrice = price;
    	return paper;
    }

    public static News setSellPrice(News paper, int price)
    {
    	paper.sellPrice = price;
    	return paper;
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
class News
{
	String name;
	int[] quantityBought; // contains how many newspapers they bought every day eg. quantityBought[1] = 15; // they sold 15 newspapers in day 1
	int[] quantitySold; // -||- how many they sold
	int buyPrice;
	int sellPrice;
}