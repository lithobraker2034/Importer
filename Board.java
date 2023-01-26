package checkers;

public class Board {
	private Piece[][] board = new Piece[8][8];
	
	public Board() {
		this.board[0][1] = new Piece("r1", 1, 0);
		this.board[0][3] = new Piece("r2", 3, 0);
		this.board[0][5] = new Piece("r3", 5, 0);
		this.board[0][7] = new Piece("r4", 7, 0);
		this.board[1][0] = new Piece("r5", 0, 1);
		this.board[1][2] = new Piece("r6", 2, 1);
		this.board[1][4] = new Piece("r7", 4, 1);
		this.board[1][6] = new Piece("r8", 6, 1);
		this.board[2][1] = new Piece("r9", 1, 2);
		this.board[2][3] = new Piece("rA", 3, 2);
		this.board[2][5] = new Piece("rB", 5, 2);
		this.board[2][7] = new Piece("rC", 7, 2);
		
		this.board[7][0] = new Piece("w1", 0, 7);
		this.board[7][2] = new Piece("w2", 2, 7);
		this.board[7][4] = new Piece("w3", 4, 7);
		this.board[7][6] = new Piece("w4", 6, 7);
		this.board[6][1] = new Piece("w5", 1, 6);
		this.board[6][3] = new Piece("w6", 3, 6);
		this.board[6][5] = new Piece("w7", 5, 6);
		this.board[6][7] = new Piece("w8", 7, 6);
		this.board[5][0] = new Piece("w9", 0, 5);
		this.board[5][2] = new Piece("wA", 2, 5);
		this.board[5][4] = new Piece("wB", 4, 5);
		this.board[5][6] = new Piece("wC", 6, 5);
	}
	
	public String OccupantID(int[] position) {
		int xPos = position[0];
		int yPos = position[1];
		if(board[yPos][xPos] != null) {
			Piece reference = board[yPos][xPos];
			return reference.getID();
		} else {
			return "empty";
		}

	}
	
	public int[] findPiece(String id) {
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				int[] position = {i, j};
				if(OccupantID(position) == id) {
					return position;
				}
			}
		}
		int[] error = {9, 9};
		return error;
	}
	
	public void movePiece(String id, String direction) {
		int[] position = findPiece(id);
		int xPos = position[0];
		int yPos = position[1];
		if(direction == "NE") {
			int xDest = xPos + 2;
			int yDest = yPos - 2;
			int[] destination = {xDest, yDest};
			int xMed = xPos + 1;
			int yMed = yPos - 1;
			int[] middle = {xMed, yMed};
			if(OccupantID(destination) == "empty" && xDest >= 0 && xDest < 8 
					&& yDest >= 0 && yDest < 8) {
				board[yDest][xDest] = board[yPos][xPos];
				if(!OccupantID(middle).substring(0, 1).equals(id.substring(0,1))) {
					board[yMed][xMed] = null;
				}
			}
		}
		
		if(direction == "SE") {
			int xDest = xPos + 2;
			int yDest = yPos + 2;
			int[] destination = {xDest, yDest};
			int xMed = xPos + 1;
			int yMed = yPos + 1;
			int[] middle = {xMed, yMed};
			if(OccupantID(destination) == "empty" && xDest >= 0 && xDest < 8 
					&& yDest >= 0 && yDest < 8) {
				board[yDest][xDest] = board[yPos][xPos];
				if(!OccupantID(middle).substring(0, 1).equals(id.substring(0,1))) {
					board[yMed][xMed] = null;
				}
			}
		}
		if(direction == "NW") {
			int xDest = xPos - 2;
			int yDest = yPos - 2;
			int[] destination = {xDest, yDest};
			int xMed = xPos - 1;
			int yMed = yPos - 1;
			int[] middle = {xMed, yMed};
			if(OccupantID(destination) == "empty" && xDest >= 0 && xDest < 8 
					&& yDest >= 0 && yDest < 8) {
				board[yDest][xDest] = board[yPos][xPos];
				if(!OccupantID(middle).substring(0, 1).equals(id.substring(0,1))) {
					board[yMed][xMed] = null;
				}
			}
		}
		if(direction == "SW") {
			int xDest = xPos - 2;
			int yDest = yPos + 2;
			int[] destination = {xDest, yDest};
			int xMed = xPos - 1;
			int yMed = yPos + 1;
			int[] middle = {xMed, yMed};
			if(OccupantID(destination) == "empty" && xDest >= 0 && xDest < 8 
					&& yDest >= 0 && yDest < 8) {
				board[yDest][xDest] = board[yPos][xPos];
				if(!OccupantID(middle).substring(0, 1).equals(id.substring(0,1))) {
					board[yMed][xMed] = null;
				}
			}
		}
	}
	
	public void printBoard() {
		for(Piece[] row : board) {
			System.out.println();
			System.out.println("---------------------------------");
			for(Piece item : row) {
				System.out.print("|");
				if(item != null) {
					if(item.isKing()) {
						System.out.print(item.getID() + "k");
					} else {
						System.out.print(item.getID() + " ");
					}
					
				} else {
					System.out.print("   ");
				}
			}
			System.out.print("|");
		}
		System.out.println();
		System.out.println("---------------------------------");
	}
}
