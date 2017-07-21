class Generic
{
	/*
	 * Holds all of the generic Items, Weapons, and Armor. 
	 */
	public static Item genericItem = new Item("Generic Item", "A generic, placeholder item.");
	public static Weapon genericWeapon = new Weapon("Generic Weapon", "A generic, placeholder weapon.", 5, 100, 10, 100);
	public static Sword genericSword = new Sword("Generic Sword", "A generic, placeholder sword.", 5, 100, 10, 100);
	public static Lance genericLance = new Lance("Generic Lance", "A generic, placeholder lance.", 5, 100, 10, 100);
	public static Axe genericAxe = new Axe("Generic Axe", "A generic, placeholder axe.", 5, 100, 10, 100);
	public static Armor genericArmor = new Armor("Generic Armor", "A generic, placeholder armor piece.", 5, 100);
	public static Helm genericHelm = new Helm("Generic Helm", "A generic, placeholder helmet.", 5, 100);
	public static Chest genericChest = new Chest("Generic Chest", "A generic, placeholder chestplate.", 5, 100);
	public static Legs genericLegs = new Legs("Generic Legs", "A generic, placeholder pair of leggings.", 5, 100);
	public static Boots genericBoots = new Boots("Generic Armor", "A generic, placeholder pair of boots.", 5, 100);
	public static ArmorSet genericArmorSet = new ArmorSet("Generic Set of Armor", "A generic, placeholder set of armor.", genericHelm, genericChest, genericLegs, genericBoots);
	public static Character genericChar = new Character("Character");
	
}

class Instances
{
	/*
	 * Holds all of the instances of Items, Weapons, and Armor, Classes, etc.
	 */
	
	//CLASSES
	public static Class lightMage = new Class("Light Mage", new int[]{10, 0, 5, 10, 10, 10, 20, 20, 15}, new int[]{20, 8, 14, 20, 18, 18, 25, 25, 20});
	public static Class darkMage = new Class("Dark Mage", new int[]{15, 0, 20, 5, 3, 15, 10, 16, 16}, new int[]{25, 10, 20, 11, 10, 20, 25, 22, 25});
	public static Class swordsman = new Class("Swordsman", new int[]{20, 15, 10, 15, 10, 5, 10, 5, 10}, new int[]{20, 8, 14, 20, 18, 18, 25, 25, 20});
	public static Class knight = new Class("Knight", new int[]{10, 0, 5, 10, 10, 10, 18, 18, 15}, new int[]{20, 8, 14, 20, 18, 18, 25, 25, 20});
	
	//ITEMS
	
	// ARMOR
	public static Armor nullArmor = new Armor("Nothing", "Nothing", 2, true);
		// BRONZE
			public static Helm bronzeHelm = new Helm("Bronze Helmet", "A bronze helmet, not very strong or durable.", 2, 25);
			public static Chest bronzeChest = new Chest("Bronze Chestplate", "A bronze chestplate, not very strong or durable.", 2, 25);
			public static Legs bronzeLegs = new Legs("Bronze Leggings", "A pair of bronze leggings, not very strong or durable.", 2, 25);
			public static Boots bronzeBoots = new Boots("Bronze Boots", "A pair of bronze boots, not very strong or durable.", 2, 25);
			public static ArmorSet bronzeSet = new ArmorSet("Bronze Armor", "Bronze armor, not very strong or durable.", bronzeHelm, bronzeChest, bronzeLegs, bronzeBoots);
		// IRON
			public static Helm ironHelm = new Helm("Iron Helmet", "An iron helmet, average in strength.", 3, 40);
			public static Chest ironChest = new Chest("Iron Chestplate", "An iron chestplate, average in strength.", 3, 40);
			public static Legs ironLegs = new Legs("Iron Leggings", "A pair of iron leggings, average in strength.", 3, 40);
			public static Boots ironBoots = new Boots("Iron Boots", "A pair of iron boots, average in strength.", 3, 40);
			public static ArmorSet ironSet = new ArmorSet("Iron Armor", "Iron armor, average in strength.", bronzeHelm, bronzeChest, bronzeLegs, bronzeBoots);
	// WEAPONS
}
