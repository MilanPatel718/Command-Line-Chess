package chess;

import java.util.Map;

import java.util.Scanner;
/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class Game {
	Block board[][];
	Player blackPlayer;
	Player whitePlayer;
	boolean resign;
	boolean checkmate;
	boolean stalemate;
	boolean drawPrompt;
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
		drawPrompt=false;
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
		if(move.equals("resign")){
			resign=true;
			System.out.println("Black wins");
		}
		chess.Chess.prevMove=move;
		
		if(resign==false)
		successfulMove =  mapAndExecute(whitePlayer, move);
		else{
			successfulMove=true;
		}
		
		
		while(successfulMove != true){
			System.out.print("White's move: ");
			scanner=new Scanner(System.in);
			move=scanner.nextLine();
			if(move.equals("resign")){
				resign=true;
				System.out.println("Black wins");
				break;
			}
			successfulMove =  mapAndExecute(whitePlayer, move);
		}

		lastTurn = 0;
		
		while(resign != true && checkmate != true && stalemate != true){
			//Black Move
			if(lastTurn == 0){
				scanner=new Scanner(System.in);
				System.out.print("Black's move: ");
				move=scanner.nextLine();
				if(drawPrompt==true && move.equals("draw")){
					System.out.println("Draw");
					break;
				}
				if(move.equals("resign")){
					resign=true;
					System.out.println("White wins");
					continue;
				}
				drawPrompt=false;
				successfulMove =  mapAndExecute(blackPlayer, move);
				while(successfulMove != true){
					System.out.print("Black's move: ");
					scanner=new Scanner(System.in);
					move=scanner.nextLine();
					if(move.equals("resign")){
						resign=true;
						System.out.println("White wins");
						continue;
					}
					successfulMove =  mapAndExecute(blackPlayer, move);
				}
				chess.Chess.prevMove=move;
				lastTurn = 1;
			}
			
			//White Move
			else if(lastTurn == 1){
				scanner=new Scanner(System.in);
				System.out.print("White's move: ");
				move=scanner.nextLine();
				if(drawPrompt==true && move.equals("draw")){
					System.out.println("Draw");
					break;
				}
				if(move.equals("resign")){
					resign=true;
					System.out.println("Black wins");
					continue;
				}
				drawPrompt=false;
				successfulMove =  mapAndExecute(whitePlayer, move);
				while(successfulMove != true){
					System.out.print("White's move: ");
					scanner=new Scanner(System.in);
					move=scanner.nextLine();
					if(move.equals("resign")){
						resign=true;
						System.out.println("Black wins");
						continue;
					}
					successfulMove =  mapAndExecute(whitePlayer, move);
				}
				chess.Chess.prevMove=move;
				lastTurn = 0;
			}
		}
		scanner.close();
		
	}
	
	/**
	 * @param src
	 * Parses Input Move
	 */
	public void getInput(String src){
		if(src.length()==11)
			drawPrompt=true;
		sf = src.charAt(0);
		sr = src.charAt(1);
		df = src.charAt(3);
		dr = src.charAt(4);
		
		
	}
	
	/**
	 * @param current
	 * @param dest
	 * @param player
	 * @return boolean
	 * Checks if the current piece color matches the current player color and then executes move
	 */
	public boolean makeMove(Block current, Block dest, Player player, boolean check, String move){
		boolean success = false;
		if(current.getPiece().getColor().equals(player.getColor())){
			success = current.getPiece().move(dest, check, move);
			if(success == true){
				//checks if the opponent's king is in check after move
				if(dest.getPiece().getName().charAt(0) == 'w'){
					if(blackPlayer.getKing().isInCheck() == true){
						System.out.println("Check");
						return true;
					}
				}else if(dest.getPiece().getName().charAt(0) == 'b'){
					if(whitePlayer.getKing().isInCheck() == true){
						System.out.println("Check");
						return true;
					}
				}
			}
			return success;
		}else{
			System.out.println("Invalid move, try again");
			return false;
		}
	}
	
	/**
	 * @param player
	 * @param s
	 * @return boolean
	 * Takes in Player and Move sets up information for makeMove
	 */
	public boolean mapAndExecute(Player player, String s){
		getInput(s);
		srcFile = fMap.get(sf+"");
		srcRank = rMap.get(sr+"");
		destFile = fMap.get(df+"");
		destRank = rMap.get(dr+"");
		return makeMove(board[srcRank][srcFile], board[destRank][destFile], player, false, s);
	}
}