import java.util.ArrayList;
public class Player extends BaseFighter
{
	public static ArrayList<Quest> quests = new ArrayList<Quest>();
	Item[] inv = new Item[20];
	ArmorSet armor = new ArmorSet();
	public Player(String n, int h, int str, int def, int spd)
	{
		super(n, h);
		this.str = str;
		this.def = def;
		this.spd = spd;
		armor.set(Generic.genericHelm);
		armor.set(Generic.genericChest);
		armor.set(Generic.genericLegs);
		armor.set(Generic.genericBoots);
		arms[0] = Generic.genericAxe;
		equip(Generic.genericAxe);
	}
	
	/**
	 * Equips an armor to the active slot. 
	 * 
	 * @param a - The armor piece to be equipped.
	 * @return true if the a is in the inventory of the Player and
	 * could be equipped.
	 */
	public boolean equipA(Armor a)
	{
		for(int i = 0; i < inv.length; i++)
		{
			if(inv[i] == a)
			{
				armor.set(a);
				inv[i] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Removes an armor from the active slot. 
	 * 
	 * @param a - The armor piece to be removed.
	 * @return true if the a is in the inventory of the Player and
	 * could be removed.
	 */
	 /*
	public boolean removeA(Armor a)
	{
		if(a == armor.helm) armor.remove(a);return true;
		if(a == armor.chest) armor.remove(a);return true;
		if(a == armor.legs) armor.remove(a);return true;
		if(a == armor.boots) armor.remove(a);return true;
		return false;
	}*/
	
	/**
	 * Prints the armory of the player, including names and descriptions
	 * of the currently equipped armor and weapons.
	 */ 
	public void printArmory()
	{
		Dialogue.print("Weapon - " + weapon.name + " - " + weapon.desc + 
					 "\n\nHelm - " + armor.helm.name + " - " + armor.helm.desc + 
					 "\n\nChest - " + armor.chest.name + " - " + armor.chest.desc + 
					 "\n\nLeggings - " + armor.legs.name + " - " + armor.legs.desc + 
					 "\n\nBoots - " + armor.boots.name + " - " + armor.boots.desc + 
					 "\n");
	}
	public static void main(String[] args)
	{
		Player player = new Player("Bob", 0, 0, 0, 0);
		player.armor = Instances.bronzeSet;
		player.printArmory();
	}
}
