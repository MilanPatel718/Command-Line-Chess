package chess;

public class Bishop extends Piece{
	public Bishop(String name, Block block){
		super(name, block);
	}
	
	public void move(Block moveTo){
		if(moveTo.isOccupied()){
			System.out.println("Invalid move: Block is occupied");
			return;
		}
		if(Math.abs(getBlock().getRank() - moveTo.getRank()) == 
				Math.abs(getBlock().getFile() - moveTo.getFile())){
			setBlock(moveTo);
		}else{
			System.out.println("Invalid Move");
			//output to board 
		}
	}
}
