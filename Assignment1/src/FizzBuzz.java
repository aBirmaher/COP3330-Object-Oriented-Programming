//Alan Birmaher
//COP 3330-001
//Description: The purpose of this program is to read in two values a and b and
//for every value between those two values determine what to do. If the value is
//divisible by 3 then print 'Fizz'and if its divisible by 5 print 'Buzz'. If
//it is divisible by bother then print 'Fizz Buzz'. If its divisible by neither
//just print the number. The data should be printed to an output file.

//Class to import
import java.util.Scanner;

//The FizzBuzz class
public class FizzBuzz {

	//This is our main
	public static void main(String[] args){
		
		//Variables
		int x=0;
		int a=0;
		int b=0;
		int flag=0;
		
		//Read in the first 2 values for A and B
		Scanner scanner = new Scanner(System.in);

		//Reads in a and b for the first time
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		//While the values for A and B are not zero do this
		while(a!=0 && b!=0){
			
			//For loop that checks and prints every value from a to b
			for(x=a;x<=b;x++){
			
				//If x is divisible by 3 
				if((x%3)==0){
	
					//Print 'Fizz' and set flag to 1
					System.out.print("Fizz ");
					flag=1;
					
				}
				
				//If x is divisible by 5
				if((x%5)==0){
					
					//Print 'Buzz' and set flag to 1
					System.out.print("Buzz");
					flag=1;
				}
				
				//If the number was not divisible by 3 or 5
				if(flag!=1){
					
					//Print the value of x
					System.out.printf("%d", x);
					
				}
				
				//Print a line break and reset flag variable
				System.out.print("\n");
				flag=0;
				
			}
			
		//Prints a blank line before receiving new a and b values
		System.out.print("\n");
			
		//Read in new A and B
		a = scanner.nextInt();
		b = scanner.nextInt();
		
		//Print line break
		System.out.print("\n");
		
		}
		
	}

}//End of code
