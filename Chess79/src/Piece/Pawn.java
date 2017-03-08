package Piece;

import chess.Block;

public class Pawn extends Piece{
	public Pawn(String name, Block block, String color){
		super(name, block, color);
	}
	
	public void move(Block moveTo){
		if(getName().charAt(0) == 'w'){
			if(moveTo.isOccupied()){
				if((moveTo.getRank() == getBlock().getRank() + 1)
						&& (moveTo.getFile() == getBlock().getFile() + 1)){
					if(moveTo.getPiece().getName().charAt(0) != getName().charAt(0)){
						//capture opponent's piece
						//send message to remove
					}else{
						System.out.println("Invalid move!");
					}
				}else if((moveTo.getRank() == getBlock().getRank() + 1))
						/*|| ((moveTo.getRank() == getBlock().getRank() + 2) &&
								(moveTo.getRank() - 1  )))*/{
					
				}
				System.out.println("Invalid move: Block is occupied");
				return;
			}
		}else if(getName().charAt(0) == 'b'){
			if(moveTo.isOccupied()){
				if((moveTo.getRank() == getBlock().getRank() - 1)
						&& (moveTo.getFile() == getBlock().getFile() - 1)){
					if(moveTo.getPiece().getName().charAt(0) != getName().charAt(0)){
						//capture opponent's piece
						//send message to remove
					}
				}
				System.out.println("Invalid move: Block is occupied");
				return;
			}
		}
	}
}
