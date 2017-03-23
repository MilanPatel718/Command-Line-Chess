package chess;

import Piece.Piece;

/**
 * The Block application models a Chess Board block.
 * @author Milan Patel
 * @author Baljit Kaur
 */
public class Block {
	private int rank;
	private int file;
	private boolean shaded;
	private boolean occupied;
	private Piece piece;
	private String display;
	
	
	/**
	 * Initializes the block with parameters rank and file.
	 * @param rank The rank of the block.
	 * @param file The file of the block.
	 */
	public Block(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	
	/**
	 * Block Constructor for outer label blocks (a:h, 8:1)
	 * @param display The string displayed when the black is printed.
	 */
	public Block(String display){
		this.display=display;
	}
	
	/**
	 * Getter Method for Rank
	 * @return The rank of the block.
	 */
	public int getRank(){
		return rank;
	}
	
	/**
	 * Getter Method for File
	 * @return The file of the block.
	 */
	public int getFile(){
		return file;
	}
	
	
	/**
	 * Setter Method for Occupied Block
	 * @param True if block is occupied, false if it is not.
	 */
	public void setOccupied(boolean b){
		occupied = b;
	}
	
	/**
	 * Getter Method for Occupied Block
	 * @return True if block is occupied, false if it is not.
	 */
	public boolean isOccupied(){
		return occupied;
	}
	
	/**
	 * Setter Method for Piece
	 * @param The Piece placed on a block.
	 */
	public void setPiece(Piece p){
		piece = p;
	}
	
	/**
	 * Getter Method for Piece
	 * @return The Piece placed on a block.
	 */
	public Piece getPiece(){
		return piece;
	}

	/**
	 * Informs whether the block is shaded or not.
	 * @return True if the block is shaded, False if it not.
	 */
	public boolean isShaded() {
		return shaded;
	}

	/**
	 * Sets the shade of the block.
	 * @param True is block is shaded, False if it is not.
	 */
	public void setShaded(boolean shaded) {
		this.shaded = shaded;
	}

	/**
	 * Returns the string displayed when the board is printed.
	 * @return The content displayed on board.
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * Sets the string displayed when the board is printed.
	 * @param The content displayed on board.
	 */
	public void setDisplay(String display) {
		this.display = display;
	}
}
