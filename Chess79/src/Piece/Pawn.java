package Piece;
import chess.Block;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class Pawn extends Piece{
	/**
	 * Initializes a Pawn object
	 * 
	 * @param name
	 * Name used to identify a Pawn
	 * @param block
	 * The block where the Pawn is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Pawn(String name, Block block, String color){
		super(name, block, color);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Pawn is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Pawn will be moved to if the move is valid
	 */
	public boolean move(Block moveTo){
		
		int srcFile  = this.getBlock().getFile();
		int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
		int destFile = moveTo.getFile();
		int destRank = chess.Chess.Rmap.get(moveTo.getRank()+""); 
		
		if(getName().charAt(0) == 'w'){
			if(moveTo.isOccupied()){
			   if((destRank == srcRank - 1)
						&& ((destFile== srcFile - 1) || (destFile == srcFile + 1))){
					if(moveTo.getPiece().getName().charAt(0) != getName().charAt(0)){
						//capture opponent's piece
						//send message to remove
						chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
						getBlock().setOccupied(false);
						getBlock().setPiece(null);
						chess.Chess.printBoard();
						return true;
						
						
					}else{
						System.out.println("Invalid move!");
						return false;
					}
				}
				
			  else if(destRank == srcRank - 1)
						/*|| ((moveTo.getRank() == getBlock().getRank() + 2) &&
								(moveTo.getRank() - 1  )))*/{
				
				 System.out.println("Invalid move: Block is occupied");
				return false;
			  }
			 
			  else if(srcRank==6 && destRank==srcRank-2){
				  System.out.println("Invalid move: Block is occupied");
				  return false;
			  }
			 
			  else{
				  System.out.println("Invalid move!");
				  return false;
			  }
			  
	}
		
		//Destination is not occupied	
		else{
			if(destRank == srcRank -1){
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				chess.Chess.board[destRank][destFile].setDisplay("wp ");
				getBlock().setOccupied(false);
				getBlock().setPiece(null);
				if(getBlock().isShaded()){
					getBlock().setDisplay("## ");
				}
				else{
					getBlock().setDisplay("   ");
				}
				chess.Chess.printBoard();
				return true;
			}
			
			else if(srcRank==6 && destRank == srcRank-2){
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				chess.Chess.board[destRank][destFile].setDisplay("wp ");
				getBlock().setOccupied(false);
				getBlock().setPiece(null);
				if(getBlock().isShaded()){
					getBlock().setDisplay("## ");
				}
				else{
					getBlock().setDisplay("   ");
				}
				chess.Chess.printBoard();
				return true;
			}
			else{
				System.out.println("Invalid Move!");
				return false;
			}
			
		}
			
			
		}
		
		else if(getName().charAt(0) == 'b'){
			if(moveTo.isOccupied()){
				if((moveTo.getRank() == getBlock().getRank() - 1)
						&& (moveTo.getFile() == getBlock().getFile() - 1)){
					if(moveTo.getPiece().getName().charAt(0) != getName().charAt(0)){
						//capture opponent's piece
						//send message to remove
					}
				}
				System.out.println("Invalid move: Block is occupied");
				return false;
			}
		}
		return false;
	}
}
