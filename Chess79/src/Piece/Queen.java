package Piece;

import chess.Block;

public class Queen extends Piece{
	public Queen(String name, Block block, String color){
		super(name, block, color);
	}
	
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if((((getBlock().getRank() == moveTo.getRank()) && (getBlock().getFile() != moveTo.getFile())
				|| ((getBlock().getFile() == moveTo.getFile()) && (getBlock().getRank() != moveTo.getRank()))))
				|| (Math.abs(getBlock().getRank() - moveTo.getRank()) == 
						Math.abs(getBlock().getFile() - moveTo.getFile()))){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}
