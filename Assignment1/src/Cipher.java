//Alan Birmaher
//COP 3330-001
//Description:Cipher words by moving each letter up a certain amount

//Class import
import java.util.Scanner;

//Public Class
public class Cipher {

	//Main
	public static void main(String[] args){
		
		//Variables
		int k=0;
		int temp=0;
		int length = 0;
		int counter = 0;
		int loop=0;
		String sentence;
		char[] cipher = null;
		
		//Scanner setup
		Scanner scanner = new Scanner (System.in);
		
		//Read in first value for k
		k=scanner.nextInt();
		
		//Infinite Loop
		while(loop!=1){
			
			//Counter increases
			counter++;
			
			//Read in String
			sentence=scanner.nextLine();
			
			//Length of sentence saved to integer
			length = sentence.length();
			
			//Saves the sentence to the array
			cipher = sentence.toCharArray();
			
			//Prints case
			System.out.printf("CASE #%d:", counter);
			
			//For loop to go for entire length of array
			for(int i=0;i<length;i++){
				
				//If the character is not a space
				if(cipher[i] != ' '){
					
					//Adds the k value
					temp=(int)cipher[i] + (k%26);
					
					//Prevents over flow
					if(temp > 'Z'){
						temp-=26;
					}
					
					//Saves the new value back into the array
					cipher[i]= (char)temp;
				}
					
				//Print out letter
				System.out.print(cipher[i]);

			}

			//Prints blank line
			System.out.println();
			
			//Reads in the next k 
			k=scanner.nextInt();
		}

	}

}//Ends
