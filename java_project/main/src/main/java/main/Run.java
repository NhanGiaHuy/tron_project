package main;

import model.Init;

public class Run extends Init {

	public void run() {
		try {
			init();
			gameLoop();
		} finally {
			sm.restoreScreen();
		}
	}

}
