package Piece;

import chess.Block;

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
	public Knight(String name, Block block, String color){
		super(name, block, color);
	}
	
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if(((Math.abs(getBlock().getRank() - moveTo.getRank()) == 2)
			&& (Math.abs(getBlock().getFile() - moveTo.getFile()) == 1))
			|| ((Math.abs(getBlock().getFile() - moveTo.getFile()) == 2)
					&& (Math.abs(getBlock().getRank() - moveTo.getRank()) == 1))){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}
