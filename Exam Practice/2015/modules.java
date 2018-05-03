import java.util.*;

public class modules
{
	public static void main(String[] args)
	{
		while(true)
		{
			String ans = input("\nInput a Module Code");
			printUnit(ans);
		}
	}

	public static void printUnit(String ans)
	{
		if(ans.equalsIgnoreCase("ECS401"))
			print("Module ECS401 is called Procedural Programming and is on Monday.");
		else if(ans.equalsIgnoreCase("ECS402"))
			print("Module ECS402 is called Professional and Research Themes and is on Tuesday.");
		else if(ans.equalsIgnoreCase("ECS403"))
			print("Module ECS403 is called Communications and Networks and is on Wednesday.");
		else if(ans.equalsIgnoreCase("ECS407"))
			print("Module ECS407 is called Logic and Discrete Structures and is on Friday.");
		else if(ans.equalsIgnoreCase("XXX"))
			System.exit(0);
		else
			print("There is no such module.");
	}

	public static void print(String m) {System.out.println(m);}

	public static String input(String m)
	{
		Scanner sc = new Scanner(System.in);
		print(m);
		return sc.nextLine();
	}
}