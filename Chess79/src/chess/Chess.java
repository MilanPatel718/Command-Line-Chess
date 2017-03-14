package chess;

import Piece.*;


/**
 * @author Milan Patel
 * @author Baljit Kaur
 */
public class Chess {
	static Block board[][] =new Block[9][9];
	
/**
 * Populates Chess Board for start of game
 * @param None
 */
public static void populateBoard(){
	for(int i=0; i<8; i++){
		for(int j=0;j<8;j++){
			
			//Initialize pieces at starting locations
			if(i==0 || i==7){
					
					//Rooks
					if(j==0 || j==7){
						//Black Rook
						if(i==0){
							board[i][j]=new Block(8, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Rook("bR ", board[i][j], "Black"));
							board[i][j].setDisplay("bR ");
							
						}
						//White Rook
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Rook("wR ", board[i][j], "White"));
							board[i][j].setDisplay("wR ");
						}
					}
					
					//Knights
					else if(j==1 || j==6){
						//Black Knight
						if(i==0){
							board[i][j]=new Block(8, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Knight("bN ", board[i][j], "Black"));
							board[i][j].setDisplay("bN ");
						}
						//White Knight
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Knight("wN ", board[i][j], "White"));
							board[i][j].setDisplay("wN ");
						}
					}
					
					//Bishops
					else if(j==2 || j==5){
						//Black Bishop
						if(i==0){
							board[i][j]=new Block(8, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Bishop("bB ", board[i][j], "Black"));
							board[i][j].setDisplay("bB ");
						}
						//White Bishop
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Bishop("wB ", board[i][j], "White"));
							board[i][j].setDisplay("wB ");
						}
						
					}
					
					//Queen
					else if(j==3){
						//Black Queen
						if(i==0){
							board[i][j]=new Block(8, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Queen("bQ ", board[i][j], "Black"));
							board[i][j].setDisplay("bQ ");
						}
						//White Queen
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Queen("wQ ", board[i][j], "White"));
							board[i][j].setDisplay("bQ ");
						}
					}
					
					//King
					else{
						//Black King
						if(i==0){
							board[i][j]=new Block(8, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new King("bK ", board[i][j], "Black"));
							board[i][j].setDisplay("bK ");
						}
						//White King
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new King("wK ", board[i][j], "White"));
							board[i][j].setDisplay("wK ");
						}
					}
					
				}
				
			//Pawns
			else if(i==1 || i==6){
					//Black Pawns
					if(i==1){
							board[i][j]=new Block(7, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Pawn("bp ", board[i][j], "Black"));
							board[i][j].setDisplay("bp ");
						}
					//White Pawn
					if(i==6){
							board[i][j]=new Block(2, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Pawn("wp ", board[i][j], "White"));
							board[i][j].setDisplay("wp ");
						}
					}
				
				
			//Unoccupied
			else{
					if(i==2){
						board[i][j]=new Block(6, j);
						board[i][j].setOccupied(false);
						
					}
					
					else if(i==3){
						board[i][j]=new Block(5, j);
						board[i][j].setOccupied(false);
					}
					
					else if(i==4){
						board[i][j]=new Block(4, j);
						board[i][j].setOccupied(false);
					}
					
					else{
						board[i][j]=new Block(3, j);
						board[i][j].setOccupied(false);
						
					}
				}
			
			//Determine which blocks are shaded/nonshaded
			if( (i%2==0 && j%2==1) || (i%2==1 && j%2==0)){
				board[i][j].setShaded(true);
				if(board[i][j].getPiece()==null){
				board[i][j].setDisplay("## ");
				}
			}
			else{
				board[i][j].setShaded(false);
				if(board[i][j].getPiece()==null){
				board[i][j].setDisplay("   ");
				}
			}
		}
	}
	
	//Populate Row 9 and Column 9
	for(int i=0; i<9;i++){
		if(i==0)
			board[8][i]=new Block(" a");
		else if(i==1)
			board[8][i]=new Block("  b");
		else if(i==2)
			board[8][i]=new Block("  c");
		else if(i==3)
			board[8][i]=new Block("  d");
		else if(i==4)
			board[8][i]=new Block("  e");
		else if(i==5)
			board[8][i]=new Block("  f");
		else if(i==6)
			board[8][i]=new Block("  g");
		else if(i==7) 
			board[8][i]=new Block("  h");
		else
			board[8][i]=new Block("  ");
		
	}
	
	for(int i=0; i<9;i++){
		if(i==0)
			board[i][8]=new Block("8");
		else if(i==1)
			board[i][8]=new Block("7");
		else if(i==2)
			board[i][8]=new Block("6");
		else if(i==3)
			board[i][8]=new Block("5");
		else if(i==4)
			board[i][8]=new Block("4");
		else if(i==5)
			board[i][8]=new Block("3");
		else if(i==6)
			board[i][8]=new Block("2");
		else if(i==7)
			board[i][8]=new Block("1");
		else
			board[i][8]=new Block(" ");
	} 
}
	
	/**
	 * Prints Chess Board
	 * @params None
	 */
	public static void printBoard(){
		for(int i=0;i<9;i++){
			for(int j=0;j<9;j++){
				
			System.out.print(board[i][j].getDisplay());
				
			}
			System.out.println();
	}
}


	/**
	 * Main Class for Chess Driver
	 */
	public static void main(String[] args){
			populateBoard();
			printBoard();
	

	}
}