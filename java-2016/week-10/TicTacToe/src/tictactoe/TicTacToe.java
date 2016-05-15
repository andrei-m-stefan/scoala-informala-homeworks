package tictactoe;

import java.util.ArrayList;
import java.util.Random;

public class TicTacToe {

	private String cell;
	private String[][] gameBoard;
	private int currentPlayer;
	private ArrayList<String> movesLog;

	public TicTacToe() {
		gameBoard = new String[3][3];
		cell = PlayerMark.E.name();
		currentPlayer = 1;
		movesLog = new ArrayList<>();
	}

	public void initBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				gameBoard[i][j] = PlayerMark.E.name();
			}
		}
	}

	public String[][] getBoard() {
		return gameBoard;
	}

	public ArrayList<String> getMovesHistory() {
		return movesLog;
	}

	public String getPeon() {
		return cell;
	}

	public synchronized void makeAMove() {
		Random random = new Random();
		String move = " ";
		boolean isDone = false;

		changePlayer();

		while (!isDone) {
			int i = random.nextInt(3);
			int j = random.nextInt(3);
			move = "(" + i + "," + j + ")";
			if (gameBoard[i][j].equals(PlayerMark.E.name())) {
				if (movesLog.contains(move)) {
					return;
				} else {
					gameBoard[i][j] = cell;

					movesLog.add(move);
					System.out.println("\n");
					isDone = true;
				}
			}
		}

	}

	private void changePlayer() {
		if (currentPlayer == 1) {
			cell = PlayerMark.X.name();
			currentPlayer = 2;
		} else if (currentPlayer == 2) {
			cell = PlayerMark.O.name();
			currentPlayer = 1;
		}
	}

	public synchronized boolean checkForWin() {
		boolean hasWon = false;
		if ((gameBoard[0][0].equals(cell) && gameBoard[0][1].equals(cell) && gameBoard[0][2].equals(cell))
				|| (gameBoard[1][0].equals(cell) && gameBoard[1][1].equals(cell) && gameBoard[1][2].equals(cell))
				|| (gameBoard[2][0].equals(cell) && gameBoard[2][1].equals(cell) && gameBoard[2][2].equals(cell))
				|| (gameBoard[0][0].equals(cell) && gameBoard[1][0].equals(cell) && gameBoard[2][0].equals(cell))
				|| (gameBoard[0][1].equals(cell) && gameBoard[1][1].equals(cell) && gameBoard[2][1].equals(cell))
				|| (gameBoard[0][2].equals(cell) && gameBoard[1][2].equals(cell) && gameBoard[2][2].equals(cell))
				|| (gameBoard[0][0].equals(cell) && gameBoard[1][1].equals(cell) && gameBoard[2][2].equals(cell))
				|| (gameBoard[0][2].equals(cell) && gameBoard[1][1].equals(cell) && gameBoard[2][0].equals(cell))) {
			System.out.println("\n\n" + cell + " Won!");
			hasWon = true;
			System.exit(0);
		}

		if ((movesLog.size() == 9) && (hasWon == false)) {
			System.out.println("\n Match ended in a draw.");
			System.exit(0);
		}
		return hasWon;
	}

	public synchronized void updateBoard() {
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; j < gameBoard[i].length; j++) {
				System.out.print(gameBoard[i][j]);
				if (j != 2) {
					System.out.print(" | ");
				}
			}
			if (i != 2) {
				System.out.println("\n----------");
			}
		}
	}

	class Player implements Runnable {

		@Override
		public synchronized void run() {
			try {
				for (int i = 0; i < 9; i++) {
					makeAMove();
					updateBoard();
					checkForWin();
					Thread.sleep(2000);
				}
			} catch (Exception e) {
			}
		}
	}

}
