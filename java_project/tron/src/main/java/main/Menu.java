package main;

import javax.swing.JOptionPane;

/**
 * TRON PROJECT
 * 
 * @author lborruto
 * @version 1.0
 */
public class Menu {

	/**
	 * 
	 * First menu with instructions
	 * 
	 */
	public Menu() {

		String[] lvl = { "START GAME" };
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		int rang = jop.showOptionDialog(null,
				"This is a 2 players game, Keys used are Z,Q,S,D and UP, DOWN, LEFT, RIGHT.", "WELCOMME TO TRON",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, lvl, lvl);
	}

}
