/* Author - Catalin Alexandru
This program was created for the Mini Project (Suggestion 2)
*/

import java.util.*; // it imports the entire java util library and makes it available to use
import java.io.*;

public class alien
{
    public static void main (String[] param) throws IOException
    {
        readStatistics(); // it can read old game statistics
        explain(); // just some prints

        int AngerLVL = 0;
        int alienCount;

        while(true)
        {
            try
            {
                alienCount = Integer.parseInt(InputString("How many aliens do you want to take care of?"));
                break;
            }
            catch(Exception e)
            {
                Print("\nERROR: Please input a number.");
            }
        }

        AlienData[] a1 = new AlienData[alienCount];
        
        for(int a = 0; a < alienCount; a++) 
        {
            a1[a] = new AlienData();

            String n = name(); // get the name  
            a1[a] = setName(a1[a], n); // and transform it into a1.name here

            Print("On a scale of 1 to 10...");

            // The next lines will calcualte the hunger,thirst and irritability of the alien and will save them into the records
            a1[a] = setHungerLevel(a1[a], hunger(a1[a]));   
            a1[a] = setThirstLevel(a1[a], thirst(a1[a])); 
            a1[a] = setIrritLevel(a1[a], irritability(a1[a])); 

            Print("(10 means very bad and 1 means not at all)\n");

            //  The anger will pe calculated and will be pritned on the screen
            AngerLVL = anger(a1[a]); 
            Print("(A lower anger level is better.)\n");
            a1[a] = setAngerLevel(a1[a], AngerLVL);
            
            // The user will be asked how many round he or she wants to play (up to 3 rounds)
       
        }

        int numberRounds = rounds(a1);
        AlienData[][] RoundsCount = ressurectionAL(a1, numberRounds, AngerLVL, alienCount);
      
        //bubblesort(RoundsCount, alienCount, numberRounds);
      
        statistics(a1, numberRounds, alienCount, RoundsCount);

        System.exit(0);

    } // END Main

    // this method will ask the user if he or she want to print any game statistics from previous games or just continue to the game
    public static void readStatistics() throws IOException
    {
    	String ans  = "";
    	String ans2 = "";
    	Print("Do you want to START a new game or READ previous game Statistics?");
    	
    	while(true)
    	{
    		ans = InputString("Write START or READ <-- [I'm not case sensitive]");
    		if(ans.equalsIgnoreCase("READ"))
    		{
    			Print("");
    			try(BufferedReader inputStream = new BufferedReader(new FileReader("statistics.txt"))) 
    			{
    				for(String lineToPr; (lineToPr = inputStream.readLine()) != null;) 
    				{
    					Print(lineToPr);
    				}
				}

    			Print("Do you want to CONTINUE to a new game or CLOSE the game?");
    	
    			while(true)
    			{
    				ans2 = InputString("Write CONTINUE or CLOSE <-- [I'm not case sensitive]");
    				if(ans2.equalsIgnoreCase("CONTINUE"))
    				{
    					Print("");
    					return;
    				}
    				else if(ans2.equalsIgnoreCase("CLOSE"))
    				{
    					Print("\nThanks for playing! (Code 04)\n");
    					System.exit(0);
    				}
    				else
    				{
    					Print("\nThat's an unexpected answer... Let's try again!");
    				}
    			}
    		}
    		else if(ans.equalsIgnoreCase("START"))
    		{
    			return;
    		}
    		else
    		{
    			Print("\nThat's an unexpected answer... Let's try again!");
    		}
    	}
    } // END readStatistics

