package cardtrick.userinterface;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cardtrick.CardTrickMainMenu;
import cardtrick.Settings;
import cardtrick.problemdomain.Card;
import cardtrick.problemdomain.CardDeck;
import cardtrick.problemdomain.CardTrick;
import cardtrick.problemdomain.Pile;

/**
 * This class handles all of the GUI enviroment's methods, event handling, and
 * displays all of the information necessary to run through a card trick.
 */
public class MainWindow extends JFrame {
	private PilePanel cards;
	private InstructionPanel instructions;
	private CardQueryPanel cQuery;
	private CardTrick cTrick;
	private Pile piles;
	private Settings config = new Settings();
	private CardDeck mergeDeck = new CardDeck();
	private JButton nextButton, exitButton;
	private JComboBox chosenNumBox;
	private JLabel numLabel, pileLabel;
	private ArrayList<JTextField> pileSelection;
	ArrayList<JButton> buttonArr;
	private JPanel buttonPanel, pileButtonPanel;

	private int round = 0; // index tells which stage program is in
	private int chosenPile;
	private ArrayList<String> selectedPiles;

	/**
	 * Constructor
	 * 
	 * @param p  The cards being displayed
	 * @param ct The card trick object
	 */
	public MainWindow(Pile p, CardTrick ct) {
		// Set cardTrick and initialize variables
		piles = p;
		cTrick = ct;
		selectedPiles = new ArrayList<>();

		// Construct main window
		// Title
		setTitle(cTrick.getTitle());
		// Set size and lock window.
		setSize(config.getResX(), config.getResY());
		setResizable(false);

		// Specify close action
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// BorderLayout
		setLayout(new BorderLayout());

		// Create custom panels
		cards = new PilePanel(piles, cTrick);
		instructions = new InstructionPanel(cTrick);

		// Build panels
		buildButtonPanel(cTrick);

		// Add components to content pane
		add(cards, BorderLayout.CENTER);
		add(instructions, BorderLayout.NORTH);
		add(buttonPanel, BorderLayout.SOUTH);

		// Pack contents and display
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		validate();
	}

	/**
	 * The buildButtonPanel method builds the panel for all components on the bottom
	 * of the main window.
	 * 
	 * @param ct The card trick object
	 */
	private void buildButtonPanel(CardTrick ct) {
		// Create panel for buttons
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());

		// Create list for number selection for ComboBox
		String[] numbers = new String[ct.getNCards()];
		for (int i = 0; i < ct.getNCards(); i++)
			numbers[i] = String.valueOf(i + 1);

		// Create ComboBox
		chosenNumBox = new JComboBox(numbers);

		// Create uneditable text field
		pileSelection = new ArrayList<>();
		for (int i = 0; i < ct.getNCards(); i++) {
			pileSelection.add(new JTextField(1));
			// Disable the text field
			pileSelection.get(i).setEditable(false);
		}

		// Create labels
		numLabel = new JLabel("Select a number from the drop-box" + " and click NEXT");
		pileLabel = new JLabel("Piles selected:");

		// Create buttons
		nextButton = new JButton("NEXT");
		nextButton.setMnemonic(KeyEvent.VK_N);
		exitButton = new JButton("EXIT");
		exitButton.setMnemonic(KeyEvent.VK_X);

		// Register action listeners
		nextButton.addActionListener(new NextButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		chosenNumBox.addActionListener(new NumBoxListener());

		// Add buttons to button panel
		buttonPanel.add(numLabel);
		buttonPanel.add(chosenNumBox);
		buttonPanel.add(nextButton);
		buttonPanel.add(exitButton);

	}

	/**
	 * The buildPileButtonPanel method constructs the buttons to be used for pile
	 * selection.
	 * 
	 * @param ct The card trick object
	 */
	private void buildPileButtonPanel(CardTrick ct) {
		// Create new panel
		pileButtonPanel = new JPanel();

		// GridLayout
		pileButtonPanel.setLayout(new GridLayout(ct.getNPiles(), 1));

		// Build pile panel array and button label array
		// Register action listeners
		buttonArr = new ArrayList<>();
		for (int i = 1; i <= cTrick.getNPiles(); i++) {
			buttonArr.add(new JButton("Pile " + i));
			// VK_i for i=0thru9 => integer values 48thru57
			buttonArr.get(i - 1).setMnemonic(i + 48);
			buttonArr.get(i - 1).addActionListener(new PileButtonListener());
		}

		// Add buttons to grid
		for (JButton btn : buttonArr)
			pileButtonPanel.add(btn);
	}

