package chess;

import java.util.Map;

import java.util.Scanner;

import Piece.Pawn;
import Piece.Piece;
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
				boolean check=Check(whitePlayer.getKing().getBlock(), "White", false);
				if(check){
					boolean check1=false, check2=false, check3=false, check4=false, check5=false, check6=false, check7=false, check8=false;
					int file=whitePlayer.getKing().getBlock().getFile();
					int rank=rMap.get(whitePlayer.getKing().getBlock().getRank()+"");
					whitePlayer.getKing().getBlock().setOccupied(false);
					
					if((0<=file-1 && file-1<=7) && (0<=rank-1 && rank-1<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank-1][file-1], true, "")){
							check1=Check(chess.Chess.board[rank-1][file-1], "White", true);
						}
				}
					if((0<=file && file<=7) && (0<=rank-1 && rank-1<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank-1][file], true, "")){
							check2=Check(chess.Chess.board[rank-1][file], "White", true);
						}
							
					}
					if((0<=file+1 && file+1<=7) && (0<=rank-1 && rank-1<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank-1][file+1], true, "")){
							check3=Check(chess.Chess.board[rank-1][file+1], "White", true);
						}
							
					}
					if((0<=file-1 && file-1<=7) && (0<=rank && rank<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank][file-1], true, "")){
							check4=Check(chess.Chess.board[rank][file-1], "White", true);
					}
				}
					if((0<=file+1 && file+1<=7) && (0<=rank && rank<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank][file+1], true, "")){
							check5=Check(chess.Chess.board[rank][file+1], "White", true);
					}
				}
					if((0<=file-1 && file-1<=7) && (0<=rank+1 && rank+1<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank+1][file-1], true, "")){
							check6=Check(chess.Chess.board[rank+1][file-1], "White", true);
					}
				}
					if((0<=file && file<=7) && (0<=rank+1 && rank+1<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank+1][file], true, "")){
							check7=Check(chess.Chess.board[rank+1][file], "White", true);
					}
				}
					if((0<=file+1 && file+1<=7) && (0<=rank+1 && rank+1<=7)){
						if(whitePlayer.getKing().move(chess.Chess.board[rank+1][file+1], true, "")){
							check8=Check(chess.Chess.board[rank+1][file+1], "White", true);
					}
				}
					whitePlayer.getKing().getBlock().setOccupied(true);
					
						if(check1==false && check2==false && check3==false && check4==false && check5 ==false &&
								check6==false && check7==false && check8==false){
								checkmate=true;
								System.out.println("Black Wins");
								continue;
							}
						System.out.println("Check");
				}
				chess.Chess.prevMove=move;
				lastTurn = 1;
			}
			
			//White Move
			if(lastTurn == 1){
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
				boolean check=Check(blackPlayer.getKing().getBlock(), "Black", false);
				if(check){
					boolean check1=false, check2=false, check3=false, check4=false, check5=false, check6=false, check7=false, check8=false;
					int file=blackPlayer.getKing().getBlock().getFile();
					int rank=rMap.get(blackPlayer.getKing().getBlock().getRank()+"");
					blackPlayer.getKing().getBlock().setOccupied(false);
					
					if((0<=file-1 && file-1<=7) && (0<=rank-1 && rank-1<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank-1][file-1], true, "")){
							check1=Check(chess.Chess.board[rank-1][file-1], "Black", true);
						}
				}
					if((0<=file && file<=7) && (0<=rank-1 && rank-1<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank-1][file], true, "")){
							check2=Check(chess.Chess.board[rank-1][file], "Black", true);
						}
							
					}
					if((0<=file+1 && file+1<=7) && (0<=rank-1 && rank-1<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank-1][file+1], true, "")){
							check3=Check(chess.Chess.board[rank-1][file+1], "Black", true);
						}
							
					}
					if((0<=file-1 && file-1<=7) && (0<=rank && rank<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank][file-1], true, "")){
							check4=Check(chess.Chess.board[rank][file-1], "Black", true);
					}
				}
					if((0<=file+1 && file+1<=7) && (0<=rank && rank<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank][file+1], true, "")){
							check5=Check(chess.Chess.board[rank][file+1], "Black", true);
					}
				}
					if((0<=file-1 && file-1<=7) && (0<=rank+1 && rank+1<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank+1][file-1], true, "")){
							check6=Check(chess.Chess.board[rank+1][file-1], "Black", true);
					}
				}
					if((0<=file && file<=7) && (0<=rank+1 && rank+1<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank+1][file], true, "")){
							check7=Check(chess.Chess.board[rank+1][file], "Black", true);
					}
				}
					if((0<=file+1 && file+1<=7) && (0<=rank+1 && rank+1<=7)){
						if(blackPlayer.getKing().move(chess.Chess.board[rank+1][file+1], true, "")){
							check8=Check(chess.Chess.board[rank+1][file+1], "Black", true);
					}
				}
					blackPlayer.getKing().getBlock().setOccupied(false);
					
						if(check1==false && check2==false && check3==false && check4==false && check5 ==false &&
								check6==false && check7==false && check8==false){
								checkmate=true;
								System.out.println("White Wins");
								continue;
							}
					System.out.println("Check");
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
			return success;
		}
		else{
			System.out.println("Invalid move, try again");
			return false;
		}
	}
	
	public boolean Check(Block King, String color, Boolean CM){
		boolean check=false;
		if(color.equals("White")){
			
			if(this.blackPlayer.getQueen()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getQueen(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getQueen().move(King, true, "");
				if(check)
					return true;
				}
					
			}
			if(this.blackPlayer.getBishop1()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getBishop1(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getBishop1().move(King, true, "");
				if(check)
					return true;
				}
			}
					
				
			
			if(this.blackPlayer.getBishop2()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getBishop2(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getBishop2().move(King, true, "");
				if(check)
					return true;
				}
					
			}
			if(this.blackPlayer.getRook1()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getRook1(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getRook1().move(King, true, "");
				if(check)
					return true;
				}
					
				
			}
			if(this.blackPlayer.getRook2()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getRook2(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getRook2().move(King, true, "");
				if(check)
					return true;
				}
					
			}
			if(this.blackPlayer.getPawn1()==null){
				if(this.blackPlayer.RPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote1.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.QPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote1.move(King, true, "");
					if(check)
						return true;
					}
						
				}
				if(this.blackPlayer.BPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.BPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.BPromote1.move(King, true, "");
					if(check)
						return true;
					}
						
				}
				if(this.blackPlayer.KPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote1.move(King, true, "");
					if(check)
						return true;
					}
					
			}
		}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn1(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn1().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.blackPlayer.getPawn2()==null){
				if(this.blackPlayer.RPromote2!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote2, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote2.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.QPromote2!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote2, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote2.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.BPromote2!=null){
						if(CM){
							boolean cMate= checkMate(King, this.blackPlayer.BPromote2, color);
							if(!cMate)
								return false;
						}
						else{
						check=this.blackPlayer.BPromote2.move(King, true, "");
						if(check)
							return true;
						}
						
				}
				if(this.blackPlayer.KPromote2!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote2, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote2.move(King, true, "");
					if(check)
						return true;
					
						
					}
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn2(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn2().move(King, true, "");
				if(check)
					return true;
				
				
				}
			}
			if(this.blackPlayer.getPawn3()==null){
				if(this.blackPlayer.RPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote3.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.QPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote3.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.BPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.BPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.BPromote3.move(King, true, "");
					if(check)
						return true;
					}

				}
				if(this.blackPlayer.KPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote3.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn3(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn3().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.blackPlayer.getPawn4()==null){
				if(this.blackPlayer.RPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote4.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.QPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote4.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.BPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.BPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.BPromote4.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.KPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote4.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn4(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn4().move(King, true, "");
				if(check)
					return true;
				}
			}
			if(this.blackPlayer.getPawn5()==null){
				if(this.blackPlayer.RPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote5.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.QPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote5.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.BPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.BPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.BPromote5.move(King, true, "");
					if(check)
						return true;
					}

				}
				if(this.blackPlayer.KPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote5.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn5(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn5().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.blackPlayer.getPawn6()==null){
				if(this.blackPlayer.RPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote6.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.QPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote6.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.BPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.BPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.BPromote6.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.KPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote6.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn6(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn6().move(King, true, "");
				if(check)
					return true;
				}
			}
			if(this.blackPlayer.getPawn7()==null){
				if(this.blackPlayer.RPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote7.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.QPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote7.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.BPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.BPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.BPromote7.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.KPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote7.move(King, true, "");
					if(check)
						return true;
					}

					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn7(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn7().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.blackPlayer.getPawn8()==null){
				if(this.blackPlayer.RPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.RPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.RPromote8.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.QPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.QPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.QPromote8.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.blackPlayer.BPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.BPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.BPromote8.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.blackPlayer.KPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.blackPlayer.KPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.blackPlayer.KPromote8.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.blackPlayer.getPawn8(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.blackPlayer.getPawn8().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			
		
	}
		else{
			if(this.whitePlayer.getQueen()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getQueen(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getQueen().move(King, true, "");
				if(check)
					return true;
				}
					
			}
			if(this.whitePlayer.getBishop1()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getBishop1(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getBishop1().move(King, true, "");
				if(check)
					return true;
				}
			}
					
				
			
			if(this.whitePlayer.getBishop2()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getBishop2(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getBishop2().move(King, true, "");
				if(check)
					return true;
				}
					
			}
			if(this.whitePlayer.getRook1()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getRook1(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getRook1().move(King, true, "");
				if(check)
					return true;
				}
					
				
			}
			if(this.whitePlayer.getRook2()!=null){
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getRook2(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getRook2().move(King, true, "");
				if(check)
					return true;
				}
					
			}
			if(this.whitePlayer.getPawn1()==null){
				if(this.whitePlayer.RPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote1.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.QPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote1.move(King, true, "");
					if(check)
						return true;
					}
						
				}
				if(this.whitePlayer.BPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.BPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.BPromote1.move(King, true, "");
					if(check)
						return true;
					}
						
				}
				if(this.whitePlayer.KPromote1!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote1, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote1.move(King, true, "");
					if(check)
						return true;
					}
					
			}
		}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn1(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn1().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.whitePlayer.getPawn2()==null){
				if(this.whitePlayer.RPromote2!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote2, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote2.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.QPromote2!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote2, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote2.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.BPromote2!=null){
						if(CM){
							boolean cMate= checkMate(King, this.whitePlayer.BPromote2, color);
							if(!cMate)
								return false;
						}
						else{
						check=this.whitePlayer.BPromote2.move(King, true, "");
						if(check)
							return true;
						}
						
				}
				if(this.whitePlayer.KPromote2!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote2, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote2.move(King, true, "");
					if(check)
						return true;
					
						
					}
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn2(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn2().move(King, true, "");
				if(check)
					return true;
				
				
				}
			}
			if(this.whitePlayer.getPawn3()==null){
				if(this.whitePlayer.RPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote3.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.QPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote3.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.BPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.BPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.BPromote3.move(King, true, "");
					if(check)
						return true;
					}

				}
				if(this.whitePlayer.KPromote3!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote3, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote3.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn3(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn3().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.whitePlayer.getPawn4()==null){
				if(this.whitePlayer.RPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote4.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.QPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote4.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.BPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.BPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.BPromote4.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.KPromote4!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote4, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote4.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn4(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn4().move(King, true, "");
				if(check)
					return true;
				}
			}
			if(this.whitePlayer.getPawn5()==null){
				if(this.whitePlayer.RPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote5.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.QPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote5.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.BPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.BPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.BPromote5.move(King, true, "");
					if(check)
						return true;
					}

				}
				if(this.whitePlayer.KPromote5!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote5, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote5.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn5(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn5().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.whitePlayer.getPawn6()==null){
				if(this.whitePlayer.RPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote6.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.QPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote6.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.BPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.BPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.BPromote6.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.KPromote6!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote6, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote6.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn6(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn6().move(King, true, "");
				if(check)
					return true;
				}
			}
			if(this.whitePlayer.getPawn7()==null){
				if(this.whitePlayer.RPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote7.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.QPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote7.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.BPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.BPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.BPromote7.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.KPromote7!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote7, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote7.move(King, true, "");
					if(check)
						return true;
					}

					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn7(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn7().move(King, true, "");
				if(check)
					return true;
				}
				
			}
			if(this.whitePlayer.getPawn8()==null){
				if(this.whitePlayer.RPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.RPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.RPromote8.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.QPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.QPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.QPromote8.move(King, true, "");
					if(check)
						return true;
					}
					
				}
				if(this.whitePlayer.BPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.BPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.BPromote8.move(King, true, "");
					if(check)
						return true;
					}
				}
				if(this.whitePlayer.KPromote8!=null){
					if(CM){
						boolean cMate= checkMate(King, this.whitePlayer.KPromote8, color);
						if(!cMate)
							return false;
					}
					else{
					check=this.whitePlayer.KPromote8.move(King, true, "");
					if(check)
						return true;
					}
					
				}
					
			}
			else{
				if(CM){
					boolean cMate= checkMate(King, this.whitePlayer.getPawn8(), color);
					if(!cMate)
						return false;
				}
				else{
				check=this.whitePlayer.getPawn8().move(King, true, "");
				if(check)
					return true;
				}
				
			}
		}
		if(CM)
			return true;
		else
		return false;
		
		
	}
	
	public boolean checkMate(Block Move, Piece  P, String color){
		boolean occupied=Move.isOccupied();
		String Color=" ";
		if(Move.getPiece()!=null){
			Color=Move.getPiece().getColor();
			
		}
		if(occupied){
			if(color.equals("Black"))
			Move.getPiece().setColor("Black");
			else
			Move.getPiece().setColor("White");
		}
		else{
			if(color.equals("Black")){
			Move.setPiece(new Pawn("bp", Move, "Black", blackPlayer));
			Move.setOccupied(true);
			}
			else{
			Move.setPiece(new Pawn("wp", Move, "White", whitePlayer));
			Move.setOccupied(true);
			}
		}
		
		boolean check=P.move(Move, true, "");

		if(check){
			if(occupied)
				Move.getPiece().setColor(Color);
			
			else{
				Move.setPiece(null);
				Move.setOccupied(false);
			}
			return false;
		}
		
		if(occupied)
			Move.getPiece().setColor(Color);
		else{
			Move.setPiece(null);
			Move.setOccupied(false);
		}
		return true;
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