    // This method will sort the aliens and the rounds inside the RoundsCount array
    public static void bubblesort(AlienData[][] RoundsCount, int alienCount, int numberRounds)
    {
		System.out.println(RoundsCount[0][0]); // Alien 1 Round 1
		System.out.println(RoundsCount[0][1]); // Alien 1 Round 2

		System.out.println(RoundsCount[1][0]); // Alien 2 Round 1
    	System.out.println(RoundsCount[1][1]); // Alien 2 Round 2

    	Print("");
/*

    	boolean sorted=false;
    	while(!sorted)
    	{
    		sorted = true; //array potentially sorted
    		for(int i=0; i<RoundsCount.length-1; i++)
    		{
    			if(RoundsCount[i] > RoundsCount[i+1]) //swap them
    			{
    				int tmp = RoundsCount[i+1];
    				RoundsCount[i+1] = RoundsCount[i];
    				RoundsCount[i] = tmp;
    				sorted = false; // array wasn't sorted
    			}
    		}
    	}
*/
    	System.out.println(RoundsCount[0][0]); // Alien 1 Round 1
		System.out.println(RoundsCount[0][1]); // Alien 1 Round 2

		System.out.println(RoundsCount[1][0]); // Alien 2 Round 1
    	System.out.println(RoundsCount[1][1]); // Alien 2 Round 2

    	Print("");

/* ------------------------------------------- OLD ---------------------------------------------------------------
    	boolean sorted = false;
     	int f = 0;
     	int k = 0;
    	// int c is the current alien
    	// int jj is the current round which contains all the data of the c alien
    	while(!sorted)
    	{
    		sorted = true;
      		f = 0; // Alien number
        	k = 0; // Round number
		Print("The Aliens with the highest Anger level in Round " + (k+1) + " are:");
    		while(f+1 < alienCount && k+1 < numberRounds)
    		{
    			// print
    			if(getAngerLevel(RoundsCount[f][k]) > getAngerLevel(RoundsCount[f+1][k])) // swap them
    			{
    				// print
    				int tmp = getAngerLevel(RoundsCount[f+1][k]);
    				//RoundsCount[f+1][k] = setAngerLevel(RoundsCount[f+1][k], getAngerLevel(RoundsCount[f][k])); // original line
    				setAngerLevel(RoundsCount[f+1][k], getAngerLevel(RoundsCount[f][k])); // new line for test
    				//RoundsCount[f][k] = setAngerLevel(RoundsCount[f][k], tmp); // original line
    				setAngerLevel(RoundsCount[f][k], tmp); //new line for test
    				sorted = false; // array wasn't sorted
    			} // end if statement
                f = f +1;
                k = k +1;
                for(int rc = 1; rc <= numberRounds; rc++)
    			{
    				Print("Alien number " + rc + " with anger level " + getAngerLevel(RoundsCount[rc][(k-1)]));
    			}
   			} // end for loop
    	} // end while loop
---------------------------------------------- END OLD -------------------------------------------------------------- */
    	return;
    } // end bubblesort

    // this method will swap data inside an array
    public static void swap(int[]a, int i, int j)
	{
		int t = a[j];
		a[j] = a[i];
		a[i] = t;
		return;
	} // END swap

	// this method will increse the hunger level of other aliens when one of them will die
    public static void EatAlien(AlienData[] a1, String DeadAlienname) {
        
        for(int a = 0; a < a1.length; a++) {
            // check if alien is alive
            if(a1[a].dead == false) {
                // do something with alive alien
                System.out.println(a1[a].name + " is eating " + DeadAlienname + "'s dead body!! [Hunger Level Increased]");
                a1[a].HungerLevel += 3;
            }
        }   
        return;
    } // END EatAlien
    
