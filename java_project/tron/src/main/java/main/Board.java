package main;

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
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener {

	// TODO: Implement a way for the player to win

	// Holds height and width of the window
	private final static int BOARDWIDTH = 600;
	private final static int BOARDHEIGHT = 400;

	// Used to represent pixel size of food & our snake's joints
	private final static int PIXELSIZE = 5;

	// The total amount of pixels the game could possibly have.
	// We don't want less, because the game would end prematurely.
	// We don't more because there would be no way to let the player win.

	private final static int TOTALPIXELS = (BOARDWIDTH * BOARDHEIGHT) / (PIXELSIZE * PIXELSIZE);

	// Check to see if the game is running
	private boolean inGame = true;

	// Timer used to record tick times
	private Timer timer;

	// Used to set game speed, the lower the #, the faster the snake travels
	// which in turn
	// makes the game harder.
	private static int speed = 100;

	// Instances of our snake & food so we can use their methods
	private Snake snake = new Snake();
	private Snake snake2 = new Snake();

	public Board() {

		addKeyListener(new Keys());
		setBackground(Color.BLACK);
		setFocusable(true);
		setPreferredSize(new Dimension(BOARDWIDTH, BOARDHEIGHT));
		initializeGame();
	}

	// Used to paint our components to the screen
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}

	// Draw our Snake & Food (Called on repaint()).
	void draw(Graphics g) {
		// Only draw if the game is running / the snake is alive
		if (inGame == true) {
			// Draw our snake.
			for (int i = 0; i < snake.getJoints(); i++) {
				// Snake's head
					g.setColor(Color.RED);
					g.fillRect(snake.getSnakeX(i), snake.getSnakeY(i), PIXELSIZE, PIXELSIZE);

			}
			
			for (int i = 0; i < snake2.getJoints(); i++) {
				// Snake's head
					g.setColor(Color.GREEN);
					g.fillRect(snake2.getSnakeX(i), snake2.getSnakeY(i), PIXELSIZE, PIXELSIZE);

			}
			// Sync our graphics together
			Toolkit.getDefaultToolkit().sync();
		} else {
			// If we're not alive, then we end our game
			endGame(g);
		}
	}

	void initializeGame() {
		// set our snake's initial size
		snake.setJoints(999);
		snake2.setJoints(999);
		
		// Create our snake's body
		for (int i = 0; i < snake.getJoints(); i++) {
			snake.setSnakeX(BOARDWIDTH / 2);
			snake.setSnakeY(BOARDHEIGHT / 2);
		}
		
		for (int i = 0; i < snake2.getJoints(); i++) {
			snake2.setSnakeX(200);
			snake2.setSnakeY(200);
		}
	
		
		// Start off our snake moving right
		snake.setMovingLeft(true);
		snake2.setMovingRight(true);

		// Generate our first 'food'
		//food.createFood();

		// set the timer to record our game's speed / make the game move
		timer = new Timer(speed, this);
		timer.start();
	}

	// Used to check collisions with snake's self and board edges
	void checkCollisions() {

		// If the snake hits its' own joints..
		for (int i = snake.getJoints(); i > 0; i--) {

			// Snake can't intersect with itself if it's not larger than 5
			if ((i > 5) && (snake.getSnakeX(0) == snake.getSnakeX(i) && (snake.getSnakeY(0) == snake.getSnakeY(i)))) {
				inGame = false; // then the game ends
			}
		}

		// If the snake intersects with the board edges..
		if (snake.getSnakeY(0) >= BOARDHEIGHT) {
			inGame = false;
		}

		if (snake.getSnakeY(0) < 0) {
			inGame = false;
		}

		if (snake.getSnakeX(0) >= BOARDWIDTH) {
			inGame = false;
		}

		if (snake.getSnakeX(0) < 0) {
			inGame = false;
		}

		// If the game has ended, then we can stop our timer
		if (!inGame) {
			timer.stop();
		}
	}

	void endGame(Graphics g) {

		// Create a message telling the player the game is over
		String message = "Game over";

		// Create a new font instance
		Font font = new Font("Times New Roman", Font.BOLD, 14);
		FontMetrics metrics = getFontMetrics(font);

		// Set the color of the text to red, and set the font
		g.setColor(Color.red);
		g.setFont(font);

		// Draw the message to the board
		g.drawString(message, (BOARDWIDTH - metrics.stringWidth(message)) / 2, BOARDHEIGHT / 2);

		System.out.println("Game Ended");

	}

	// Run constantly as long as we're in game.
	@Override
	public void actionPerformed(ActionEvent e) {
		if (inGame == true) {

			checkCollisions();
			snake.move();
			snake2.move();
		}
		// Repaint or 'render' our screen
		repaint();
	}

	private class Keys extends KeyAdapter {

		
		public void keyPressed(KeyEvent e) {

			int key = e.getKeyCode();

			if ((key == KeyEvent.VK_LEFT) && (!snake.isMovingRight())) {
				snake.setMovingLeft(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
			}

			if ((key == KeyEvent.VK_RIGHT) && (!snake.isMovingLeft())) {
				snake.setMovingRight(true);
				snake.setMovingUp(false);
				snake.setMovingDown(false);
			}

			if ((key == KeyEvent.VK_UP) && (!snake.isMovingDown())) {
				snake.setMovingUp(true);
				snake.setMovingRight(false);
				snake.setMovingLeft(false);
			}

			if ((key == KeyEvent.VK_DOWN) && (!snake.isMovingUp())) {
				snake.setMovingDown(true);
				snake.setMovingRight(false);
				snake.setMovingLeft(false);
			}
			
			if ((key == KeyEvent.VK_Q) && (!snake2.isMovingRight())) {
				snake2.setMovingLeft(true);
				snake2.setMovingUp(false);
				snake2.setMovingDown(false);
			}

			if ((key == KeyEvent.VK_D) && (!snake2.isMovingLeft())) {
				snake2.setMovingRight(true);
				snake2.setMovingUp(false);
				snake2.setMovingDown(false);
			}

			if ((key == KeyEvent.VK_Z) && (!snake2.isMovingDown())) {
				snake2.setMovingUp(true);
				snake2.setMovingRight(false);
				snake2.setMovingLeft(false);
			}

			if ((key == KeyEvent.VK_S) && (!snake2.isMovingUp())) {
				snake2.setMovingDown(true);
				snake2.setMovingRight(false);
				snake2.setMovingLeft(false);
			}
		}
	}

	@SuppressWarnings("unused")
	private boolean proximity(int a, int b, int closeness) {
		return Math.abs((long) a - b) <= closeness;
	}

	public static int getAllDots() {
		return TOTALPIXELS;
	}

	public static int getDotSize() {
		return PIXELSIZE;
	}
}