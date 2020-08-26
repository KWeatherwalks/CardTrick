package cardtrick.problemdomain;

import java.util.*; // for ArrayList

/**
 * This class creates a playing card deck object using the Card class
 * constructor to build a set of cards.
 */
public class CardDeck extends CardTrick {
	private ArrayList<Card> cards = new ArrayList<>();

	/**
	 * Default constructor builds a 52 card standard deck of playing cards.
	 */
	public CardDeck() {
		// Create a 52 card playing card deck
		String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };

		for (String s : suits) {
			for (int i = 1; i <= 13; i++) {
				cards.add(new Card(s, i));
			}
		}
	}

	/**
	 * The setCards method takes an ArrayList of card objects and adds them to the
	 * CardDeck object.
	 * 
	 * @param cardList The array of cards to be added to CardDeck object
	 */
	public void setCards(ArrayList<Card> cardList) {
		while (cards.size() > 0)
			cards.remove(0);
		for (Card c : cardList)
			cards.add(c);
	}

	/**
	 * The toString method returns a description of the deck.
	 * 
	 * @return str The description of the CardDeck object
	 */
	public String toString() {
		String str = "Standard deck with " + cards.size() + " cards.";
		return str;
	}

	/**
	 * The shuffleDeck method performs random sort of CardDeck object.
	 */
	public void shuffleDeck() {
		ArrayList<Card> freshDeck = new ArrayList<>();
		Random randIndex = new Random(); // Create random object
		int randCard;

		while (cards.size() > 0) {
			randCard = randIndex.nextInt(cards.size());
			freshDeck.add(cards.get(randCard));
			cards.remove(randCard);
		}

		cards = freshDeck;
	}

	/**
	 * The pruneDeck method keeps the first n cards in the CardDeck object.
	 * 
	 * @param n The number of cards in final deck
	 */
	public void pruneDeck(int n) {
		while (n < cards.size()) {
			cards.remove(cards.size() - 1);
		}
	}

	/**
	 * addCard method
	 * 
	 * @param c Card to be inserted
	 */
	public void addCard(Card c) {
		cards.add(c);
	}

	/**
	 * The getCards method returns an ArrayList of Card objects.
	 * 
	 * @return cards The list of Card objects.
	 */
	public ArrayList<Card> getCards() {
		return cards;
	}

}