package chess;
import java.util.Scanner;

/**
 * @author Milan Patel
 * @author Baljit Kaur
 *
 */
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
		
		
	}
	
	/**
	 * Method that begins an actual instance of a game
	 * @param None
	 */
	public void Start(){
		
		/*
		 * color keeps track of which sides move it is; Odd=White, Even=Black
		 * prevMove keeps track of the move that came before the current move being evaluated (For Enpassant or other special cases)
		 */
		int color=1;
		String prevMove;
		
		while(resign != true || checkmate != true || stalemate != true){
			//ask players for input
			Scanner s=new Scanner(System.in);
			
			//Parse Input
			String move=s.nextLine();
			String StartEnd[]=move.split(" ");
			String start=StartEnd[0];
			String end=StartEnd[1];
			
			
		}
		
	}
	
	public void makeMove(Block current, Block dest){
		if(!dest.isOccupied()){
			current.getPiece().move(dest);
		}
	}
}
