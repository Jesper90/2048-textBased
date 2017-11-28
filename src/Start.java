import java.util.Random;

public class Start {

	Box [][] board = new Box[4][4];
	
	
	public static void main(String [] args) {
		Start s = new Start();
		s.initializeGame();
		s.runGame();
		System.exit(0);
	}
	
	//Set board with start values
	void initializeGame() {		
		Box b;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				b = new Box();
				board[i][j] = b;
			}
		}
		board[getRandomNumber()][getRandomNumber()].initialize();
		int x = getRandomNumber();
		int y = getRandomNumber();
		if (board[x][y].getValue() == 0) {
			board[x][y].initialize();
		} else {
			board[y][x].initialize();
		} 
		printBoard();
	}
	
	void runGame() {
		
		
	}
	
	// Return random number for position on board
	int getRandomNumber() {
		return new Random().nextInt(4);
	}
	
	void printBoard() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(board[i][j].getValue() + " ");
			}
			System.out.println();
		}
	}
	
}