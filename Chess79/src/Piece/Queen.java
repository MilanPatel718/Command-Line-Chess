package Piece;

import chess.Block;
import chess.Player;

/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class Queen extends Piece{
	/**
	 * Initializes a Queen object
	 * 
	 * @param name
	 * Name used to identify a Queen
	 * @param block
	 * The block where the Queen is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Queen(String name, Block block, String color, Player player){
		super(name, block, color, player);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Queen is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Queen will be moved to if the move is valid
	 */
	public boolean move(Block moveTo){
		//Translate File and Rank to array indices
		int srcFile  = this.getBlock().getFile();
		int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
		int destFile = moveTo.getFile();
		int destRank = chess.Chess.Rmap.get(moveTo.getRank()+"");
			
		//Vertical Movement
		if(((srcFile==destFile) && (srcRank!=destRank)) && destRank < srcRank){				
			//Loop through every space between source and destination, excluding source and destination
			for(int i = srcRank - 1; i > destRank; i--){
				if(chess.Chess.board[i][srcFile].isOccupied()){
					System.out.println("Invalid move, try again");
					return false;
				}
			}
			//Queen Captures Piece at Destination
			if(moveTo.isOccupied()){
				if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
				//Call deletePiece to indicate that target piece has been captured
				chess.Chess.board[destRank][destFile].getPiece().deletePiece(
						chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
						chess.Chess.board[destRank][destFile].getPiece());
				
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wQ ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bQ ");
					
				
				this.getBlock().setOccupied(false);
				this.getBlock().setPiece(null);
				
				if(this.getBlock().isShaded()){
					this.getBlock().setDisplay("## ");
				}
				else{
					this.getBlock().setDisplay("   ");
				}
				this.setBlock(moveTo);
				chess.Chess.printBoard();
				return true;
				}
				else{
					System.out.println("Invalid move, try again");
					return false;
				}
			}else{
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wQ ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bQ ");
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
				this.getBlock().setOccupied(false);
				this.getBlock().setPiece(null);
				
				if(this.getBlock().isShaded()){
					this.getBlock().setDisplay("## ");
				}
				else{
					this.getBlock().setDisplay("   ");
				}
				this.setBlock(moveTo);
				chess.Chess.printBoard();
				return true;
			}
		}else if(((srcFile==destFile) && (srcRank!=destRank)) && destRank > srcRank){ //Queen is moving down
			for(int i=srcRank+1; i<destRank; i++){
				if(chess.Chess.board[i][srcFile].isOccupied()){
					System.out.println("Invalid move, try again");
					return false;
				}
			}
			if(moveTo.isOccupied()){
				if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
				//Call deletePiece to indicate that target piece has been captured
				chess.Chess.board[destRank][destFile].getPiece().deletePiece(
						chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
						chess.Chess.board[destRank][destFile].getPiece());
				
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wQ ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bQ ");
					
				
				this.getBlock().setOccupied(false);
				this.getBlock().setPiece(null);
				
				if(this.getBlock().isShaded()){
					this.getBlock().setDisplay("## ");
				}
				else{
					this.getBlock().setDisplay("   ");
				}
				this.setBlock(moveTo);
				chess.Chess.printBoard();
				return true;
			}else{
				System.out.println("Invalid Move, try again");
				return false;
			}
		}else{
			chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
			if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
				chess.Chess.board[destRank][destFile].setDisplay("wQ ");
			else
				chess.Chess.board[destRank][destFile].setDisplay("bQ ");
			chess.Chess.board[destRank][destFile].setOccupied(true);
			
			this.getBlock().setOccupied(false);
			this.getBlock().setPiece(null);
			
			if(this.getBlock().isShaded()){
				this.getBlock().setDisplay("## ");
			}
			else{
				this.getBlock().setDisplay("   ");
			}
			this.setBlock(moveTo);
			chess.Chess.printBoard();
			return true;
		}
	}else if(((srcFile != destFile) && (srcRank == destRank)) && destRank < srcRank){ //horizontal movement			
		//Loop through every space between source and destination, excluding source and destination
		for(int i = srcFile - 1; i > destFile; i--){
			if(chess.Chess.board[i][srcFile].isOccupied()){
				System.out.println("Invalid move, try again");
				return false;
			}
		}
		//Queen Captures Piece at Destination
		if(moveTo.isOccupied()){
			if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
			//Call deletePiece to indicate that target piece has been captured
				chess.Chess.board[destRank][destFile].getPiece().deletePiece(
					chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
					chess.Chess.board[destRank][destFile].getPiece());
			
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
			
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wQ ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bQ ");
				
			
				this.getBlock().setOccupied(false);
				this.getBlock().setPiece(null);
			
				if(this.getBlock().isShaded()){
					this.getBlock().setDisplay("## ");
				}
				else{
					this.getBlock().setDisplay("   ");
				}
				this.setBlock(moveTo);
				chess.Chess.printBoard();
				return true;
				}else{
					System.out.println("Invalid move, try again");
					return false;
				}
			}else{
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wQ ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bQ ");
				chess.Chess.board[destRank][destFile].setOccupied(true);
			
				this.getBlock().setOccupied(false);
				this.getBlock().setPiece(null);
			
				if(this.getBlock().isShaded()){
					this.getBlock().setDisplay("## ");
				}
				else{
					this.getBlock().setDisplay("   ");
				}
				this.setBlock(moveTo);
				chess.Chess.printBoard();
				return true;
			}
		}else if(((srcFile==destFile) && (srcRank!=destRank)) && destRank > srcRank){ //Queen is moving down
			for(int i=srcFile+1; i<destFile; i++){
				if(chess.Chess.board[i][srcFile].isOccupied()){
					System.out.println("Invalid move, try again");
					return false;
				}
			}
			if(moveTo.isOccupied()){
				if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
					//Call deletePiece to indicate that target piece has been captured
					chess.Chess.board[destRank][destFile].getPiece().deletePiece(
							chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
							chess.Chess.board[destRank][destFile].getPiece());
			
					chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
			
					if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
						chess.Chess.board[destRank][destFile].setDisplay("wQ ");
					else
						chess.Chess.board[destRank][destFile].setDisplay("bQ ");
				
			
					this.getBlock().setOccupied(false);
					this.getBlock().setPiece(null);
			
					if(this.getBlock().isShaded()){
						this.getBlock().setDisplay("## ");
					}
					else{
						this.getBlock().setDisplay("   ");
					}
					this.setBlock(moveTo);
					chess.Chess.printBoard();
					return true;
				}else{
					System.out.println("Invalid Move, try again");
					return false;
				}
			}else{
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wQ ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bQ ");
				chess.Chess.board[destRank][destFile].setOccupied(true);
		
				this.getBlock().setOccupied(false);
				this.getBlock().setPiece(null);
		
				if(this.getBlock().isShaded()){
					this.getBlock().setDisplay("## ");
				}
				else{
					this.getBlock().setDisplay("   ");
				}
				this.setBlock(moveTo);
				chess.Chess.printBoard();
				return true;
			}
		}else if(Math.abs(srcRank - destRank) == Math.abs(srcFile - destFile)){
			if(srcRank < destRank){
				if(srcFile < destFile){
					for(int i = 0; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank + i][destFile + i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				}else if(srcFile > destFile){
					for(int i = 0; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank + i][destFile - i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}	
				}
			}else if(srcRank > destRank){
				if(srcFile < destFile){
					for(int i = 0; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank - i][destFile + i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				}else if(srcFile > destFile){
					for(int i = 0; i < (Math.abs(srcRank - destRank)); i++){
						if(chess.Chess.board[srcRank - i][destFile - i].isOccupied()==true){
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				}
			}
			
			if(moveTo.isOccupied()){
				if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
					//Call deletePiece to indicate that target piece has been captured
					chess.Chess.board[destRank][destFile].getPiece().deletePiece(
							chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
							chess.Chess.board[destRank][destFile].getPiece());
					
					chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
					
					if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
						chess.Chess.board[destRank][destFile].setDisplay("wR ");
					else
						chess.Chess.board[destRank][destFile].setDisplay("bR ");
						
					
					this.getBlock().setOccupied(false);
					this.getBlock().setPiece(null);
					
					if(this.getBlock().isShaded()){
						this.getBlock().setDisplay("## ");
					}
					else{
						this.getBlock().setDisplay("   ");
					}
					this.setBlock(moveTo);
					chess.Chess.printBoard();
					return true;
				}
				else{
					System.out.println("Invalid move, try again");
					return false;
				}
			}
			
			//Normal Move
			else{
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wR ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bR ");
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
				this.getBlock().setOccupied(false);
				this.getBlock().setPiece(null);
				
				if(this.getBlock().isShaded()){
					this.getBlock().setDisplay("## ");
				}
				else{
					this.getBlock().setDisplay("   ");
				}
				this.setBlock(moveTo);
				chess.Chess.printBoard();
				return true;
			}
		}else{
			System.out.println("Invalid move, try again");
			return false;
		}
	}
}
