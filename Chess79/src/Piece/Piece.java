package chess;

public abstract class Piece {
	private String name;
	private Block block;
	
	public Piece(String name, Block block){
		this.name = name;
		this.block = block;
	}
	
	public String getName(){
		return name;
	}
	
	public Block getBlock(){
		return block;
	}
	
	public void setBlock(Block b){
		block = b;
	}
	
	public abstract void move(Block moveTo);
}
