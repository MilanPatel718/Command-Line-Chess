package Piece;

import chess.Block;
import chess.Player;

/**
 * Represent a King in a Chess game.
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class King extends Piece {
	private boolean hasCastled;
	
	/**
	 * Initializes a King object
	 * @param name Name used to identify a King
	 * @param block The block where the King is initially placed
	 * @param color Color of the piece
	 */
	public King(String name, Block block, String color, Player player){
		super(name, block, color, player);
		hasCastled = false;
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Bishop is moved if the move is valid, else an error is returned.
	 * @param moveTo The block a King will be moved to if the move is valid.
	 */
	public boolean move(Block moveTo, boolean check, String move){
		int srcFile  = this.getBlock().getFile();
		int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
		int destFile = moveTo.getFile();
		int destRank = chess.Chess.Rmap.get(moveTo.getRank()+""); 
		
		//If the King moves one square in any direction, the move is valid
		if(((Math.abs(srcRank - destRank) == 1) && (Math.abs(srcFile - destFile) == 1)) ||
				((Math.abs(srcRank - destRank) == 1) && (Math.abs(srcFile - destFile) == 0)) ||
				((Math.abs(srcRank - destRank) == 0) && (Math.abs(srcFile - destFile) == 1))){
			if(moveTo.isOccupied()){
				if(moveTo.getPiece().getColor().equals(chess.Chess.board[srcRank][srcFile].getPiece().getColor())==false){
					//A check to see if this move puts the opponent's King in check
					if(check == true){
						return true;
					}
					
					//Call deletePiece to indicate that target piece has been captured
					chess.Chess.board[destRank][destFile].getPiece().deletePiece(
							chess.Chess.board[destRank][destFile].getPiece().getNumber(), 
							chess.Chess.board[destRank][destFile].getPiece());
					
					chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
					
					if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
						chess.Chess.board[destRank][destFile].setDisplay("wK ");
					else
						chess.Chess.board[destRank][destFile].setDisplay("bK ");
						
					
					this.getBlock().setOccupied(false);
					this.getBlock().setPiece(null);
					
					if(this.getBlock().isShaded()){
						this.getBlock().setDisplay("## ");
					}
					else{
						this.getBlock().setDisplay("   ");
					}
					this.setBlock(moveTo);
					getPlayer().getKing().setBlock(moveTo);
					chess.Chess.printBoard();
					setHasMoved(true);
					return true;
				}
				else{
					if(check == true){
						return false;
					}
					System.out.println("Invalid move, try again");
					return false;
				}
			}else{
				//A check to see if this move puts the opponent's King in check
				if(check == true){
					return true;
				}
				
				chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
				if(chess.Chess.board[destRank][destFile].getPiece().getColor().equals("White"))
					chess.Chess.board[destRank][destFile].setDisplay("wK ");
				else
					chess.Chess.board[destRank][destFile].setDisplay("bK ");
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
				getPlayer().getKing().setBlock(moveTo);
				chess.Chess.printBoard();
				setHasMoved(true);
				return true;
			}
		}else if((getHasMoved() == false) && (hasCastled == false)){ //CASTLING IMPLEMENTATION
			//check if piece has been moved before and if it is a rook
			if((chess.Chess.board[destRank][destFile].getPiece()==null)){
				//if the king is white
				if(getName().charAt(0) == 'w'){
					if(chess.Chess.board[7][7].getPiece().getName().charAt(1) == 'R'){
						if(srcRank == 7 && destRank == 7 && srcFile == 4 && destFile == 6){
							for(int i = srcFile + 1; i < destFile; i++){
								if(chess.Chess.board[srcRank][i].isOccupied()){
									if(check == true){
										return false;
									}
									System.out.println("Invalid move, try again");
									return false;
								}
							}
							//A check to see if this move puts the opponent's King in check
							if(check == true){
								return true;
							}
							
							//Set new position of king
							chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
							chess.Chess.board[destRank][destFile].setDisplay("wK ");
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
							getPlayer().getKing().setBlock(moveTo);
							
							//set new position of rook
							chess.Chess.board[destRank][destFile - 1].setPiece(chess.Chess.board[destRank][destFile+1].getPiece());
							chess.Chess.board[destRank][destFile+1].setPiece(null);
							chess.Chess.board[destRank][destFile+1].setOccupied(false);
							
							chess.Chess.board[destRank][destFile - 1].setDisplay("wR ");
							chess.Chess.board[destRank][destFile-1].setOccupied(true);
							
							if(chess.Chess.board[destRank][destFile+1].isShaded()){
								chess.Chess.board[destRank][destFile+1].setDisplay("## ");
							}
							else{
								chess.Chess.board[destRank][destFile+1].setDisplay("   ");
							}
						

							chess.Chess.board[destRank][destFile - 1].getPiece().setBlock(
									chess.Chess.board[destRank][destFile - 1]);
							
							chess.Chess.printBoard();
							setHasMoved(true);
							hasCastled = true;
							chess.Chess.board[destRank][destFile - 1].getPiece().setHasMoved(true);
							return true;
						}
					}else if(chess.Chess.board[7][0].getPiece().getName().charAt(1) == 'R'){
						if(srcRank == 7 && destRank == 7 && srcFile == 4 && destFile == 2){
							for(int i = srcFile - 1; i > destFile; i--){
								if(chess.Chess.board[srcRank][i].isOccupied()){
									if(check == true){
										return false;
									}
									System.out.println("Invalid move, try again");
									return false;
								}
							}
							//A check to see if this move puts the opponent's King in check
							if(check == true){
								return true;
							}
							
							//Set new position of king
							chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
							chess.Chess.board[destRank][destFile].setDisplay("wK ");
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
							getPlayer().getKing().setBlock(moveTo);
							
							//set new position of rook
							chess.Chess.board[destRank][destFile + 1].setPiece(chess.Chess.board[destRank][destFile-2].getPiece());
							chess.Chess.board[destRank][destFile-2].setPiece(null);
							chess.Chess.board[destRank][destFile-2].setOccupied(false);
							
							chess.Chess.board[destRank][destFile + 1].setDisplay("wR ");
							chess.Chess.board[destRank][destFile+1].setOccupied(true);
							
							if(chess.Chess.board[destRank][destFile-2].isShaded()){
								chess.Chess.board[destRank][destFile-2].setDisplay("## ");
							}
							else{
								chess.Chess.board[destRank][destFile-2].setDisplay("   ");
							}
						

							chess.Chess.board[destRank][destFile + 1].getPiece().setBlock(
									chess.Chess.board[destRank][destFile + 1]);
							
							chess.Chess.printBoard();
							setHasMoved(true);
							hasCastled = true;
							chess.Chess.board[destRank][destFile + 1].getPiece().setHasMoved(true);
							return true;
						}else{
							if(check == true){
								return false;
							}
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				//if the king is black
				}else if(getName().charAt(0) == 'b'){
					if(chess.Chess.board[0][7].getPiece().getName().charAt(1) == 'R'){
						if(srcRank == 0 && destRank == 0 && srcFile == 4 && destFile == 6){
							for(int i = srcFile + 1; i < destFile; i++){
								if(chess.Chess.board[srcRank][i].isOccupied()){
									if(check == true){
										return false;
									}
									System.out.println("Invalid move, try again");
									return false;
								}
							}
							//A check to see if this move puts the opponent's King in check
							if(check == true){
								return true;
							}
							
							//Set new position of king
							chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
							chess.Chess.board[destRank][destFile].setDisplay("bK ");
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
							getPlayer().getKing().setBlock(moveTo);
							
							//set new position of rook
							chess.Chess.board[destRank][destFile - 1].setPiece(chess.Chess.board[destRank][destFile+1].getPiece());
							chess.Chess.board[destRank][destFile+1].setPiece(null);
							chess.Chess.board[destRank][destFile+1].setOccupied(false);
							
							chess.Chess.board[destRank][destFile-1].setOccupied(true);
							chess.Chess.board[destRank][destFile - 1].setDisplay("bR ");
							
							if(chess.Chess.board[destRank][destFile+1].isShaded()){
								chess.Chess.board[destRank][destFile+1].setDisplay("## ");
							}
							else{
								chess.Chess.board[destRank][destFile+1].setDisplay("   ");
							}
						

							chess.Chess.board[destRank][destFile - 1].getPiece().setBlock(
									chess.Chess.board[destRank][destFile - 1]);
							
							chess.Chess.printBoard();
							setHasMoved(true);
							hasCastled = true;
							chess.Chess.board[destRank][destFile - 1].getPiece().setHasMoved(true);
							return true;
						}
					}else if(chess.Chess.board[0][0].getPiece().getName().charAt(1) == 'R'){
						if(srcRank == 0 && destRank == 0 && srcFile == 4 && destFile == 2){
							for(int i = srcFile - 1; i >= destFile; i--){
								if(chess.Chess.board[srcRank][i].isOccupied()){
									if(check == true){
										return false;
									}
									System.out.println("Invalid move, try again");
									return false;
								}
							}
							//A check to see if this move puts the opponent's King in check
							if(check == true){
								return true;
							}
							
							//Set new position of king
							chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
							chess.Chess.board[destRank][destFile].setDisplay("bK ");
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
							getPlayer().getKing().setBlock(moveTo);
							
							//set new position of rook
							chess.Chess.board[destRank][destFile + 1].setPiece(chess.Chess.board[destRank][destFile-2].getPiece());
							chess.Chess.board[destRank][destFile-2].setPiece(null);
							chess.Chess.board[destRank][destFile-2].setOccupied(false);
							
							chess.Chess.board[destRank][destFile + 1].setDisplay("bR ");
							chess.Chess.board[destRank][destFile+1].setOccupied(true);
							
							if(chess.Chess.board[destRank][destFile-2].isShaded()){
								chess.Chess.board[destRank][destFile-2].setDisplay("## ");
							}
							else{
								chess.Chess.board[destRank][destFile-2].setDisplay("   ");
							}
						

							chess.Chess.board[destRank][destFile + 1].getPiece().setBlock(
									chess.Chess.board[destRank][destFile + 1]);
							
							chess.Chess.printBoard();
							setHasMoved(true);
							hasCastled = true;
							chess.Chess.board[destRank][destFile + 1].getPiece().setHasMoved(true);
							return true;
						}else{
							if(check == true){
								return false;
							}
							System.out.println("Invalid move, try again");
							return false;
						}
					}
				}
			}
		}else{
			if(check == true){
				return false;
			}
			System.out.println("Invalid move, try again");
			return false;
		}
		return false;
	}

}

