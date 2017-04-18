public class Weapon extends Item
{
	int pwr, eva, hit; // PWR - Power, EVA - Evasion, HIT - Hit Value.
	double dur; //DUR - Durability.
	boolean breakable = false;
	
	/*
	 * PWR - The base strength of a weapon.
	 * EVA - The evasion that holding the weapon adds to the character.
	 * HIT - The percentage chance that the weapon will hit it's target,
	 * checked against the target's EVA among other things.
	 */
	
	public Weapon(String n, int p, int d, int e, int h)
	{
		super(n);
		pwr = p;
		dur = (double)d;
		eva = e;
		hit = h;
	}
	
	public Weapon(String n, String d, int p, int du, int e, int h)
	{
		super(n, d);
		pwr = p;
		dur = (double)du;
		eva = e;
		hit = h;
	}
}

class Sword extends Weapon
{
	public Sword(String n, int p, int d, int e, int h)
	{
		super(n, p, d, e, h);
	}
	
	public Sword(String n, String d, int p, int du, int e, int h)
	{
		super(n, d, p, du, e, h);
	}
}

class Lance extends Weapon
{
	public Lance(String n, int p, int d, int e, int h)
	{
		super(n, p, d, e, h);
	}
	
	public Lance(String n, String d, int p, int du, int e, int h)
	{
		super(n, d, p, du, e, h);
	}
}

class Axe extends Weapon
{
	public Axe(String n, int p, int d, int e, int h)
	{
		super(n, p, d, e, h);
	}
	
	public Axe(String n, String d, int p, int du, int e, int h)
	{
		super(n, d, p, du, e, h);
	}
}


