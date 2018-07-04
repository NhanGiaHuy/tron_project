package main;

import model.Loop;
import model.Vars;

public class Run2 extends Vars {
	
	public void run() {
		try {
			gameLoop();
		} finally {
			sm.restoreScreen();
		}
	}

}
