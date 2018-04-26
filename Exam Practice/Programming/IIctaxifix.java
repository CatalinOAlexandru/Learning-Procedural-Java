import java.util.*;
class IIctaxifix
{
	public static final int MAX_DAYS = 28;
	public static final int MAX_PERIODS = 3;
	
	public static void main (String [] param)
	{
		String [] stations = {"Kings Cross", "Liverpool Street", "Paddington","Euston"};
		String [] periods = {"Morning", "Afternoon", "Evening"};
		PeriodRecord [] [] periodrecords = createPeriodRecords(MAX_DAYS,MAX_PERIODS, periods);
		for(int day = 0; day < MAX_DAYS; day++)
		{
			workDay(periodrecords, day, periods, stations);
			summariseDay(periodrecords, day);
		}
		printFullSummary(periodrecords);
	}
	// Create a 2D array of period records with one record each period of each
	// day
	public static PeriodRecord [] [] createPeriodRecords(int MAX_DAYS, int MAX_PERIODS, String [] periods)
	{
		PeriodRecord [] [] periodrecords = new PeriodRecord [MAX_DAYS]
		[MAX_PERIODS];
		for(int day = 0; day < MAX_DAYS; day++)
		{
			for(int period = 0; period<MAX_PERIODS; period++)
			{
				periodrecords[day][period] = createPeriodRecord(periods[period]);
			}
		}
		return periodrecords;
	}
	// Work a single day
	public static void workDay(PeriodRecord [] [] periodrecords, int day, String[] periods, String[] stations)
	{
		String station = pickStation(stations);
		for (int p = 0; p < MAX_PERIODS; p++)
		{
			setStation (periodrecords[day][p], station);
			String working = input("Are you working in the " + periods[p] + "(Y/N)?");
			if (isWorking(working))
			{
				workPeriod(periodrecords, day, p);
			}
		}
	}
	// Record the takings for a single day
	public static void workDay(PeriodRecord [] [] periodrecords, int day)
	{
		for (int p = 0; p < MAX_PERIODS; p++)
		{
			workPeriod(periodrecords, day, p);
		}
	}
	// Summarise the takings for all periods
	public static void printFullSummary(PeriodRecord [] [] periodrecords)
	{
		print("______________________");
		print("Here is a full summary");
		print("______________________");
		for (int day = 0; day < MAX_DAYS; day++)
		{
			summariseDay(periodrecords, day);
		}
	}
	// Summarise the takings for a single day
	public static void summariseDay(PeriodRecord [] [] periodrecords, int day)
	{
		print("Day " + day);
		for (int p = 0; p < MAX_PERIODS; p++)
		{
			summarisePeriod(periodrecords, day, p);
		}
	}
	// Summarise the takings for a single period
	public static void summarisePeriod(PeriodRecord [] [] periodrecords, int day, int period)
	{
		PeriodRecord pr = periodrecords[day][period];
		printPeriod(pr);
	}
	// Work a single day
	public static void workPeriod(PeriodRecord [] [] periodrecords, int day, int period)
	{
		final int QUIT = -1;
		PeriodRecord pr = periodrecords[day][period];
		int fare = inputInt("What is the next fare (-1 to quit)?");
		while (! (fare == QUIT))
		{
			addToTakings (pr, fare);
			fare = inputInt("What is the next fare (-1 to quit)?");
		}
	}
	// Enter the number of a station from a menu, returning the name
	public static String pickStation(String[] stations)
	{
		int station = -1;
		while ((station < 0) | (station >3))
		{
			for(int i = 0; i<stations.length; i++)
			{
				print(i + ": " + stations[i]);
			}
			station = inputInt("What station will you work from today?");
		}
		return stations[station];
	}
	// Was Y typed?
	public static boolean isWorking(String s)
	{
		if (s.equals("Y"))
			return true;
		else
			return false;
	}
	// Print a message
	public static void print(String message)
	{
		System.out.println(message);
	}
	// Input a string
	public static String input(String message)
	{
		Scanner scanner = new Scanner(System.in);
		print(message);
		return (scanner.nextLine());
	}
	// Input an int
	public static int inputInt(String message)
	{
		return Integer.parseInt(input(message));
	}
	// Abstract Data Type for Period Record
	// * Print a record
	// * Add to takings
	// * Create a record
	// * Get Station name
	// * Get Period name
	// * Get Takings in that period
	// Method to create a single Period Record
	public static PeriodRecord createPeriodRecord(String period)
	{
		PeriodRecord pr = new PeriodRecord();
		pr.Station = "No station";
		pr.Period = period;
		pr.Takings = 0;
		return pr;
	}
	public static PeriodRecord addToTakings (PeriodRecord pr, int t)
	{
		pr.Takings = pr.Takings + t;
		return pr;
	}
	// Summarise the takings for a single period
	public static void printPeriod(PeriodRecord pr)
	{
		print(" Period " + getPeriod(pr) +
		" Station " + getStation(pr) +
		" Takings " + getTakings(pr) );
	}
	// Setter methods
	public static PeriodRecord setStation (PeriodRecord pr, String st)
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
}

// A record definition for a Period Record
class PeriodRecord
{
	String Station;
	String Period;
	int Takings;
}