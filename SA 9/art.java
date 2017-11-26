/* Author - Catalin Alexandru
This program was created for Short Assessed Programming Exercise 9: Abstract Data Types built from an array
On the 14.11.2017
This program will ask the user to input a number which represent the room the user curretly is.
The problem will print a popular painting, the artist of that painting and the year, depanding of the user input.
*/

import java.util.*; // it imports the entire java util library and makes it available to use

class art
{
	// the program will start from here
    public static void main(String[] args) 
    {
		whichroom(passArray());
		System.exit(0);
	}

	public static Painting[] passArray()
	{
		Painting[] paintings = new Painting[4];
		for(int a = 0; a < 4; a++)
  		paintings[a] = new Painting();
  
  		return paintings;
	}

	// this method will set all the data for all rooms and will set them into an array
	// this method will ask the user in which room he or she currently is and will print facts about a popular painting
	public static void whichroom(Painting[] paintings)
	{

		ArtCollection artCollection = new ArtCollection();
		artCollection.paintings= paintings;  //  paintings ??? bruhh. paintings does not exists
		
		artCollection.paintings[0] = newMethod("Girl With Chrysanthemums", "Olga Boznanska", 1894, 3,paintings[0]);
		artCollection.paintings[1] = newMethod("Woman With a Pearl Necklace in a Loge","Mary Cassat",1979,1, paintings[1] );
		artCollection.paintings[2] = newMethod("Self-Portrait with Baret and Turned-up Collar","Rembrandt",1659,2, paintings[2]);
		artCollection.paintings[3] = newMethod("Impression , Sunrise", "Claude Monet", 1872, 4, paintings[3]);

		
		int userinp = 0;
		int finaluserinp = 0;

		while(true)
		{
			userinp = Integer.parseInt(InputString("\nWhat room are you in?"));

			if (userinp<=0 || userinp>4)
			{
				Print("Sorry, but that is a wrong room.\n");
				break;
			}
			else 
			{
				finaluserinp = userinp - 1;
				Print("The painting in gallery " + userinp + " is by " + getArtist(artCollection.paintings[finaluserinp]) + ". It was painted in " + getYear(artCollection.paintings[finaluserinp]) + " and is called " + getName(artCollection.paintings[finaluserinp]) + ".\n");
			}
		}
		return;
	}


//Getter Methods 
	public static String getName(Painting p)
	{
		return p.name;
	}
	public static String getArtist(Painting p)
	{
		return p.artist;
	}
	public static int getYear(Painting p)
	{
		return p.year;
	}
	public static int getroomnumber(Painting p)
	{
		return p.roomnumber;
	}
	
//Setter Methods
	public static Painting setName(Painting p, String name)
	{
		p.name = name;
		return p;
	}
	public static Painting setArtist(Painting p, String artist)
	{
		p.artist = artist;
		return p;
	}
	public static Painting setYear(Painting p, int year)
	{
		p.year = year;
		return p;
	}
	public static Painting setRoomnumber(Painting p, int roomnumber)
	{
		p.roomnumber = roomnumber;
		return p;
	}
	public static Painting newMethod(String name, String artist,int year,int roomnumber, Painting p)
	{
		p = setName(p, name);
		p = setArtist(p,artist);
		p = setYear(p,year);
		p = setRoomnumber(p,roomnumber);
		return p;
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

} // END art

class ArtCollection
{
	Painting[]paintings;
	int roomnumber;
}

class Painting
{
	String name;
	String artist;
	int year;
	int roomnumber;

}