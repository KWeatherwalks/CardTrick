package cardtrick.problemdomain;

import java.util.*; // for ArrayList

/**
 * This class splits a deck of cards into multiple piles, which is an array list
 * of an array list of Card objects. The class provides methods for manipulating
 * the piles to perform the card trick.
 */
public class Pile extends CardDeck {
	private ArrayList<ArrayList<Card>> piles = new ArrayList<>();
	private CardDeck pileDeck;

	/**
	 * Constructor
	 * 
	 * @param deck The deck of cards to split
	 * @param num  The number of piles
	 */
	public Pile(CardDeck deck, int num) {
		pileDeck = deck;
		int numCards = pileDeck.getCards().size();
		ArrayList<Card> pile = new ArrayList<>();

		for (int i = 0; i < num; i++) {
			while (pile.size() > 0)
				pile.remove(0);
			for (int j = i; j < numCards; j += num)
				pile.add(pileDeck.getCards().get(j));
			piles.add(new ArrayList<Card>(pile));
		}
	}

	/**
	 * orderPiles method
	 * 
	 * @param secNum  The chosen number
	 * @param secPile The pile location
	 */
	public void orderPiles(int secNum, int secPile) {
		ArrayList<Card> temp = new ArrayList<>();

		// If the pile is already located where it needs to be,
		// then it does not need to be ordered.
		// Otherwise, put the pile in its proper location.
		if (secNum != secPile) {
			temp = piles.remove(secPile); // Remove the pile from the deck, hold the value
			piles.add(secNum, temp); // Insert the pile where it needs to be

			// Reset the pileDeck
			ArrayList<Card> temp2 = new ArrayList<>();
			for (int i = 0; i < piles.size(); i++)
				for (Card c : piles.get(i)) {
					temp2.add(c);
				}
			pileDeck.setCards(temp2);
		}
	}

	/**
	 * mergePiles method
	 * 
	 * @param splitdeck Deck to be merged
	 * @return The merged card deck
	 */
	public ArrayList<Card> mergePiles(Pile splitdeck) {
		ArrayList<Card> mergedDeck = new ArrayList<Card>();

		for (int i = 0; i < 3; i++) {
			for (Card c : splitdeck.getPiles().get(i)) {
				mergedDeck.add(c);
			}
		}
		return mergedDeck;
	}

	public void setPileDeck(CardDeck d) {
		pileDeck = d;
	}

	/**
	 * getPiles method
	 * 
	 * @return piles The distinct piles
	 */
	public ArrayList<ArrayList<Card>> getPiles() {
		return piles;
	}

	public CardDeck getPileDeck() {
		return pileDeck;
	}

	/**
	 * toString method
	 * 
	 * @return The cards in the piles
	 */
	public String toString() {
		String str = String.valueOf(piles);
		return str;
	}

}