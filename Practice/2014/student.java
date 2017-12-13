/* Author - Catalin Alexandru
This file was created as a start template
*/

import java.util.*; // it imports the entire java util library and makes it available to use

public class student
{  
  	// Program starting point
    public static void main (String[] param)
    {
    	final int numberOfStudents = 500;
    	String ans = "";

    	String[] students = new String[numberOfStudents];
    	String[] units = {"Mathematics", "English", "Computing"};


    	for(int s = 0; s < 500; s++)
    	{
   			ans = InputString("Student Name: ");
   			if(ans.equals("0"))
   				break;
   			else{}
   			students[s] = ans; 
   		}

    	int[] mathsGrades = Grades(students, numberOfStudents, units, 0);
    	int[] englishGrades = Grades(students, numberOfStudents, units, 1);
    	int[] computingGrades = Grades(students, numberOfStudents, units, 2);

    	report(students, mathsGrades, englishGrades, computingGrades, units);

    	System.exit(0);
    }   // END Main

    public static void report(String[] students, int[] mathsGrades, int[] englishGrades, int[] computingGrades, String[] units)
    {
    	for(int s = 0; s <= students.length; s++)
    	{
    		if(students[s] == null)
    			break;
    		else{}
    		Print("\nReport Card for " + students[s]);
    		Print(units[0] + ": " + mathsGrades[s]);
    		Print(units[1] + ": " + englishGrades[s]);
    		Print(units[2] + ": " + computingGrades[s]);
    	}
    	return;
    }

    public static int[] Grades(String [] students, final int numberOfStudents, String[] units, int k)
    {
    	Print("\nSubject: Mathematics:");
    	int[] mathsGrades = new int[numberOfStudents];
    	int ans;

    	for(int m = 0; m <= students.length; m++)
    	{
    		if(students[m] == null)
    			break;
    		else{}
    		ans = InputInt("what is the predicted grade for " + students[m] + " in " + units[k] + "?");
    		mathsGrades[m] =ans;
    	}

    	return mathsGrades;
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