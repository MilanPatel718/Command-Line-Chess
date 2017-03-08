package Piece;

import chess.Block;

public class Rook extends Piece{
<<<<<<< HEAD:Chess79/src/Piece/Rook.java
	public Rook(String name, Block block, String color){
		super(name, block, color);
=======
	/**
	 * Initializes a Bishop object
	 * 
	 * @param name
	 * Name used to identify a Rook
	 * @param block
	 * The block where the Rook is initially placed
	 */
	public Rook(String name, Block block){
		super(name, block);
>>>>>>> 7098b25cc7795434eb8a89738c4946558c949155:Chess79/src/chess/Rook.java
	}
	
	/**
	 * @param moveTo
	 * The potential destination block of a Rook
	 */
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if(((getBlock().getRank() == moveTo.getRank()) && (getBlock().getFile() != moveTo.getFile())
				|| ((getBlock().getFile() == moveTo.getFile()) && (getBlock().getRank() != moveTo.getRank())))){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}
