package main;

import java.awt.EventQueue;

import javax.swing.JFrame;

import main.Board;

public class Game extends JFrame {

	private static final long serialVersionUID = 1L;

	public Game() {
		setTitle("TRON GAME");
		setContentPane(new Board());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
		setLocationRelativeTo(null);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new Game();
				frame.setVisible(true);
			}
		});
	}
}