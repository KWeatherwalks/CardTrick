package com.kevinweatherwalks.cardtrick.problemdomain;

/**
 * This class is used to construct Card objects. Card objects hold the card's
 * rank, suit, and image filename path.
 */

public class Card {
	private String suit;
	private String rank;
	private String imgName;
	private final String CARD_FOLDER = "..\\classiccards\\";
	private final String IMG_TYPE = ".png";

	/**
	 * Constructor
	 * 
	 * @param s The card's suit
	 * @param r The card's rank
	 */
	public Card(String s, String r) {
		suit = s;
		rank = r;
		imgName = CARD_FOLDER + rank + "_" + suit + IMG_TYPE; // hold location of image
	}

	/**
	 * Overloaded Constructor to catch integer entries
	 * 
	 * @param s The card's suit
	 * @param r The card's integer rank
	 */
	public Card(String s, int r) {
		suit = s;

		switch (r) {
			case 1:
				rank = "Ace";
				break;
			case 13:
				rank = "King";
				break;
			case 12:
				rank = "Queen";
				break;
			case 11:
				rank = "Jack";
				break;
			case 10:
				rank = "Ten";
				break;
			default:
				rank = String.valueOf(r);

		}
		imgName = CARD_FOLDER + rank + "_" + suit + IMG_TYPE; // hold image location
	}

	/**
	 * The toString method returns a description of the Card object.
	 * 
	 * @return str The description of the card.
	 */
	public String toString() {
		String r = String.valueOf(rank.toUpperCase().charAt(0));
		String s = String.valueOf(suit.toLowerCase().charAt(0));
		String str = r + s;
		return str;
	}

	/**
	 * The getSuit method returns the suit of the card.
	 * 
	 * @return suit The card's suit
	 */
	public String getSuit() {
		return suit;
	}

	/**
	 * The getRank method returns the rank of the card.
	 * 
	 * @return rank The card's rank
	 */
	public String getRank() {
		return rank;
	}

	/**
	 * The getImgName method returns the name of the image file.
	 * 
	 * @return imgName The image filename.
	 */
	public String getImgName() {
		return imgName;
	}

}