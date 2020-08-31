package com.kevinweatherwalks.cardtrick.userinterface;

// for grid layout
import java.awt.GridLayout;

// for JPanel
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kevinweatherwalks.cardtrick.problemdomain.Card;
import com.kevinweatherwalks.cardtrick.problemdomain.CardTrick;

public class CardQueryPanel extends JPanel {
	/**
	 * This class creates a panel to display the selected card and provide final
	 * instructions.
	 */

	private static final long serialVersionUID = 3151049508028779330L;
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