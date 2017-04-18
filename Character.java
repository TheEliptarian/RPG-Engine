import java.util.ArrayList;
public class Character
{
	/*
	 * A basic character class, used only for regular NPCs and as a base
	 * for other classes.
	 * 
	 * Features only barebones features of a character, such as name
	 * and other attributes.
	 */ 
	
	String name; //The name of the character.
	ArrayList<Dialogue> dialogue = new ArrayList<Dialogue>(); /* The
	arraylist holding all of the dialogue options of the character.*/
	boolean silent = false;
	
	/**
	 * Construtor.
	 * 
	 * Gets passed a names, and an arraylist of dialogue. If the 
	 * arraylist is empty, it adds a placeholder dialogue of "...". This
	 * is to prevent completely mute characters.
	 * 
	 * @param n - The name of the character.
	 * @param d - The arraylist holding all of the dialogue options of
	 * the character.
	 */ 
	public Character(String n, ArrayList<Dialogue> d)
	{
		name = n;
		if(d != null)
		{
			 if(!d.isEmpty())
			 {
				  dialogue = d;
			 }
			 else
			 {
				 dialogue.add(new Dialogue("...", null));
				 silent = true;
			 }
		}
		else
		{
			dialogue.add(new Dialogue("...", null));
			silent = true;
		}
	}
	
	/**
	 * A constructor for a character with no dialogue.
	 * For instance, an enemy only encountered in battle, which would 
	 * instead have flavor text.
	 */ 
	public Character(String n)
	{
		name = n;
		dialogue = null;
	}
	
	/**
	 * These three functions add a dialogue option to the character.
	 * They each take a different set of parameters and wraps them 
	 * into a Dialogue ArrayList
	 * 
	 */ 
	public void addDialogue(Dialogue d)
	{
		if(silent)
		{
			 dialogue.clear();
			 silent = false;
		}
		dialogue.add(d);
	}
	public void addDialogue(String s, Quest q)
	{
		if(silent)
		{
			 dialogue.clear();
			 silent = false;
		}
		dialogue.add(new Dialogue(s, q));
	}
	public void addDialogue(String s)
	{
		if(silent)
		{
			 dialogue.clear();
			 silent = false;
		}
		dialogue.add(new Dialogue(s, null));
	}
	
	/**
	 * Has the character 'say' the text at the index provided.
	 * 
	 * @param index - The index of the list to pull from.
	 */ 
	public void say(int index)
	{
		try
		{
			Runtime.getRuntime().exec("cls");
		}
		catch(Exception e){}
		System.out.println(name + ": ");
		dialogue.get(index).print();
	}
	
	public static void main(String[] args)
	{
		ArrayList<Dialogue> d = new ArrayList<Dialogue>();
		Character test = new Character("Mayor Jones", d);
		//test.addDialogue(new Dialogue("Hey, traveler! Some ducc monsters have been terrorizing our village for far too long! Kill them pl0x thnx.", new Quest("Kill the Duccs!", null, test, "Do you accept this quest?")));
		test.say(0);
	}
}
