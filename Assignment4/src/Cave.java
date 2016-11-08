//Alan Birmaher & Adam Clark
//COP 3330-001
//3/16/13
//Purpose: Class that defines a single cave location

public class Cave {
	
	//Enum of the different types of caves
	public static enum CaveType{
		BLOCKED,
		OPEN,
		PIT,
		TELEPORT,
		TREASURE;
	}
	
	//Variables for the class
	private int row;
	private int col;
	private Cave.CaveType cavetype;
	private boolean isMarked=false;
	private boolean isOccupied=false;
	
	//Constructs an open cave which is unoccupied and unmarked in the begining
	public Cave(int r, int c){
		row=r;
		col=c;
		cavetype=Cave.CaveType.OPEN;
	}
	
	//Gets the column of the cave
	public int getCol(){
		return col;
	}
	
	//Gets the row of the cave
	public int getRow(){
		return row;
	}

	//Get whether cave is blocked
	public boolean isBlocked(){
		if(cavetype==Cave.CaveType.BLOCKED){
			return true;
		}
		
		else
			return false;
	}
	
	//Get whether this cave is marked
	public boolean isMarked(){
		return isMarked;
	}
	
	//Get whether this cave is occupied
	public boolean isOccupied(){
		return isOccupied;
	}
	
	//Get whether this cave is open
	public boolean isOpen(){
		if(cavetype==Cave.CaveType.OPEN){
			return true;
		}
		
		else
			return false;
	}
	
	//Get whether this cave is a pit
	public boolean isPit(){
		if(cavetype==Cave.CaveType.PIT){
			return true;
		}
		
		else
			return false;
	}
	
	//Get whether this cave is a teleport
	public boolean isTeleport(){
		if(cavetype==Cave.CaveType.TELEPORT){
			return true;
		}
		
		else
			return false;
	}
	
	//Mark this cave as blocked
	public void makeBlocked(){
		cavetype=Cave.CaveType.BLOCKED;
		return;
	}
	
	//Mark this cave as open
	public void makeOpen(){
		cavetype=Cave.CaveType.OPEN;
		return;
	}
	
	//Mark this cave as a pit
	public void makePit(){
		cavetype=Cave.CaveType.PIT;
		return;
	}
	
	//Mark this cave as a teleport
	public void makeTeleport(){
		cavetype=Cave.CaveType.TELEPORT;
		return;
	}
	
	//Set whether this cave is marked
	public void setMarked(boolean set){
		isMarked=set;
		return;
	}
	
	//Set whether this cave is occupied
	public void setOccupied(boolean set){
		isOccupied = set;
		return;
	}
	
	//Mark this cave as treasure
	public void makeTreasure(){
		cavetype=Cave.CaveType.TREASURE;
		return;
	}
}
