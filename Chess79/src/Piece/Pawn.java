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
	public void move(Block moveTo){
		if(getName().charAt(0) == 'w'){
			if(moveTo.isOccupied()){
				if((moveTo.getRank() == getBlock().getRank() + 1)
						&& (moveTo.getFile() == getBlock().getFile() + 1)){
					if(moveTo.getPiece().getName().charAt(0) != getName().charAt(0)){
						//capture opponent's piece
						//send message to remove
					}else{
						System.out.println("Invalid move!");
					}
				}else if((moveTo.getRank() == getBlock().getRank() + 1))
						/*|| ((moveTo.getRank() == getBlock().getRank() + 2) &&
								(moveTo.getRank() - 1  )))*/{
					
				}
				System.out.println("Invalid move: Block is occupied");
				return;
			}
		}else if(getName().charAt(0) == 'b'){
			if(moveTo.isOccupied()){
				if((moveTo.getRank() == getBlock().getRank() - 1)
						&& (moveTo.getFile() == getBlock().getFile() - 1)){
					if(moveTo.getPiece().getName().charAt(0) != getName().charAt(0)){
						//capture opponent's piece
						//send message to remove
					}
				}
				System.out.println("Invalid move: Block is occupied");
				return;
			}
		}
	}
}
