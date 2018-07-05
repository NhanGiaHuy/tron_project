package view;

import javax.swing.JPanel;

import main.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class GamePanel extends JPanel {


	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	public static final int pixel = 1;
	Object[][] grid = new Object[WIDTH/pixel][HEIGHT/pixel];
			
	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		setBackground(Color.BLACK);
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.fillRect(Init.player1.getPositionX(), Init.player1.getPositionY(), pixel, pixel);
        g.fillRect(Init.player2.getPositionX(), Init.player2.getPositionY(), pixel, pixel);
    }
}