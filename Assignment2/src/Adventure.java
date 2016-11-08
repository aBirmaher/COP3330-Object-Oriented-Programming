//Alan Birmaher
//2/6/13
//COP 3330.0001
//Adventure Game: This is a game where you need to get your piece to the treasure
//while avoiding obstacles.

//Imports
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//Start of our public class
public class Adventure {
	
	//Setting a final value for N
	public static final int N=10; // The size of the game board.
       
	//Start of our main
	public static void main(String[] args) throws IOException {
		
		/***********************************Begin of Board generation**********************************************/
		// Create an NxN game board. Remember Array? What kind of array is this? 2D char array. 
		char[][] board = new char[N][N];
		
		//Sets up random number generator
		Random generator = new Random();
		
		// Put the player in the top left and treasure in the bottom right.
		board[0][0]='P';
		board[N-1][N-1]='T';
		
		// Fill the rest of the board in randomly, with the probabilities given in the assignment.
		for (int i=0; i<N; ++i) {
			for (int j=0; j<N; ++j) {  //note - we are using 2 'for' loops to populate the array as the board is 2D. 
				
				//Generates a random value less than 100
				int r = generator.nextInt(100);
				
				if(board[i][j]=='P' || board[i][j]=='T'){
					//Do nothing so that you dont erase first and last position
				}
				
				//If its a pit (5% probability)
				else if(r<5){
					board[i][j]='*';
				}
				
				//If its an obstacle (10% probability)
				else if(r<15){
					board[i][j]='X';
				}
				
				//If its a normal space (85% probability)
				else{
					board[i][j]='.';
				}			
			}
		}
		
		/***********************************End of Board generation**********************************************/


		// Store the current location of the user.
		int r=0,c=0; // r indicates row and c indicates column.
		
		//Game over tracker
		int gameOver=-1;
		
		//Game logic begins
		while (true) {
			
			/***********************************Print the current board*******************************************/
			// First, print the current state of the game (i.e. print the game board).
			System.out.println("Here's the current game board:");
			System.out.println("------------------------------");
			
			// Print current game board here.
			for (int i=0; i<N; ++i) {
				for (int j=0; j<N; ++j) {
					System.out.print(board[i][j]); //Prints all spaces on line i
				}
				System.out.print("\n"); //Next line
			}
			
			//Skips a line
			System.out.println();
			/*****************************************End of Print***********************************************/


			
			/**************************************Begin of User input*******************************************/
			///Variable to record user's move.
			char move= '\0';
			int flag=0;
			
			//While loop that loops until correct input is given
			while(flag==0){
				
				//Prompts the user for input
				System.out.print("Enter your move <U/D/L/R> ");

				//Reads in the user input
				move=(char) new InputStreamReader(System.in).read ();

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
			
			/**************************************End of User input*********************************************/

			
			
			/*****************Calculate the current position of the user based on the user input*****************/
			//Set up variables
			int dr=0;
			int dc=0;
			
			//Variable for use in this section
			int selection = 0;
			
			//If the move was u or U its condition 1
			if(move=='u' || move=='U')
				selection=1;
			
			//If the move was d or D its condition 2
			else if(move=='d' || move=='D')
				selection=2;
			
			//If the move was r or R its condition 3
			else if(move=='r' || move=='R')
				selection=3;
			
			//If the move was l or L its condition 4
			else if(move=='l' || move=='L')
				selection=4;
			
			//If none of the cases are met for some reason
			else
				System.out.println("Something went wrong");	//Tells user their input was wrong
		
			//Switch statement to determine what move was made and act on it
			switch (selection) {
			
				//If user selects up
				case 1:
					dr=-1;
					break;
					
				//If user selects down
				case 2:
					dr=1;
					break;
					
				//If user selects left
				case 3:
					dc=1;
					break;
					
				//If user selects right
				case 4:
					dc=-1;
					break;
					
				//If the input was nor correct
				default: System.out.println("Error"); 
				break;
						 
			
			}
			//Prints blank line
			System.out.println();
			
			// Get the new row and new col the user wants to move to.
			int nr=r+dr, nc=c+dc;
			
			/*********************************************End of Calculation**************************************/

			
			
			/*************************Logic of the game: Update the board based on each move**********************/			
			// First check if the spot is off the game board (i.e. the user is walking into a wall).
			if (nr<0 || nr>9 || nc<0 || nc>9) {
				
				// Wall, can't move here! Just tell the user that, no updates necessary.
				System.out.println("You can't walk into a wall! No movement made.");
				
			}
			
			// Otherwise the spot is guaranteed to be on the game board, so we need to check what
			// type of spot it is (Open/Treasure, Blocked, or Pit)
			else if (board[nr][nc]=='.' || board[nr][nc]=='T') { 
				
				// Check if we made it to the end! If so, tell the user s/he won and break out.
				if (board[nr][nc]=='T') {
					
					//Tells the user they found the treasure and ends the game
					System.out.print("You have found the treasure! Congratulations!\n");
					r=nr; c=nc;
					
					//Breaks out of the loop
					break;
					
				}
				
				// Remove the player from the old spot.
				board[r][c]='.';
				
				// Update the current spot of the player
				r=nr; c=nc;
				
				// Put the player in the new spot.
				board[r][c]='P';
				
				// Tell the user the move was successful.
				System.out.println("You have successfully moved one spot!");
				
			}
			
			//If the path is blocked
			else if (board[nr][nc]=='X') { // Blocked (indicated by X), can't move here! Just tell the user that, no updates necessary.
				
				//Let the user know they can't move there
				System.out.print("That spot is blocked! No movement made.\n"); 
				
			}
			
			//If the user goes into a pit
			else if (board[nr][nc]=='*') { // Pit, game over! Tell the user they lost and get out of the loop.
				
				// Pit, game over! Tell the user they lost and get out of the loop.
				System.out.println("That wasn't very smart bro, you just walked right into that pit!");
				System.out.println("Your dead :-(. Better luck next time!\n");
				
				//Sets the game flag to over
				gameOver=1;
				
				//End the if else loop
				break;
				
			}
			
			//If their move was invalid let them know and continue
			else { // Print error otherwise
				// Shouldn't ever happen unless the game board was invalidly generated...
				System.err.printf("board[%d][%d] = %c is unrecognized spot!%n",nr,nc,board[nr][nc]);
				continue;
			}
			
			//Print blank line
			System.out.println();
			
			
			//If game is over get out of loop
			if (gameOver==1)
				break;
			
		} // end of while(true) loop
		
		// The game is over here, nothing to do but say goodbye.
		System.out.println("Thanks for playing. Bye!");
		/********************************************End of the game logic************************************/		
		
	}

}//End