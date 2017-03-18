package Piece;

import chess.Block;
import chess.Player;

/**
 * @author Baljit Kaur
 * @author MIlan Patel
 */
public class Rook extends Piece{
	/**
	 * Initializes a Bishop object
	 * 
	 * @param name
	 * Name used to identify a Rook
	 * @param block
	 * The block where the Rook is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Rook(String name, Block block, String color, Player player){
		super(name, block, color, player);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Rook is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Rook will be moved to if the move is valid
	 */
	public boolean move(Block moveTo){
		//Translate File and Rank to array indices
				int srcFile  = this.getBlock().getFile();
				int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
				int destFile = moveTo.getFile();
				int destRank = chess.Chess.Rmap.get(moveTo.getRank()+""); 
				
				//Vertical Movement
				if((srcFile==destFile) && (srcRank!=destRank)){
					
					
					//This means the Rook is moving in the upwards direction
					if(destRank<srcRank){ 
						//Loop through every space between source and destination, excluding source and destination
						for(int i=srcRank-1; i>destRank; i--){
							if(chess.Chess.board[i][srcFile].isOccupied()){
								System.out.println("Invalid move, try again");
								return false;
							}
							else{}
						}
						//Rook Captures Destination
						if(moveTo.isOccupied()){
							//Call deletePiece to indicate that the piece has been captured
							chess.Chess.board[destRank][destFile].getPiece().deletePiece(chess.Chess.board[destRank][destFile].getPiece().getNumber(), chess.Chess.board[destRank][destFile].getPiece());
							
							chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
							
							if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
								chess.Chess.board[destRank][destFile].setDisplay("wR ");
							else
								chess.Chess.board[destRank][destFile].setDisplay("bR ");
								
							
							this.getBlock().setOccupied(false);
							this.getBlock().setPiece(null);
							
							if(this.getBlock().isShaded()){
								this.getBlock().setDisplay("## ");
							}
							else{
								this.getBlock().setDisplay("   ");
							}
							this.setBlock(moveTo);
							chess.Chess.printBoard();
							return true;
						}
						//Normal Move
						else{
							chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
							if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
								chess.Chess.board[destRank][destFile].setDisplay("wR ");
							else
								chess.Chess.board[destRank][destFile].setDisplay("bR ");
							chess.Chess.board[destRank][destFile].setOccupied(true);
							
							this.getBlock().setOccupied(false);
							this.getBlock().setPiece(null);
							
							if(this.getBlock().isShaded()){
								this.getBlock().setDisplay("## ");
							}
							else{
								this.getBlock().setDisplay("   ");
							}
							this.setBlock(moveTo);
							chess.Chess.printBoard();
							return true;
							
						}
					}
				}
				//Horizontal Movement
				else if((srcFile!=destFile) && (srcRank==destRank)){
					
				}
				//Invalid Move
				else{
					
				}
				
		
		return false;
	}
}
