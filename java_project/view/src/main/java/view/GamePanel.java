package view;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public static final int WIDTH = 618;
	public static final int HEIGHT = 414;
	

	public GamePanel() {
		super();
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setFocusable(true);
		requestFocus();
		Init.init();
		
	}
}
