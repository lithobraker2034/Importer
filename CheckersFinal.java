package checkers;

public class CheckersFinal {
	public static void main(String[] args) {
		Board board = new Board();
		board.printBoard();
		int[] spot = {1,0};
		board.movePiece("wA", "NE");
		board.printBoard();
		board.movePiece("rA", "SE");
		board.printBoard();
	}		
}

