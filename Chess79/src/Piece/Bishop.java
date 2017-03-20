package Piece;

import chess.Block;
import chess.Player;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class Bishop extends Piece{
	/**
	 * Initializes a Bishop object
	 * 
	 * @param name
	 * Name used to identify a Bishop
	 * @param block
	 * The block where the Bishop is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Bishop(String name, Block block, String color, Player player){
		super(name, block, color, player);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Bishop is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Bishop will be moved to if the move is valid
	 */
	public boolean move(Block moveTo, boolean check, String move){
		//Translate File and Rank to array indices
		int srcFile  = this.getBlock().getFile();
		int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
		int destFile = moveTo.getFile();
		int destRank = chess.Chess.Rmap.get(moveTo.getRank()+"");
		
		if(Math.abs(srcRank - destRank) == Math.abs(srcFile - destFile)){
			if(srcRank > destRank){
				if(srcFile < destFile){
					for(int i = 1; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank - i][srcFile + i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				}else if(srcFile > destFile){
					for(int i = 1; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank - i][srcFile - i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}	
				}
			}else if(srcRank < destRank){
				if(srcFile < destFile){
					for(int i = 1; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank + i][srcFile + i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				}else if(srcFile > destFile){
					for(int i = 1; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank + i][srcFile - i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				}
			}
			
			if(moveTo.isOccupied()){
				if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
					//A check to see if this move puts the opponent's King in check
					if(check == true){
						return true;
					}
					//Call deletePiece to indicate that target piece has been captured
					chess.Chess.board[destRank][destFile].getPiece().deletePiece(
							chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
							chess.Chess.board[destRank][destFile].getPiece());
					
					chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
					
					if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
						chess.Chess.board[destRank][destFile].setDisplay("wB ");
					else
						chess.Chess.board[destRank][destFile].setDisplay("bB ");
						
					
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
					System.out.println("Invalid move, try again");
					return false;
				}
			}
			
			//Normal Move
			else{
				//A check to see if this move puts the opponent's King in check
				if(check == true){
					return true;
				}
				
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wB ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bB ");
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
		}else{
			System.out.println("Invalid move, try again");
			return false;
		}
	}
}
