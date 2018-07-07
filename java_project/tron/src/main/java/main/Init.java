package main;

import javax.swing.Timer;

import controller.Game;

public class Init extends Game {


	private static final long serialVersionUID = 1L;
	
	public void initializeGame() {
		// set our snake's initial size
		player1.setSize(999);
		player2.setSize(999);
		
		// Create our snake's body
		for (int i = 0; i < player1.getSize(); i++) {
			player1.setPlayerX(width / 2);
			player1.setPlayerY(height / 2);
		}
		
		for (int i = 0; i < player2.getSize(); i++) {
			player2.setPlayerX(100);
			player2.setPlayerY(100);
		}
		// Start off our snake moving right
		player1.setMovingLeft(true);
		player2.setMovingRight(true);

		// set the timer to record our game's speed / make the game move
		timer = new Timer(speed, this);
		timer.start();
	}

}
