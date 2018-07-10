package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Collision;
import controller.Edge;
import controller.Move;
import model.Database;
import model.Pixel;
import model.Players;

/**
 * TRON PROJECT
 * 
 * @author lborruto
 * @version 1.0
 */
public class Game extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;

	// Define the width and the height of the window
	public final static int width = 600;
	public final static int height = 400;

	// Check if the game is running or not
	protected boolean isRunning = true;

	// Record the tick time to make the lightcycles moving
	private Timer timer;

	// Set the game speed (the lower the value is, higher the lightcycle speed will
	// be)
	private int speed = 1;

	// Instances of our lightcycles
	private Players player1 = new Players();
	private Players player2 = new Players();

	// Define the variable winner for the endscreen and the database
	public static String winner;

	// Define the chronometer set to know the time of a game
	public static double chrono = 0;
	public static double chrono2 = 0;
	public static double temps;

	Database bdd = new Database();

	Move move = new Move();

	Collision col = new Collision();
	Edge edge = new Edge();
	String resultCol;

	/**
	 * 
	 * Launch our JPanel window and start the game loop with " initializeGame(); "
	 * 
	 */
	public Game() {
		chrono = java.lang.System.currentTimeMillis();
		addKeyListener(new Keys());
		setBackground(Color.BLACK);
		setFocusable(true);
		setPreferredSize(new Dimension(width, height));
		initializeGame();
	}

	/**
	 * 
	 * Used to paint our components to the screen
	 * 
	 * 
	 */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	/**
	 * 
	 * Start the principal game loop
	 * 
	 * 
	 */
	public void initializeGame() {

		// Set the lightcycle trail size
		player1.setSize(999);
		player2.setSize(999);

		// Create our player 1 lightcycle
		for (int i = 0; i < player1.getSize(); i++) {
			// Set the initial position of the lightcycle
			player1.setPlayerX(0, width / 2);
			player1.setPlayerY(0, height / 2);
		}

		// Create our player 2 lightcycle
		for (int i = 0; i < player2.getSize(); i++) {
			// Set the initial position of the lightcycle
			player2.setPlayerX(0, 100);
			player2.setPlayerY(0, 100);
		}
		// Set the initial movement of the lightcycle 1 and 2
		player1.setMovingLeft(true);
		player2.setMovingRight(true);

		// Timer to make the game move
		timer = new Timer(speed, this);
		timer.start();
	}

	/**
	 * 
	 * Draw our lightcycles called on repaint()
	 * 
	 */
	void draw(Graphics g) {

		// Only draw if the game is running
		if (isRunning == true) {
			// Draw our first lightcycle.
			for (int i = 0; i < player1.getSize(); i++) {
				// Lightcycle color
				g.setColor(Color.RED);
				// Draw our lightcycle with initial position and Rectangular (g.fillRect)
				g.fillRect(player1.getPlayerX(i), player1.getPlayerY(i), Pixel.getPixel(), Pixel.getPixel());

			}
			// Draw our second lightcycle.
			for (int i = 0; i < player2.getSize(); i++) {
				g.setColor(Color.BLUE);
				g.fillRect(player2.getPlayerX(i), player2.getPlayerY(i), Pixel.getPixel(), Pixel.getPixel());

			}
			// Synchronise the graphic
			Toolkit.getDefaultToolkit().sync();
		} else {
			// End the game if players loose or win
			chrono2 = java.lang.System.currentTimeMillis();
			temps = (chrono2 - chrono) / 1000;
			// Call the database and write Winner and Time
			bdd.Database();
			// End the game with Game over Screen + winner
			endGame(g);
		}
	}

	/**
	 * 
	 * If the game end, draw an end screen with winner + Game over
	 * 
	 * 
	 */
	void endGame(Graphics g) {
		// Create message for game over and winner
		String message = "Game over";
		String message2 = winner;
		String message3 = "Game Time : " + String.valueOf(temps) + " s";

		// Create a new font instance
		Font font = new Font("Times New Roman", Font.BOLD, 25);
		FontMetrics metrics = getFontMetrics(font);
		
		// Set the color of the text and the font
		g.setColor(Color.green);
		g.setFont(font);

		// Draw the message to the board
		g.drawString(message, ((width / 2) - (metrics.stringWidth(message)/ 2)), height / 2);
		g.drawString(message2, ((width / 2) - (metrics.stringWidth(message2)/ 2)), height / 3);
		g.drawString(message3, ((width / 2) - (metrics.stringWidth(message3)/ 2)), height / 4);

		System.out.println("END");
	}

	/**
	 * 
	 * Run constantly as long as we're in game.
	 * 
	 * 
	 */
	public void actionPerformed(ActionEvent e) {
		if (isRunning == true) {
			resultCol = col.checkCollisions(player1, player2);

			switch (resultCol) {
			case "p1":
				// Set the winner for the specific interaction
				winner = "RED WON";
				// The game end
				isRunning = false;
			case "p2":
				winner = "BLUE WON";
				isRunning = false;
			}
			edge.checkEdge(player1, player2);
			move.player(player1);
			move.player(player2);
			// If the game end, stop our timer
			if (!isRunning) {
				timer.stop();
			}
		}
		// Repaint our screen
		repaint();
	}

	/**
	 * 
	 * Set our Keys for playing
	 * 
	 * 
	 */
	private class Keys extends KeyAdapter {

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
}