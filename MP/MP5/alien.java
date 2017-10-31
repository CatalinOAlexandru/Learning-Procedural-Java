/* Author - Catalin Alexandru
This program was created for the Mini Project (Suggestion 2)
On the 
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use
import java.util.Random; // it imports the Random and makes it available to use

public class alien
{
    public static void main (String[] param)
    {
    	AlienData a1 = new AlienData();
        explain(); // just some prints
        
        String n = name(); // get the name  
         a1 = setName(a1, n); // and transform it into a1.name here

        int r = random(); // get a random number
        a1 = setHungerLevel(a1, r); // transfer the random number into a1.hungerlevel
        hunger(a1); // a1.name and a1.hungerlevel will be used here

        int a = anger(a1); // a1.name and a1.hungerlevel will be used here as well
        Print("A lower anger level is better.\n");
        a1 = setAngerLevel(a1, a);

        feed(a1);

        System.exit(0);

    } // END Main

    public static void explain()
    {

        Print("\nWelcome to TRAAAAAAIN YOOOUR alien...");
        Print("You will be asked to input a name for your new alien and after that the program will print something special regarding your alien.\n");
    	return;
    }  // END explain

    public static String name()
    {
        String alienname = InputString("How do you want to call your new Alien?");
        Print("Happy 0th Birthday " + alienname + " the Alien!\n");
        return alienname;
    }  // END Name

    public static AlienData setName(AlienData p1, String name1)
    {
    	p1.name = name1;
    	return p1;
    } // END setName

    public static AlienData setHungerLevel(AlienData p2, int hunger1)
    {
    	p2.HungerLevel = hunger1;
    	return p2;
    }  // END setHungerLevel

    public static AlienData setAngerLevel(AlienData p3, int anger1)
    {
    	p3.AngerLevel = anger1;
    	return p3;
    }  // END setAngerLevel

    public static String getName(AlienData a1)
    {
    	return a1.name;
    }  // END getName

    public static int getHungerLevel(AlienData a1) // hunger is a random number
    {
    	return a1.HungerLevel;
    } // END getHungerLevel

    public static int getAngerLevel(AlienData a1) 
    {
    	return a1.AngerLevel;
    } // END getAngerLevel

    public static void hunger(AlienData a1)
    {
        String name = getName(a1);
        int hunger = getHungerLevel(a1);
        Print("On a scale of 1 to 10, " + name + "'s hunger level is " + hunger + "/10.");
        Print("(1 means hungry and 10 means full)\n");

        return;
    } // END hungers

    public static int random()
    {
       final int LEVEL = 10;        // How hungry the alien can be
       Random hunger = new Random();  // Random number generator
       int random = hunger.nextInt(LEVEL) + 1; // Generate a number and adds 1, otherwise we can get 0 or we cant get 10
       return random;
    } // END random

    public static int anger(AlienData a1)
    {
		String name = getName(a1);
        int hunger = getHungerLevel(a1);
        int anger = 0;
        
        if(hunger <= 10 && hunger >=8)
        {
        	Print("Also, " + name + " looks very happy! You can play together. [ANGER LEVEL 1]");
        	anger = anger +1;
        }
        else if(hunger <= 7 && hunger >=6)
        {
        	Print(name + " looks very calm at the moment, he probably likes you! [ANGER LEVEL 2]");
        	anger = anger +2;
        }
		else if(hunger <= 5 && hunger >=4)
        {
        	Print("I think " +name + " is tetchy. Please, be careful! [ANGER LEVEL 3]");
        	anger = anger +3;
        }
        else if(hunger <= 3 && hunger >= 1)
        {
			Print(name + " looks very dangerous! BE CAREFUL OUT THERE! [ANGER LEVEL 4]");
        	anger = anger +4;
        }
        else
        {
        	Print("ERROR\nERROR\nERROR\nHmm... Something didn't worked as it should. I'm sorry about that...");
        }
       

       return anger;
    } // END anger

    public static void Print(String p)
	{
		System.out.println(p);
		return;
	} // END Print

	public static String InputString(String s)
	{
		Scanner scanner = new Scanner(System.in);
		Print(s);
		return scanner.nextLine();
	} // END Input String

	public static void feed(AlienData a1)
	{
		String name = getName(a1);
		int hunger = getHungerLevel(a1);
		int anger = getAngerLevel(a1);
		int random = random();
		
		while(true)
		{
			String ans = InputString("Do you want to feed " + name + "? Food will make " + name + " happier.\nYES/NO <-- [I'm not case sensitive]");
			
			if(ans.equalsIgnoreCase("yes"))
			{
				Print("\nAlright! Here is some food for " + name + ".");
				Print(name + " likes it!");
				hunger = hunger + random;

				if(hunger > 10)
					hunger = 10;
				else
					{}

				Print(name + "'s Hunger Level is " + hunger + " right now!\n");
				a1 = setHungerLevel(a1, hunger);
        		
        		int angerUpdate = anger(a1);
        		a1 = setAngerLevel(a1, angerUpdate);

        		Print("");

				break;
			}
			else if(ans.equalsIgnoreCase("no"))
			{
				Print("\nJust be careful, maybe " + name + " will try to eat you.");
				break;
			}
			else
			{
					Print("\nOh... That's an unexpected answer... Lets try again!");
			}
		} // END while

		Print("\n\nFOR TEST ONLY:   " + name + "   " + hunger + "   " + anger + "\n");
		return;
	} // END feed

} // END class alien


class AlienData
{
	String name;
	int HungerLevel;
	int AngerLevel;
	int ThirstLevel;
	int IrritLevel; // Irritability Level
}