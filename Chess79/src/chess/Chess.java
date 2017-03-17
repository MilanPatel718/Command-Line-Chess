package chess;

import java.util.HashMap;
import java.util.Map;

import Piece.*;


/**
 * @author Milan Patel
 * @author Baljit Kaur
 */ 
public class Chess {
	static Block board[][] = new Block[9][9];
	public static Map<String, Integer> Fmap=new HashMap<String, Integer>();
	public static Map<String, Integer> Rmap=new HashMap<String, Integer>();
	public static Player black;
	public static Player white;
	
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
							if(j == 0){
								black.setRook1((Rook)board[i][j].getPiece());
							}else if(j == 7){
								black.setRook2((Rook)board[i][j].getPiece());
							}
							
						}
						//White Rook
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Rook("wR ", board[i][j], "White"));
							board[i][j].setDisplay("wR ");
							if(j == 0){
								white.setRook1((Rook)board[i][j].getPiece());
							}else if(j == 7){
								white.setRook2((Rook)board[i][j].getPiece());
							}
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
							if(j == 1){
								black.setKnight1((Knight)board[i][j].getPiece());
							}else if(j == 6){
								black.setKnight2((Knight)board[i][j].getPiece());
							}
						}
						//White Knight
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Knight("wN ", board[i][j], "White"));
							board[i][j].setDisplay("wN ");
							if(j == 1){
								white.setKnight1((Knight)board[i][j].getPiece());
							}else if(j == 6){
								white.setKnight2((Knight)board[i][j].getPiece());
							}
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
							if(j == 2){
								black.setBishop1((Bishop)board[i][j].getPiece());
							}else if(j == 5){
								black.setBishop2((Bishop)board[i][j].getPiece());
							}
						}
						//White Bishop
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Bishop("wB ", board[i][j], "White"));
							board[i][j].setDisplay("wB ");
							if(j == 2){
								white.setBishop1((Bishop)board[i][j].getPiece());
							}else if(j == 5){
								white.setBishop2((Bishop)board[i][j].getPiece());
							}
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
							black.setQueen((Queen)board[i][j].getPiece());
						}
						//White Queen
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Queen("wQ ", board[i][j], "White"));
							board[i][j].setDisplay("bQ ");
							white.setQueen((Queen)board[i][j].getPiece());
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
							black.setKing((King)board[i][j].getPiece());
						}
						//White King
						if(i==7){
							board[i][j]=new Block(1, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new King("wK ", board[i][j], "White"));
							board[i][j].setDisplay("wK ");
							white.setKing((King)board[i][j].getPiece());
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
							if(j == 0){
								black.setPawn1((Pawn)board[i][j].getPiece());
							}else if(j == 1){
								black.setPawn2((Pawn)board[i][j].getPiece());
							}else if(j == 2){
								black.setPawn3((Pawn)board[i][j].getPiece());
							}else if(j == 3){
								black.setPawn4((Pawn)board[i][j].getPiece());
							}else if(j == 4){
								black.setPawn5((Pawn)board[i][j].getPiece());
							}else if(j == 5){
								black.setPawn6((Pawn)board[i][j].getPiece());
							}else if(j == 6){
								black.setPawn7((Pawn)board[i][j].getPiece());
							}else if(j == 7){
								black.setPawn8((Pawn)board[i][j].getPiece());
							}
						}
					//White Pawn
					if(i==6){
							board[i][j]=new Block(2, j);
							board[i][j].setOccupied(true);
							board[i][j].setPiece(new Pawn("wp ", board[i][j], "White"));
							board[i][j].setDisplay("wp ");
							if(j == 0){
								white.setPawn1((Pawn)board[i][j].getPiece());
							}else if(j == 1){
								white.setPawn2((Pawn)board[i][j].getPiece());
							}else if(j == 2){
								white.setPawn3((Pawn)board[i][j].getPiece());
							}else if(j == 3){
								white.setPawn4((Pawn)board[i][j].getPiece());
							}else if(j == 4){
								white.setPawn5((Pawn)board[i][j].getPiece());
							}else if(j == 5){
								white.setPawn6((Pawn)board[i][j].getPiece());
							}else if(j == 6){
								white.setPawn7((Pawn)board[i][j].getPiece());
							}else if(j == 7){
								white.setPawn8((Pawn)board[i][j].getPiece());
							}
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
	 * Initializes Chessboard
	 */
	public static void main(String[] args){
			white = new Player("White");
			black = new Player("Black");
			
			populateBoard();
			printBoard();
			
			/*Initializes Maps for FileRank Conversion to Array Indices 
			 * Use when translating input to actual board location 
			 * e.g a7 a5 == [1][0] [3][0]
			 */
			Fmap.put("a", 0);
			Fmap.put("b", 1);
			Fmap.put("c", 2);
			Fmap.put("d", 3);
			Fmap.put("e", 4);
			Fmap.put("f", 5);
			Fmap.put("g", 6);
			Fmap.put("h", 7);
			Rmap.put("1", 7);
			Rmap.put("2", 6);
			Rmap.put("3", 5);
			Rmap.put("4", 4);
			Rmap.put("5", 3);
			Rmap.put("6", 2);
			Rmap.put("7", 1);
			Rmap.put("8", 0);
			
			Game game = new Game(board, black, white, Fmap, Rmap);
			game.Start();
	}
}