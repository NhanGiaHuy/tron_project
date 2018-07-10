package model;

import main.Game;

/**
 * TRON PROJECT
 * 
 * @author lborruto
 * @version 1.0
 */
public class Grid extends Game {
	
	// The total of pixels the game could possibly have
	private static int playGrid = (width * height) / (Pixel.getPixel() * Pixel.getPixel());

	/**
	 * 
	 * Used to set the total of pixel we could have
	 * 
	 *
	 */
	public static int getGrid() {
		return playGrid;
	}

}
