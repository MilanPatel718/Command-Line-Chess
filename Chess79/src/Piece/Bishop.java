package Piece;

import chess.Block;

public class Bishop extends Piece{
<<<<<<< HEAD:Chess79/src/Piece/Bishop.java
	public Bishop(String name, Block block, String color){
		super(name, block, color);
=======
	/**
	 * Initializes a Bishop object
	 * 
	 * @param name
	 * Name used to identify a Bishop
	 * @param block
	 * The block where the Bishop is initially placed
	 */
	public Bishop(String name, Block block){
		super(name, block);
>>>>>>> 7098b25cc7795434eb8a89738c4946558c949155:Chess79/src/chess/Bishop.java
	}
	
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if(Math.abs(getBlock().getRank() - moveTo.getRank()) == 
				Math.abs(getBlock().getFile() - moveTo.getFile())){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}
