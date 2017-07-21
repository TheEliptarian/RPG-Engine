public class Quest
{
	/*
	 * A class to hold quests.
	 * 
	 * Holds the objective, giver, name, and other things.
	 */
	 
	 String name;
	 Obj objective;
	 Character giver;
	 Dialogue promptText;
	 boolean activated = false, completed = false;
	 
	 public Quest(String n, Obj o, Character g, String p)
	 {
		 name = n;
		 objective = o;
		 giver = g;
		 promptText = new Dialogue(p, null);
	 }
	 
	 public Quest(String n, Obj o, Character g, Dialogue p)
	 {
		 name = n;
		 objective = o;
		 giver = g;
		 promptText = p;
	 }
	 
	 public void update()
	 {
		 if(objective.check() == true)
		 {
			 objective.complete = true;
			 completed = true;
		 }
	 }
	 
	 public void prompt()
	 {
		 promptText.print();
		 String input = Engine.getInput("yes", "no");
		 if(input.equals("yes"))
		 { 
			 System.out.println("The Quest \"" + name + "\" has been added to your Quest Log.");
			 activated = true;
			 Player.quests.add(this);
		 }
		 else if(input.equals("no"))
		 {
			 System.out.println("This Quest will remain at this location until you come for it...");
		 }
	 }
}

class Obj
{
	/*
	 * A class that holds the objective of a Quest.
	 */ 
	 
	 enum Type{Kill, Fetch, Speak};
	 Type type;
	 BaseFighter killTarget;
	 Character speakTarget;
	 Item fetchTarget;
	 int goal = 0, count = 0;
	 boolean complete = false;
	 
	 public Obj(Type t)
	 {
		type = t; 
	 }
	 
	 public void killObj(BaseFighter t, int g)
	 {
		 killTarget = t;
		 goal = g;
	 }
	 
	 public void fetchObj(Item t, int g)
	 {
		 fetchTarget = t;
		 goal = g;
	 }
	 
	 public void speakObj(Character t, int g)
	 {
		 speakTarget = t;
		 goal = g;
	 }
	 
	 public boolean check()
	 {
		 if(count >= goal) return true;
		 else return false;
	 }
}
