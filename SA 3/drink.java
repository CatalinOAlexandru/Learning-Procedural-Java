/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 3: Making Decisions
On the 3rd of October 2017 / 4th of October 2017
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use

class drink
{
    public static void main (String[] param)
    {
		ask();
		// userdrink();
		choice();
		System.exit(0);
    } // END main

    public static void ask()
    {
    	System.out.println("What drink do you want?");
    	
    	return;
    }

    public static int userdrink()
    {
    	int number;

    	
    	System.out.println("Type 1 for Coffee, 2 for Tea or 3 for Chocolate");
    	
		while(true)
		{
			try
			{
				Scanner scanner = new Scanner(System.in);
				number = scanner.nextInt();
				break;
				
			}
			catch(Exception e)
			{
				
			}
		}
		
        
        

        retun number;
    }

    public static void choice()
    {
    	int order;
    	order = userdrink();
    	
    	
    		if (order == 1)
    		{
    			System.out.println("Coffee costs 3.50");
    		}
    		else
    			if (order == 2)
    			{
    				System.out.println("Tea costs 2.50");
    			}
    			else
    				if (order == 3)
    				{
    					System.out.println("Chocolate costs 3.00");
    				}
    				else
    					if (order < 1 || order > 3)
    					{
    						System.out.println("I do not have a drink for number " + order);
    					}
    }

} // END class drink
