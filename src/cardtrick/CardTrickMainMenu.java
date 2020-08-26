package cardtrick;

// for windows
import java.awt.Dimension;
import java.awt.GridLayout;
// for action listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

// for JPanel
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

// for local
import cardtrick.problemdomain.CardDeck;
import cardtrick.problemdomain.CardTrick;
import cardtrick.problemdomain.Pile;
import cardtrick.userinterface.MainWindow;

/**
 * This class serves as the main menu for the card trick program. Buttons are
 * contained in a GridLayout manager.
 */
public class CardTrickMainMenu extends JFrame {
	private final int WINDOW_WIDTH = 150; // Window width
	private final int WINDOW_HEIGHT = 250; // Window height

	/**
	 * Constructor
	 */
	public CardTrickMainMenu() {
		// Set title and lock size of the window.
		setTitle("The n Card Trick");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Add a GridLayout manager to the content pane.
		setLayout(new GridLayout(5, 1));

		// Create buttons
		JButton button1 = new JButton("27 Card Trick");
		JButton button2 = new JButton("49 Card Trick");
		JButton button3 = new JButton("Settings");
		JButton button4 = new JButton("How it works");
		JButton button5 = new JButton("Statistics");

		// Set size of buttons
		Dimension btnSize = new Dimension(WINDOW_WIDTH - 10, WINDOW_HEIGHT / 5 - 10);
		button1.setPreferredSize(btnSize);
		button2.setPreferredSize(btnSize);
		button3.setPreferredSize(btnSize);
		button4.setPreferredSize(btnSize);
		button5.setPreferredSize(btnSize);

		// Create labels (NA)
		// Create panels
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();

		// Register action listeners
		button1.addActionListener(new Trick1ButtonListener());

		// Add labels to panels (NA)
		// Add buttons to panels
		panel1.add(button1);
		panel2.add(button2);
		panel3.add(button3);
		panel4.add(button4);
		panel5.add(button5);

		// Add panels to content pane
		add(panel1);
		add(panel2);
		add(panel3);
		add(panel4);
		add(panel5);

		// Disable inactive buttons
		button2.setEnabled(false);
		button3.setEnabled(false);
		button4.setEnabled(false);
		button5.setEnabled(false);

		// Display window
		pack();
		setLocationRelativeTo(null);
		setVisible(true);

		JButton escButton = new JButton("Exit");
		escButton.setMnemonic(KeyEvent.VK_ESCAPE);
		escButton.addActionListener(new EscButtonListener());

	}// End constructor

	/**
	 * Private inner class to handle 27 Card Trick button press.
	 */
	private class Trick1ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Initialize objects
			CardTrick cTrick = new CardTrick();
			CardDeck deck = new CardDeck();
			deck.shuffleDeck();
			deck.pruneDeck(cTrick.getNCards());
			Pile piles = new Pile(deck, cTrick.getNPiles());

			// Begin trick
			MainWindow main = new MainWindow(piles, cTrick);

			dispose(); // exit this window
		}
	}

	private class EscButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// Exit program
			System.exit(0);
		}
	}

	/**
	 * Main method creates instance of CardTrickMainMenu
	 * 
	 * @param args The arguments being passed to main method
	 */
	public static void main(String[] args) {
		new CardTrickMainMenu();
	}

}