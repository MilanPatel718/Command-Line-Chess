package Piece;

import chess.Block;

public abstract class Piece {
	private String name;
	private Block block;
	private String color;
	
	public Piece(String name, Block block, String color){
		this.name = name;
		this.block = block;
		this.setColor(color);
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

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
