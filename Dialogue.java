import java.util.*;
public class Dialogue
{
	/*
	 * A class for holding Dialogue options. Stores the text of the
	 * dialogue, and whether or not it activates a quest, among other
	 * things.
	 */ 
	 
	ArrayList<String> text = new ArrayList<String>(); //The actual text of the dialogue. Stored in an arraylist to emulating clicking through dialogue.
	Quest quest = null; //The quest that the dialogue activates, if any.
	
	public Dialogue(String t)
	{
		text = split(t);
	}
	
	public Dialogue(String t, Quest q)
	{
		text = split(t);
		quest = q;
	}
	
	/**
	 * Splits the text into 'scrolling' Dialogue.
	 * Automatically inserts line breaks and user prompts.
	 * 
	 * @param text - The text to split.
	 * @return The text in arraylist form.
	 */ 
	public ArrayList<String> split(String text)
	{
		ArrayList<String> list = new ArrayList<String>();
		String s = "";
		int j = 0, c = 0;
		for(int i = 0; i < text.length(); i++)
		{
			s += text.charAt(i);
			if(j >= 50 && text.charAt(i) == ' ')
			{
				c++;
				s += "\n";
				if(c < 2)
				{
					s += "\n";
				}
				j = -1;
				if(c >= 2)
				{
					list.add(s);
					s = "";
					c = 0;
				}
			}
			j++;
		}
		list.add(s);
		if(list.size() == 1) list.add("\n");
		return list;
	}
	
	/**
	 * Prints the text of the Dialogue. 
	 * Prints character by character with a small delay to add a 
	 * 'scrolling' effect.
	 * 
	 * @return The text that was printed.
	 */ 
	public ArrayList<String> print()
	{
		System.out.print("\n");
		for(int i = 0; i < text.size(); i++)
		{
			String current = text.get(i);
			for(int j = 0; j < current.length(); j++)
			{
				System.out.print(current.charAt(j));
				try
				{
					Thread.sleep(15);
				}
				catch(InterruptedException ex)
				{
					Thread.currentThread().interrupt();
				}
			}
			if(text.size() > 2)Engine.input.nextLine();
		}
		if(quest != null) quest.prompt();
		return text;
	}
	
	public static String print(String text)
	{
		System.out.print("\n");
		for(int i = 0; i < text.length(); i++)
		{
			System.out.print(text.charAt(i));
			try
			{
				Thread.sleep(15);
			}
			catch(InterruptedException ex)
			{
				Thread.currentThread().interrupt();
			}
		}
		return text;
	}
	
	public String toString()
	{
		return text.toString();
	}
	
	public static void main(String[] args)
	{
		//Dialogue test = new Dialogue("Do you accept this quest?", null);
		Dialogue test = new Dialogue("This is the last time I'll abandon you! And this is, the last time I'll forget you! I wish I could! I won't stand in your way. Let your hatred grow, And she'll scream, And she'll shout, And she'll pray, And she had a name. Yeah she had a name!", new Quest("Test", null, null, new Dialogue("Do you accept this quest?", null)));
		test.print();
	}
}