    // will allow the user to ressurect the alien 
    // will allow the user to check the statistics at the end of the game
    public static AlienData[][] ressurectionAL(AlienData[] a1, int r, int a, int alienCount)
    {
        int alienCount2 = alienCount + 10;
        AlienData[][] RoundsCount = new AlienData[alienCount2][alienCount2];
        
        for(int c = 0; c < a1.length; c++) // START 1st for loop
        {    
	        int angerKiller = 0;
	        int randres     = random();
	        int r2          = r; // r2 represents a back-up of the round number, r will be modified
	        
	        String n        = getName(a1[c]);

        // This will loop the rounds and will allow the player to take care of the alien
        for(int jj = 1; jj <= r; jj++) // START 2nd for loop
        {
            Print("\nROUND NUMBER: " + (jj) + " for Alien " + n +"\n");
            feed(a1[c]);
            water(a1[c]);
            sing(a1[c]);
            a = anger(a1[c]); // a1.name and a1.hungerlevel will be used here as well
            a1[c] = setAngerLevel(a1[c], a);
            
            if(a == 4) {angerKiller = angerKiller + 1;}
            else {angerKiller = 0;}

            Print("");

            if(angerKiller == 3)
            {
                Print("\n" + n + " just died... I'm sorry.\n" + n + "'s heart stopped because the angry level was too high.\n");
                
                while(true)
                {
                    String res = InputString("Do you want to try to ressurect " + n + " and continue to play? [You have 50% chance to succeed]");

                    if(res.equalsIgnoreCase("yes"))
                    {
                        if(randres > 5)
                        {
                            Print("WOW! " + n + " is alive!");
                            Print("");
                            angerKiller = 0;

                            // The if statement will make sure the alien will not get angreier at the end of the last round, because the time will not pass
                            if(r2 >= 2)
                            {
                                RoundsCount[c][jj] = new AlienData();
                                RoundsCount[c][jj] = setRoundDetails(RoundsCount[c][jj], getRoundDetails(a1[c]));
                                a1[c].name = "dead";
                                timepass(a1[c]);
                                r2 = r2 - 1;
                            }
                            else
                            {
                                Print("\nEND OF THE GAME\n");
                            }

                            break;
                        }
                        else
                        {
                            Print("\nOh... " + n +" is permanently dead");
                            jj = r;
                            a1[c].dead = true;
                            EatAlien(a1,  a1[c].name);
                            break;
                        }
                    }
                    else if(res.equalsIgnoreCase("no"))
                    {
                        Print("\nAlright, " + n + " was not a great pet anyway.");
                        jj = r;
                        a1[c].dead = true;
                        EatAlien(a1,  a1[c].name);
                        break;
                    }
                    else
                    {
                        Print("\nThat's not the answer I expected... Let's try again! ");
                    }
                }
            }
            else
            {
                // The if statement will make sure the alien will not get angreier at the end of the last round, because the time will not pass
                if(r2 >= 2)
                {
                    RoundsCount[c][jj] = new AlienData();
                    RoundsCount[c][jj] = setRoundDetails(RoundsCount[c][jj], getRoundDetails(a1[c]));
         
                    timepass(a1[c]);
                    r2 = r2 - 1;
                }
                else if(r2 == 1) 
                {
                    RoundsCount[c][jj] = new AlienData();
                    RoundsCount[c][jj] = setRoundDetails(RoundsCount[c][jj], getRoundDetails(a1[c]));
                
                }
            }

            

        } // end 2nd for loop
        } // end 1st for loop
        return RoundsCount;
     } // END Ressurection

