package model;

import java.awt.Color;

import main.Board;

public class Players {
	
	private int positionX;
	private int positionY;
	private Color color;
	private boolean movingLeft = false;
	private boolean movingRight = false;
	private boolean movingUp = false;
	private boolean movingDown = false;
	private int joints = 0;
	
	private final int[] x = new int[Board.getDots()];
	private final int[] y = new int[Board.getDots()];

	public Players(int x, int y, Color c) {
		positionX = x;
		positionY = y;
		color = c;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public boolean isMovingLeft() {
	    return movingLeft;
	}

	public void setMovingLeft(boolean movingLeft) {
	    this.movingLeft = movingLeft;
	}

	public boolean isMovingRight() {
	    return movingRight;
	}

	public void setMovingRight(boolean movingRight) {
	    this.movingRight = movingRight;
	}

	public boolean isMovingUp() {
	    return movingUp;
	}

	public void setMovingUp(boolean movingUp) {
	    this.movingUp = movingUp;
	}

	public boolean isMovingDown() {
	    return movingDown;
	}

	public void setMovingDown(boolean movingDown) {
	    this.movingDown = movingDown;
	}
	
	public int getJoints() {
	    return joints;
	}

	public void setJoints(int j) {
	    joints = j;
	}
	
	public void move() {
		
	    for (int i = joints; i > 0; i--) {

	        // Moves the joints of the snake 'up the chain'
	        // Meaning, the joint of the snake all move up one
	        x[i] = x[(i - 1)];
	        y[i] = y[(i - 1)];
	    }
	    
		if (movingLeft) {
	        x[0] -= Board.getPixel();
	    }
	    // To the right
	    if (movingRight) {
	        x[0] += Board.getPixel();
	    }
	    // Down
	    if (movingDown) {
	        y[0] += Board.getPixel();
	    }
	    // And finally up
	    if (movingUp) {
	        y[0] -= Board.getPixel();
	    }
	}
}