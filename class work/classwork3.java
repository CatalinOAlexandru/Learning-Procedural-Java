import java.util.ArrayList;  //imports the arrays
import java.util.Scanner;

class classwork3
{
	public static void main(String[] param)
	{

		String[] s = new String[10];
		for (int i=0; i<10; i++)
		{
			s[i]= ask("Give me a name");
		} // end for loop

		System.exit(0);

	} // end main

	public static String ask(String s);
	{
		Scanner scanner = new Scanner;
		System.out.println(s);
		return scanner.nextLine;
	}

} // end class classwork3