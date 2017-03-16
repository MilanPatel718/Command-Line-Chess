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
	 * @param block
	 * @param color
	 */
	public Piece(String name, Block block, String color){
		this.name = name;
		this.block = block;
		this.setColor(color);
	}
	
	/**
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * @return block
	 */
	public Block getBlock(){
		return block;
	}
	
	/**
	 * @param b
	 */
	public void setBlock(Block b){
		block = b;
	}
	
	/**
	 * @param moveTo
	 */
	public abstract void move(Block moveTo);

	/**
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}
}
