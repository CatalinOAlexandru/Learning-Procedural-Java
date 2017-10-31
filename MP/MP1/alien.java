/* Author - Catalin Alexandru
This program was created for the Mini Project (Suggestion 2)
On the 3rd -
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use

public class alien
{
    public static void main (String[] param)
    {
        explain();
        name();
        System.exit(0);
    } // END Main

    public static void explain()
    {
        System.out.println("Welcome to TRAAAAAAIN YOOOUR alien...");
        System.out.println("You will be asked to input a name for your new alien and after that the program will print something special regarding your alien.");
    }

    public static void name()
    {
        System.out.println("How do you want to call your new Alien?");
        Scanner scanner = new Scanner(System.in);
        String alien = scanner.nextLine();
        System.out.println("Happy 0th Birthday " + alien + " the Alien!");
    }

} // END class alien
