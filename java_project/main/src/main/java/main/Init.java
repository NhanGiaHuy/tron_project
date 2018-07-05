package main;

import java.awt.Color;
import model.Players;
import view.GamePanel;

public class Init {

	public static Players player1 = new Players();
	public static Players player2 = new Players();
	GamePanel paintComponent = new GamePanel();

	public Init() {
		player1.setPositionX(2);
		player1.setPositionY(2);
		player1.setColor(Color.BLUE);
		player2.setPositionX(GamePanel.WIDTH/2);
		player2.setPositionY(GamePanel.HEIGHT/2);
		player2.setColor(Color.RED);
	
	}
}