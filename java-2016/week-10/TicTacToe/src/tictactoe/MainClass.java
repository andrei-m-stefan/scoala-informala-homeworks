package tictactoe;

public class MainClass {

	public static void main(String[] args) throws InterruptedException {

		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.initBoard();

		TicTacToe.Player playerOne = ticTacToe.new Player();
		TicTacToe.Player playerTwo = ticTacToe.new Player();

		Thread threadOne = new Thread(playerOne);
		Thread threadTwo = new Thread(playerTwo);

		threadOne.start();
		threadOne.join(2000);
		threadTwo.start();
		threadTwo.join(2000);

	}

}