	/**
	 * Private inner class that handles event when user clicks Next button.
	 */
	private class NextButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (round == 0) {
				// Initialize Round 0 operations
				remove(cards); // remove pilePanel from BorderLayout
				initialOps(); // Run through initialization operations
				revalidate(); // Refresh screen
				round++; // Increment round
			} // END InitialOps

			else if (round < cTrick.getNRounds()) {
				// Pile Selection Operations
				remove(cards); // remove pilePanel from BorderLayout
				pileSelOps(); // Run through pile selection operations
				revalidate(); // Refresh screen
				round++; // Increment round
			} // END PileSelOps

			// LAST OPERATION
			else {
				remove(cards); // remove pilePanel from BorderLayout
				pileSelOps(); // run through pile selection operations
				revalidate(); // refresh screen

				// Disable buttons after last round
				for (JButton b : buttonArr)
					b.setEnabled(false);

				// Call cardQuery routine
				remove(pileButtonPanel); // remove pileButtonPanel from BorderLayout
				cardQuery(); // "Is this your card?" routine
				revalidate(); // Refresh screen
			} // END cardQuery
		}
	}

	/**
	 * Private inner class handling Exit event Returns user to main menu
	 */
	private class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new CardTrickMainMenu();
			dispose(); // exit this window
		}
	}

	/**
	 * Private inner class handles event when user adjusts the number selection box.
	 */
	private class NumBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Get selected number
			String selection = (String) chosenNumBox.getSelectedItem();

			// Set selected number
			cTrick.setChosenNum(Integer.parseInt(selection));
		}
	}

	/**
	 * Private inner class handles event when user clicks a pile selection button.
	 */
	private class PileButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Get action command
			String actionCommand = e.getActionCommand();

			// Pile button operations
			pileBtnOps(actionCommand);
			revalidate();
		}
	}

	private void initialOps() {
		// Disable number box
		chosenNumBox.setEnabled(false);
		// Show pile buttons
		buildPileButtonPanel(cTrick);
		add(pileButtonPanel, BorderLayout.EAST);
		// Update instructions
		instructions.setInstrLabel(cTrick.getInstruction(round + 1));
		// Update text fields
		numLabel.setText("Your chosen number:");
		nextButton.setEnabled(false); // Disable 'Next' button
		buttonPanel.add(pileLabel); // Add selected pile label

		// Merge, shuffle cards and update pile panel
		mergeDeck.setCards(piles.mergePiles(piles));
		mergeDeck.shuffleDeck();
		piles.setPileDeck(mergeDeck);

		// THIS WORKS BUT MAY BE CLUNKY?
		// Refresh cards
		piles = new Pile(mergeDeck, cTrick.getNPiles());
		cards = new PilePanel(piles, cTrick);
		add(cards, BorderLayout.CENTER);

	}

	private void pileSelOps() {
		instructions.setInstrLabel(cTrick.getInstruction(round + 1));
		buttonPanel.add(pileSelection.get(round)); // Add JTextField for pile number
		nextButton.setEnabled(false);

		// Store selection
		selectedPiles.add(pileSelection.get(round).getText());
		// Rebuild button panel
		int ps = Integer.parseInt(String.valueOf(selectedPiles.get(round - 1))) - 1;
		int c = Integer.parseInt(String.valueOf(cTrick.getMagicStr().charAt(round - 1)));
		piles.orderPiles(c, ps);
		// Re-combine piles
		// THIS CODE WORKS BUT THERE MAY BE BETTER METHOD?
		mergeDeck.setCards(piles.mergePiles(piles));
		piles.setPileDeck(mergeDeck);
		piles = new Pile(mergeDeck, cTrick.getNPiles());

		cards = new PilePanel(piles, cTrick);
		add(cards, BorderLayout.CENTER);

	}

	/**
	 * The pileBtnOps method runs through the necessary methods that save the pile
	 * selection.
	 * 
	 * @param a The action command to be compared to button
	 */
	private void pileBtnOps(String a) {
		// Find selected pile
		for (int i = 1; i <= cTrick.getNPiles(); i++) {
			if (a.equals("Pile " + i)) {
				// Add pile selection to main window
				buttonPanel.add(pileSelection.get(round));
				pileSelection.get(round).setText(String.valueOf(i));

				// Enable 'Next' button
				nextButton.setEnabled(true);
			}
		}

	}

	private void cardQuery() {
		CardDeck pDeck = piles.getPileDeck();
		Card c = pDeck.getCards().get(cTrick.getChosenNum());

		// Is this your card?
		cQuery = new CardQueryPanel(c);
		add(cQuery, BorderLayout.CENTER);
	}
}