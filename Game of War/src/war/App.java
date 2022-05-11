package war;

import java.util.Scanner;

public class App {

	static Scanner p1 = new Scanner(System.in);

	public static void main(String[] args) {
		Deck deck1 = new Deck();
		System.out.println(
				"***Here is the deck of cards.  There are 52 cards total with values \n ranging " + "from 2-14***");
		deck1.describe();
		deck1.shuffle();		
		System.out.println("Can you beat the computer in a game of war? You and the computer will each be given a hand of cards."
				+ " \n Each card in your hand will be compared to the computer's hand.  The card with the higher value gets one point."
				+ "\n The player with the most points wins. "
				+ "\n Type your name and then press 'Enter':");
		String playerOneName = p1.nextLine();
		Player player1 = new Player(playerOneName);
		Player computerPlayer = new Player("Computer");
		System.out.println("Hi, " + player1.getName());
		deck1.createPlayersHands(deck1, player1, computerPlayer);
		System.out.println("***The deck has been shuffled and the hands have been delt*** \n"
		+ "***Would you like to take a sneak peak at your cards to see if you have a chance at winning?"
						+ " \n Type 'yes' or 'no.' \n Type your response and then press 'Enter':");
		String sneakChoice = p1.nextLine();
        player1.sneakChoice(sneakChoice, player1);
        System.out.println("Press 'enter' to see who wins...");
        String pressEnter = p1.nextLine();
		deck1.getPlayersScores(player1, computerPlayer);

	}
}
