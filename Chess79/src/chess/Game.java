package chess;

import java.util.Map;
import java.util.Scanner;

public class Game {
	Block board[][];
	Player blackPlayer;
	Player whitePlayer;
	boolean resign;
	boolean checkmate;
	boolean stalemate;
	int lastTurn; // 0: white went last, 1:black went last
	int srcFile, srcRank, destFile, destRank;
	char sf, sr, df, dr;
	boolean successfulMove;
	Map<String, Integer> fMap;
	Map<String, Integer> rMap;
	
	public Game(Block board[][], Player blackPlayer, Player whitePlayer, 
			Map<String, Integer> fMap, Map<String, Integer> rMap){
		this.board = board;
		this.blackPlayer = blackPlayer;
		this.whitePlayer = whitePlayer;
		resign = false;
		checkmate = false;
		stalemate = false;
		successfulMove = false;
		this.fMap = fMap;
		this.rMap = rMap; 
		sf = '\0'; 
		sr = '\0';
		df = '\0'; 
		dr = '\0';
	}
	
	/**
	* Method that begins an actual instance of a game
	* @param None
	*/
	public void Start(){
		/*
		* prevMove keeps track of the move that came before the current move being evaluated (For Enpassant or other special cases)
		*/
		String prevMove;

		Scanner scanner = new Scanner(System.in);
		
		//ask White player for input
		System.out.print("White's move: ");
		successfulMove =  mapAndExecute(whitePlayer, scanner);
		while(successfulMove != true){
			successfulMove =  mapAndExecute(whitePlayer, scanner);
		}
		lastTurn = 0;
		
		while(resign != true || checkmate != true || stalemate != true){
			if(lastTurn == 0){
				System.out.print("Black's move: ");
				successfulMove =  mapAndExecute(blackPlayer, scanner);
				while(successfulMove != true){
					successfulMove =  mapAndExecute(blackPlayer, scanner);
				}
				lastTurn = 1;
			}else if(lastTurn == 1){
				System.out.print("White's move: ");
				successfulMove =  mapAndExecute(whitePlayer, scanner);
				while(successfulMove != true){
					successfulMove =  mapAndExecute(whitePlayer, scanner);
				}
				lastTurn = 0;
			}
		}
		
	}
	
	public void getInput(Scanner t){
		String src=t.next();
		sf = src.charAt(0);
		sr = src.charAt(1);
		
		String dest=t.next();
		df = dest.charAt(0);
		dr = dest.charAt(1);
	}
	
	public boolean makeMove(Block current, Block dest, Player player){
		if(!dest.isOccupied() && current.getPiece().getColor().equals(player.getColor())){
			return current.getPiece().move(dest);
		}
		return false;
	}
	
	public boolean mapAndExecute(Player player, Scanner scanner){
		getInput(scanner);
		srcFile = fMap.get(sf+"");
		srcRank = rMap.get(sr+"");
		destFile = fMap.get(df+"");
		destRank = rMap.get(dr+"");
		return makeMove(board[srcRank][srcFile], board[destRank][destFile], player);
	}
}