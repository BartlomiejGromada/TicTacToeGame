package pl.gromada;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

public class Game implements ActionListener {

	private GameGUI gameGUI;
	private Cell[][] cells;
	public List<List<Integer>> winningCombinations;
	private boolean move;
	private User userOne;
	private User userTwo;
	private boolean win;

	public Game() {
		this.gameGUI = new GameGUI();
		this.cells = new Cell[3][3];
		this.userOne = new User("X user");
		this.userTwo = new User("O user");
		this.move = true;
		this.win = false;
		initWinningCombinations();
		initListener();
	}

	private void initWinningCombinations() {
		winningCombinations = new ArrayList<List<Integer>>();
		winningCombinations.add(Arrays.asList(0, 1, 2));
		winningCombinations.add(Arrays.asList(0, 3, 6));
		winningCombinations.add(Arrays.asList(0, 4, 8));
		winningCombinations.add(Arrays.asList(1, 4, 7));
		winningCombinations.add(Arrays.asList(2, 5, 8));
		winningCombinations.add(Arrays.asList(3, 4, 5));
		winningCombinations.add(Arrays.asList(6, 7, 8));
		winningCombinations.add(Arrays.asList(2, 4, 6));
	}

	private void initListener() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.cells[i][j] = new Cell(i, j);
				gameGUI.getButtons()[i][j].addActionListener(this);
			}
		}

		gameGUI.getButtonReset().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == gameGUI.getButtonReset()) {
			resetGame();
		} else {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (e.getSource() == gameGUI.getButtons()[i][j]) {
						moveUser(i, j);
					}
				}
			}
		}
	}

	private void moveUser(int i, int j) {
		if (!cells[i][j].isClicked() && !win) {
			gameGUI.getButtons()[i][j].setFont(new Font(null, Font.BOLD, 40));
			if (move) {
				gameGUI.getButtons()[i][j].setText("X");
				gameGUI.getButtons()[i][j].setForeground(Color.BLUE);
				userOne.addCell(i, j);
				checkIfWin(userOne);
			} else {
				gameGUI.getButtons()[i][j].setText("O");
				gameGUI.getButtons()[i][j].setForeground(Color.RED);
				userTwo.addCell(i, j);
				checkIfWin(userTwo);
			}
			move = !move;
			cells[i][j].setClicked(true);
		}
	}

	private void checkIfWin(User user) {
		if (user.getUserCells().size() >= 3) {
			for (int i = 0; i < winningCombinations.size(); i++) {
				if (user.getUserCells().containsAll(winningCombinations.get(i))) {
					JOptionPane.showMessageDialog(gameGUI, user.getName() + " is a winner", "Winner",
							JOptionPane.INFORMATION_MESSAGE);
					win = true;
				}
			}
		}
	}

	private void resetGame() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				this.gameGUI.getButtons()[i][j].setText("");
				this.cells[i][j].setClicked(false);
			}
		}

		userOne.getUserCells().clear();
		userTwo.getUserCells().clear();
		move = true;
		win = false;
	}
}
