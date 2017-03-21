package Piece;
import chess.Block;
import chess.Player;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public abstract class Piece {
	private String name;
	private Block block;
	private String color;
	private Player player;
	private int number;
	private boolean hasMoved;
	
	/**
	 * @param name
	 * Name used to identify a piece
	 * @param block
	 * The block the piece is initially placed on
	 * @param color
	 * Color of the block the piece is placed on
	 */
	public Piece(String name, Block block, String color, Player player){
		this.name = name;
		this.block = block;
		this.setColor(color);
		this.setPlayer(player);
		this.hasMoved = false;
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
	 * @param check
	 * @param move
	 * The block a piece is being move to
	 */
	public abstract boolean move(Block moveTo, boolean check, String move);

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

	/**
	 * @return player
	 * Returns the Player assigned to Piece
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * @param player
	 * Sets the player assigned to Piece
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return number
	 * Returns the Number Assigned to a piece
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * @param number
	 * Sets the number to assign to a piece
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @param num
	 * @param P
	 * Sets Player Piece to Null when that piece is captured by enemy player
	 */
	public void deletePiece(int num, Piece P){
		String Name=P.getName();
		if((Name.equals("wP ") || Name.equals("bP "))){
			if(num==1){
				P.player.setPawn1(null);
			}
			else if(num==2){
				P.player.setPawn2(null);
			}
			else if(num==3){
				P.player.setPawn3(null);
			}
			else if(num==4){
				P.player.setPawn4(null);
			}
			else if(num==5){
				P.player.setPawn5(null);
			}
			else if(num==6){
				P.player.setPawn6(null);
			}
			else if(num==7){
				P.player.setPawn7(null);
			}
			else{
				P.player.setPawn8(null);
			}
		}
		else if((Name.equals("wR ")) || Name.equals("bR ")){
			if(num==1){
				P.player.setRook1(null);
				
			}
			else{
				P.player.setRook2(null);
			}
			
		}
		else if(((Name.equals("wB ")) || Name.equals("bB "))){
			if(num==1){
				P.player.setBishop1(null);
			}
			else{
				P.player.setBishop2(null);
			}
			
		}
		else if(((Name.equals("wN ")) || Name.equals("bN "))){
			if(num==1){
				P.player.setKnight1(null);
			}
			else{
				P.player.setKnight2(null);
			}
		}
		else if(((Name.equals("wQ ")) || Name.equals("bQ "))){
				P.player.setQueen(null);
			
		}
		else if(((Name.equals("wK ")) || Name.equals("bK "))){
				P.player.setKing(null);
		}
	}
	
	public void setHasMoved(boolean b){
		hasMoved = b;
	}
	
	public boolean getHasMoved(){
		return hasMoved;
	}
	
	public boolean isInCheck(){
		return false;
	}
}
