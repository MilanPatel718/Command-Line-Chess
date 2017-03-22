package chess;

import Piece.*;
/**
 * @author Milan Patel
 * @author Baljit Kaur
 */
public class Player {
	private String color;
	
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
	
	
	
	
	
	public Player(String color){
		this.color = color;
	}
	
	public String getColor(){
		return color;
	}
	
	public King getKing(){
		return king;
	}
	
	public Queen getQueen(){
		return queen;
	}
	
	public Knight getKnight1(){
		return knight1;
	}
	
	public Knight getKnight2(){
		return knight2;
	}
	
	public Bishop getBishop1(){
		return bishop1;
	}
	
	public Bishop getBishop2(){
		return bishop2;
	}
	
	public Rook getRook1(){
		return rook1;
	} 
	
	public Rook getRook2(){
		return rook2;
	}
	
	public Pawn getPawn1(){
		return pawn1;
	}
	
	public Pawn getPawn2(){
		return pawn2;
	}
	
	public Pawn getPawn3(){
		return pawn3;
	}
	
	public Pawn getPawn4(){
		return pawn4;
	}
	
	public Pawn getPawn5(){
		return pawn5;
	}
	
	public Pawn getPawn6(){
		return pawn6;
	}
	
	public Pawn getPawn7(){
		return pawn7;
	}
	
	public Pawn getPawn8(){
		return pawn8;
	}
	
	public void setKing(King k){
		king = k;
	}
	
	public void setQueen(Queen q){
		queen = q;
	}
	
	public void setKnight1(Knight k){
		knight1 = k;
	}
	
	public void setKnight2(Knight k){
		knight2 = k;
	}
	
	public void setBishop1(Bishop b){
		bishop1 = b;
	}
	
	public void setBishop2(Bishop b){
		bishop2 = b;
	}
	
	public void setRook1(Rook r){
		rook1 = r;
	} 
	
	public void setRook2(Rook r){
		rook2 = r;
	}
	
	public void setPawn1(Pawn p){
		pawn1 = p;
	}
	
	public void setPawn2(Pawn p){
		pawn2 = p;
	}
	
	public void setPawn3(Pawn p){
		pawn3 = p;
	}
	
	public void setPawn4(Pawn p){
		pawn4 = p;
	}
	
	public void setPawn5(Pawn p){
		pawn5 = p;
	}
	
	public void setPawn6(Pawn p){
		pawn6 = p;
	}
	
	public void setPawn7(Pawn p){
		pawn7 = p;
	}
	
	public void setPawn8(Pawn p){
		pawn8 = p;
	}
}

