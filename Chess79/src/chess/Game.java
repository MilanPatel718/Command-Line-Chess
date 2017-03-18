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
		
		Scanner scanner = new Scanner(System.in);
		
		//ask White player for input
		System.out.print("White's move: ");
		String move=scanner.nextLine();
		chess.Chess.prevMove=move;
		successfulMove =  mapAndExecute(whitePlayer, move);
		while(successfulMove != true){
			System.out.print("White's move: ");
			scanner=new Scanner(System.in);
			move=scanner.nextLine();
			successfulMove =  mapAndExecute(whitePlayer, move);
		}

		lastTurn = 0;
		
		while(resign != true || checkmate != true || stalemate != true){
			if(lastTurn == 0){
				scanner=new Scanner(System.in);
				System.out.print("Black's move: ");
				move=scanner.nextLine();
				successfulMove =  mapAndExecute(blackPlayer, move);
				while(successfulMove != true){
					System.out.print("Black's move: ");
					scanner=new Scanner(System.in);
					move=scanner.nextLine();
					successfulMove =  mapAndExecute(blackPlayer, move);
				}
				System.out.println();
				chess.Chess.prevMove=move;
				lastTurn = 1;
			}
			
			else if(lastTurn == 1){
				scanner=new Scanner(System.in);
				System.out.print("White's move: ");
				move=scanner.nextLine();
				successfulMove =  mapAndExecute(whitePlayer, move);
				while(successfulMove != true){
					System.out.print("White's move: ");
					scanner=new Scanner(System.in);
					move=scanner.nextLine();
					successfulMove =  mapAndExecute(whitePlayer, move);
				}
				System.out.println();
				chess.Chess.prevMove=move;
				lastTurn = 0;
			}
		}
		scanner.close();
		
	}
	
	public void getInput(String src){
		sf = src.charAt(0);
		sr = src.charAt(1);
		df = src.charAt(3);
		dr = src.charAt(4);
	}
	
	public boolean makeMove(Block current, Block dest, Player player){
		if(current.getPiece().getColor().equals(player.getColor()))
		return current.getPiece().move(dest);
		
		else{
			System.out.println("Invalid move, try again");
			return false;
		}

		
	}
	
	public boolean mapAndExecute(Player player, String s){
		getInput(s);
		srcFile = fMap.get(sf+"");
		srcRank = rMap.get(sr+"");
		destFile = fMap.get(df+"");
		destRank = rMap.get(dr+"");
		return makeMove(board[srcRank][srcFile], board[destRank][destFile], player);
	}
}