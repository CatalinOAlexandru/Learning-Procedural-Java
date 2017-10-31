/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 1: Output
On the 2nd of October 2017
The purpose of this program is to print my initials in the Terminal whenever it is lauched
by someone. It will stop process immediately after.
*/

class Initials
{
    public static void main (String[] param)
    {		
        buildInitials();
        System.exit(0);
		
    } // END main

        //This part will print my initials in the Terminal.
       public static void buildInitials()
       {
		   // Print big letter C
        System.out.println(" ");
        System.out.println("  CCCCC");
        System.out.println(" CCC  ");
        System.out.println("CCC  ");
        System.out.println(" CCC  ");
        System.out.println("  CCCCC");

          // Print big letter A
        System.out.println(" ");
        System.out.println("    A");
        System.out.println("   A A");
        System.out.println("  AAAAA");
        System.out.println(" AA   AA");
        System.out.println("AA     AA");   
        System.out.println(" ");		
        return;
       } // END buildInitials

} // END class Initials
