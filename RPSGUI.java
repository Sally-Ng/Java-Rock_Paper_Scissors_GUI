package project4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;

public class RPSGUI extends JFrame {
	
	// buttons for the user to enter their move
	private JButton rockButton, paperButton, scissorsButton;

	// labels to display the number of wins/losses/ties
	private JLabel statusC, statusU, statusT;

	// images and labels to display the computer and user's moves and the outcome of a match-up
	private ImageIcon rockImage, paperImage, scissorsImage;
	private JLabel computerPlay, userPlay;
	private JLabel outcome;
	
	// the game object
	public RPSGame game;
	
	// bet
	public static String howMuch;
	private JLabel balance;
	public static boolean showBalance = true;
	
	public RPSGUI() {
		
		// initializes the window
		super("Let's Play!");
		setSize(350, 300);
		Container contentPane = getContentPane();
		contentPane.setLayout(new BorderLayout());
		contentPane.setBackground(Color.black);
		setResizable(false);

		// creates the game object
		game = new RPSGame(0, 0, 0, 0, 0);
		
		// bet 
		game.setBet(Integer.parseInt(howMuch));
		
		// creates the labels for displaying the computer and user's move
		rockImage = new ImageIcon("C:/Users/Suen/Desktop/Java/Project/src/project4/rock.jpg");
		paperImage = new ImageIcon("C:/Users/Suen/Desktop/Java/Project/src/project4/paper.jpg");
		scissorsImage = new ImageIcon("C:/Users/Suen/Desktop/Java/Project/src/project4/scissors.jpg");

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
		
		// creates the labels for the status of the game (number of wins, losses, and ties)
		statusC = new JLabel("Computer Wins: " + game.getScoreComputer());
		statusU = new JLabel("User Wins: " + game.getScoreUser());
		statusT = new JLabel("Ties: " + game.getScoreTie());
		balance = new JLabel("Balance: " + game.getBalance());
		statusC.setForeground(Color.white);
		statusU.setForeground(Color.white);
		statusT.setForeground(Color.white);
		balance.setForeground(Color.white);
		JPanel statusPanel = new JPanel();
		statusPanel.setBackground(Color.black);
		statusPanel.add(statusC);
		statusPanel.add(statusU);
		statusPanel.add(statusT);
		if (showBalance == true) {
			statusPanel.add(balance);
		}

		// the play and status panels are nested in a single panel
		JPanel gamePanel = new JPanel();
		gamePanel.setPreferredSize(new Dimension(250, 250));
		gamePanel.setBackground(Color.black);
		gamePanel.add(imageOutcomePanel);
		gamePanel.add(statusPanel);
		
		// creates the buttons and displays them in a control panel
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

	// ActionListener- GameListener
	private class GameListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			// YOUR CODE GOES HERE!
			if(event.getSource() == rockButton){
				userPlay.setIcon(rockImage);
				;
				game.playUser = game.ROCK;
			} else if (event.getSource() == paperButton) {
				userPlay.setIcon(paperImage);
				game.playUser = game.PAPER;
			} else if (event.getSource() == scissorsButton) {
				userPlay.setIcon(scissorsImage);
				game.playUser = game.SCISSORS;
			}
			userPlay.setText("User's Play");
			
			game.playComputer = game.generateComputerPlay();
			if(game.playComputer == game.ROCK) {
				computerPlay.setIcon(rockImage);
			} else if (game.playComputer == game.PAPER) {
				computerPlay.setIcon(paperImage);
			} else if (game.playComputer == game.SCISSORS) {
				computerPlay.setIcon(scissorsImage);
			}
			computerPlay.setText("Computer's Play");
			
			game.findWinner(game.playUser, game.playComputer);
		
			outcome.setText(game.message);
			statusC.setText("Computer Wins: " + game.getScoreComputer());
			statusU.setText("User Wins: " + game.getScoreUser());
			statusT.setText("Ties: " + game.getScoreTie());
			balance.setText("Balance: " + game.getBalance());
	
			}
	}
		
	public static void main(String args[]) {
		// create an object of your class
		int betOrNot = JOptionPane.showConfirmDialog(null, "Do you want to place a bet?", 
				"Play with a bet?" , JOptionPane.YES_NO_OPTION);
	    if (betOrNot == JOptionPane.YES_OPTION) {
	    	RPSGUI.howMuch = JOptionPane.showInputDialog("How much per round?");
	    } else {
	    	JOptionPane.showMessageDialog(null, "Play for fun.");
	    	showBalance = false;
	    	howMuch = "0";
	    }		
					
		RPSGUI frame = new RPSGUI();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}





