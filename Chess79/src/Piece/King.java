package Piece;

import chess.Block;
import chess.Player;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class King extends Piece {
	private boolean hasMoved;
	private boolean hasCastled;
	
	/**
	 * Initializes a King object
	 * 
	 * @param name
	 * Name used to identify a King
	 * @param block
	 * The block where the King is initially placed
	 * @param color
	 * Color of the piece
	 */
	public King(String name, Block block, String color, Player player){
		super(name, block, color, player);
		hasMoved = false;
		hasCastled = false;
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Bishop is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a King will be moved to if the move is valid.
	 */
	public boolean move(Block moveTo){
		int srcFile  = this.getBlock().getFile();
		int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
		int destFile = moveTo.getFile();
		int destRank = chess.Chess.Rmap.get(moveTo.getRank()+""); 
		
		//If the King moves one square in any direction, the move is valid
		if(((Math.abs(srcRank - destRank) == 1) && (Math.abs(srcFile - destFile) == 1)) ||
				((Math.abs(srcRank - destRank) == 1) && (Math.abs(srcFile - destFile) == 0)) ||
				((Math.abs(srcRank - destRank) == 0) && (Math.abs(srcFile - destFile) == 1))){
			if(moveTo.isOccupied()){
				if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
					//Call deletePiece to indicate that target piece has been captured
					chess.Chess.board[destRank][destFile].getPiece().deletePiece(
							chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
							chess.Chess.board[destRank][destFile].getPiece());
					
					chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
					
					if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
						chess.Chess.board[destRank][destFile].setDisplay("wK ");
					else
						chess.Chess.board[destRank][destFile].setDisplay("bK ");
						
					
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
					hasMoved = true;
					return true;
				}
				else{
					System.out.println("Invalid move, try again");
					return false;
				}
			}else{
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wK ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bK ");
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
				hasMoved = true;
				return true;
			}
		}else if((hasMoved == false) && (hasCastled == false)){
			//castling implementation here
		}else{
			System.out.println("Invalid move, try again");
			return false;
		}
		return false; //
	}
	
	public boolean getHasMoved(){
		return hasMoved;
	}
}

