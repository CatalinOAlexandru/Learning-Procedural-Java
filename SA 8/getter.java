/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 8: Getter and Setter Methods
On the 9.11.2017
This program will ask the user about the base price of a car, what type of engine the user wants and if the user wants a sunroof.
After that the program will print the prices for the user's decision and a final total price.
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use

public class getter
{  
	static final int electricDiscount = -1000; // the discount of the electric model
	static final int hybridDiscount = 0; // the discount of the hybrid model
	static final int sunroofPrice = 500; // the sunroof price

  	// Program starting point
    public static void main (String[] param)
    {
    	Sales a1 = new Sales();

    	int price = price();
    	a1 = setPrice(a1, price);
    	String electric = electric();
    	a1 = setElectric(a1, electric);
    	String sunroof = sunroof();
    	a1 = setSunroof(a1, sunroof);

    	total(a1);

    	System.exit(0);
    }   // END Main

    // will get the bace price of the car
    public static int price()
    {
    	int p;

    	while(true)
    	{
    		try
    		{
    			p = Integer.parseInt(InputString("\nBase Price?"));
    			break;
    		}
    		catch(Exception e)
    		{
    			Print("\nWRONG INPUT !!! - Please enter a number");
    		}
    		
    	}
    	
    	return p;
    }

    // will get the answer from the user about the type of electric car
    public static String electric()
    {
    	String ans;
    	while(true)
    	{
    		ans =InputString("\nHybrid or Electric? <-- [I'm not case sensitive]");
    		if(ans.equalsIgnoreCase("Hybrid") || ans.equalsIgnoreCase("Electric"))
    			break;
    		else
    			Print("\nThat's an unexpected answer... Let try again:");
    	}
    	return ans;
    }

    // will get the answer if the user wants or not a sunroof
    public static String sunroof()
    {
    	String ans;
    	while(true)
    	{
    		ans =InputString("\nSun roof? YES/NO <-- [I'm not case sensitive]");
    		if(ans.equalsIgnoreCase("Yes") || ans.equalsIgnoreCase("No"))
    			break;
    		else
    			Print("\nThat's an unexpected answer... Let try again:");
    	}
    	return ans;
    }

    // This method will print the final statement about the the car price and the final total
    public static void total(Sales a1)
    {
    	int price = getPrice(a1);
    	String electric = getElectric(a1);
    	String sunroof = getSunroof(a1);

    	int electricPriceFinal = 0;
    	int sunroofPriceFinal = 0;

    	int total;

    	Print("\n\nBasic Price          : " + price);

    	if(electric.equalsIgnoreCase("Electric"))
    	{
    		electricPriceFinal = electricDiscount;
    		Print("Electric model       :" + electricPriceFinal);
    	}
    	else if(electric.equalsIgnoreCase("Hybrid"))
    	{
    		electricPriceFinal = hybridDiscount;
    		Print("Hybrid model         : " + electricPriceFinal);
    	}
    	else
    		Print("Hmm... It looks like there was a problem. I'm sorry about that.");


    	if(sunroof.equalsIgnoreCase("Yes"))
    	{
    		sunroofPriceFinal = sunroofPrice;
    		Print("Sun roof             : " + sunroofPriceFinal);
    	}
    	else if(sunroof.equalsIgnoreCase("No"))
    	{
    		Print("Sun roof             : " + sunroofPriceFinal);
    	}
    	else
    		Print("Hmm... It looks like there was a problem. I'm sorry about that.");

    	total = price + electricPriceFinal + sunroofPriceFinal;
    	Print("\nTotal                : " + total + "\n");

    	return;
    }

    // will set the price of the car into the records
    public static Sales setPrice(Sales p5, int price1)
    {
    	p5.Price = price1;
    	return p5;
    }
    // will set the electric type of the car level  into the records
    public static Sales setElectric(Sales p5, String electric1)
    {
    	p5.Electric = electric1;
    	return p5;
    }
	// will set the sunroof answer level into the records
    public static Sales setSunroof(Sales p5, String sunroof1)
    {
    	p5.Sunroof = sunroof1;
    	return p5;
    }
	// will get and return the price from the records and return it whereever the getter method was called
    public static int getPrice(Sales a1) 
    {
    	return a1.Price;
    } 
    // will get and return the electric type of the car from the records and return it whereever the getter method was called
    public static String getElectric(Sales a1) 
    {
    	return a1.Electric;
    } 
    // will get and return the sun roof answer from the records and return it whereever the getter method was called
    public static String getSunroof(Sales a1) 
    {
    	return a1.Sunroof;
    } 

    // a method which will allow me to print messages faster
    public static void Print(String p)
	{
		System.out.println(p);
		return;
	} // END Print

	// a method which will allow me to get a string input from the user faster
	public static String InputString(String s)
	{
		Scanner scanner = new Scanner(System.in);
		Print(s);
		return scanner.nextLine();
	} // END Input String

} // END getter

 class Sales
 {
	  int Price;
	  String Electric;
	  String Sunroof;

 } // END Class Sale

