package cardtrick.userinterface;

// for grid layout
import java.awt.GridLayout;

// for JPanel
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cardtrick.problemdomain.Card;
import cardtrick.problemdomain.CardTrick;

/**
 * This class creates a panel to display the selected card and provide final
 * instructions.
 */

public class CardQueryPanel extends JPanel {
	private JLabel queryLabel;
	private JPanel queryPanel;
	private CardTrick cTrick;
	private ImageIcon cImage;

	public CardQueryPanel(Card cd) {
		// Create panels
		queryPanel = new JPanel();

		// GridLayout
		setLayout(new GridLayout(2, 2, 15, 15));

		// Create Label
		queryLabel = new JLabel("Drum roll, please...");

		// Create image
		cImage = new ImageIcon(cd.getImgName());

		// Add image to label
		queryLabel.setIcon(cImage);
		queryLabel.setText(null);

		// Add to panels
		queryPanel.add(queryLabel);

		// Add panels to grid
		add(queryPanel);

		// Show panel
		setVisible(true);
	}
}