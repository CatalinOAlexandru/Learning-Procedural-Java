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
    	AlienData specs = new AlienData();
        explain(); // just some prints
        
        String n = name(); // get the name  
        specs = setName(specs, n); // and transform it into specs.name here
        
        int r = random(); // get a random number
        specs = setRandom(specs, r); // transfer the random number into specs.hungerlevel
        
        hunger(specs); // specs.name and specs.hungerlevel will be used here
        anger(specs); // specs.name and specs.hungerlevel will be used here as well
        System.exit(0);
    } // END Main

    public static void explain()
    {
        Print("Welcome to TRAAAAAAIN YOOOUR alien...");
        Print("You will be asked to input a name for your new alien and after that the program will print something special regarding your alien.");
    	return;
    }  // END explain

    public static String name()
    {
        String alienname = InputString("How do you want to call your new Alien?");
        Print("Happy 0th Birthday " + alienname + " the Alien!");
        return alienname;
    }  // END Name

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

    public static void hunger(AlienData specs)
    {
/*
        String alien = getName(specs);
        int hungry = getHunger(specs);
        System.out.println("On a scale of 1 to 10, " + alien + "'s hunger level is " + hungry + "/10");
*/      
        Print("FOR TEST: Alien Name: " + getName(specs) + "   Alien Hunger: " + getHunger(specs));

        return;
    } // END hunger

    public static int random()
    {
       final int LEVEL = 10;        // How hungry the alien can be
       Random hunger = new Random();  // Random number generator
       int random = hunger.nextInt(LEVEL) + 1; // Generate a number and adds 1, otherwise we can get 0 or we cant get 10
       return random;
    } // END random

    public static void anger(AlienData specs)
    {
		//String alien = getName(specs);
		// int hungry = getHunger(specs);
		Print("FOR TEST: Alien Name: " + getName(specs) + "   Alien Hunger: " + getHunger(specs));

       
    } // END anger

    public static void Print(String p)
	{
		System.out.println(p);
		return;
	} // END Print

	public static String InputString(String s)
	{
		Scanner scanner = new Sscanner(System.in);
		Print(s);
		return scanner.nextLine();
	} // END Input String
} // END class alien

class AlienData
{
	String name;
	int hungerLevel;
}