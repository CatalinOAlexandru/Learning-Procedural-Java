/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 2: Input, Calculation and Variables
On the 3rd of October 2017 / 4th of October 2017
This program will calculate how much carpet the user needs to order with an additional 5% for wastage.

This program may be still in beta. Not sure...
*/

import java.util.Scanner; // it imports the Scanner and makes it available to use

class carpet
{
    public static void main (String[] param)
    {
    	extra();
        //calculationAR();
        //getLength();
        //getWidth();
        System.exit(0);
		
    } // END main


       // This method will get the Length of the room by asking the user to input it
       public static double getLength()
       {
          	Double length;

         	Scanner scanner = new Scanner(System.in);
         	System.out.println("What is the Lenght of the room (in m to 1dp)?");
            length = scanner.nextDouble();

            return length;
       }


        // This method will get the Width of the room by asking the user to input it
        public static double getWidth()
        {
       	    Double width;

       	    Scanner scanner = new Scanner(System.in);
            System.out.println("What is the Width of the room (in m to 1dp)?");
            width = scanner.nextDouble();

            return width;
        }


       /* This method will calculate the area of the room, will round it to 2 decimal places
          and will print it in the terminal
       */

       public static double calculationAR()
       {
       
	       Double length;
	       Double width;
	       Double area1;
	       //Double area2;

           length = getLength();
           width = getWidth();
        
           // Calculates the area of the room
           area1 = length * width;
           
           // Rounds the area to 2 decimal places and print it
           double area2 = (area1 * 100) / 100;
           System.out.println("Your room area is " + area2 + " m2.");

           return area2;
        } // END calculationAR 


        // This method will calculate the extra carpet the user need to buy
        public static void extra()
        {
           
           Double extra5;
           Double area;
           Double total1;

           area = calculationAR();

           extra5 = (area * 5 ) / 100;
           double extra5round = (extra5 * 1000) / 1000;
           System.out.println("The extra you need for wastage is " + extra5round + " m2.");

           
           total1 = area + extra5round;
           double total2 = (total1 * 10) / 10;
           System.out.println("The total carpet area to order is: " + total2 + " m2.");

           return;
        }  // END extra

} // END class carpet
