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
				return true;
			}
		}
		return false;
	}
}
