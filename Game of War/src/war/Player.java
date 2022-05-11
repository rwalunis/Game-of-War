package war;

import java.util.ArrayList;
import java.util.List;

public class Player {

	public String name;
	public int score;
	public List<Card> hand = new ArrayList<>();

	public Player(String name) {
		this.score = 0;
		this.name = name;
		if (name != "Computer") {
		System.out.println("Player name: " + name);
	}
	}
	public void sneakChoice (String answer, Player player1) {
		if (answer.equalsIgnoreCase("yes")) {
			System.out.println("Shhh..." + player1.getName() + ", I won't tell the computer...");
			List<Card> playerOneHand = player1.getHand();
			for (Card card : playerOneHand) {
				System.out.println(card.getName());
			}
		} else if (answer.equalsIgnoreCase("no")) {
			System.out.println("Okay, no cheating for you.");
		} else {
			System.out.println("I don't understand your response...We will move on.");
		}
	}

	public void describe() {
		System.out.println("Player name: " + name);
		for (Card card : hand) {
			card.describe();
		}
	}

	public void draw(Deck deck) { // This method draws upon the deck, and then adds that drawn card to the hand of									// cards.
		hand.add(deck.draw());
	}

	public Card flip() {
		return hand.remove(0);

	}

	public void incrementScore() {
		score++;
	}

	public int getScore() {
		return score;
	}

	public String getName() {
		return name;

	}
	
	

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

	public Card getCard () {
		return getCard();
	}
}
