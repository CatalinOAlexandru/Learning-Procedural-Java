/* Author - Catalin Alexandru
This program was created for the Mini Project (Suggestion 2)
On the 3rd -
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use
import java.util.Random; // it imports the Random and makes it available to use

public class alien
{
    public static void main (String[] param)
    {
        explain();
        //name();
        hunger();
        System.exit(0);
    } // END Main

    public static void explain()
    {
        System.out.println("Welcome to TRAAAAAAIN YOOOUR alien...");
        System.out.println("You will be asked to input a name for your new alien and after that the program will print something special regarding your alien.");
    }

    public static String name()
    {
        System.out.println("How do you want to call your new Alien?");
        Scanner scanner = new Scanner(System.in);
        String alienname = scanner.nextLine();
        System.out.println("Happy 0th Birthday " + alienname + " the Alien!");
        return alienname;
    }

    public static void hunger()
    {
        String alien = name();
        int hungry = random();
        System.out.println("On a scale of 1 to 10, " + alien + "'s hunger level is " + hungry + "/10");
        return;
    }

    public static int random()
    {
       final int LEVEL = 10;        // How hungry the alien can be
       Random hunger = new Random();  // Random number generator
       int random = hunger.nextInt(LEVEL) + 1; // Generate a number and adds 1, otherwise we can get 0 or we cant get 10
       return random;

    } // END random

} // END class alien
