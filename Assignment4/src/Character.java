//Alan Birmaher & Adam Clark
//COP 3330-001
//3/18/13
//Purpose: Class to store information about characters in general for the game.
//Implements the CaveWorker class which defines special operations on a cave
//depending on what kind of character

public abstract class Character implements CaveWorker{
	
	//The cave that is being occupied
	protected Cave location;
	
	//Constructs a new character at the initial location
	public Character(Cave initLoc){
		location=initLoc;
		location.setOccupied(true);
	}
	
	//Get the cave the character is currently occupying
	public Cave getLocation(){
		return location;
	}
	
	//Abstract method to get the name of the character
	public abstract String getName();
	
	//Moves the character from its current location to a new one
	public boolean move(Cave to){
		to.setOccupied(true);
		location.setOccupied(false);
		location=to;
		location.setOccupied(true);
		return true;
	}
}
