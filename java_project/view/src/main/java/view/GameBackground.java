package view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GameBackground extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 618;
	public static final int HEIGHT = 414;
	
	BufferedImage img;
	
	public GameBackground() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		init();
	}
	
	private void init() {
		try {
			img = ImageIO.read(getClass().getResourceAsStream("/1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g) {
		if (img != null) {
			g.drawImage(img, 0, 0, null);
		}
	}
}