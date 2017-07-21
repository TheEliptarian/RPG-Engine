import java.util.ArrayList;
public class Player extends BaseFighter
{
	public static ArrayList<Quest> quests = new ArrayList<Quest>();
	Class c;
	int level = 1;
	int[] stats;
	Item[] inv = new Item[20];
	ArmorSet armor = new ArmorSet();
	public Player(String n, Class c, int[] stat)
	{
		super(n, stat[0]);
		this.c = c;
		this.str = stat[1];
		this.def = stat[2];
		this.spd = stat[3];
		this.eva = stat[4];
		this.dge = stat[5];
		this.crt = stat[6];
		this.mag = stat[7];
		this.con = stat[8];
		armor.set(Generic.genericHelm);
		armor.set(Generic.genericChest);
		armor.set(Generic.genericLegs);
		armor.set(Generic.genericBoots);
		arms[0] = Generic.genericAxe;
		equip(Generic.genericAxe);
		stats = stat;
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
		Engine.cls();
		Dialogue.print("Class - " + c.name);
		Dialogue.print("Weapon - " + weapon.name + " - " + weapon.desc + 
					 "\n\nHelm - " + armor.helm.name + " - " + armor.helm.desc + 
					 "\n\nChest - " + armor.chest.name + " - " + armor.chest.desc + 
					 "\n\nLeggings - " + armor.legs.name + " - " + armor.legs.desc + 
					 "\n\nBoots - " + armor.boots.name + " - " + armor.boots.desc);
		Dialogue.print("\nHP - " + hp + (hp < c.max[0] ? "" : " (MAX)") +
					 "\n\nSTR - " + str + (str < c.max[1] ? "" : " (MAX)") +
					 "\n\nDEF - " + def + (def < c.max[2] ? "" : " (MAX)") +
					 "\n\nSPD - " + spd + (spd < c.max[3] ? "" : " (MAX)") +
					 "\n\nEVA - " + eva + (eva < c.max[4] ? "" : " (MAX)") +
					 "\n\nDGE - " + dge + (dge < c.max[5] ? "" : " (MAX)") +
					 "\n\nCRT - " + crt + (crt < c.max[6] ? "" : " (MAX)") +
					 "\n\nMAG - " + mag + (mag < c.max[7] ? "" : " (MAX)") +
					 "\n\nCON - " + con + (con < c.max[8] ? "" : " (MAX)") +
					 "\n");
	}
	
	
	public static int[] rollStats(Class c)
	{
		int[] stats = new int[]{5, 5, 5, 5, 5, 5, 5, 5, 5};
		for(int i = 0; i < 10; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				int n = (int)(Math.random() * 100);
				if(n < c.growths[j])
				{
					stats[j]++;
				}
			}
		}
		return stats;
	}
	
	public void levelUp()
	{
		level++;
		Engine.cls();
		boolean[] up = new boolean[9];
		for(int j = 0; j < 9; j++)
		{
			int n = (int)(Math.random() * 100);
			if(n < c.growths[j])
			{
				stats[j]++;
				up[j] = true;
			}
		}
		Dialogue.print("\nHP - " + hp + (up[0] ? " +1 " : "") + (hp < c.max[0] ? "" : " (MAX)") +
					 "\n\nSTR - " + str + (up[1] ? " +1 " : "") + (str < c.max[1] ? "" : " (MAX)") +
					 "\n\nDEF - " + def + (up[2] ? " +1 " : "") + (def < c.max[2] ? "" : " (MAX)") +
					 "\n\nSPD - " + spd + (up[3] ? " +1 " : "") + (spd < c.max[3] ? "" : " (MAX)") +
					 "\n\nEVA - " + eva + (up[4] ? " +1 " : "") + (eva < c.max[4] ? "" : " (MAX)") +
					 "\n\nDGE - " + dge + (up[5] ? " +1 " : "") + (dge < c.max[5] ? "" : " (MAX)") +
					 "\n\nCRT - " + crt + (up[6] ? " +1 " : "") + (crt < c.max[6] ? "" : " (MAX)") +
					 "\n\nMAG - " + mag + (up[7] ? " +1 " : "") + (mag < c.max[7] ? "" : " (MAX)") +
					 "\n\nCON - " + con + (up[8] ? " +1 " : "") + (con < c.max[8] ? "" : " (MAX)") +
					 "\n");
	}
	
	public static void main(String[] args)
	{
		Player player = new Player("Bob", Instances.swordsman, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0});
		player.armor = Instances.bronzeSet;
		player.printArmory();
	}
}
