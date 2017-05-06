package project4;

import java.util.Scanner;

public class RPSGameDriver {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		// creates the game object
		RPSGame game = new RPSGame(0,0,0,0,0);
		
		// welcome message and ask if the user wants to play with a bet
		System.out.println("Welcome to Rock, Paper, Scissors!");
		System.out.println("Do you want to play a bet? Y/ N");
		String betOption = scan.nextLine();
		
		if (betOption.equals("Y")) {
			System.out.println("How much do you want to bet?");
			int bet = Integer.parseInt(scan.nextLine());
			game.setBet(bet);
			System.out.println("Bet: " + game.getBet());
		} else {
			game.setBalance(0);
		}
		
		// the menu
		boolean menu = true;
		while(menu) {
			System.out.println("To play, enter : " + "\n" + 
							"\"r\" to play Rock" + "\n" +
							"\"p\" to play Paper" + "\n" +
							"\"s\" to play Scissors" + "\n" +
							"or any other to quit.");
		
			String option = scan.nextLine();
	
			if (option.equals("r") | option.equals("p") | option.equals("s")) {
				if (option.equals("r")) {
					game.playUser = game.ROCK;
				} else if (option.equals("p")) {
					game.playUser = game.PAPER;
				} else if (option.equals("s")) {
					game.playUser = game.SCISSORS;
				} 
				System.out.println("Yours move: " +  game.playUser);
				game.playComputer = game.generateComputerPlay();
				System.out.println("Computer's move: " +  game.playComputer);
				game.findWinner(game.playUser, game.playComputer);
				System.out.println(game.message);
				System.out.println(game.result);
			} else {
				menu = false;
				System.out.println("Bye!");
			}
			
		}
		
	}
	
}
