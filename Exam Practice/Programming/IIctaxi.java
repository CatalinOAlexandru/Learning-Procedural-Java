import java.util.*; // it imports the entire java util library and makes it available to use

public class IIctaxi
{  
	public static final int MAX_days = 28;
    public static final int MAX_periods = 3;

  	// Program starting point
    public static void main (String[] param)
    {
    	
    	String[] stations = {"Kings Cross", "Liverpool Street", "PAddington", "Euston"};
    	String[] periods = {"Morning", "Afternoon", "Evening"};
    	PeriodRecord[][] periodrecords = createPeriodRecords(MAX_days, MAX_periods, periods);

    	for(int day=0; day<MAX_days; day++)
    	{
    		workDay(periodrecords, day, periods, stations);
    		summariseDay(periodrecords, day);
    	}

    	printFullSummary(periodrecords);

    	System.exit(0);
    }   // END Main

    public static PeriodRecord[][] createPeriodRecords(int MAX_days, int MAX_periods, String[] periods)
    {
    	PeriodRecord[][] periodrecords = new PeriodRecord[MAX_days][MAX_periods];
    	for(int day=0; day<MAX_days; day++)
    	{
    		for(int period=0; period<MAX_periods; period++)
    		{
    			periodrecords[day][period] = createPeriodRecord2(periods[period]);
    		}
    	}		
    	return periodrecords;
    }

    public static PeriodRecord createPeriodRecord2(String period)
    {
    	PeriodRecord pr = new PeriodRecord();
    	pr.Station = "No station";
    	pr.Period = period;
    	pr.Takings = 0;
    	return pr;
    }

    public static void workDay(PeriodRecord[][] periodrecords, int day, String[] periods, String[] stations)
    {
    	String station = pickStation(stations);
    	for(int p=0; p<MAX_periods; p++)
    	{
    		setStation(periodrecords[day][p], station);
    		String working = InputString("Are you working in the "+periods[p]+"(Y/N)");

    		if(isWorking(working))
    			workPeriod(periodrecords, day, p);
    	}

    }

    public static void workPeriod(PeriodRecord[][] periodrecords, int day, int period)
    {
    	final int QUIT = -1;
    	PeriodRecord pr = periodrecords[day][period];

    	int fare = InputInt("What is the next fare (-1 to quit)?");
    	while(!(fare==QUIT))
    	{
    		addToTakings(pr, fare);
    		fare = InputInt("What is the next fare (-1 to quit)?");
    	}
    }

    public static PeriodRecord addToTakings(PeriodRecord pr, int t)
    {
    	pr.Takings = pr.Takings + t;
    	return pr;
    }

    public static boolean isWorking(String s)
    {
    	if(s.equals("Y"))
    		return true;
    	else
    		return false;
    }

    public static String pickStation(String[] stations)
    {
    	int station = -1;
    	while((station<0) | (station>3))
    	{
    		for(int i=0; i<stations.length; i++)
    		{
    			Print(i+": "+stations[i]);
    		}
    		station = InputInt("What station will you work from today?");
    	}
    	return stations[station];
    }

    public static void summariseDay(PeriodRecord[][] periodrecords, int day)
    {
    	Print("Day " + day);
    	for(int p=0; p<MAX_periods; p++)
    	{
    		summarisePeriod(periodrecords, day, p);
    	}
    }

    public static void summarisePeriod(PeriodRecord[][] periodrecords, int day, int period)
    {
    	PeriodRecord pr = periodrecords[day][period];
    	PrintPeriod(pr);
    }

    public static void PrintPeriod(PeriodRecord pr)
    {
    	Print(" Period " + getPeriod(pr) + " Station " + getStation(pr) + " Takings " + getTakings(pr));
    }

    public static void printFullSummary(PeriodRecord[][] periodrecords)
    {
    	Print("___________________");
    	Print("Here is a full summary");
    	Print("___________________");
    	for(int p=0; p<MAX_periods; p++)
    	{
    		summarisePeriod(periodrecords, MAX_days, p);
    	}
    }

    // setter methods
    public static PeriodRecord setStation(PeriodRecord pr, String st)
    {
    	pr.Station = st;
    	return pr;
    }

    public static PeriodRecord setPeriod (PeriodRecord pr, String p)
	{
		pr.Period = p;
		return pr;
	}

	public static PeriodRecord setTakings (PeriodRecord pr, int t)
	{
		pr.Takings = t;
		return pr;
	}

	// getter methods
	public static String getStation (PeriodRecord pr)
	{
		return pr.Station;
	}

	public static String getPeriod (PeriodRecord pr)
	{
		return pr.Period;
	}

	public static int getTakings (PeriodRecord pr)
	{
		return pr.Takings;
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

class PeriodRecord
{
	String Station;
	String Period;
	int Takings;
}