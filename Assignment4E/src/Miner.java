//Alan Birmaher
//COP 3330
//3/16/13
//Purpose: Class to represent a Miner. The Miner has a special ability 
//to walk into blocked cave spots and excavate the cave so that other 
//characters can traverse that spot (essentially, opening up the cave). 

public class Miner extends Character{
	
	//Sets string to miner
	private String name="Miner";
	
	//Constructs a miner at the initial location
	public Miner(Cave initLoc){
		super(initLoc);
	}
	
	//A string describing what changes were made by the Miner to a blocked cave
	public String describeModification(){
		return "The Miner succesfully moved and excavated a blocked cave";
	}
	
	//The name of this miner
	public String getName(){
		return name;
	}
	
	//Attempt to modify a cave at the given location
	public boolean modifyCave(Cave loc){
		if(loc.isBlocked()){
			loc.makeOpen();
			return true;
		}
		
		else
			return false;
		
	}
	
	//Override of the move method from the Character class. It calls 
	//super class if the character is able to move
	public boolean move(Cave to){
		if(to.isOccupied()){
			return false;
		}
		
		else
			return super.move(to);
	}

}