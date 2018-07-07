package model;

import controller.Game;

public class Players {

	// Stores the joints / body part locations for our snake
	private final int[] x = new int[Game.getGrid()];
	private final int[] y = new int[Game.getGrid()];

	// Stores direction of our snake
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	private int size = 0; // Stores # of dots / joints the snake has (starts
							// with 3)

	public int getPlayerX(int index) {
		return x[index];
	}

	public int getPlayerY(int index) {
		return y[index];
	}

	public void setPlayerX(int i) {
		x[0] = i;
	}

	public void setPlayerY(int i) {
		y[0] = i;
	}

	public boolean isMovingLeft() {
		return left;
	}

	public void setMovingLeft(boolean movingLeft) {
		this.left = movingLeft;
	}

	public boolean isMovingRight() {
		return right;
	}

	public void setMovingRight(boolean movingRight) {
		this.right = movingRight;
	}

	public boolean isMovingUp() {
		return up;
	}

	public void setMovingUp(boolean movingUp) {
		this.up = movingUp;
	}

	public boolean isMovingDown() {
		return down;
	}

	public void setMovingDown(boolean movingDown) {
		this.down = movingDown;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int j) {
		size = j;
	}

	public void move() {
		for (int i = size; i > 0; i--) {

			// Moves the joints of the snake 'up the chain'
			// Meaning, the joint of the snake all move up one
			x[i] = x[(i - 1)];
			y[i] = y[(i - 1)];
		}

		// Moves snake to the left
		if (left) {
			x[0] -= Game.getPixel();
		}
		// To the right
		if (right) {
			x[0] += Game.getPixel();
		}
		// Down
		if (down) {
			y[0] += Game.getPixel();
		}
		// And finally up
		if (up) {
			y[0] -= Game.getPixel();
		}

		// Dotsize represents the size of the joint, so a pixel of DOTSIZE
		// gets added on to the snake in that direction
	}
}