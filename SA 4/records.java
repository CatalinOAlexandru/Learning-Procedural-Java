/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 4: Records
On the 11th of October 2017 
This program will ask the user to input a name of an underground station
The program will read the input, will check if it is on the known list and will give the user some information
The information will be the zone of the station and if it has a wheelchair access
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use

public class records
{  
	   // It's like a global variable so all functions in records class could use it
	   // So ifstatementtrain() could access "me" object
    static Station me;
  	
  	// Program starting point
    public static void main (String[] param)
    {
    	underground();
    	System.exit(0);
    }   // END Main

    // Ask user question and return his answer 
    public static String ask() 
    { 
    	System.out.println("What station do you need to know about?");
        System.out.println("You can try: Mile End, Kings Cross, Woodford or Oxford Circus");
    	Scanner scanner = new Scanner(System.in);
        // returns users input as a String
    	return scanner.nextLine(); 
    } // END ask
  
    // if train is not true return "not"  (! means not, example (if you add ! to true > !true < it will be false))
    public static String booleanfortrain(boolean train)
    {
        if(!train)
          return " not ";
          else
          return " ";
    } // END booleanfortrain

    // Check if user input matches our data set 
    // If input name == text then return our values eg Mile End,Kings Cross
    public static String ifstatementtrain()
    {
      if(me.name.equals("Mile End"))
      {
          me.zone = 2;
          me.wca  = false; 
          return "Mile End";
      }
      else if(me.name.equals("Kings Cross"))
      {
          me.zone = 1;
          me.wca  = true;   
          return "Kings Cross";
      }
      else if(me.name.equals("Woodford"))
      {
          me.zone = 4;
          me.wca  = false;
          return "Woodford";
      }
      else if(me.name.equals("Oxford Circus"))
      {
          me.zone = 4;
          me.wca  = true;
          return "Oxford Circus";
      }
      else 
        return ""; 
    } // END ifstatementtrain
  

    public static void underground() 
    {
    
    	// Create new object called "me"
    	me = new Station();

/*          // SOLUTION 1 @@@@@
        	// get user input
	        me.name = ask();
      	        
	     	 // when we run the program this is how it looks like
	     	 // if("returned data from our function" == "what user types")
	    	if (ifstatementtrain().equals(me.name))  
	    		System.out.println(me.name + " is in Zone " + me.zone + " and does" + booleanfortrain(me.wca) + "have wheelchair access.") ;
	    	    System.out.println(""); // A line of space in the terminal
	        else
	        System.out.println("Is " + me.name + " a London Underground Station? Maybe check your spelling");
	        System.out.println(""); // A line of space in the terminal

*/	    // OR OR OR OR OR

        // SOLUTION 2 @@@@@
	    while(true) 
    	{
        	// get user input
	        me.name = ask();
	        
	        if( me.name.equals("STOP"))
	        break;
	        
	      // when we run the program this is how it looks like
	      // if("returned data from our function" == "what user types")
	    	if (ifstatementtrain().equals(me.name))
	    	{  
	    		System.out.println(me.name + " is in Zone " + me.zone + " and does" + booleanfortrain(me.wca) + "have wheelchair access.") ;
	    		System.out.println(""); // A line of space in the terminal
	        }
	        else
	        {
	        System.out.println("Is " + me.name + " a London Underground Station? Maybe check your spelling");
	        System.out.println(""); // A line of space in the terminal
    		}
    	} // END while

    } // END underground

} // END records

 class Station
 {
	  String name; 
	  int zone;
	  boolean wca; // wca = Wheelchair access
 } // END Class Station

