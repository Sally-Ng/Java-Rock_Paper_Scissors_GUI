package project4;

import java.util.Random;

public class RPSGame {	 
    // play
	String playComputer;
	String playUser;	
	
	// game result 
    private int scoreUser;
    private int scoreComputer;
    private int scoreTie;
    	
    // paper, rock, scissors
    String PAPER = "Paper";
    String ROCK = "Rock";
    String SCISSORS = "Scissors";
    
    // paper, rock, scissors winner
    String winnerPaper = "Paper eats rock! ";
    String winnerRock = "Rock Smashes Scissors! ";
    String winnerScissors = "Scissors Shred Paper! ";
		
	// game result messages
	String message;
	String result;
	String who;
	String messageUserWin = "User wins!";
	String messageComputerWin = "Computer wins!";
	String messageTie = "It is a Tie!"; 
    
    // betting
    private int bet = 0;
    private int balance = 0;
    
    // constructor 
    public RPSGame(int initalScoreUser, int initalScoreComputer, int initalScoreTie, int initalBet, int initalBalance) {
    	scoreUser= initalScoreUser;
    	scoreComputer = initalScoreComputer;
    	scoreTie = initalScoreTie;
    	bet = initalBet;
    	balance = initalBalance;
    }
    
    // getter
    public int getScoreUser() {
    	return scoreUser;
    }
    public int getScoreComputer() {
    	return scoreComputer;
    }    
    public int getScoreTie() {
    	return scoreTie;
    }
    public int getBet() {
    	return bet;
    }
    public int getBalance() {
    	return balance;
    }
    
    // setter
    public void setScoreUser(int newScoreUser) {
    	scoreUser = newScoreUser;
    }
    public void setScoreComputer(int newScoreComputer) {
    	scoreComputer = newScoreComputer;
    }
    public void setScoreTie(int newScoreTie) {
    	scoreTie = newScoreTie;
    }    
    public void setBet(int newBet) {
    	bet = newBet;
    }   
    public void setBalance(int newBalance) {
    	balance = newBalance;
    }   
    
    //generateComputerPlay method
    public String generateComputerPlay() {
    	Random generator = new Random(); 
    	int playComputerInt = generator.nextInt(3)+1; 
    	if (playComputerInt == 1)
    		playComputer = PAPER;
        if (playComputerInt == 2)
    		playComputer = ROCK;
        if (playComputerInt == 3)
    		playComputer = SCISSORS;
        return playComputer;
    }
         
    // findWinner method 
    public String findWinner(String user, String computer) {
    	if (user == PAPER) {
    		if (computer == PAPER) {
    			message = messageTie;
        	    scoreTie += 1;	
        	    balance += 0;
    		} else if (computer == ROCK) {
    			message = winnerPaper + messageUserWin;
        		scoreUser += 1;
        		balance += bet;
    		} else if (computer == SCISSORS) {
    			message = winnerScissors + messageComputerWin;
        		scoreComputer += 1;
        		balance -= bet;
    		}
    	}
    	
    	if (user == ROCK) {
    		if (computer == PAPER) {
    			message= winnerPaper + messageComputerWin;
        		scoreComputer += 1;
        		balance -= bet;
    		} else if (computer == ROCK) {
    			message = messageTie;
        	    scoreTie += 1;	
        	    balance += 0;
    		} else if (computer == SCISSORS) {
    			message = winnerRock + messageUserWin;
        		scoreUser += 1;
        		balance += bet;
    		}
    	}
    	
    	if (user == SCISSORS) {
    		if (computer == PAPER) {
    			message = winnerScissors + messageUserWin;
        		scoreUser += 1;
        		balance += bet;
    		} else if (computer == ROCK) {
    			message = winnerRock + messageComputerWin;
        		scoreComputer += 1;
        		balance -= bet;
    		} else if (computer == SCISSORS) {
    			message = messageTie;
        	    scoreTie += 1;	
        	    balance += 0;
    		}
    	}
    	
    	// the result
    	result = "Ties: " + scoreTie + " Wins: " + scoreUser + " Losses: " + scoreComputer + " Balance: " + balance;
    	return message;
    }   
    
}
