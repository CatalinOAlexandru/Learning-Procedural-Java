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

        Print("On a scale of 1 to 10...");

        int h = hunger(a1); // a1.name and a1.hungerlevel will be used here
        a1 = setHungerLevel(a1, h); // transfer the random number into a1.hungerlevel
        int t = thirst(a1);
        a1 = setThirstLevel(a1, t);
        int i = irritability(a1);
        a1 = setIrritLevel(a1, i);

        Print("(10 means very bad and 1 means not at all)\n");

        int a = anger(a1); // a1.name and a1.hungerlevel will be used here as well
        Print("(A lower anger level is better.)\n");
        a1 = setAngerLevel(a1, a);

        int r = rounds(a1);
        int r2 = r;

        for(int jj = 1; jj <= r; jj++)
        {
	        Print("\nROUND NUMBER: " + (jj) + "\n");
	        feed(a1);
	        water(a1);
	        sing(a1);
	        a = anger(a1); // a1.name and a1.hungerlevel will be used here as well
	        a1 = setAngerLevel(a1, a);
	        Print("");

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

    public static void explain()
    {
        Print("\nWelcome to TRAAAAAAIN YOOOOOUR... alien...");
        Print("You will be asked to input a name for your new alien and after that the program will print something special regarding your alien.\n");
    	return;
    }  // END explain

    public static String name()
    {
        String alienname = InputString("How do you want to call your new Alien?");
        Print("Happy 0th Birthday " + alienname + " the Alien!\n");
        return alienname;
    }  // END Name

    public static int hunger(AlienData a1)
    {
        String name = getName(a1);
        int hunger = random();
        Print(name + "'s hunger level is " + hunger + "/10.");
   
        return hunger;
    } // END hungers

    public static int thirst(AlienData a1)
    {
    	String name = getName(a1);
    	int thirst = random();
    	Print(name + "'s thirst level is " + thirst + "/10.");

    	return thirst;
    }

    public static int irritability(AlienData a1)
    {
		String name = getName(a1);
    	int irrit = random();
    	Print(name + "'s irritability level is " + irrit + "/10.");
    	return irrit;
    }

    public static int random()
    {
       final int LEVEL = 10;        // How hungry the alien can be
       Random hunger = new Random();  // Random number generator
       int random = hunger.nextInt(LEVEL) + 1; // Generate a number and adds 1, otherwise we can get 0 or we cant get 10
       return random;
    } // END random

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

    public static AlienData setThirstLevel(AlienData p4, int thirst1)
    {
    	p4.ThirstLevel = thirst1;
    	return p4;
    }

    public static AlienData setIrritLevel(AlienData p5, int Irrit1)
    {
    	p5.IrritLevel = Irrit1;
    	return p5;
    }

    public static int getIrritLevel(AlienData a1)
    {
    	return a1.IrritLevel;
    }

    public static int getThirstLevel(AlienData a1)
    {
    	return a1.ThirstLevel;
    }

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


class AlienData
{
	String name;
	int HungerLevel;
	int AngerLevel;
	int ThirstLevel;
	int IrritLevel; // Irritability Level
}