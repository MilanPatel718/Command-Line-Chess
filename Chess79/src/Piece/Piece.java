package Piece;
import chess.Block;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public abstract class Piece {
	private String name;
	private Block block;
	private String color;
	
	/**
	 * @param name
	 * Name used to identify a piece
	 * @param block
	 * The block the piece is initially placed on
	 * @param color
	 * Color of the block the piece is placed on
	 */
	public Piece(String name, Block block, String color){
		this.name = name;
		this.block = block;
		this.setColor(color);
	}
	
	/**
	 * @return name
	 * Returns the name of the piece
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return block
	 * Returns the block the piece is currently placed on
	 */
	public Block getBlock(){
		return block;
	}
	
	/**
	 * @param b
	 * Updates the housing block of a piece
	 */
	public void setBlock(Block b){
		block = b;
	}
	
	/**
	 * @param moveTo
	 * The block a piece is being move to
	 */
	public abstract boolean move(Block moveTo);

	/**
	 * @return color
	 * Returns the color of the block the piece is placed on
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 * Updates the color of the block the piece is placed on
	 */
	public void setColor(String color) {
		this.color = color;
	}
}
