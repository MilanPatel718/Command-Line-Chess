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
	public boolean move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return false;
		}
		if(((Math.abs(getBlock().getRank() - moveTo.getRank()) == 2)
			&& (Math.abs(getBlock().getFile() - moveTo.getFile()) == 1))
			|| ((Math.abs(getBlock().getFile() - moveTo.getFile()) == 2)
					&& (Math.abs(getBlock().getRank() - moveTo.getRank()) == 1))){
			setBlock(moveTo);
			return true;
		}else{
			//output to board 
			System.out.println("Illegal move, try again!");
			return false;
		}
	}
}
