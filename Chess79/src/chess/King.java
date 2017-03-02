package chess;

public class King extends Piece {
	public King(String name, Block block){
		super(name, block);
	}
	
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if(((Math.abs(getBlock().getRank() - moveTo.getRank()) == 1)
				&& (Math.abs(getBlock().getFile() - moveTo.getFile()) == 1))
				|| ((Math.abs(getBlock().getRank() - moveTo.getRank()) == 1)
						&& ((getBlock().getFile() - moveTo.getFile()) == 0))
				|| ((Math.abs(getBlock().getRank() - moveTo.getRank()) == 0)
						&& ((getBlock().getFile() - moveTo.getFile()) == 1))){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}

