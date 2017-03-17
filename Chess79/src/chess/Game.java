package chess;

public class Game {
	Block board[][];
	Player black;
	Player white;
	boolean resign;
	boolean checkmate;
	boolean stalemate;
	
	public Game(Block board[][], Player black, Player white){
		this.board = board;
		this.black = black;
		this.white = white;
		resign = false;
		checkmate = false;
		stalemate = false;
		
		while(resign != true || checkmate != true || stalemate != true){
			//ask players for input
		}
	}
	
	public void makeMove(Block current, Block dest){
		if(!dest.isOccupied()){
			current.getPiece().move(dest);
		}
	}
}
