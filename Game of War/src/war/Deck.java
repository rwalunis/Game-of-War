package war;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> cards;

	public Deck() {
		cards = new ArrayList<Card>();
		for (int i = 2; i < 15; i++) {
			Card card = new Card(i, "Diamonds");
			cards.add(card);
		}
		for (int i = 2; i < 15; i++) {
			Card card = new Card(i, "Hearts");
			cards.add(card);
		}
		for (int i = 2; i < 15; i++) {
			Card card = new Card(i, "Spades");
			cards.add(card);
		}
		for (int i = 2; i < 15; i++) {
			Card card = new Card(i, "Clubs");
			cards.add(card);
		}

	}

	public void describe() {
		for (Card card : cards) {
			card.describe();
		}
	}

	public void shuffle() {
		Collections.shuffle(cards);
	}

	public Card draw() { // This method gets and removed the first card of the deck of cards.
		Card drawnCard = cards.get(0);
		cards.remove(drawnCard);
		return drawnCard;
	}

	public void createPlayersHands(Deck deck, Player player1, Player player2) {
		for (int i = 0; i < 52; i++) {
			if (i % 2 == 0) { // This loop ensures that each player is drawing half of the cards into their hand
				player1.draw(deck);
			} else {
				player2.draw(deck);
			}
		}
	}

	public void getPlayersScores(Player player1, Player player2) {
		for (int i = 0; i < 26; i++) { // The flip method is iterated 26 times for each player's hand w/a for loop.
			Card card1 = player1.flip();
			Card card2 = player2.flip();
			if (card1.getValue() > card2.getValue()) {
				player1.incrementScore();
			} else if (card1.getValue() < card2.getValue()) {
				player2.incrementScore();
			}
		}
		if (player1.getScore() > player2.getScore()) {
			System.out.println("*****" + player1.getName() + " wins! " + player1.getName() + "'s Score: "
					+ player1.getScore() + "\n" + player2.getName() + "'s score: " + player2.getScore());
		} else if (player2.getScore() > player1.getScore()) {
			System.out.println("*****" + player2.getName() + " wins! " + player2.getName() + "'s Score: "
					+ player2.getScore() + "\n" + player1.getName() + "'s score: " + player1.getScore());
		} else {
			System.out.println("*****DRAW*****");
		}
	}
}
