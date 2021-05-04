package pl.gromada;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameGUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;

	private JPanel gamePanel;
	private JButton[][] buttons = new JButton[3][3];
	private JButton buttonReset;

	public GameGUI() {
		this.setLayout(new BorderLayout(10, 10));
		this.setTitle("TIC TAC TOE");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		initGamePanel();
		initComponents();
		this.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private void initGamePanel() {
		gamePanel = new JPanel();
		gamePanel.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setFocusable(false);
				gamePanel.add(buttons[i][j]);
			}
		}

		this.add(gamePanel, BorderLayout.CENTER);
	}

	private void initComponents() {
		this.buttonReset = new JButton("Reset");
		this.buttonReset.setForeground(Color.BLACK);
		this.buttonReset.setFont(new Font(null, Font.BOLD, 40));
		this.buttonReset.setFocusable(false);
		this.add(buttonReset, BorderLayout.SOUTH);
	}

	public JButton getButtonReset() {
		return buttonReset;
	}

	public JButton[][] getButtons() {
		return buttons;
	}

	public JPanel getGamePanel() {
		return gamePanel;
	}

	public void setButtons(JButton[][] buttons) {
		this.buttons = buttons;
	}

}
