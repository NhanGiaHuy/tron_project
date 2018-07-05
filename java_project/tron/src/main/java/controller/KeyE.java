package controller;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import main.Board;
import model.Players;

public class KeyE extends KeyAdapter {

	public static Players player1 = new Players(2, 2, Color.BLUE);
	public static Players player2 = new Players(Board.WIDTH / 2, Board.HEIGHT / 2, Color.RED);

	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();

		if ((key == KeyEvent.VK_LEFT) && (!player1.isMovingRight())) {
			player1.setMovingLeft(true);
			player1.setMovingUp(false);
			player1.setMovingDown(false);
		}

		if ((key == KeyEvent.VK_RIGHT) && (!player1.isMovingLeft())) {
			player1.setMovingRight(true);
			player1.setMovingUp(false);
			player1.setMovingDown(false);
		}

		if ((key == KeyEvent.VK_UP) && (!player1.isMovingDown())) {
			player1.setMovingUp(true);
			player1.setMovingRight(false);
			player1.setMovingLeft(false);
		}

		if ((key == KeyEvent.VK_DOWN) && (!player1.isMovingUp())) {
			player1.setMovingDown(true);
			player1.setMovingRight(false);
			player1.setMovingLeft(false);
		}
		
		if ((key == KeyEvent.VK_Q) && (!player2.isMovingRight())) {
			player2.setMovingLeft(true);
			player2.setMovingUp(false);
			player2.setMovingDown(false);
		}

		if ((key == KeyEvent.VK_D) && (!player2.isMovingLeft())) {
			player2.setMovingRight(true);
			player2.setMovingUp(false);
			player2.setMovingDown(false);
		}

		if ((key == KeyEvent.VK_Z) && (!player2.isMovingDown())) {
			player2.setMovingUp(true);
			player2.setMovingRight(false);
			player2.setMovingLeft(false);
		}

		if ((key == KeyEvent.VK_S) && (!player2.isMovingUp())) {
			player2.setMovingDown(true);
			player2.setMovingRight(false);
			player2.setMovingLeft(false);
		}
	}
}