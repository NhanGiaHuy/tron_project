package main;

import java.awt.EventQueue;
import javax.swing.JFrame;

import controller.Game;

public class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		// Creates a new thread so our GUI can process itself
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new Main();
				frame.setVisible(true);
			}
		});
	}

	Main() {
		add(new Game());
		setResizable(false);
		pack();
		setTitle("TRON");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}