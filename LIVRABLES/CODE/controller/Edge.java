package controller;

import main.Game;
import model.Players;

/**
 * TRON PROJECT
 * 
 * @author lborruto
 * @version 1.0
 */
public class Edge {

	/**
	 * 
	 * If the lightcycle intersects with the board edges the game continue and set
	 * the lightcycle to the other edge
	 * 
	 * 
	 */
	public void checkEdge(Players p1, Players p2) {
		if (p1.getPlayerY(0) >= Game.height) {
			p1.setPlayerY(0, 0);
		}

		if (p1.getPlayerY(0) < 0) {
			p1.setPlayerY(0, Game.height);
		}

		if (p1.getPlayerX(0) >= Game.width) {
			p1.setPlayerX(0, 0);
		}

		if (p1.getPlayerX(0) < 0) {
			p1.setPlayerX(0, Game.width);
		}

		if (p2.getPlayerY(0) >= Game.height) {
			p2.setPlayerY(0, 0);
		}

		if (p2.getPlayerY(0) < 0) {
			p2.setPlayerY(0, Game.height);
		}

		if (p2.getPlayerX(0) >= Game.width) {
			p2.setPlayerX(0, 0);
		}

		if (p2.getPlayerX(0) < 0) {
			p2.setPlayerX(0, Game.width);
		}
	}
}
