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
    	//AlienData specs = new AlienData();
        explain(); // just some prints
        
        String n = name(); // get the name  
        //specs = setName(specs, n); // and transform it into specs.name here
        
        int r = random(); // get a random number
       // specs = setRandom(specs, r); // transfer the random number into specs.hungerlevel
        
        hunger(n, r); // specs.name and specs.hungerlevel will be used here
        anger(n, r); // specs.name and specs.hungerlevel will be used here as well
        System.exit(0);
    } // END Main

    public static void explain()
    {
    	Print(""); // line of space
        Print("Welcome to TRAAAAAAIN YOOOUR alien...");
        Print("You will be asked to input a name for your new alien and after that the program will print something special regarding your alien.");
        Print(""); // line of space
    	return;
    }  // END explain

    public static String name()
    {
        String alienname = InputString("How do you want to call your new Alien?");
        Print("Happy 0th Birthday " + alienname + " the Alien!");
        Print(""); // line of space
        return alienname;
    }  // END Name
/*
    public static AlienData setName (AlienData specs, String n)
    {
    	specs.name = n;
    	return specs;
    } // END setName

    public static AlienData setRandom (AlienData specs, int r)
    {
    	specs.hungerLevel = r;
    	return specs;
    }  // END setRandom

    public static String getName(AlienData n)
    {
    	return specs.name;
    }  // END getName

    public static int getHunger(AlienData h) // hunger is a random number
    {
    	return specs.hungerLevel;
    } // END getHunger
*/
    public static void hunger(String n, Integer r)
    {
/*
        String alien = getName(specs);
        int hungry = getHunger(specs);
        Print("On a scale of 1 to 10, " + alien + "'s hunger level is " + hungry + "/10");
*/      
        String name = n;
        int hunger = r;
        Print("On a scale of 1 to 10, " + name + "'s hunger level is " + hunger + "/10");

        return;
    } // END hunger

    public static int random()
    {
       final int LEVEL = 10;        // How hungry the alien can be
       Random hunger = new Random();  // Random number generator
       int random = hunger.nextInt(LEVEL) + 1; // Generate a number and adds 1, otherwise we can get 0 or we cant get 10
       return random;
    } // END random

    public static int anger(String n, Integer r)
    {
		//String alien = getName(specs);
		// int hungry = getHunger(specs);
		String name = n;
        int hunger = r;
        int anger = 0;
        
        if(hunger <= 10 && hunger >=8)
        {
        	Print("Also, " + name + " looks very happy! You can play together");
        	anger = anger +1;
        }
        else if(hunger <= 7 && hunger >=6)
        {
        	Print(name + " looks very calm at the moment, he probably likes you!");
        	anger = anger +2;
        }
		else if(hunger <= 5 && hunger >=4)
        {
        	Print("I think " +name + " is tetchy. Please, be careful!");
        	anger = anger +3;
        }
        else if(hunger <= 3 && hunger >= 1)
        {
			Print(name + " looks very dangerous! GET OUT OF THERE!");
        	anger = anger +4;
        }
        else
        {
        	Print("Hmm... Something didn't worked as it should. I'm sorry about that...");
        }

        Print(""); // line of space

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
} // END class alien

/*
class AlienData
{
	String name;
	int hungerLevel;
}
*/