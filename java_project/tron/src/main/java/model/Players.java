package model;

import java.awt.Color;

public class Players {

	private int positionX;
	private int positionY;
	private Color color;
	
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
}