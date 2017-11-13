/* Author - Catalin Alexandru
Trying to make a queue.
*/

import java.util.*; // it imports the entire java util library and makes it available to use

public class Queue
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	//Queue();
    	System.exit(0);
    }   // END Main

	public static String Queue()
	{
		Queue q = new Queue();
		String[] a = new String[size];

		q.entries = a;
		q.numberqueueing = 0;

		return q;
	} // END Queue

	public static Queue joinQueue(Queue q, String newentry)
	{
		if (q.numberqueueing < q.entries.length)
		{
			q.entries[q.numberqueueing] = newentry;
			q.numberqueueing = q.numberqueueing + 1;
		}

	}

	public static String firstInQueue (Queue q)
	{
		If(q.numberqueueing == 0)
		{
			return "Queue Empty";
		}
		else
		{
			String firstentry = q.entries[0];
			return firstenrty;
		}
	}
	
	public statis Queue leaveQueue(Queue q)
	{
		If (q.numberqueueing != 0) // queue is not emplty
		{
			For (int = 0; i<q.numberqueueing; i++)
			{
			q.entries[i] = q.entries[i+1];  // shuffle all enties
			}
			
			q.numberqueueing = q.numberqueueing -1;
		}
	return q;
	}


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

} // END Class Queue

Class Queue
{
	String [] entries;
	Int numberqueueing;
}