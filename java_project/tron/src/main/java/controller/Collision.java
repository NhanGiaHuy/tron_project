package controller;

import model.Players;

/**
 * TRON PROJECT
 * 
 * @author lborruto
 * @version 1.0
 */
public class Collision {

	/**
	 * 
	 * Check the collisions between our lightcycles and itself colPlayer = p1, p2,
	 * noCollision
	 * 
	 */
	public String checkCollisions(Players p1, Players p2) {

		String colPlayer = "noCollision";

		for (int i = p1.getSize(); i > 0; i--) {
			// Lightcycle can't intersect with itself
			if ((p1.getPlayerX(0) == p1.getPlayerX(i) && (p1.getPlayerY(0) == p1.getPlayerY(i)))) {
				colPlayer = "p2";

			}
			// Lightcycle can't intersect with p2
			if ((p1.getPlayerX(0) == p2.getPlayerX(i) && (p1.getPlayerY(0) == p2.getPlayerY(i)))) {
				colPlayer = "p2";

			}
		}
		// Do the same for p2
		for (int i = p2.getSize(); i > 0; i--) {
			if ((p2.getPlayerX(0) == p2.getPlayerX(i) && (p2.getPlayerY(0) == p2.getPlayerY(i)))) {
				colPlayer = "p1";

			}
			if ((p2.getPlayerX(0) == p1.getPlayerX(i) && (p2.getPlayerY(0) == p1.getPlayerY(i)))) {
				colPlayer = "p1";

			}
		}
		return colPlayer;
	}

}
