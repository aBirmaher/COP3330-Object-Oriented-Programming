//Alan Birmaher
//3/16/13
//COP 3330
//Purpose: This class represents the adventure. He has the ability to walk into teleport
//spots and not be teleported but rather makes them known. He must make his way down to the treasure.

public class Adventurer extends Character{

	//Sets up a private string for this class for the adventurer
	private String name="Adventurer";
	
	//Constructor for an adventurer
	public Adventurer(Cave initLoc){
		super(initLoc);
	}
	
	//Lets the user know a transporter was uncovered
	public String describeModification(){
		return "The Adventurer sucessfully moved and marked a teleporter";
	}
	
	//The adventurer's name
	public String getName(){
		return name;
	}
	
	//Attempt to modify the cave at a given location
	public boolean modifyCave(Cave loc){
		if(loc.isTeleport()){
			loc.setMarked(true);
			return true;
		}
		
		else
			return false;
	}
	
	//Overrides the move method from the Character class and calls super class
	//if the character can move
	public boolean move(Cave to){
		if(to.isBlocked()||to.isOccupied()){
			return false;
		}
		
		else
			return super.move(to);
	}
	
}