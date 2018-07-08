package controller;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.text.SimpleDateFormat;

import javax.swing.JPanel;
import javax.swing.Timer;

import model.Players;

public class Game extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	// Holds height and width of the window
	private final static int width = 600;
	private final static int height = 400;

	// Used to represent pixel size of our lightcycle joints
	private final static int pixel = 5;

	// The total amount of pixels the game could possibly have.
	// We don't want less, because the game would end prematurely.
	// We don't more because there would be no way to let the player win.

	private final static int playGrid = (width * height) / (pixel * pixel);

	// Check to see if the game is running
	private boolean isRunning = true;

	// Timer used to record tick times
	private Timer timer;

	// Used to set game speed, the lower the #, the faster the lightcycle travels
	// which in turn
	// makes the game harder.
	private int speed = 80;

	// Instances of our lightcycle so we can use their methods
	private Players player1 = new Players();
	private Players player2 = new Players();

	private String winner;

	static double chrono = 0;
	static double chrono2 = 0;
	static double temps;

	public Game() {
		chrono = java.lang.System.currentTimeMillis();
		addKeyListener(new Keys());
		setBackground(Color.BLACK);
		setFocusable(true);
		setPreferredSize(new Dimension(width, height));
		initializeGame();
	}

	// Used to paint our components to the screen
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);

	}

	public void initializeGame() {
		// set our lightcycle initial size
		player1.setSize(999);
		player2.setSize(999);

		// Create our lightcycle body
		for (int i = 0; i < player1.getSize(); i++) {
			player1.setPlayerX(width / 2);
			player1.setPlayerY(height / 2);
		}

		for (int i = 0; i < player2.getSize(); i++) {
			player2.setPlayerX(100);
			player2.setPlayerY(100);
		}
		// Start off our lightcycle moving right
		player1.setMovingLeft(true);
		player2.setMovingRight(true);

		// set the timer to record our game's speed / make the game move
		timer = new Timer(speed, this);
		timer.start();
	}

	// Draw our lightcycle (Called on repaint()).
	void draw(Graphics g) {
		// Only draw if the game is running / the lightcycle is alive
		if (isRunning == true) {
			// Draw our lightcycle.
			for (int i = 0; i < player1.getSize(); i++) {
				// lightcycle head
				g.setColor(Color.RED);
				g.fillRect(player1.getPlayerX(i), player1.getPlayerY(i), pixel, pixel);

			}

			for (int i = 0; i < player2.getSize(); i++) {
				// lightcycle head
				g.setColor(Color.BLUE);
				g.fillRect(player2.getPlayerX(i), player2.getPlayerY(i), pixel, pixel);

			}
			// Sync our graphics together
			Toolkit.getDefaultToolkit().sync();
		} else {
			// If we're not alive, then we end our game
			chrono2 = java.lang.System.currentTimeMillis();
			temps = (chrono2 - chrono) / 1000;
			Database();
			endGame(g);

		}
	}

	// Used to check collisions with lightcycle self and board edges
	void checkCollisions() {

		// If the lightcycle hits its' own joints..
		for (int i = player1.getSize(); i > 0; i--) {
			// lightcycle can't intersect with itself
			if ((player1.getPlayerX(0) == player1.getPlayerX(i) && (player1.getPlayerY(0) == player1.getPlayerY(i)))) {
				isRunning = false;
				winner = "BLUE WON";
				// then the game ends
			}

			if ((player1.getPlayerX(0) == player2.getPlayerX(i) && (player1.getPlayerY(0) == player2.getPlayerY(i)))) {
				isRunning = false;
				winner = "BLUE WON";
				// then the game ends
			}
		}

		for (int i = player2.getSize(); i > 0; i--) {
			// lightcycle can't intersect with itself
			if ((player2.getPlayerX(0) == player2.getPlayerX(i) && (player2.getPlayerY(0) == player2.getPlayerY(i)))) {
				isRunning = false;
				winner = "RED WON";// then the game ends
			}
			if ((player2.getPlayerX(0) == player1.getPlayerX(i) && (player2.getPlayerY(0) == player1.getPlayerY(i)))) {
				isRunning = false;
				winner = "RED WON";// then the game ends
			}
		}

		// If the lightcycle intersects with the board edges..
		if (player1.getPlayerY(0) >= height) {
			player1.setPlayerY(0);
		}

		if (player1.getPlayerY(0) < 0) {
			player1.setPlayerY(height);
		}

		if (player1.getPlayerX(0) >= width) {
			player1.setPlayerX(0);
		}

		if (player1.getPlayerX(0) < 0) {
			player1.setPlayerX(width);
		}

		if (player2.getPlayerY(0) >= height) {
			player2.setPlayerY(0);
		}

		if (player2.getPlayerY(0) < 0) {
			player2.setPlayerY(height);
		}

		if (player2.getPlayerX(0) >= width) {
			player2.setPlayerX(0);
		}

		if (player2.getPlayerX(0) < 0) {
			player2.setPlayerX(width);
		}

		// If the game has ended, then we can stop our timer
		if (!isRunning) {
			timer.stop();
		}
	}

	void endGame(Graphics g) {

		// Create a message telling the player the game is over
		String message = "Game over";

		// Create a new font instance
		Font font = new Font("Times New Roman", Font.BOLD, 30);
		FontMetrics metrics = getFontMetrics(font);

		// Set the color of the text to red, and set the font
		g.setColor(Color.red);
		g.setFont(font);

		// Draw the message to the board
		g.drawString(message, (width - metrics.stringWidth(message)) / 2, height / 2);

		System.out.println("END");

	}

	// Run constantly as long as we're in game.
	public void actionPerformed(ActionEvent e) {
		if (isRunning == true) {
			checkCollisions();
			player1.move();
			player2.move();
		}
		// Repaint or 'render' our screen
		repaint();
	}

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

	public void Database() {

		try {
			System.out.println(temps);
			System.out.println(winner);
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String URL = "jdbc:mysql://localhost:3306/tron?autoReconnect=true&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String USER = "root";
			String PASS = "";
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO score(player, time) VALUES(?, ?)");
			preparedStatement.setObject(1, winner, Types.CHAR);
			preparedStatement.setObject(2, temps, Types.DOUBLE);
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public static int getGrid() {
		return playGrid;
	}

	public static int getPixel() {
		return pixel;
	}
}