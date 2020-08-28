package cardtrick.userinterface;

import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cardtrick.problemdomain.Card;
import cardtrick.problemdomain.CardTrick;
import cardtrick.problemdomain.Pile;

/**
 * This class constructs the images for all of the cards to be displayed during
 * the card trick.
 */
public class PilePanel extends JPanel {
	private ArrayList<String> imgNameArr;
	private ArrayList<ImageIcon> imgArr;
	private ArrayList<JPanel> panelArr;

	private int rows, cols; // fields for the piles.

	/**
	 * Constructor
	 * 
	 * @param p  The cards to be displayed
	 * @param ct The card trick being used
	 */
	public PilePanel(Pile p, CardTrick ct) {
		// GridLayout
		rows = ct.getNPiles();
		cols = ct.getNCards() / rows;
		setLayout(new GridLayout(rows, cols, 0, 10));

		// Construct images
		// Set list of image filenames
		imgNameArr = new ArrayList<>();
		for (int i = 0; i < p.getNPiles(); i++) {
			for (Card c : p.getPiles().get(i)) {
				imgNameArr.add(c.getImgName());
			}
		}

		// Set list of image icons
		imgArr = new ArrayList<>();
		imgArr = buildImageArray(imgNameArr, p);

		// Create panels
		panelArr = new ArrayList<>();
		for (int i = 0; i < p.getNPiles(); i++) {
			for (Card c : p.getPiles().get(i)) {
				panelArr.add(new JPanel());
			}
		}

		// Add images to panels
		for (int i = 0; i < panelArr.size(); i++)
			panelArr.get(i).add(new JLabel(imgArr.get(i)));
		// Add panels to content pane
		for (JPanel pan : panelArr)
			add(pan);

	}// End of PilePanel constructor

	/**
	 * The buildImageArray method constructs an array list of image objects to be
	 * displayed in the PilePanel.
	 * 
	 * @param arr The array of image filenames
	 * @param p   The cards to be used
	 * @return The image array to be displayed
	 */
	private ArrayList<ImageIcon> buildImageArray(ArrayList<String> arr, Pile p) {
		ArrayList<ImageIcon> imgArr = new ArrayList<>();
		Image img = null;
		for (String i : arr) {
			try {
				img = ImageIO.read(new File(i));
			} catch (IOException e) {
				System.out.println("Image not found at path   " + i)
				e.printStackTrace();
			}
			img = img.getScaledInstance(p.getImgResX(), p.getImgResY(), Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(img);
			imgArr.add(imgIcon);
		}
		return imgArr;
	}

}