     public static void statistics(AlienData[] a1, int numberRounds, int alienCount, AlienData[][] RoundsCount) throws IOException
     {    
        int r3;
        int r4 ;
        String r3t;
        String r4t;
        String ans3 = "";
        int r4array;
        int r3array;

        Print("\nEND OF THE GAME\n");

        ans3 = InputString("\nDo you want to see the round statistics? \nType YES or anything else to refuse. <-- [I'm not case sensitive]");

        System.out.println("\nTotal Number of Aliens Created: "+ a1.length);
       
        while(ans3.equalsIgnoreCase("yes"))
        {

            while(true) {
                try {
                    while(true) {
                        r4t = InputString("1.Which Alien do you want to see?");
                        try {
                            r4 = Integer.parseInt(r4t);
                            break;
                        }catch(Exception e) {
                            Print("\nERROR: You have to input a number");
                        }
                    }
                    while(true) {
                        r3t = InputString("2.Which round do you want to see?");
                        try {
                            r3 = Integer.parseInt(r3t);
                            break;
                        }catch(Exception e) {
                            Print("\nERROR: You have to input a number");
                        }
                    }

                    r4array = (r4-1);
                    r3array = r3;

                    Print("\nAlien Number : " + (r4+1) + "\nROUND: "  + r3 + "\n");
                    Print("Hunger level was: " + getHungerLevel(RoundsCount[r4array][r3array]));
                    Print("Thirst level was: " + getThirstLevel(RoundsCount[r4array][r3array]));
                    Print("Irritability level was: " + getIrritLevel(RoundsCount[r4array][r3array]));
                    Print("Anger level was: " + getAngerLevel(RoundsCount[r4array][r3array]));
                    ans3 = InputString("\nDo you want to see any other rounds statistics? \nType YES or anything else to refuse. <-- [I'm not case sensitive]");
                    break;
                    
                }catch(Exception e) {
                    Print("ERROR: That number is too large and you probably don't have data into that round/alien.");
                }
            }
 
        }

        String ans4 = "";
        ans4 = InputString("Do you want to SAVE the statistics? \nType YES or anything else to refuse. <-- [I'm not case sensitive]");

        if(ans4.equalsIgnoreCase("YES"))
        {
        	PrintWriter outputStream = new PrintWriter(new FileWriter("statistics.txt"));

        	for(int pAlien=1; pAlien<=alienCount; pAlien++)
        	{
        		for(int pRound=1; pRound<=numberRounds; pRound++)
        		{
        			outputStream.println("Alien Name: " + getName(RoundsCount[(pAlien-1)][pRound]) + " --- Round Number: " + pRound);
        			outputStream.println("Hunger level was: " + getHungerLevel(RoundsCount[(pAlien-1)][pRound]));
        			outputStream.println("Thirst level was: " + getThirstLevel(RoundsCount[(pAlien-1)][pRound]));
        			outputStream.println("Irritability level was: " + getIrritLevel(RoundsCount[(pAlien-1)][pRound]));
        			outputStream.println("Anger level was: " + getAngerLevel(RoundsCount[(pAlien-1)][pRound]));
        			outputStream.println("");
        		}
        	}

        	outputStream.close();
        	Print("\nStatistics Saved.");
        }
        else
        {}

        Print("Thanks for playing! (Code 03)\n");

        return;
    } // END statistics

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
        String alienname = InputString("\nHow do you want to call your new Alien?");
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
        int hunger  = getHungerLevel(a1);
        int thirst  = getThirstLevel(a1);
        int irrit   = getIrritLevel(a1);

        Print("\n\n\n*********************************************************\n[12 Hours just passed]\n"+name+"'s hunger, thirst and irritability Level increased:");
        

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
    public static int rounds(AlienData[] a1)
    {
        int rounds;
            
            // this loop will make sure that the user will only input the right amont of rounds
            while(true)
            {
    
                // this loop will not allow the program to crash if the user will not input an integer
                while(true)
                {
                    try
                    {
                        rounds = Integer.parseInt(InputString("How many rounds do you want to play?"));
                        break; // will stop the loop
                    }
                    catch(Exception e)
                    {
                        Print("\nWRONG INPUT - Please try again\n");
                    }
                }
    
                if(rounds >= 1 && rounds <=999)
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
        
        if(anger >= 22)
        Print("NOTE: If " + name + "'s anger level will be level 4 for 3 rounds in a row, " + name + " will die. (This message will print only if Anger Level is 4)");
        else {}
       
        
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

                Print(name + "'s Thirst Level is " + Thirst + "/10 right now!\n");
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

                Print(name + "'s Irrit Level is " + Irrit + "/10 right now!\n");
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
    // will get all the data from the records and return them wherever the method is called
    public static AlienData setRoundDetails(AlienData p6, AlienData rounds)
    {
        p6.name = getName(rounds);
        p6.HungerLevel = getHungerLevel(rounds);
        p6.ThirstLevel = getThirstLevel(rounds);
        p6.IrritLevel = getIrritLevel(rounds);
        p6.AngerLevel = getAngerLevel(rounds);
        return p6;
    }

    public static AlienData setAngerDetails(AlienData p7, AlienData rounds)
    {
        p7.AngerLevel = getAngerLevel(rounds);
        return p7;
    }

    // will get the the a1 records and pass it into an array
    public static AlienData getRoundDetails(AlienData a1)
    {
        return a1;
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

    // a method which will allow me to print string messages faster
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
	public static int InputInt (String message)
	{
		Scanner scanner = new Scanner(System.in);
		Print(message);
		return Integer.parseInt(scanner.nextLine());
	} // END Input Integer

} // END class alien


// A new type or records which will store everything about the alien
class AlienData
{
    String name;
    int HungerLevel;
    int AngerLevel;
    int ThirstLevel;
    int IrritLevel; // Irritability Level
    boolean dead = false;
}