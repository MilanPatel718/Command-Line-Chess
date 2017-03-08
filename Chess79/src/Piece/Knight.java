package chess;

public class Knight extends Piece{
	public Knight(String name, Block block){
		super(name, block);
	}
	
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if(((Math.abs(getBlock().getRank() - moveTo.getRank()) == 2)
			&& (Math.abs(getBlock().getFile() - moveTo.getFile()) == 1))
			|| ((Math.abs(getBlock().getFile() - moveTo.getFile()) == 2)
					&& (Math.abs(getBlock().getRank() - moveTo.getRank()) == 1))){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}
