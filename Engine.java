import java.util.Scanner;
import java.io.IOException;
public class Engine
{
	/*
	 * A class that houses the helper functions for the game.
	 */ 
	 public static Scanner input = new Scanner(System.in);
	 
	 public static String getInput(String... s)
	 {
		boolean match = false;
		boolean redo = false;
		while(match == false)
		{
			if(redo)
			{
				 System.out.println("Please enter one of the following: \n");
				 for(String i: s)
				 {
					 System.out.print(i + " ");
				 }
				 System.out.println("\n");
			}
			System.out.print(">> ");
			String in = input.nextLine();
			if(redo)System.out.println();
			in = in.toLowerCase();
			for(String i : s)
			{
				i = i.toLowerCase();
				if(i.equals(in)) return i;
				if(i.equals("yes")) if(in.equals("y")) return i;
				if(i.equals("no")) if(in.equals("n")) return i;
				if(i.equals("save")) if(in.equals("s")) return i;
			}
			redo = true;
		}
		return null;
	 }
	 
	public static void cls()
	{
		try
		{
			if(System.getProperty("os.name").contains("Windows")) new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			else Runtime.getRuntime().exec("clear");
		}
		catch(IOException | InterruptedException ex) {}
	}
}
