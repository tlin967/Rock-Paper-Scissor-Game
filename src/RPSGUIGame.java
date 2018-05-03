import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RPSGUIGame extends JFrame {

	// buttons for the user to enter their move
	private JButton rockButton, paperButton, scissorsButton;

	// labels to display the number of wins/losses/ties
	private JLabel statusC, statusU, statusT;

	// images and labels to display the computer and user's moves and the
	// outcome of a match-up
	private ImageIcon rockImage, paperImage, scissorsImage;
	private JLabel computerPlay, userPlay;
	private JLabel outcome;

	// the game object
	private RPSGame game;

	public RPSGUIGame() {

		// initializes the window
		super("Rock, Paper, Scissors, Go!");
		setSize(400, 300);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.black);
		setResizable(false);

		// creates the game object
		game = new RPSGame();

		// creates the labels for displaying the computer and user's move;
		// the images for the moves and the outcome of a match-up will be
		// displayed
		// in a single panel
		// put the image files in the same workspace of the project
		rockImage = new ImageIcon("rock.jpg");
		paperImage = new ImageIcon("paper.jpg");
		scissorsImage = new ImageIcon("scissors.jpg");

		computerPlay = new JLabel();
		computerPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		computerPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		computerPlay.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		computerPlay.setForeground(Color.cyan);
		userPlay = new JLabel();
		userPlay.setVerticalTextPosition(SwingConstants.BOTTOM);
		userPlay.setHorizontalTextPosition(SwingConstants.CENTER);
		userPlay.setBorder(BorderFactory.createLineBorder(Color.black, 5));
		userPlay.setForeground(Color.cyan);

		outcome = new JLabel();
		outcome.setHorizontalTextPosition(SwingConstants.CENTER);
		outcome.setForeground(Color.pink);

		JPanel imageOutcomePanel = new JPanel();
		imageOutcomePanel.setBackground(Color.black);
		imageOutcomePanel.setLayout(new BorderLayout());
		imageOutcomePanel.add(computerPlay, BorderLayout.WEST);
		imageOutcomePanel.add(userPlay, BorderLayout.EAST);
		imageOutcomePanel.add(outcome, BorderLayout.SOUTH);

		// creates the labels for the status of the game (number of wins,
		// losses, and ties);
		// the status labels will be displayed in a single panel
		statusC = new JLabel("Computer Wins: " + game.getCWins());
		statusU = new JLabel("User Wins: " + game.getUWins());
		statusT = new JLabel("Ties: " + game.getTies());
		statusC.setForeground(Color.white);
		statusU.setForeground(Color.white);
		statusT.setForeground(Color.white);
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.black);
		statusPanel.add(statusC);
		statusPanel.add(statusU);
		statusPanel.add(statusT);

		// the play and status panels are nested in a single panel
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(250, 250));
		gamePanel.setBackground(Color.black);
		gamePanel.add(imageOutcomePanel);
		gamePanel.add(statusPanel);

		// creates the buttons and displays them in a control panel;
		// one listener is used for all three buttons
		rockButton = new JButton("Play Rock");
		rockButton.addActionListener(new GameListener());
		paperButton = new JButton("Play Paper");
		paperButton.addActionListener(new GameListener());
		scissorsButton = new JButton("Play Scissors");
		scissorsButton.addActionListener(new GameListener());

		JPanel controlPanel = new JPanel();
		controlPanel.add(rockButton);
		controlPanel.add(paperButton);
		controlPanel.add(scissorsButton);
		controlPanel.setBackground(Color.black);

		// the gaming and control panel are added to the window
		contentPane.add(gamePanel, BorderLayout.CENTER);
		contentPane.add(controlPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	/* determines which button was clicked and updates the game accordingly */
	private class GameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if (event.getSource() == rockButton) {
				game.setMove("ROCK");
				userPlay.setIcon(rockImage);
				setComputerPlay(game.generateComputerPlay());
			} else if (event.getSource() == paperButton) {
				game.setMove("PAPER");
				userPlay.setIcon(paperImage);
				setComputerPlay(game.generateComputerPlay());
			} else {
				game.setMove("SCISSORS");
				userPlay.setIcon(scissorsImage);
				setComputerPlay(game.generateComputerPlay());
			}
			outcome.setText("                   " + game.findWinner());
			statusC.setText("Computer Wins: " + game.getCWins());
			statusU.setText("User Wins: " + game.getUWins());
			statusT.setText("Ties: " + game.getTies());
			userPlay.setText("Your Move");
			computerPlay.setText("Computer Move");

		}

		public void setComputerPlay(String play) {
			if (play.equals("ROCK")) {
				computerPlay.setIcon(rockImage);
			} else if (play.equals("PAPER")) {
				computerPlay.setIcon(paperImage);
			} else {
				computerPlay.setIcon(scissorsImage);
			}
		}
	}

	public static void main(String args[]) {

		RPSGUIGame frame = new RPSGUIGame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}