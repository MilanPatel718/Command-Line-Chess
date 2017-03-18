package Piece;
import chess.Block;


/**
 * @author Baljit Kaur
 * @author Milan Patel
 */
public class Pawn extends Piece{
	/**
	 * Initializes a Pawn object
	 * 
	 * @param name
	 * Name used to identify a Pawn
	 * @param block
	 * The block where the Pawn is initially placed
	 * @param color
	 * Color of the piece
	 */
	public Pawn(String name, Block block, String color){
		super(name, block, color);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Pawn is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Pawn will be moved to if the move is valid
	 */
	public boolean move(Block moveTo){
		
		//Translate File and Rank to array indices
		int srcFile  = this.getBlock().getFile();
		int srcRank  = chess.Chess.Rmap.get(this.getBlock().getRank()+"");
		int destFile = moveTo.getFile();
		int destRank = chess.Chess.Rmap.get(moveTo.getRank()+""); 
		
		
		int prevSrcRank=chess.Chess.Rmap.get(chess.Chess.prevMove.charAt(1)+"");
		int prevDestFile=chess.Chess.Fmap.get(chess.Chess.prevMove.charAt(3)+"");
		int prevDestRank=chess.Chess.Rmap.get(chess.Chess.prevMove.charAt(4)+"");
		
		System.out.println();
		
		//Check White Pawn Legality
		if(this.getName().charAt(0) == 'w'){
			if(moveTo.isOccupied()){
			   if((destRank == srcRank - 1) && (Math.abs(destFile-srcFile)==1)){
					if(moveTo.getPiece().getName().charAt(0) != this.getName().charAt(0)){
						//capture opponent's piece
						//send message to remove
						
						chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
						chess.Chess.board[destRank][destFile].setDisplay("wp ");
						
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
						System.out.println();
					
						return true;
						
						
					}
				   else{
						System.out.println("Invalid move, try again");
						return false;
					}
				}
				
			  else if(destRank == srcRank - 1)
						/*|| ((moveTo.getRank() == getBlock().getRank() + 2) &&
								(moveTo.getRank() - 1  )))*/{
				
				System.out.println("Invalid move, try again");
				return false;
			  }
			 
			  else if(srcRank==6 && destRank==srcRank-2){
				  System.out.println("Invalid move, try again");
				  return false;
			  }
			 
			  else{
				  System.out.println("Invalid move, try again");
				  return false;
			  }
			  
	}
		
		//Destination is not occupied	
		else{
			//Pawn moves 1 forward
			if(destRank == srcRank -1 && destFile==srcFile){
				
				chess.Chess.board[destRank][destFile].setPiece(this);
				chess.Chess.board[destRank][destFile].setOccupied(true);
				chess.Chess.board[destRank][destFile].setDisplay("wp ");
				
				
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
				System.out.println();
				return true;
			}
			
			//Pawn moves two forward on first move
			else if(srcRank==6 && destRank == srcRank-2){
				
				chess.Chess.board[destRank][destFile].setPiece(this);
				chess.Chess.board[destRank][destFile].setOccupied(true);
				chess.Chess.board[destRank][destFile].setDisplay("wp ");
				
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
				System.out.println();
				return true;
			}
			//Enpassant Capture
			else  if((destRank == srcRank - 1) && (Math.abs(destFile-srcFile)==1) && srcRank==3){
					
				if((chess.Chess.board[srcRank][destFile].getPiece().equals(chess.Chess.board[prevDestRank][prevDestFile].getPiece())) &&
					(Math.abs(prevDestRank-prevSrcRank)==2)){
					
					chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
					chess.Chess.board[destRank][destFile].setDisplay("wp ");
					
					this.getBlock().setOccupied(false);
					this.getBlock().setPiece(null);
					
					if(this.getBlock().isShaded()){
						this.getBlock().setDisplay("## ");
					}
					else{
						this.getBlock().setDisplay("   ");
					}
					
					chess.Chess.board[srcRank][destFile].setPiece(null);
					chess.Chess.board[srcRank][destFile].setOccupied(false);

					if(chess.Chess.board[srcRank][destFile].isShaded()){
						chess.Chess.board[srcRank][destFile].setDisplay("## ");
					}
					else{
						chess.Chess.board[srcRank][destFile].setDisplay("   ");
					}
					
					this.setBlock(moveTo);
					chess.Chess.printBoard();
					System.out.println();
				
					return true;
					
				}
				else{
					System.out.println("Invalid Move, try again");
					return false;
				}
				
			}
			
			//Illegal Move
			else{
				System.out.println("Invalid Move, try again");
				return false;
			}
			
		}
			
			
	}
		
		//Black Pawn Move
		else if(this.getName().charAt(0) == 'b'){
			if(moveTo.isOccupied()){
				   if((destRank == srcRank + 1) && (Math.abs(destFile-srcFile)==1)){
						if(moveTo.getPiece().getName().charAt(0) != this.getName().charAt(0)){
							//capture opponent's piece
							//send message to remove
							
							chess.Chess.board[destRank][destFile].setPiece(this);
							chess.Chess.board[destRank][destFile].setDisplay("bp ");
							
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
							System.out.println();
							return true;
							
							
						}else{
							System.out.println("Invalid move, try again");
							return false;
						}
					}
					
				  else if(destRank == srcRank + 1)
							/*|| ((moveTo.getRank() == getBlock().getRank() + 2) &&
									(moveTo.getRank() - 1  )))*/{
					
					System.out.println("Invalid move, try again");
					return false;
				  }
				 
				  else if(srcRank==1 && destRank==srcRank+2){
					  System.out.println("Invalid move, try again");
					  return false;
				  }
				 
				  else{
					  System.out.println("Invalid move, try again");
					  return false;
				  }
				  
		}
			
			//Destination is not occupied	
			else{
				//Pawn moves forward 1 tile
				if(destRank == srcRank +1 && destFile==srcFile){
					
					chess.Chess.board[destRank][destFile].setPiece(this);
					chess.Chess.board[destRank][destFile].setOccupied(true);
					chess.Chess.board[destRank][destFile].setDisplay("bp ");
					
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
					System.out.println();
					return true;
				}
				//Pawn moves forward 2 tiles on first move
				else if(srcRank==1 && destRank == srcRank+2){
					
					chess.Chess.board[destRank][destFile].setPiece(this);
					chess.Chess.board[destRank][destFile].setOccupied(true);
					chess.Chess.board[destRank][destFile].setDisplay("bp ");
					
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
					System.out.println();
					return true;
				}
				
				//Enpassant capture 
				else if((destRank == srcRank + 1) && (Math.abs(destFile-srcFile)==1) && srcRank==4){
					if((chess.Chess.board[srcRank][destFile].getPiece().equals(chess.Chess.board[prevDestRank][prevDestFile].getPiece())) &&
							(Math.abs(prevDestRank-prevSrcRank)==2)){
						chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
						chess.Chess.board[destRank][destFile].setDisplay("bp ");
						
						this.getBlock().setOccupied(false);
						this.getBlock().setPiece(null);
						
						if(this.getBlock().isShaded()){
							this.getBlock().setDisplay("## ");
						}
						else{
							this.getBlock().setDisplay("   ");
						}
						
						chess.Chess.board[srcRank][destFile].setPiece(null);
						chess.Chess.board[srcRank][destFile].setOccupied(false);

						if(chess.Chess.board[srcRank][destFile].isShaded()){
							chess.Chess.board[srcRank][destFile].setDisplay("## ");
						}
						else{
							chess.Chess.board[srcRank][destFile].setDisplay("   ");
						}
						
						this.setBlock(moveTo);
						chess.Chess.printBoard();
						System.out.println();
					
						return true;
					}
					
					else{
						System.out.println("Invalid Move, try again");
						return false;
					}
					
				}
				
				//Invalid move
				else{
					System.out.println("Invalid Move, try again");
					return false;
				}
				
			}
		}
		return false;
	}
}
		
