package chess;

import Piece.Piece;

/**
 * @author Milan Patel
 * @author Baljit Kaur
 *
 */
public class Block {
	private int rank;
	private int file;
	private boolean shaded;
	private boolean occupied;
	private Piece piece;
	private String display;
	
	
	/**
	 * Block Constructor for game board
	 * @param rank
	 * @param file
	 */
	public Block(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	
	/**
	 * Block Constructor for outer label blocks (a:h, 8:1)
	 * @param display
	 */
	public Block(String display){
		this.display=display;
	}
	
	/**
	 * Getter Method for Rank
	 * @return int
	 */
	public int getRank(){
		return rank;
	}
	
	/**
	 * Getter Method for File
	 * @return int
	 */
	public int getFile(){
		return file;
	}
	
	
	/**
	 * Setter Method for Occupied Block
	 * @param b
	 */
	public void setOccupied(boolean b){
		occupied = b;
	}
	
	/**
	 * Getter Method for Occupied Block
	 * @return occupied
	 */
	public boolean isOccupied(){
		return occupied;
	}
	
	/**
	 * Setter Method for Piece
	 * @param p
	 */
	public void setPiece(Piece p){
		piece = p;
	}
	
	/**
	 * Getter Method for Piece
	 * @return piece
	 */
	public Piece getPiece(){
		return piece;
	}

	/**
	 * @return shaded
	 */
	public boolean isShaded() {
		return shaded;
	}

	/**
	 * @param shaded
	 */
	public void setShaded(boolean shaded) {
		this.shaded = shaded;
	}

	/**
	 * @return display
	 */
	public String getDisplay() {
		return display;
	}

	/**
	 * @param display
	 */
	public void setDisplay(String display) {
		this.display = display;
	}
}
