package cardtrick.problemdomain;

import java.util.ArrayList;

/**
 * This class creates CardTrick objects. A Card trick object holds the number of
 * cards to be used, the number of piles necessary, and the number of rounds
 * necessary to complete the particular trick. Additionally, anything that may
 * describe the card trick is held in an instance of this class' object.
 */
public class CardTrick {
	private int numCards, numPiles, numRounds;
	private int chosenNum;
	private int imgResX, imgResY;

	private String magicNum, magicStr;
	private String title;
	private ArrayList<String> instruct;

	/**
	 * Default Constructor 27 Card Trick
	 */
	public CardTrick() {
		title = "The 27 Card Trick";
		numCards = 27;
		numPiles = 3;
		numRounds = 3;
		chosenNum = 1;
		magicNum = numToString(decToBaseN(chosenNum, numPiles), numRounds);
		magicStr = reverseMagicNum(magicNum);
		imgResX = (int) (72);
		imgResY = (int) (96);

		// Build instructions
		instruct = new ArrayList<>();
		instruct.add("Memorize the rank and suit of one card");
		instruct.add("Which pile is your card in?");
		for (int i = 1; i < numRounds; i++)
			instruct.add("Which pile is your card in now?");
		instruct.add("Your card is ");
	}

	/**
	 * Overloaded constructor to create additional tricks. Possible configurations:
	 * 4,8,9,16,25,27,49 cards 2,2,3, 4, 5, 3, 7 piles 2,3,2, 2, 2, 3, 2 rounds
	 * 
	 * @param nCards  The number of cards to use in the trick
	 * @param nPiles  The number of piles necessary
	 * @param nRounds The number of rounds necessary
	 */
	public CardTrick(int nCards, int nPiles, int nRounds) {
		title = "The " + nCards + " Card Trick";
		numCards = nCards;
		numPiles = nPiles;
		numRounds = nRounds;
		magicNum = numToString(decToBaseN(chosenNum, numPiles), numRounds);
		// Build instructions
		instruct = new ArrayList<>();
		instruct.add("Memorize the rank and suit of one card");
		instruct.add("Which pile is your card in?");
		for (int i = 1; i <= numRounds; i++)
			instruct.add("Which pile is your card in now?");
	}

	/**
	 * The setChosenNum method updates the number chosen by the user.
	 * 
	 * @param n The number chosen
	 */
	public void setChosenNum(int n) {
		chosenNum = n - 1;
		magicNum = numToString(decToBaseN(chosenNum, numPiles), numRounds);
		magicStr = reverseMagicNum(magicNum);
	}

	/**
	 * The setImgRes method sets the dimensions for the card images.
	 * 
	 * @param x The card image's pixel width
	 * @param y The card image's pixel height
	 */
	public void setImgRes(int x, int y) {
		imgResX = x;
		imgResY = y;
	}

	/**
	 * The reverseMagicNum method reverses the ordering of the number converted to
	 * base nPiles so it can be easily compared to the selected piles.
	 * 
	 * @param mStr The string to be reversed
	 * @return The magic number string
	 */
	public String reverseMagicNum(String mStr) {
		String revStr = "";
		for (int i = mStr.length() - 1; i >= 0; i--)
			revStr += String.valueOf(mStr.charAt(i));
		return revStr;
	}

	/**
	 * The decToBaseN method converts a decimal number into a base n number.
	 * 
	 * @param num  The decimal number being converted
	 * @param base The base of the new number system
	 * @return The converted number
	 */
	public static int decToBaseN(int num, int base) {
		int rem; // hold the remainder
		int number = 0, // build the return value
				place = 1; // hold place value counter

		while (num > 0) {
			rem = num % base; // get remainder
			num = (num - rem) / base; // reduce the initial number
			number += rem * place; // build return value
			place *= 10; // increase place value
		}
		return number;
	}

	/**
	 * The numToString method converts an integer into a string so it may be easily
	 * looped over.
	 * 
	 * @param num    The number being converted
	 * @param digits The total number of place values to be used
	 * @return The number as a string
	 */
	public static String numToString(int num, int digits) {
		String str = String.valueOf(num);
		while (str.length() < digits) {
			str = "0" + str;
		}
		return str;
	}

	/**
	 * The getNCards method returns the number of cards used in the trick.
	 * 
	 * @return The number of cards
	 */
	public int getNCards() {
		return numCards;
	}

	/**
	 * The getNPiles method returns the number of piles used in each round of the
	 * trick.
	 * 
	 * @return The number of piles
	 */
	public int getNPiles() {
		return numPiles;
	}

	/**
	 * The getNRounds method returns the number of rounds necessary for the trick to
	 * work.
	 * 
	 * @return The number of rounds
	 */
	public int getNRounds() {
		return numRounds;
	}

	/**
	 * The getChosenNum method returns the number chosen by the user.
	 * 
	 * @return The number chosen
	 */
	public int getChosenNum() {
		return chosenNum;
	}

	/**
	 * The getMagicNum method returns the number chosen by the user in String
	 * format.
	 * 
	 * @return The magic number string
	 */
	public String getMagicNum() {
		return magicNum;
	}

	/**
	 * The getImgResX method returns the pixel width of the card image.
	 * 
	 * @return The card image's width
	 */
	public int getImgResX() {
		return imgResX;
	}

	/**
	 * The getImgResY method returns the pixel height of the card image.
	 * 
	 * @return The card image's height
	 */
	public int getImgResY() {
		return imgResY;
	}

	/**
	 * The getTitle method returns the title of the trick.
	 * 
	 * @return The title to be displayed
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * The getMagicStr method returns the reversed magic number string.
	 * 
	 * @return The reversed magicNum string
	 */
	public String getMagicStr() {
		return magicStr;
	}

	/**
	 * The getInstruction method returns the information to be displayed at the top
	 * of the main window during the card trick.
	 * 
	 * @param n The index of the instruction array
	 * @return The instruction to be displayed
	 */
	public String getInstruction(int n) {
		return instruct.get(n);
	}
}