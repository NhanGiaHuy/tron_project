package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Init {

	BufferedImage img;

	public void init() {
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
