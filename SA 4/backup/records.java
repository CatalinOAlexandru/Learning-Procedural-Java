import java.util.Scanner; // it imports the Scanner and makes it available to use

public class records
{  
	// It's like a global variable so all functions in records class could use it
	// So
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
        // returns users input as an String
    	return scanner.nextLine(); 
    } 
  
    // if ass is not true return "not"  (! means not, example (if you add ! to true > !true < it will be false))
    public static String potatodecide(boolean ass)
    {
        if(!ass)
          return " not ";
          else
          return "";
    }

    // Check if user input matches our data set
    // it would be better to use Arrays or Switch cases 
    // If our name == text then return our values eg Mile End,Kings Cross
    public static String hentaibabe()
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
    }
  
    public static void underground() 
    {
    
    	// Create new object called "me"
    	me = new Station();
    	// get user input
    	//while(true) 
    	//{
	        me.name = ask();
	        
	       // if( me.name.equals("STOP"))
	        //	break;
	        
	      // me.hentaibabe().equals(me.name)
	      // when we run the program this is how it looks like
	      // if("returned data from our function" == "what user types")
	        
	    	if (hentaibabe().equals(me.name))  
	    		System.out.println(me.name + " is in Zone " + me.zone + " and does " + potatodecide(me.wca) + "have wheelchair access.") ;
	        else
	        System.out.println("Is " + me.name + " a London Underground Station? Maybe check your spelling");
    	//}
    }

} 

 class Station
 {
	  String name; 
	  int zone;
	  boolean wca; // wca = Wheelchair access
 } // END Class Station



