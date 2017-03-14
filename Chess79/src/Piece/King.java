package Piece;

import chess.Block;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class King extends Piece {
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
	public King(String name, Block block, String color){
		super(name, block, color);
	}
	
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if(((Math.abs(getBlock().getRank() - moveTo.getRank()) == 1)
				&& (Math.abs(getBlock().getFile() - moveTo.getFile()) == 1))
				|| ((Math.abs(getBlock().getRank() - moveTo.getRank()) == 1)
						&& ((getBlock().getFile() - moveTo.getFile()) == 0))
				|| ((Math.abs(getBlock().getRank() - moveTo.getRank()) == 0)
						&& ((getBlock().getFile() - moveTo.getFile()) == 1))){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}

