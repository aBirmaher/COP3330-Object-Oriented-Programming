//Alan Birmaher & Adam Clark
//COP 3330-001
//3/17/13
//Purpose: Interface to describe what modifications are allowed by certain characters 
//and actually carry out those modifications, if applicable to a given spot for a given 
//character type. Remember that you don't implement any methods in an interface, you 
//just give the method prototypes. 

public interface CaveWorker {
	
	//Give a description of the type of modification made
	public String describeModification();
	
	//Method making modifications to a given cave if this worker can modify this type of cave
	public boolean modifyCave(Cave loc);

}
