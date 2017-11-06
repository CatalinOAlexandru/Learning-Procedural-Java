/* Author - Catalin Alexandru
This program was created for the Mini Project (Suggestion 2)
On this version, the game will allow the user to select how many rounds he or she wants to play.
The user will also make de decisions how to take care of the alien if they want or they will leave the alien to be angry.
After each round, 12 hours will pass and the alien will become angreier.
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

        Print("On a scale of 1 to 10...");

        // The next lines will calcualte the hunger,thirst and irritability of the alien and will save them into the records
        int h = hunger(a1); 
        a1 = setHungerLevel(a1, h); 
        int t = thirst(a1);	
        a1 = setThirstLevel(a1, t); 
        int i = irritability(a1); 
        a1 = setIrritLevel(a1, i); 

        Print("(10 means very bad and 1 means not at all)\n");

        //  The anger will pe calculated and will be pritned on the screen
        int a = anger(a1); 
        Print("(A lower anger level is better.)\n");
        a1 = setAngerLevel(a1, a);

        // The user will be asked how many round he or she wants to play (up to 3 rounds)
        int r = rounds(a1);
        int r2 = r;

        // This will loop the rounds and will allow the player to take care of the alien
        for(int jj = 1; jj <= r; jj++)
        {
	        Print("\nROUND NUMBER: " + (jj) + "\n");
	        feed(a1);
	        water(a1);
	        sing(a1);
	        a = anger(a1); // a1.name and a1.hungerlevel will be used here as well
	        a1 = setAngerLevel(a1, a);
	        Print("");

	        // The if statement will make sure the alien will not get angreier at the end of the last round, because the time will not pass
	        if(r2 == 3)
		    {
		    	timepass(a1);
		    	r2 = r2 - 1;
		    }
		    else if(r2 == 2)
		    {
		    	timepass(a1);
		    	r2 = r2 - 1;
		    }
		    else
		    {
		    	Print("\nEND OF THE GAME\n");
		    }

    	}

        System.exit(0);

    } // END Main

    // Will print a welcome message and will explain to the user what he or she will have to do
    public static void explain()
    {
        Print("\nWelcome to TRAAAAAAIN YOOOOOUR... alien...");
        Print("You will be asked to input a name for your new alien and after that the program will print something special regarding your alien.\n");
    	return;
    }  // END explain

    // Allow the user to give a name to the alien
    public static String name()
    {
        String alienname = InputString("How do you want to call your new Alien?");
        Print("Happy 0th Birthday " + alienname + " the Alien!\n");
        return alienname;
    }  // END Name

    // calculate alien's hunger level
    public static int hunger(AlienData a1)
    {
        String name = getName(a1);
        int hunger = random();
        Print(name + "'s hunger level is " + hunger + "/10.");
   
        return hunger;
    } // END hungers

    // calculate alien's thist level
    public static int thirst(AlienData a1)
    {
    	String name = getName(a1);
    	int thirst = random();
    	Print(name + "'s thirst level is " + thirst + "/10.");

    	return thirst;
    }

    // calculate alien's irritability level
    public static int irritability(AlienData a1)
    {
		String name = getName(a1);
    	int irrit = random();
    	Print(name + "'s irritability level is " + irrit + "/10.");
    	return irrit;
    }

    // generate a random number everytime the method is called
    public static int random()
    {
       final int LEVEL = 10;        // How hungry the alien can be
       Random hunger = new Random();  // Random number generator
       int random = hunger.nextInt(LEVEL) + 1; // Generate a number and adds 1, otherwise we can get 0 or we cant get 10
       return random;
    } // END random

    // allow the game to increse alien's anger by virtualy forwarding the game 12 hours
    public static void timepass(AlienData a1)
    {
    	String name = getName(a1);
        int hunger = getHungerLevel(a1);
        int thirst = getThirstLevel(a1);
        int irrit = getIrritLevel(a1);
        int anger = getAngerLevel(a1);

        Print("\n\n\n*********************************************************\n[12 Hours just passed]\n"+name+"'s hunger, thirst and Irritability Level increased:");
        

        hunger = hunger + random();
        if(hunger > 10)
        	{hunger = 10;}
        else {} 
        setHungerLevel(a1, hunger);
    	Print("Hunger level: " + hunger + "/10.");


        thirst = thirst + random();
        if(thirst > 10)
        	{thirst = 10;}
        else {}
        setThirstLevel(a1, thirst);
    	Print("Thirst level: " + thirst + "/10.");


        irrit = irrit + random();
        if(irrit > 10)
        	{irrit = 10;}
        else {}
       	setIrritLevel(a1, irrit);
        Print("Irritability level is " + irrit + "/10.");

        Print("*********************************************************\n\n\n");

        return;
    }

    // will ask the user how many rounds to play
    public static int rounds(AlienData a1)
    {
    	String name = getName(a1);
    	int rounds;
    	Print("Now it's time to try to take care of " + name + ".");
    	
   		while(true)
   		{
   			rounds = Integer.parseInt(InputString("How many rounds do you want to play? (1-3)"));
   			if(rounds >= 1 && rounds <=3)
   			{	
   				break;
   			}
   			else
   			{
   				Print("Sorry, but that is not a number I can accept... Let's try again!");
   			}
   		} // END while loop
   		return rounds;
    } // END rounds

    // calculates the anger level based on the other stats (hunger, thirst and irritability)
    public static int anger(AlienData a1)
    {
		String name = getName(a1);
        int hunger = getHungerLevel(a1);
        int thirst = getThirstLevel(a1);
        int irrit = getIrritLevel(a1);
        int anger = hunger + thirst + irrit;
        int angerlevel = 0;
        
        Print("\nPutting all of these together...");

        if(anger <= 9 && anger >=1)
        {
        	Print(name + " looks very happy! You can play together. [ANGER LEVEL 1]");
        	angerlevel = angerlevel +1;
        }
        else if(anger <= 15 && anger >=10)
        {
        	Print(name + " looks very calm at the moment, he probably likes you! [ANGER LEVEL 2]");
        	angerlevel = angerlevel +2;
        }
		else if(anger <= 21 && anger >=16)
        {
        	Print("I think " +name + " is tetchy. Please, be careful! [ANGER LEVEL 3]");
        	angerlevel = angerlevel +3;
        }
        else if(anger <= 30 && anger >= 22)
        {
			Print(name + " looks very dangerous! GET OUT THERE! [ANGER LEVEL 4]");
        	angerlevel = angerlevel +4;
        }
        else
        {
        	Print("ERROR\nERROR\nERROR\nHmm... Something didn't worked as it should. I'm sorry about that...");
        }
       
       return angerlevel;
    } // END anger

    // will allow the user to decide if he or she wants to feed the alien to decrese the hunger level
	public static void feed(AlienData a1)
	{
		String name = getName(a1);
		int hunger = getHungerLevel(a1);
		int random = random();
		
		while(true)
		{
			String ans = InputString("Do you want to feed " + name + "? Food will make " + name + " happier.\nYES/NO <-- [I'm not case sensitive]");
			
			if(ans.equalsIgnoreCase("yes"))
			{
				Print("\nAlright! Here is some food for " + name + ".");
				Print(name + " likes it!");
				hunger = hunger - random;

				if(hunger < 1)
					hunger = 1;
				else
					{}

				Print(name + "'s hunger level is " + hunger + "/10.");
				a1 = setHungerLevel(a1, hunger);
        		Print("");

				break;
			}
			else if(ans.equalsIgnoreCase("no"))
			{
				Print("\nJust be careful, maybe " + name + " will try to eat you.\n");
				break;
			}
			else
			{
				Print("\nOh... That's an unexpected answer... Lets try again!");
			}
		} // END while

		return;
	} // END feed

	// will allow the user to decide if he or she wants to give some water to the alien to decrese the thirst level
	public static void water(AlienData a1)
	{
		String name = getName(a1);
		int Thirst = getThirstLevel(a1);
		int random = random();
		
		while(true)
		{
			String ans = InputString("Do you want to give " + name + " some water? It will make him happier.\nYES/NO <-- [I'm not case sensitive]");
			
			if(ans.equalsIgnoreCase("yes"))
			{
				Print("\nAlright! Here is some water for " + name + ".");
				Print(name + " likes it!");
				Thirst = Thirst - random;

				if(Thirst < 1)
					Thirst = 1;
				else
					{}

				Print(name + "'s Thirst Level is " + Thirst + " right now!\n");
				a1 = setThirstLevel(a1, Thirst);
        		Print("");

				break;
			}
			else if(ans.equalsIgnoreCase("no"))
			{
				Print("\nJust be careful, maybe " + name + " will try to make a bad move if is not happy.\n");
				break;
			}
			else
			{
					Print("\nOh... That's an unexpected answer... Lets try again!");
			}
		} // END while

		return;
	} // END water

	// will allow the user to decide if he or she wants to sing a song to the alien to decrese the irritability level
	public static void sing(AlienData a1)
	{
		String name = getName(a1);
		int Irrit = getIrritLevel(a1);
		int random = random();
		
		while(true)
		{
			String ans = InputString("Do you want to sing a song to " + name + "? He will become happier.\nYES/NO <-- [I'm not case sensitive]");
			
			if(ans.equalsIgnoreCase("yes"))
			{
				Print("\nWow! That song is great!");
				Print(name + " likes it!");
				Irrit = Irrit - random;

				if(Irrit < 1)
					Irrit = 1;
				else
					{}

				Print(name + "'s Irrit Level is " + Irrit + " right now!\n");
				a1 = setIrritLevel(a1, Irrit);
        		Print("");

				break;
			}
			else if(ans.equalsIgnoreCase("no"))
			{
				Print("\nJust be careful, maybe " + name + " will try to make a bad move if is not happy.\n");
				break;
			}
			else
			{
					Print("\nOh... That's an unexpected answer... Lets try again!");
			}
		} // END while

		return;
	} // END irrit

	// will set the name of the alien into the records
	public static AlienData setName(AlienData p1, String name1)
    {
    	p1.name = name1;
    	return p1;
    } // END setName

	// will set the hunger level of the alien into the records
    public static AlienData setHungerLevel(AlienData p2, int hunger1)
    {
    	p2.HungerLevel = hunger1;
    	return p2;
    }  // END setHungerLevel

    // will set the anger level of the alien into the records
    public static AlienData setAngerLevel(AlienData p3, int anger1)
    {
    	p3.AngerLevel = anger1;
    	return p3;
    }  // END setAngerLevel

    // will set the thirst level of the alien into the records
    public static AlienData setThirstLevel(AlienData p4, int thirst1)
    {
    	p4.ThirstLevel = thirst1;
    	return p4;
    }

    // will set the irritability level of the alien into the records
    public static AlienData setIrritLevel(AlienData p5, int Irrit1)
    {
    	p5.IrritLevel = Irrit1;
    	return p5;
    }

    // will get and return the irritability level from the records and return it where ever the getter method was called
    public static int getIrritLevel(AlienData a1)
    {
    	return a1.IrritLevel;
    }

    // will get and return the thirst level from the records and return it where ever the getter method was called
    public static int getThirstLevel(AlienData a1)
    {
    	return a1.ThirstLevel;
    }

    // will get and return the name of the alien from the records and return it where ever the getter method was called
    public static String getName(AlienData a1)
    {
    	return a1.name;
    }  // END getName

    // will get and return the hunger level from the records and return it whereever the getter method was called
    public static int getHungerLevel(AlienData a1) // hunger is a random number
    {
    	return a1.HungerLevel;
    } // END getHungerLevel

    // will get and return the anger level from the records and return it whereever the getter method was called
    public static int getAngerLevel(AlienData a1) 
    {
    	return a1.AngerLevel;
    } // END getAngerLevel

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

} // END class alien


// A new type or records which will store everything about the alien
class AlienData
{
	String name;
	int HungerLevel;
	int AngerLevel;
	int ThirstLevel;
	int IrritLevel; // Irritability Level
}