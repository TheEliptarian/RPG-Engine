public class BaseFighter extends Character
{
	/*
	 * This class is a BaseFighter, or a Fighting Character. It takes
	 * the base Character class and extends it to add Fighting related 
	 * attributes. Skills, attacks, etc.
	 */ 
	
	int hp;
	int str, def, crt; /*Physical attack related skills. STR - Strength,
	DEF - Defense, CRT - Crit Chance.*/
	int spd, eva, dg; /*Dexterity related skills. SPD - Speed, EVA - 
	Evasion, DG - Dodge.*/
	
	/*
	 * STR is the base strength of a character. Directly affects the 
	 * damage done by a fighter. 
	 * DEF is the base defense of a character. Directly affects damage 
	 * taken.
	 */
	
	Item[] inv = new Item[10];
	Weapon[] arms = new Weapon[2];
	Weapon weapon;
	
	/**
	 * A base constructor. Sets name and HP, and puts STR, DEF, and SPD
	 * at 0;
	 */ 
	public BaseFighter(String n, int h)
	{
		super(n);
		hp = h;
		str = 0;
		def = 0;
		spd = 0;
		crt = 0;
		eva = 0;
		dg = 0;
	}
	
	/**
	 * A dummy attack that deals damage equal to that of the fighter's
	 * strenth minus the target's defense.
	 * 
	 * @param target - The target of the attack.
	 */
	public void dummyAttack(BaseFighter target)
	{
		target.hp -= (str - target.def);
	}
	
	/**
	 * @return Whether or not the fighter can flee the encounter.
	 */
	public boolean dummyFlee(BaseFighter target)
	{
		return (Math.random() < ((1.0 * spd) / (1.0 * target.spd)));
	}
	
	/**
	 * Equips a weapon to the active slot. Only equips weapons that are
	 * in the inventory of the fighter.
	 * 
	 * @param w - The Weapon to be equipped.
	 * @return true if the w is in the inventory of the fighter and
	 * could be equipped.
	 */
	public boolean equip(Weapon w)
	{
		for(int i = 0; i < 2; i++)
		{
			if(arms[i] == w)
			{
				weapon = w;
				return true;
			}
		}
		return false;
	}
	
	public void attack(BaseFighter target)
	{
		if((int)(Math.random() * 100) > target.eva - weapon.hit) return;
		
	}
}
