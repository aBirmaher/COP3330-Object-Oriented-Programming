import java.util.Random;

//Alan Birmaher
//3/16/13
//COP 3330
//Purpose: Creates the board

public class Board {

	//Variables
	private Cave[][] gameboard;
	private int rand;
	private int rows;
	private int cols;
	private Random randGen=new Random();
	
	//Generates a random game board with a size of rows x cols
	public Board(int rows, int cols){
		
		//Sets the value of given rows and cols to this specific rows and cols
		this.cols=cols;
		this.rows=rows;
		
		//New gameboard
		gameboard= new Cave[rows][cols];
		
		//Loop through rows and cols
		for(int i=0;i<rows;i++){
			for(int j=0; j<cols;j++){
				
				//Random generation
				rand=randGen.nextInt(101);
				gameboard[i][j]=new Cave(i,j);
				
				//50% chance that the space is open
				if(rand<=50){
					gameboard[i][j].makeOpen();
					gameboard[i][j].setOccupied(false);
				}
				
				//20% chance that the space is blocked
				else if(rand<=70){
					gameboard[i][j].makeBlocked();
					gameboard[i][j].setOccupied(false);
				}
				
				//20% chance the space is a pit
				else if(rand <=90){
					gameboard[i][j].makePit();
					gameboard[i][j].setOccupied(false);
				}
				
				//10% chance the space is a teleporter
				else if(rand <= 100){
					gameboard[i][j].makeTeleport();
					gameboard[i][j].setOccupied(false);
				}
				
				//Sets the top left as our starting location
				if(i==0&&j==0){
					gameboard[i][j].makeOpen();
					gameboard[i][j].setOccupied(true);
				}
				
				//Makes treasure say its not occupied
				else if(i==rows-1&&j==cols-1){
					gameboard[rows-1][cols-1].setOccupied(false);
					gameboard[rows-1][cols-1].makeTreasure();
				}
			}
		}	
		
	}
	
	//Get the cave at a given location (r,c)
	public Cave getCave(int r, int c){
		return gameboard[r][c];
	}
	
	//Get a random unoccupied open location from the current game board
	public Cave getUnoccupiedOpenLocation(){
		
		//Random location
		int randRow=randGen.nextInt(rows);
		int randCol=randGen.nextInt(cols);
		
		//While its open or occupied
		while(!gameboard[randRow][randCol].isOpen()||gameboard[randRow][randCol].isOccupied()){
			randRow=(int)(Math.random()*rows);
			randCol=(int)(Math.random()*cols);
		}
		
		//Returns the location on the gameboard
		return gameboard[randRow][randCol];
	}
	
	//Check if the location is inside the board or not and return boolean
	public boolean ok(int r, int c){
		if((r<rows && r>=0)&&(c>=0 && c<cols)){
			return true;
		}
		else
			return false;
	}
}