import java.io.*;
import java.util.*;

//Alan Birnmaher
//2.27.13
//Assignment 3: Allocation Class
//Purpose: Where out main will be for the whole program. Reads in file information.

public class Allocation {
	
	public static void main(String[] args) throws IOException{
		
		//Variables
		String tempFirst= null;
		String tempLast= null;
		int tempSection=0;
		int tempDateSubmitted=0;
		int tempNumberFiles=0;
		int i=0;
		
		//Set up homework queue object
		HomeworkQueue hwQueue = new HomeworkQueue();
		
		//Setting up output file
		Writer OFP= new BufferedWriter(new FileWriter("HW_Allocation.txt"));
		
		//Setting up homework list file for use
		File homeWorkList= new File("HW_List.txt");
		Scanner homeWork= new Scanner(homeWorkList);
		
		//Loop to read the file line by line and process it
		while(homeWork.hasNextLine()){
			
			//Tries to see if this works, would not work in case of blank line at end of file
			try{
				
				//Read values in from file
				tempLast=homeWork.next();
				tempFirst=homeWork.next();
				tempSection=homeWork.nextInt();
				tempDateSubmitted=homeWork.nextInt();
				tempNumberFiles=homeWork.nextInt();
				
				//Creates out file ArrayList
				Files fileList=new Files();
				
				//Scan list of file names
				for(i=0;i<tempNumberFiles;i++)
					fileList.addFile(homeWork.next());
				
				//Creates out homework object
				Homework assignment=new Homework(tempFirst, tempLast,tempSection, tempDateSubmitted);
				
				//Adds the file list to our object
				assignment.list=fileList;
				
				//Adding to queue and checking if duplicate
				boolean flag=hwQueue.addHomework(assignment);
					
				//If the assignment already exists in queue
				if(flag==false)
					OFP.write("Homework "+assignment.toString()+" already in queue. Not added.\n");
					
				//If the assignment was added to queue successfully
				else
					OFP.write("Homework "+assignment.toString()+" added to the queue.\n");
				
			}
			
			//Empty next line 
			catch(Exception ex){
				//Do nothing
			}
					
		}

		//Let the user know that the assignments have been processed
		OFP.write("Finished processing homeworks!\n\n");
		
		//Close input file
		homeWork.close();
		
		//Go through and determine if Files are new or repeats. If they are repeats don't add to Queue. If they aren't
		//add them to the queue as well. Then print to file saying if we did or did not add them to Queue
		
		//Variables
		int TAid=0;
		int TAsection=0;
		int assignRequested=0;
		
		//Setting up TA file for use
		File requestWorkList= new File("TA_Queries.txt");
		Scanner taList= new Scanner(requestWorkList);
		
		//Read in TA requests
		
		//Loop to read the file line by line and process it
		while(taList.hasNextLine()){
			
			//Tries to see if this works, would not work in case of blank line at end of file
			try{
				//Read though the TA list of queries
				TAid=taList.nextInt();
				TAsection=taList.nextInt();
				assignRequested=taList.nextInt();
				
				//Sets up a counter variable
				int counter=0;
				
				//Loop to give the TA the amount of assignments they want for their section
				for(i=0;i<assignRequested;i++){
					
					//There is no more assignments in this section
					if(hwQueue.sectionIsEmpty(TAsection)){
						
						//If no assignments were assigned
						if(counter==0){
							OFP.write("TA "+TAid+" assigned no homeworks. Nothing in the queue for section "+TAsection+"\n");
						}
						
						//If some assignments were assigned
						else{
							OFP.write("TA "+TAid+" assigned "+counter+"/"+assignRequested+" homework(s) from section "+TAsection+".\n");
						}
						
						//Breaks out of the current loop
						break;
					
					}
				
					//If there is more assignments in this section
					else{
						
						//Prints that assignment was assigned
						OFP.write("TA "+TAid+" gets assigned homework "+hwQueue.getHomework(TAsection)+"\n");
						
						//Increments the counter
						counter++;
						
						//If all requests are filled
						if(counter==assignRequested){
							OFP.write("TA "+TAid+" assigned all "+assignRequested+" requested homework(s) from section "+TAsection+".\n");
						}
						
					}
				}
			}
			
			//In case of blank line at end of file
			catch(Exception ex){
				//Do nothing
			}
			
			//Print addtional blank line 
			OFP.write("\n");
			
		}
		
		//Let the user know that the assignments have been processed
		OFP.write("Finished processing TA Queries! Exiting.\n");
		
		//Closes input file
		taList.close();
		
		
		//Close output file
		OFP.close();
		
	}//End file
	
}