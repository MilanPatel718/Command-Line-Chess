package Piece;

import chess.Block;
import chess.Player;

/**
 * @author Baljit Kaur
 * @author MIlan Patel
 */
public class Rook extends Piece{
	/**
	 * Initializes a Bishop object
	 * 
	 * @param name
	 * Name used to identify a Rook
	 * @param block
	 * The block where the Rook is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Rook(String name, Block block, String color, Player player){
		super(name, block, color, player);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Rook is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Rook will be moved to if the move is valid
	 */
	public boolean move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return false;
		}
		if(((getBlock().getRank() == moveTo.getRank()) && (getBlock().getFile() != moveTo.getFile())
				|| ((getBlock().getFile() == moveTo.getFile()) && (getBlock().getRank() != moveTo.getRank())))){
			setBlock(moveTo);
			return true;
		}else{
			//output to board 
			System.out.println("Illegal move, try again!"); 
			return false;
		}
	}
}
