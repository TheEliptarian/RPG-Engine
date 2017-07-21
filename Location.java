/*Holds objects centered around a location (a town, or wilds area for 
* example.
*
* Going to use abbreviations to keep variables names from being too
* long.
*
* poss = possible
* enc = encounter  
*/
import java.util.ArrayList;

public class Location
{
	String name;
	ArrayList<Location> link = new ArrayList<Location>();
	ArrayList<Character> npcs = new ArrayList<Character>();
}


class Town extends Location
{
	
}

class Wild extends Location
{
	ArrayList<BaseFighter> possEncs = new ArrayList<BaseFighter>(); 
}
