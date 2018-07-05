package main;

import javax.swing.JPanel;
import javax.swing.Timer;

import controller.KeyE;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static final int WIDTH = 600;
	public static final int HEIGHT = 400;
	public static final int pixel = 10;

	int centrex1 = KeyE.player1.getPositionX();
	int centrex2 = KeyE.player2.getPositionX();
	int centrey1 = KeyE.player1.getPositionY();
	int centrey2 = KeyE.player2.getPositionY();

	Object[][] grid = new Object[WIDTH / pixel][HEIGHT / pixel];

	private boolean inGame = true;
	private Timer timer;
	private static int speed = 45;

	private final static int pixelT = (WIDTH * HEIGHT) / (pixel * pixel);

	public Board() {
		addKeyListener(new KeyE());
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		setBackground(Color.BLACK);
		requestFocus();
		initGame();

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	void draw(Graphics g) {

		if (inGame == true) {

			if (inGame == true) {
				g.setColor(Color.green);
				// Draw our snake.
				for (int i = 0; i < KeyE.player1.getJoints(); i++) {
					// Snake's head
					if (i == 0) {
						g.setColor(KeyE.player1.getColor());
						g.fillRect(centrex1, centrey1, pixel, pixel);
						// Body of snake
					} else {
						g.fillRect(centrex1, centrey1, pixel, pixel);
					}
				}
				
				for (int i = 0; i < KeyE.player2.getJoints(); i++) {
					// Snake's head
					if (i == 0) {
						g.setColor(KeyE.player2.getColor());
						g.fillRect(centrex2, centrey2, pixel, pixel);
						// Body of snake
					} else {
						g.fillRect(centrex2, centrey2, pixel, pixel);
					}
				}


				Toolkit.getDefaultToolkit().sync();
			} else {
				endGame(g);
			}

		}
	}

	public void initGame() {
		KeyE.player1.setJoints(1);
		KeyE.player2.setJoints(1);
		KeyE.player1.setMovingRight(true);
		KeyE.player2.setMovingLeft(true);
		timer = new Timer(speed, this);
		timer.start();
	}

	void endGame(Graphics g) {

		String message = "Game Over";
		Font font = new Font("Arial", Font.BOLD, 14);
		FontMetrics metrics = getFontMetrics(font);
		g.setColor(Color.RED);
		g.setFont(font);
		g.drawString(message, 100, 100);
		System.out.println("Game Ended");

	}

	public void actionPerformed(ActionEvent e) {

		if (inGame == true) {
			// checkCollision();
			KeyE.player1.move();
			KeyE.player2.move();
			repaint();
		}

	}

	public static int getDots() {
		return pixelT;
	}

	public static int getPixel() {
		return pixel;
	}

}