package main;

import javax.swing.JOptionPane;

public class Menu {
	
	public Menu() {
		
		String[] lvl = { "START PRE_ALPHA" };
		JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
		int rang = jop.showOptionDialog(null, "Disclamer : This game is in early development and does not reflect the final game.", "WELCOMME TO TRON", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, lvl, lvl);

	  }

}
