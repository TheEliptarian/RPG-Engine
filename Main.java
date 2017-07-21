/* Main class. Loads save files (sometime in the future it will, at 
 * least), runs main game loop, etc.
 */

public class Main
{
	public static Player player;
	
	public static void newGame()
	{
		Engine.cls();
		print("Enter your name: ");
		System.out.print(">> ");
		String name = Engine.input.nextLine();
		Engine.cls();
		print("Welcome, " + name + ". Please choose a class. 1 for Light Mage, 2 for Dark Mage, 3 for Swordsman, 4 for Knight.");
		String classn = Engine.getInput("1", "2", "3", "4");
		Class c = (classn.equals("1") ? Instances.lightMage : classn.equals("2") ? Instances.darkMage : classn.equals("3") ? Instances.swordsman : Instances.knight);
		Engine.cls();
		print("Rolling stats...");
		int[] s = Player.rollStats(c);
		player = new Player(name, c, s);
		player.printArmory();
	}
	
	public static void loadFile()
	{
		throw new UnsupportedOperationException();
	}
	 
	public static void print(String s)
	{
		Dialogue.print(s);
	}
	
	public static void slowPrint(String s)
	{
		Dialogue.slowPrint(s);
	}
	
	public static String input(String... s)
	{
		return Engine.getInput(s);
	}
	
	public static void main(String[] args)
	{
		print("Type 'n' to start a new game, and 'l' to load a save file (unsupported as of yet)");
		String input = input("n", "l");
		if(input.equals("n")) newGame();
		else loadFile();
		game();
	}
	
	public static void game()
	{
		
	}
}
