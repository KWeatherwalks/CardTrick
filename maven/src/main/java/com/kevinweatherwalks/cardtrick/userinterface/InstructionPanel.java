package com.kevinweatherwalks.cardtrick.userinterface;

import java.awt.Font;

// for JLabel
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.kevinweatherwalks.cardtrick.problemdomain.CardTrick;

/**
 * This class holds information to be displayed in the main menu during the card
 * trick.
 */

public class InstructionPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1252905795018160450L;
	private JLabel instrLabel;

	/**
	 * Constructor
	 * 
	 * @param ct The card trick object
	 */
	public InstructionPanel(CardTrick ct) {
		// Create label
		instrLabel = new JLabel(ct.getInstruction(0));
		instrLabel.setFont(new Font("Serif", Font.BOLD, 36));

		// Add to panel
		add(instrLabel);
	}

	/**
	 * The setInstrLabel method updates the information to be displayed in the main
	 * window.
	 * 
	 * @param txt The new instruction
	 */
	public void setInstrLabel(String txt) {
		instrLabel.setText(txt);
	}

}