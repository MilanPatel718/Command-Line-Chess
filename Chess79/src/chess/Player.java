package chess;

import Piece.*;
/**
 * The Player class keeps track of all of the player's game pieces and color.
 * 
 * @author Milan Patel
 * @author Baljit Kaur
 */
public class Player {
	private String color; //the shade of the player's game pieces
	
	private King king;
	private Queen queen;
	
	private Bishop bishop1;
	private Bishop bishop2;
	
	private Knight knight1;
	private Knight knight2;
	
	private Rook rook1;
	private Rook rook2;
	
	private Pawn pawn1;
	private Pawn pawn2;
	private Pawn pawn3;
	private Pawn pawn4;
	private Pawn pawn5;
	private Pawn pawn6;
	private Pawn pawn7;
	private Pawn pawn8;
	
	//Since Promotion changes pawn to one of four pieces, the following list all possibilities so that check/checkmate can be implemented more easily
	public Queen QPromote1;
	public Queen QPromote2;
	public Queen QPromote3;
	public Queen QPromote4;
	public Queen QPromote5;
	public Queen QPromote6;
	public Queen QPromote7;
	public Queen QPromote8;
	
	public Bishop BPromote1;
	public Bishop BPromote2;
	public Bishop BPromote3;
	public Bishop BPromote4;
	public Bishop BPromote5;
	public Bishop BPromote6;
	public Bishop BPromote7;
	public Bishop BPromote8;
	
	public Knight KPromote1;
	public Knight KPromote2;
	public Knight KPromote3;
	public Knight KPromote4;
	public Knight KPromote5;
	public Knight KPromote6;
	public Knight KPromote7;
	public Knight KPromote8;
	
	public Rook RPromote1;
	public Rook RPromote2;
	public Rook RPromote3;
	public Rook RPromote4;
	public Rook RPromote5;
	public Rook RPromote6;
	public Rook RPromote7;
	public Rook RPromote8;
	
	
	
	
	/**
	 * Initializes a Player object.
	 * @param color This is the color assigned to the player and his pieces.
	 */
	public Player(String color){
		this.color = color;
	}
	
	/**
	 * Returns the color of the player's pieces.
	 * @return color This returns the color of the player's pieces.
	 */
	public String getColor(){
		return color;
	}
	
	/**
	 * Returns the player's King object.
	 * @return king The player's King.
	 */
	public King getKing(){
		return king;
	}
	
	/**
	 * Returns the player's Queen object.
	 * @return queen The player's Queen.
	 */
	public Queen getQueen(){
		return queen;
	}
	
	/**
	 * Returns the player's first Knight object.
	 * @return knight1 The player's first Knight.
	 */
	public Knight getKnight1(){
		return knight1;
	}
	
	/**
	 * Returns the player's second Knight object.
	 * @return knight2 The player's second Knight.
	 */
	public Knight getKnight2(){
		return knight2;
	}
	
	/**
	 * Returns the player's first Bishop object.
	 * @return bishop1 The player's first Bishop.
	 */
	public Bishop getBishop1(){
		return bishop1;
	}
	
	/**
	 * Returns the player's second Bishop object.
	 * @return bishop2 The player's second Bishop.
	 */
	public Bishop getBishop2(){
		return bishop2;
	}
	
	/**
	 * Returns the player's first Rook object.
	 * @return rook1 The player's first Rook.
	 */
	public Rook getRook1(){
		return rook1;
	} 
	
	/**
	 * Returns the player's second Rook object.
	 * @return rook2 The player's second Rook.
	 */
	public Rook getRook2(){
		return rook2;
	}
	
	/**
	 * Returns the player's first Pawn object.
	 * @return pawn1 The player's first Pawn.
	 */
	public Pawn getPawn1(){
		return pawn1;
	}
	
	/**
	 * Returns the player's second Pawn object.
	 * @return pawn2 The player's second Pawn.
	 */
	public Pawn getPawn2(){
		return pawn2;
	}
	
	/**
	 * Returns the player's third Pawn object.
	 * @return pawn3 The player's third Pawn.
	 */
	public Pawn getPawn3(){
		return pawn3;
	}
	
	/**
	 * Returns the player's fourth Pawn object.
	 * @return pawn4 The player's fourth Pawn.
	 */
	public Pawn getPawn4(){
		return pawn4;
	}
	
	/**
	 * Returns the player's fifth Pawn object.
	 * @return pawn5 The player's fifth Pawn.
	 */
	public Pawn getPawn5(){
		return pawn5;
	}
	
	/**
	 * Returns the player's sixth Pawn object.
	 * @return pawn6 The player's sixth Pawn.
	 */
	public Pawn getPawn6(){
		return pawn6;
	}
	
	/**
	 * Returns the player's seventh Pawn object.
	 * @return pawn7 The player's seventh Pawn.
	 */
	public Pawn getPawn7(){
		return pawn7;
	}
	
	/**
	 * Returns the player's eight Pawn object.
	 * @return pawn8 The player's eight Pawn.
	 */
	public Pawn getPawn8(){
		return pawn8;
	}
	
	/**
	 * Sets the player's king field to parameter k
	 * @param k This is a King object
	 */
	public void setKing(King k){
		king = k;
	}
	
	/**
	 * Sets the player's queen field to parameter q
	 * @param q This is a Queen object
	 */
	public void setQueen(Queen q){
		queen = q;
	}
	
	/**
	 * Sets the player's knight1 field to parameter k
	 * @param k This is a Knight object
	 */
	public void setKnight1(Knight k){
		knight1 = k;
	}
	
	/**
	 * Sets the player's knight2 field to parameter k
	 * @param k This is a Knight object
	 */
	public void setKnight2(Knight k){
		knight2 = k;
	}
	
	/**
	 * Sets the player's bishop1 field to parameter b
	 * @param b This is a Bishop object
	 */
	public void setBishop1(Bishop b){
		bishop1 = b;
	}
	
	/**
	 * Sets the player's bishop2 field to parameter b
	 * @param b This is a Bishop object
	 */
	public void setBishop2(Bishop b){
		bishop2 = b;
	}
	
	/**
	 * Sets the player's rook1 field to parameter r
	 * @param b This is a Rook object
	 */
	public void setRook1(Rook r){
		rook1 = r;
	} 
	
	/**
	 * Sets the player's rook2 field to parameter r
	 * @param b This is a Rook object
	 */
	public void setRook2(Rook r){
		rook2 = r;
	}
	
	/**
	 * Sets the player's pawn1 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn1(Pawn p){
		pawn1 = p;
	}
	
	/**
	 * Sets the player's pawn2 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn2(Pawn p){
		pawn2 = p;
	}
	
	/**
	 * Sets the player's pawn3 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn3(Pawn p){
		pawn3 = p;
	}
	
	/**
	 * Sets the player's pawn4 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn4(Pawn p){
		pawn4 = p;
	}
	
	/**
	 * Sets the player's pawn5 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn5(Pawn p){
		pawn5 = p;
	}
	
	/**
	 * Sets the player's pawn6 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn6(Pawn p){
		pawn6 = p;
	}
	
	/**
	 * Sets the player's pawn7 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn7(Pawn p){
		pawn7 = p;
	}
	
	/**
	 * Sets the player's pawn8 field to parameter p
	 * @param p This is a Pawn object
	 */
	public void setPawn8(Pawn p){
		pawn8 = p;
	}
}

