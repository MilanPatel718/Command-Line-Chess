package chess;

public class Block {
	private int rank;
	private int file;
	private String color;
	private boolean occupied;
	private Piece piece;
	
	public Block(int rank, int file, String color){
		this.rank = rank;
		this.file = file;
		this.color = color;
	}
	
	public int getRank(){
		return rank;
	}
	
	public int getFile(){
		return file;
	}
	
	public String getColor(){
		return color;
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
}
