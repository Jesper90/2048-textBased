import java.util.Random;
import java.util.Scanner;

public class Start { 

	Box [][] board = new Box[4][4];
	Scanner scan = new Scanner(System.in);
	
	public static void main(String [] args) {
		Start s = new Start();
		s.initializeGame();
		s.runGame();
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
			if(x > 0) {
				board[0][y].initialize();
			} else {
				board[1][y].initialize();
			}
		} 
	}
	
	
	//Start the game
	void runGame() {
		String input;
		boolean unvalidInput = false;
		while (1 == 1) {
			System.out.println("--------------");
			printBoard();
			System.out.print("up, down, left or right: ");
			input = scan.nextLine();
			
			if (input.equals("w")) { // UP
				addValuesTogether("up", true);
			} else if(input.equals("s")) { //DOWN
				addValuesTogether("down", false);
			} else if(input.equals("a")) { // LEFT
				addValuesTogether("left", true);
			} else if(input.equals("d")) { //RIGHT
				addValuesTogether("right", false);
			} else {
				System.out.println("Invalid input, try again");
				unvalidInput = true;
			}
			
			
			if(gameOver()) {
				System.out.println("---GAME OVER---");
				System.exit(0);
			}else if(!unvalidInput) {
				setNewValue();
			} else {
				unvalidInput = false;
			}
		}
				
	}
	
	//Egen flytt til enden funksjon?? Rekursjon???
	
	//Run through board and check for matching values
	void addValuesTogether(String input, boolean plus) {
		if(plus) { //UP OR LEFT
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 4; j++) {
					//UP
					if(input.equals("up")) {
						if (!board[j][i].isEmpty() && board[j][i].getValue() == board[j+1][i].getValue() && j < 3) {
							board[j][i].increaseValue();
							board[j+i][i].setEmpty();
						}
					} else if(input.equals("left")) { //LEFT
						if(!board[i][j].isEmpty() && board[i][j].getValue() == board[i][j+1].getValue() && j < 3) {
							board[i][j].increaseValue();
							board[i][j+1].setEmpty();
						}
					}
				}
			}
		} else { // DOWN OR RIGHT
			for(int i = 3; i == 0; i--) {
				for(int j = 3; j == 0; j--) {
					if(input.equals("down")) {
						if(!board[j][i].isEmpty() && board[j][i].getValue() == board[j-1][i].getValue() && j > 0) {
							board[j][i].increaseValue();
							board[j-1][i].setEmpty();
						}
					} else if(input.equals("right")) {
						if(!board[i][j].isEmpty() && board[i][j].getValue() == board[i][j-1].getValue() && j > 0) {
							board[i][j].increaseValue();
							board[i][j-1].setEmpty();
						}
					}
				}
			}
		}
		
	}
	
	//Add start value to nex box in array
	void setNewValue() {
		int a;
		int b;
		while(1 == 1) {
			a = getRandomNumber();
			b = getRandomNumber();
			if(board[a][b].isEmpty()) {
				board[a][b].initialize();
				return;
			}
		}		
	}
	
	//GAME OVER
	boolean gameOver() {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
					if(board[i][j].isEmpty()) {
						return false;
					}
				}
			}
		return true;
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

//	
//	@Override
//	public void keyTyped(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyPressed(KeyEvent e) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void keyReleased(KeyEvent e) {
//		// TODO Auto-generated method stub
//		c = e.getKeyChar();
//	}
	
}