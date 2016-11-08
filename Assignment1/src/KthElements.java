//Alan Birmaher
//COP 3330-001
//Description: Print every kth term from the given array

//Classes to import
import java.util.Scanner;
import java.util.ArrayList;

//The FizzBuzz class
public class KthElements {

	//This is our main
	public static void main(String[] args){
		
		//Variables
		int k=0;
		int n=0;
		int temp=0;
		int x=0;
		boolean first = true;
		
		//Sets up our array
		ArrayList<Integer> values= new ArrayList<Integer>();
		
		//Set up scanner for the file
		Scanner scanner = new Scanner(System.in);

		//Reads in k for the first time
		k = scanner.nextInt();
		
		//While the value of k does not equal 0
		while(k!=0){
			
			//For loop adds in the file values to array
			for(x=1;x<=k;x++){
			
				//Reads in all the values into our array
				temp= scanner.nextInt();
				values.add(temp);
				
			}
			
			//Reads in our value for n
			n = scanner.nextInt();
			
			//For loop that checks and prints every value from a to b
			for(x=1;x<=k;x++){

				//Check if this is the first time to see if comma is needed
				if(x%n==0&&first==false){
					System.out.printf(", ");
				}
				
				//Reads in all the values into our array
				if(x%n==0){
					System.out.printf("%d", values.get(x-1));
					first = false;
				}
				
			}
			
			//Next line
			System.out.print("\n");
			
			//Reads in k again
			k = scanner.nextInt();
			
			//Clears the array
			values.clear();
			
			//Resets our boolean value to true
			first = true;
		
		}
		
	}

}//End of code