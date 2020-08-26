package cardtrick;

/**
 * This class holds the configuration settings for the entire program. Window
 * settings for various computer screens are held here as well as file path
 * information.
 */
public class Settings {
	private int resX; // Hold system resolution width
	private int resY; // Hold system resolution height
	private String root; // Hold program's folder location

	/**
	 * no-arg Constructor
	 */
	public Settings() {
		// Default resolution settings
		resX = 1366;
		resY = 768;

		root = "";
	}

	/**
	 * setResolution method
	 * 
	 * @param x The width of the screen (in pixels)
	 * @param y The height of the screen (in pixels)
	 */
	public void setResolution(int x, int y) {
		resX = x;
		resY = y;
	}

	/**
	 * The setRoot method sets the location of the program.
	 * 
	 * @param r The folder location
	 */
	public void setRoot(String r) {
		root = r;
	}

	/**
	 * The getResX method returns the maximum pixel width for the program.
	 * 
	 * @return The pixel width of program window.
	 */
	public int getResX() {
		return resX;
	}

	/**
	 * The getResY method returns the maximum pixel height for the program.
	 * 
	 * @return The pixel height of program window.
	 */
	public int getResY() {
		return resY;
	}

}