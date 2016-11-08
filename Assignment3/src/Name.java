//Alan Birnmaher
//2.27.13
//Assignment 3: Name Class
//Purpose: Used to compare various name entries and determine a course of action.

public class Name implements Comparable<Name>{
	
	String firstName=null;
	String lastName=null;
	String name= null;

	//Constructors
	
	//Constructs a string object with the given first and last name
	public Name (String first, String last){
		
		//First name to correct format
		String firstLetter = first.substring(0,1).toUpperCase();
		String restLetter = first.substring(1).toLowerCase();
		this.firstName=firstLetter+restLetter;
		
		//Last Name to correct format
		firstLetter = last.substring(0,1).toUpperCase();
		restLetter = last.substring(1).toLowerCase();
		this.lastName=firstLetter+restLetter;
		
		//Makes out full name string
		this.name=toString();
		
	}
	
	//Methods
	
	//Defines the natural ordering of Names. 
	public int compareTo(Name other){
		
		//Variable
		int retValue;
		
		//Compares last names
		retValue=this.lastName.compareTo(other.lastName);
		
		if(retValue>0)
			return 1;
		
		else if(retValue<0)
			return -1;
		
		//Compares first names
		retValue=this.firstName.compareTo(other.firstName);
		
		if(retValue>0)
			return 1;
		
		else if(retValue<0)
			return -1;
		
		//Names are the same
		else
			return 0;
		
	}
	
	//Determine whether two Names are identical letter by letter.
	public boolean equals(Name other){
		
		
		//Return Statement: Whether this Name is identical to the argument, in which case both 
		//first and last names are identical, letter by letter.
		return false;
		
	}
	
	//The name in format [first name][space][last name].
	public String toString(){
		
		//Produce name
		String name= (this.firstName+" "+this.lastName);
		
		//Return Statement: First name, followed by a single space, followed by last name.
		return name;
		
	}
	
}//End file
