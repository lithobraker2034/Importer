package checkers;

public class Piece {
	private int[] position;
	private String id;
	private boolean isKing;
	
	//defines its id and starting position
	public Piece(String id, int initX, int initY) {
		this.id = id;
		int[] position = {initX, initY};
		this.position = position;
		isKing = false;
	}
	
	public String getID() {
		return this.id;
	}

	public boolean isKing() {
		return this.isKing;
	}
	
	public void king() {
		this.isKing = true;
	}
	
}
