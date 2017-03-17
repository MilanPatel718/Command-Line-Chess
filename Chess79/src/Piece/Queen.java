package Piece;

import chess.Block;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class Queen extends Piece{
	/**
	 * Initializes a Queen object
	 * 
	 * @param name
	 * Name used to identify a Queen
	 * @param block
	 * The block where the Queen is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Queen(String name, Block block, String color){
		super(name, block, color);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Queen is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Queen will be moved to if the move is valid
	 */
	public boolean move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return false;
		}
		if((((getBlock().getRank() == moveTo.getRank()) && (getBlock().getFile() != moveTo.getFile())
				|| ((getBlock().getFile() == moveTo.getFile()) && (getBlock().getRank() != moveTo.getRank()))))
				|| (Math.abs(getBlock().getRank() - moveTo.getRank()) == 
						Math.abs(getBlock().getFile() - moveTo.getFile()))){
			setBlock(moveTo);
			return true;
		}else{
			//output to board 
			System.out.println("Illegal move, try again!");
			return false;
		}
	}
}
