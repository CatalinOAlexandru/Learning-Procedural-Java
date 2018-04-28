
import java.util.*; // it imports the entire java util library and makes it available to use

public class taxi
{  

	public static final int MAX_DAYS = 3; // for test only. it should be 28
	public static final int Max_Periods = 3;

  	// Program starting point
    public static void main (String[] param)
    {
    	String[] stations = {"Kings Cross", "Liverpool Street", "Paddington","Euston"};
		String[] periods = {"Morning", "Afternoon", "Evening"};
    	
		String[] Records = new String[MAX_DAYS];

		String ans = "";
		while(!(ans.equalsIgnoreCase("EXIT")))
		{
			for(int d =  0; d<=MAX_DAYS; d++)
			{
				Records[d] = addData(d, stations, periods);
			}
		}

    	System.exit(0);
    }   // END Main

    public static Record addData(int day, String[] stations, String[] periods)
    {
    	Print("+++Day "+d);

    	return Record
    }

    // a method which will allow me to print messages faster
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
	public static int InputInt(String message)
	{
		Scanner scanner = new Scanner(System.in);
		Print(message);
		return Integer.parseInt(scanner.nextLine());
	} // END Input Integer

} // END class 

class Record
{
	String Station;
	String Period;
	Int Taking;
}