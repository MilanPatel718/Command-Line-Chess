package chess;

import Piece.Piece;

public class Block {
	private int rank;
	private int file;
	private boolean shaded;
	private boolean occupied;
	private Piece piece;
	private String display;
	
	//Block for 8x8 Board
	public Block(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	
	//Display Block (a:h, 8:1)
	public Block(String display){
		this.display=display;
	}
	
	public int getRank(){
		return rank;
	}
	
	public int getFile(){
		return file;
	}
	
	
	public void setOccupied(boolean b){
		occupied = b;
	}
	
	public boolean isOccupied(){
		return occupied;
	}
	
	public void setPiece(Piece p){
		piece = p;
	}
	
	public Piece getPiece(){
		return piece;
	}

	public boolean isShaded() {
		return shaded;
	}

	public void setShaded(boolean shaded) {
		this.shaded = shaded;
	}

	public String getDisplay() {
		return display;
	}

	public void setDisplay(String display) {
		this.display = display;
	}
}
