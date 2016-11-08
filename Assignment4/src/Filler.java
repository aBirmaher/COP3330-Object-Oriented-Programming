//Alan Birmaher & Adam Clark
//COP 3330-001
//3/19/13
//Purpose: Class that represents a filler and his special ability 
//to fill pits so that the adventurer and miner can walk on them

public class Filler extends Character{
	
	//Sets string name for the filler
	private String name="Filler";
	
	//Constructs a filler at an initial location
	public Filler(Cave initLoc){
		super(initLoc);
	}
	
	//A string that describes what modification was made by the filler to a pit
	public String describeModification(){
		return "The Filler succesfully moved and filler a cave with a pit";
	}
	
	//The name of the filler
	public String getName(){
		return name;
	}
	
	//Attempt to modify the cave at a given location
	public boolean modifyCave(Cave loc){
		if(loc.isPit()){
			loc.makeOpen();
			return true;
		}
		
		else
			return false;
	}
	
	//Override of the move method from the character class which calls 
	//super class if the character can move
	public boolean move(Cave to){
		if(to.isBlocked()||to.isOccupied()){
			return false;
		}
		
		else{
			return super.move(to);
		}
	}

}