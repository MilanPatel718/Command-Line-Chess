package Piece;

import chess.Block;

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
	public Bishop(String name, Block block, String color){
		super(name, block, color);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Bishop is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Bishop will be moved to if the move is valid
	 */
	public boolean move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return false;
		}
		if(Math.abs(getBlock().getRank() - moveTo.getRank()) == 
				Math.abs(getBlock().getFile() - moveTo.getFile())){
			setBlock(moveTo);
			return true;
		}else{
			//output to board 
			System.out.println("Illegal move, try again!");
			return false;
		}
	}
}
