package Piece;
import java.util.Scanner;

import chess.Block;
import chess.Player;


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
	public Pawn(String name, Block block, String color, Player player){
		super(name, block, color, player);
	}
	
	/**
	 * Determines if a move to a new block is valid.
	 * The Pawn is moved if the move is valid, else an error is returned.
	 * 
	 * @param moveTo
	 * The block a Pawn will be moved to if the move is valid
	 */
	public boolean move(Block moveTo, boolean check, String move){
		
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
						//A check to see if this move puts the opponent's King in check
						if(check == true){
							return true;
						}
						//Call deletePiece to indicate that target piece has been captured
						chess.Chess.board[destRank][destFile].getPiece().deletePiece(chess.Chess.board[destRank][destFile].getPiece().getNumber(), chess.Chess.board[destRank][destFile].getPiece());
						
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
						if(destRank==0){
							promotion(destRank, destFile, this.getPlayer(), move);
						}
					
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
				//A check to see if this move puts the opponent's King in check
				if(check == true){
					return true;
				}
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
				if(destRank==0){
					promotion(destRank, destFile, this.getPlayer(), move);
				}
				
				chess.Chess.printBoard();
				System.out.println();
				return true;
			}
			
			//Pawn moves two forward on first move
			else if(srcRank==6 && destRank == srcRank-2){
				//A check to see if this move puts the opponent's King in check
				if(check == true){
					return true;
				}
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
				if(destRank==0){
					promotion(destRank, destFile, this.getPlayer(), move);
				}
				chess.Chess.printBoard();
				System.out.println();
				return true;
			}
			//Enpassant Capture
			else  if((destRank == srcRank - 1) && (Math.abs(destFile-srcFile)==1) && srcRank==3){
					
				if((chess.Chess.board[srcRank][destFile].getPiece().equals(chess.Chess.board[prevDestRank][prevDestFile].getPiece())) &&
					(Math.abs(prevDestRank-prevSrcRank)==2) && (prevSrcRank==1)){
					//A check to see if this move puts the opponent's King in check
					if(check == true){
						return true;
					}
					//Call deletePiece to indicate that target piece has been captured
					chess.Chess.board[srcRank][destFile].getPiece().deletePiece(chess.Chess.board[srcRank][destFile].getPiece().getNumber(), chess.Chess.board[srcRank][destFile].getPiece());
					
					chess.Chess.board[destRank][destFile].setPiece(getBlock().getPiece());
					chess.Chess.board[destRank][destFile].setDisplay("wp ");
					chess.Chess.board[destRank][destFile].setOccupied(true);

					
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
							//A check to see if this move puts the opponent's King in check
							if(check == true){
								return true;
							}
							
							//capture opponent's piece
							//send message to remove
							
							//Call deletePiece to indicate that target piece has been captured
							chess.Chess.board[destRank][destFile].getPiece().deletePiece(chess.Chess.board[destRank][destFile].getPiece().getNumber(), chess.Chess.board[destRank][destFile].getPiece());
							
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
							if(destRank==7){
								promotion(destRank, destFile, this.getPlayer(), move);
							}
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
					//A check to see if this move puts the opponent's King in check
					if(check == true){
						return true;
					}
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
					if(destRank==7){
						promotion(destRank, destFile, this.getPlayer(), move);
					}
					chess.Chess.printBoard();
					System.out.println();
					return true;
				}
				//Pawn moves forward 2 tiles on first move
				else if(srcRank==1 && destRank == srcRank+2){
					//A check to see if this move puts the opponent's King in check
					if(check == true){
						return true;
					}
					
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
					if(destRank==7){
						promotion(destRank, destFile, this.getPlayer(), move);
					}
					chess.Chess.printBoard();
					System.out.println();
					return true;
				}
				
				//Enpassant capture 
				else if((destRank == srcRank + 1) && (Math.abs(destFile-srcFile)==1) && srcRank==4){
					if((chess.Chess.board[srcRank][destFile].getPiece().equals(chess.Chess.board[prevDestRank][prevDestFile].getPiece())) &&
							(Math.abs(prevDestRank-prevSrcRank)==2) && (prevSrcRank==6)){
						//A check to see if this move puts the opponent's King in check
						if(check == true){
							return true;
						}
						
						//Call deletePiece to indicate that target piece has been captured
						chess.Chess.board[srcRank][destFile].getPiece().deletePiece(chess.Chess.board[srcRank][destFile].getPiece().getNumber(), chess.Chess.board[srcRank][destFile].getPiece());
						
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
	
	/**
	 * @param destRank
	 * @param destFile
	 * @param player
	 * Promotes Pawn that reaches other end of board after a move
	 */
	public void promotion(int destRank, int destFile, Player player, String move){
		
		String promote=" ";
		if(move.length()==7)
			move.substring(6);
		
		if(promote.equals("R")){
			int num=chess.Chess.board[destRank][destFile].getPiece().getNumber();
			if(num==1){
				Rook Rook1;
				if(player.getColor().equals("White"))
					Rook1=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook1=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn1(null);
				player.RPromote1=Rook1;
				chess.Chess.board[destRank][destFile].setPiece(Rook1);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
			}
			else if(num==2){
				Rook Rook2;
				if(player.getColor().equals("White"))
					Rook2=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook2=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn2(null);
				player.RPromote2=Rook2;
				chess.Chess.board[destRank][destFile].setPiece(Rook2);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==3){
				Rook Rook3;
				if(player.getColor().equals("White"))
					Rook3=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook3=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn3(null);
				player.RPromote3=Rook3;
				chess.Chess.board[destRank][destFile].setPiece(Rook3);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==4){
				Rook Rook4;
				if(player.getColor().equals("White"))
					Rook4=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook4=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn4(null);
				player.RPromote4=Rook4;
				chess.Chess.board[destRank][destFile].setPiece(Rook4);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==5){
				Rook Rook5;
				if(player.getColor().equals("White"))
					Rook5=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook5=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn5(null);
				player.RPromote5=Rook5;
				chess.Chess.board[destRank][destFile].setPiece(Rook5);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==6){
				Rook Rook6;
				if(player.getColor().equals("White"))
					Rook6=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook6=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn6(null);
				player.RPromote6=Rook6;
				chess.Chess.board[destRank][destFile].setPiece(Rook6);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==7){
				Rook Rook7;
				if(player.getColor().equals("White"))
					Rook7=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook7=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn7(null);
				player.RPromote7=Rook7;
				chess.Chess.board[destRank][destFile].setPiece(Rook7);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else{
				Rook Rook8;
				if(player.getColor().equals("White"))
					Rook8=new Rook("wR ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Rook8=new Rook("bR ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn8(null);
				player.RPromote8=Rook8;
				chess.Chess.board[destRank][destFile].setPiece(Rook8);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			
		}
		else if(promote.equals("B")){
			int num=chess.Chess.board[destRank][destFile].getPiece().getNumber();
			if(num==1){
				Bishop Bishop1;
				if(player.getColor().equals("White"))
					Bishop1=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop1=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn1(null);
				player.BPromote1=Bishop1;
				chess.Chess.board[destRank][destFile].setPiece(Bishop1);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==2){
				Bishop Bishop2;
				if(player.getColor().equals("White"))
					Bishop2=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop2=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn2(null);
				player.BPromote2=Bishop2;
				chess.Chess.board[destRank][destFile].setPiece(Bishop2);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==3){
				Bishop Bishop3;
				if(player.getColor().equals("White"))
					Bishop3=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop3=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn3(null);
				player.BPromote3=Bishop3;
				chess.Chess.board[destRank][destFile].setPiece(Bishop3);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
			}
			else if(num==4){
				Bishop Bishop4;
				if(player.getColor().equals("White"))
					Bishop4=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop4=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn4(null);
				player.BPromote4=Bishop4;
				chess.Chess.board[destRank][destFile].setPiece(Bishop4);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==5){
				Bishop Bishop5;
				if(player.getColor().equals("White"))
					Bishop5=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop5=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn5(null);
				player.BPromote5=Bishop5;
				chess.Chess.board[destRank][destFile].setPiece(Bishop5);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==6){
				Bishop Bishop6;
				if(player.getColor().equals("White"))
					Bishop6=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop6=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn6(null);
				player.BPromote6=Bishop6;
				chess.Chess.board[destRank][destFile].setPiece(Bishop6);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==7){
				Bishop Bishop7;
				if(player.getColor().equals("White"))
					Bishop7=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop7=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn7(null);
				player.BPromote7=Bishop7;
				chess.Chess.board[destRank][destFile].setPiece(Bishop7);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else{
				Bishop Bishop8;
				if(player.getColor().equals("White"))
					Bishop8=new Bishop("wB ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Bishop8=new Bishop("bB ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn8(null);
				player.BPromote8=Bishop8;
				chess.Chess.board[destRank][destFile].setPiece(Bishop8);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			
		}
		else if(promote.equals("K")){
			int num=chess.Chess.board[destRank][destFile].getPiece().getNumber();
			if(num==1){
				Knight Knight1;
				if(player.getColor().equals("White"))
					Knight1=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight1=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn1(null);
				player.KPromote1=Knight1;
				chess.Chess.board[destRank][destFile].setPiece(Knight1);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==2){
				Knight Knight2;
				if(player.getColor().equals("White"))
					Knight2=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight2=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn2(null);
				player.KPromote2=Knight2;
				chess.Chess.board[destRank][destFile].setPiece(Knight2);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==3){
				Knight Knight3;
				if(player.getColor().equals("White"))
					Knight3=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight3=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn3(null);
				player.KPromote3=Knight3;
				chess.Chess.board[destRank][destFile].setPiece(Knight3);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==4){
				Knight Knight4;
				if(player.getColor().equals("White"))
					Knight4=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight4=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn4(null);
				player.KPromote4=Knight4;
				chess.Chess.board[destRank][destFile].setPiece(Knight4);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==5){
				Knight Knight5;
				if(player.getColor().equals("White"))
					Knight5=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight5=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn5(null);
				player.KPromote5=Knight5;
				chess.Chess.board[destRank][destFile].setPiece(Knight5);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==6){
				Knight Knight6;
				if(player.getColor().equals("White"))
					Knight6=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight6=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn6(null);
				player.KPromote6=Knight6;
				chess.Chess.board[destRank][destFile].setPiece(Knight6);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==7){
				Knight Knight7;
				if(player.getColor().equals("White"))
					Knight7=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight7=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn7(null);
				player.KPromote7=Knight7;
				chess.Chess.board[destRank][destFile].setPiece(Knight7);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else{
				Knight Knight8;
				if(player.getColor().equals("White"))
					Knight8=new Knight("wN ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Knight8=new Knight("bN ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn8(null);
				player.KPromote8=Knight8;
				chess.Chess.board[destRank][destFile].setPiece(Knight8);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			
		}
		else{
			int num=chess.Chess.board[destRank][destFile].getPiece().getNumber();
			if(num==1){
				Queen Queen1;
				if(player.getColor().equals("White"))
					Queen1=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen1=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn1(null);
				player.QPromote1=Queen1;
				chess.Chess.board[destRank][destFile].setPiece(Queen1);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==2){
				Queen Queen2;
				if(player.getColor().equals("White"))
					Queen2=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen2=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn2(null);
				player.QPromote2=Queen2;
				chess.Chess.board[destRank][destFile].setPiece(Queen2);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
			}
			else if(num==3){
				Queen Queen3;
				if(player.getColor().equals("White"))
					Queen3=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen3=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn3(null);
				player.QPromote3=Queen3;
				chess.Chess.board[destRank][destFile].setPiece(Queen3);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==4){
				Queen Queen4;
				if(player.getColor().equals("White"))
					Queen4=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen4=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn4(null);
				player.QPromote4=Queen4;
				chess.Chess.board[destRank][destFile].setPiece(Queen4);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==5){
				Queen Queen5;
				if(player.getColor().equals("White"))
					Queen5=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen5=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn5(null);
				player.QPromote5=Queen5;
				chess.Chess.board[destRank][destFile].setPiece(Queen5);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==6){
				Queen Queen6;
				if(player.getColor().equals("White"))
					Queen6=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen6=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn6(null);
				player.QPromote6=Queen6;
				chess.Chess.board[destRank][destFile].setPiece(Queen6);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else if(num==7){
				Queen Queen7;
				if(player.getColor().equals("White"))
					Queen7=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen7=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn7(null);
				player.QPromote7=Queen7;
				chess.Chess.board[destRank][destFile].setPiece(Queen7);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			else{
				Queen Queen8;
				if(player.getColor().equals("White"))
					Queen8=new Queen("wQ ", chess.Chess.board[destRank][destFile], "White", player);
				else
					Queen8=new Queen("bQ ", chess.Chess.board[destRank][destFile], "Black", player);
				
				player.setPawn8(null);
				player.QPromote8=Queen8;
				chess.Chess.board[destRank][destFile].setPiece(Queen8);
				chess.Chess.board[destRank][destFile].setDisplay(chess.Chess.board[destRank][destFile].getPiece().getName());
				chess.Chess.board[destRank][destFile].setOccupied(true);
				
			}
			
		}
		
	}
}
		
