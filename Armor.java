/*
 * File contains classes for armor of all types.
 */ 

public class Armor extends Item
{
	/*
	 * A class for basic armor.
	 */ 
	 
	 int def; //DEF - Defense Value
	 double dur; //DUR - Durability
	 boolean breakable = false;
	 
	 public Armor(String n)
	 {
		 super(n);
	 }
	 
	 public Armor(String n, String d)
	 {
		 super(n, d);
	 }
	 
	 public Armor(String n, int de, int du)
	 {
		  super(n);
		  def = de;
		  dur = (double)du;
	 }
	 
	 public Armor(String n, String d, int de, boolean b)
	 {
		  super(n, d);
		  def = de;
		  breakable = b;
	 }
	 
	 public Armor(String n, String d, int de, int du)
	 {
		  super(n, d);
		  def = de;
		  dur = (double)du;
	 }
}

class Helm extends Armor
{
	public Helm(String n, int de, double du)
	 {
		  super(n);
		  def = de;
		  dur = du;
	 }
	 
	 public Helm(String n, String d, int de, double du)
	 {
		  super(n, d);
		  def = de;
		  dur = du;
	 }
}

class Chest extends Armor
{
	public Chest(String n, int de, double du)
	 {
		  super(n);
		  def = de;
		  dur = du;
	 }
	 
	 public Chest(String n, String d, int de, double du)
	 {
		  super(n, d);
		  def = de;
		  dur = du;
	 }
}

class Legs extends Armor
{
	public Legs(String n, int de, double du)
	 {
		  super(n);
		  def = de;
		  dur = du;
	 }
	 
	 public Legs(String n, String d, int de, double du)
	 {
		  super(n, d);
		  def = de;
		  dur = du;
	 }
}

class Boots extends Armor
{
	public Boots(String n, int de, double du)
	 {
		  super(n);
		  def = de;
		  dur = du;
	 }
	 
	 public Boots(String n, String d, int de, double du)
	 {
		  super(n, d);
		  def = de;
		  dur = du;
	 }
}

class ArmorSet extends Item
{
	
	Helm helm;
	Chest chest;
	Legs legs;
	Boots boots;	
	
	public ArmorSet()
	{
		super("","");
	}
	
	public ArmorSet(String n, String d)
	{
		super(n, d);
	}
	
	public ArmorSet(String n, String d, Helm h, Chest c, Legs l, Boots b)
	{
		super(n, d);
		helm = h;
		chest = c;
		legs = l;
		boots = b;
	}
	
	//Remove select peices of armor from a set.
	//WIP
	public void remove(Armor a)
	{
		if(a instanceof Helm) helm = null;
		if(a instanceof Chest) chest = (null;
		if(a instanceof Legs) legs = null;
		if(a instanceof Boots) boots = null;
	}
	
	public void set(Armor a)
	{
		if(a instanceof Helm) helm = (Helm)a;
		if(a instanceof Chest) chest = (Chest)a;
		if(a instanceof Legs) legs = (Legs)a;
		if(a instanceof Boots) boots = (Boots)a;
	}
}
