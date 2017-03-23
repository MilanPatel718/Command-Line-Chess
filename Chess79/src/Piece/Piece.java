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
	 * Specifies the name, block, color and player of the Piece.
	 * @param name Name used to identify a piece
	 * @param block The block the piece is initially placed on
	 * @param color Color of the block the piece is placed on
	 * @param player The player who owns the piece.
	 */
	public Piece(String name, Block block, String color, Player player){
		this.name = name;
		this.block = block;
		this.setColor(color);
		this.setPlayer(player);
		this.hasMoved = false;
	}
	
	/**
	 * Returns the name of the piece.
	 * @return name The name of the piece
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Returns the block the piece is currently placed on
	 * @return block The block a piece is on.
	 */
	public Block getBlock(){
		return block;
	}
	
	/**
	 * Sets the block a piece is placed on.
	 * @param the block
	 */
	public void setBlock(Block b){
		block = b;
	}
	
	/**
	 * The block a piece is being moved to
	 * @param moveTo The block the piece is being moved to
	 * @param check If the move is being executed or only checked whether it results in a check.
	 * @param move Used for pawn promotion
	 */
	public abstract boolean move(Block moveTo, boolean check, String move);

	/**
	 * Returns the color of the block the piece is placed on
	 * @return color The color of piece.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Updates the color of the block the piece is placed on
	 * @param color The color of the block
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Returns the Player assigned to Piece
	 * @return player The player the piece belongs to
	 */
	public Player getPlayer() {
		return player;
	}

	/**
	 * Sets the player assigned to Piece
	 * @param player The player a piece belongs to
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * Returns the Number Assigned to a piece
	 * @return number The number of the piece
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Sets the number to assign to a piece
	 * @param number the number of the piece
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * Sets Player Piece to Null when that piece is captured by enemy player
	 * @param num the number of the piece
	 * @param P the piece that is already in the game
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
	
	/**
	 * Sets whether the piece has been moved.
	 * @param b Boolean b
	 */
	public void setHasMoved(boolean b){
		hasMoved = b;
	}
	
	/**
	 * Returns whether the piece has been moved or not.
	 * @return Boolean hasMoved
	 */
	public boolean getHasMoved(){
		return hasMoved;
	}
	
	/**
	 * Returns whether the piece is in check.
	 * @return false
	 */
	public boolean isInCheck(){
		return false;
	}
}
