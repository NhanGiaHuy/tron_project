package model;

/**
 * TRON PROJECT
 * 
 * @author lborruto
 * @version 1.0
 */

/**
 * 
 * Define our Players using Getters and Setters
 * 
 */
public class Players {

	// Stores the traces locations for our Lightcycles
	private final int[] x = new int[Grid.getGrid()];
	private final int[] y = new int[Grid.getGrid()];

	// Stores direction of our lightcycles
	private boolean left = false;
	private boolean right = false;
	private boolean up = false;
	private boolean down = false;

	// Set numbers of dots
	private int size = 0;

	/**
	 * 
	 * Get the coordinate X,Y for our Players
	 * 
	 */
	public int getPlayerX(int index) {
		return x[index];
	}

	public int getPlayerY(int index) {
		return y[index];
	}

	/**
	 * 
	 * Set the coordinate X,Y for our Players
	 * 
	 */
	public void setPlayerX(int index, int i) {
		x[index] = i;
	}

	public void setPlayerY(int index, int i) {
		y[index] = i;
	}

	/**
	 * 
	 * Set the movement of our players
	 * 
	 */
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

}