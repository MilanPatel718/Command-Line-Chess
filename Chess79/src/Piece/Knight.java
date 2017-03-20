package Piece;

import chess.Block;
import chess.Player;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class Knight extends Piece{
	/**
	 * Initializes a Knight object
	 * 
	 * @param name
	 * Name used to identify a Knight
	 * @param block
	 * The block where the Knight is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Knight(String name, Block block, String color, Player player){
		super(name, block, color, player);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Knight is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Knight will be moved to if the move is valid
	 */
	public boolean move(Block moveTo, boolean check, String move){
		//Translate File and Rank to array indices
				int srcFile  = this.getBlock().getFile();
				int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
				int destFile = moveTo.getFile();
				int destRank = chess.Chess.Rmap.get(moveTo.getRank()+""); 
				
				if(((Math.abs(srcRank-destRank)==1 && Math.abs(srcFile-destFile)==2) || (Math.abs(srcRank-destRank)==2 && Math.abs(srcFile-destFile)==1))){
					if(moveTo.isOccupied()){
						if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==true){
							if(check == true){
								return false;
							}
							System.out.println("Invalid move, try again");
							return false;
						}
						
						//A check to see if this move puts the opponent's King in check
						if(check == true){
							return true;
						}
						
						//Call deletePiece to indicate that target piece has been captured
						chess.Chess.board[destRank][destFile].getPiece().deletePiece(chess.Chess.board[destRank][destFile].getPiece().getNumber(), chess.Chess.board[destRank][destFile].getPiece());
						
						chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
						
						if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
							chess.Chess.board[destRank][destFile].setDisplay("wN ");
						else
							chess.Chess.board[destRank][destFile].setDisplay("bN ");
							
						
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
					
					else{
						//A check to see if this move puts the opponent's King in check
						if(check == true){
							return true;
						}
						
						chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
						if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
							chess.Chess.board[destRank][destFile].setDisplay("wN ");
						else
							chess.Chess.board[destRank][destFile].setDisplay("bN ");
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
				else{
					if(check == true){
						return false;
					}
					System.out.println("Invalid move, try again");
					return false;
				}
						
	}
}
