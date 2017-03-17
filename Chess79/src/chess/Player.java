package chess;

import Piece.*;
/**
 * @author Milan Patel
 * @author Baljit Kaur
 */
public class Player {
	King king;
	Queen queen;
	Bishop bishop1;
	Bishop bishop2;
	Knight knight1;
	Knight knight2;
	Rook rook1;
	Rook rook2;
	Pawn pawn1;
	Pawn pawn2;
	Pawn pawn3;
	Pawn pawn4;
	Pawn pawn5;
	Pawn pawn6;
	Pawn pawn7;
	Pawn pawn8;
	
	public Player(King king, Queen queen, Knight knight1, Knight knight2, Rook rook1, Rook rook2, Bishop bishop1, Bishop bishop2,
			Pawn pawn1, Pawn pawn2, Pawn pawn3, Pawn pawn4, Pawn pawn5, Pawn pawn6, Pawn pawn7, Pawn pawn8){
		this.king = king;
		this.queen = queen;
		this.knight1 = knight1;
		this.knight2 = knight2;
		this.rook1 = rook1;
		this.rook2 = rook2;
		this.bishop1 = bishop1;
		this.bishop2 = bishop2;
		this.pawn1 = pawn1;
		this.pawn2 = pawn2;
		this.pawn3 = pawn3;
		this.pawn4 = pawn4;
		this.pawn5 = pawn5;
		this.pawn6 = pawn6;
		this.pawn7 = pawn7;
		this.pawn8 = pawn8;
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

