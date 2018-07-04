package model;

import java.awt.Color;
import java.awt.DisplayMode;
import java.awt.Font;
import java.awt.Point;
import java.awt.Window;
import java.awt.image.BufferedImage;

import view.ScreenManager;

public class Init extends Vars {

	private static final DisplayMode modes[] = { new DisplayMode(640, 480, 16, 0), };

	public void init() {
		sm = new ScreenManager();
		DisplayMode dm = sm.findFirstCompatibaleMode(modes);
		sm.setFullScreen(dm);
		Window w = sm.getFullScreenWindow();
		w.setFont(new Font("Arial", Font.PLAIN, 20));
		w.setBackground(Color.WHITE);
		w.setForeground(Color.RED);
		w.setCursor(w.getToolkit().createCustomCursor(new BufferedImage(3, 3, BufferedImage.TYPE_INT_ARGB),
				new Point(0, 0), "null"));
		running = true;
	}

}
