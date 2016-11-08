//Alan Birnmaher
//2.27.13
//Assignment 3: Homework Class
//Purpose: Deals with what to do with the homework information provided

public class Homework implements Comparable<Homework>{

	//The next available unique ID to assign to a homework assignment. See generateNextUniqueId() method for usage.
	public static int nextAvailableUid=0;
	
	//Variables
	String firstName;
	String lastName;
	int sectionNum;
	int dateIn;
	int idNum;
	Name fullName;
	Files list;
	
	//Constructors
	
	//Construct a new Homework assignment with the given initial values. 
	//Assumes the id passed is unique among all other Homework IDs.
	public Homework(int id, Name name, int section, Files files, int dateSubmitted){
	
		this.idNum=id;
		this.fullName=name;
		this.sectionNum=section;
		this.list=files;
		this.dateIn=dateSubmitted;
		this.firstName=name.firstName;
		this.lastName=name.lastName;
		
	}
	
	//Construct a new Homework assignment with the given initial values and an empty list of Files. 
	//Assumes the id passed is unique among all other Homework IDs.
	public Homework(int id, Name name, int section, int dateSubmitted){
		
		this.idNum=id;
		this.fullName=name;
		this.sectionNum=section;
		this.dateIn=dateSubmitted;
		this.list=new Files();
		this.firstName=name.firstName;
		this.lastName=name.lastName;
		
	}
	
	//Construct a new Homework assignment with the given initial values and an empty list of Files. 
	//The constructor will generate the next valid unique ID available automatically.
	public Homework(String first, String last, int section, int dateSubmitted){
		
		this.sectionNum=section;
		this.dateIn=dateSubmitted;
		this.idNum=generateNextUniqueId();
		this.list= new Files();
		fullName = new Name(first, last);
		
	}
	
	//Methods
	
	//Compares two s based on their priorities for grading. 
	//See the homework documentation for this specific ordering.
	public int compareTo(Homework other){
		
		
		//Parameter:
		//other - The Homework to be compared to this Homework.
		
		//Return Statement: A negative integer if this Homework has higher priority than the argument. 
		//A positive integer if this Homework has lower priority than the argument. 
		//Zero if this Homework has the same priority as the argument.
		
		//Checks submission dates
		if(this.dateIn < other.dateIn){
			return -1;
		}
		else if(this.dateIn > other.dateIn){
			return 1;
		}
		
		//Checks lists
		if(this.list.compareTo(other.list) < 0){
			return -1;
		}
		
		else if(this.list.compareTo(other.list) > 0){
			return 1;
		}
		
		//Checks names
		if(this.fullName.compareTo(other.fullName)<0){
			return -1;
		}else if(this.fullName.compareTo(other.fullName)>0){
			return 1;
		}
		
		//They are considered the same
		return 0;
	}
	
	//Generate the next unique ID for a homework assignment and increment the next available ID.
	public static int generateNextUniqueId(){
		
		nextAvailableUid++;
		
		//Return Statement
		return nextAvailableUid;
	}
	
	//Get the number of days late this homework assignment was submitted
	public int getDaysLate(){
		
		//Return Statement
		return (this.dateIn-15);
		
	}
	
	//Get the files associated with this homework assignment
	public Files getFiles(){
		
		//Return Statement
		return this.list;
		
	}
	
	//Get the unique ID associated with this homework.
	public int getId(){
		
		//Return Statement
		return this.idNum;
		
	}
	
	//Get the name of the student who submitted this homework assignment
	public Name getName(){
		
		//Return statement
		return this.fullName;
		
	}
	
	//Get the section number of this homework assignment
	public int getSection(){

		//Return statement
		return this.sectionNum;
		
	}
	
	//Get a String representation of this Homework.
	public String toString(){
		
		String tempReturn;
		
		//Starts the value for return value
		tempReturn=(this.idNum+": "+this.list.getNumberOfFile()+" files(s) "+this.list+" submitted by "+this.fullName+" ");
		
		//If the assignment is early
		if(this.getDaysLate()<0)
			tempReturn+=(-(this.getDaysLate())+" day(s) early for section "+this.sectionNum);
		
		//If the assignment is late
		else if(this.getDaysLate()>0)
			tempReturn+=(this.getDaysLate()+" day(s) late for section "+this.sectionNum);
		
		//If the assignment is on time
		else
			tempReturn+=("on time for section "+this.sectionNum);
		
		//Return Statement: Returns a String representation of this Homework in the form: 
		return tempReturn;
		
	}
	
}///End file
