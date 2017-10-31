/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 4: Records
On the 10rd of October 2017 

*/

import java.util.Scanner; // it imports the Scanner and makes it available to use


public class records
{
    public static void main (String[] param)
    {
    	//ask();
    	underground();
    	System.exit(0);
    } // END Main

    public static void ask()
    {
    	String station;
    	system.out.println("What station do you need to know about?");
        system.out.println("Try Mile End, Kings Cross, Woodford, Oxford Circus");
    	Scanner scanner = new Scanner(System.in);
    	station = scanner.nextLine();
    	return station;
    }

    public static void underground();
    {
    	stname = ask();

    	// First station
    	Station me = new Station;
        me.name = "Mile End";
    	me.zone = "2";
    	me.wca = false;

    	if (stname == me.name)
    		System.out.println(me.name + " is in Zone " + me.zone + " and does " + me.wca + "have wheelchair access.")
        else
            system.out.println("");
    }

} // END class records

Class Station
{
string name; 
int zone;
boolean wca; // wca = Wheelchair access
} // END Class Station