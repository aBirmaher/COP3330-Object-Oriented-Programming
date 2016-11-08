import java.io.IOException;
import java.io.InputStreamReader;

public class Test {
	
	public static final int N=10; // The size of the game board.
       
	public static void main(String[] args) throws IOException{
		
		char move= '\0';
		int flag=0;
		
		while(flag==0){
			
			//Prompts the user for input
			System.out.print("Enter your move <U/D/L/R>\n");

			//move='\0';
			move=(char) new InputStreamReader(System.in).read ();
			
			//Reads in value for choice
			//move=(char) System.in.read();
			

			//If move is up leave loop
			if(move=='u' || move=='U')
				flag=1;

			//If move is down leave loop
			else if(move=='d' || move=='D')
				flag=1;
			
			//If move is left leave loop
			else if(move=='l' || move=='L')
				flag=1;
			
			//If move is right leave loop
			else if(move=='r' || move=='R')
				flag=1;
			
			//If move is invalid prompt the user to try again
			else
				System.out.println("Incorrect input, try again.");

		}
		
		System.out.print(move);
		
	}
	
}