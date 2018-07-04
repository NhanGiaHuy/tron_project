package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import model.Vars;

public class Draw extends Vars {
	

	public void draw(Graphics2D g) {
		switch (cDirection1) {
		case 0:
			if (centrey1 > 0) {
				centrey1 -= moveAmount;
			} else {
				centrey1 = sm.getHeight();
			}
			break;
		case 1:
			if (centrex1 < sm.getWidth()) {
				centrex1 += moveAmount;
			} else {
				centrex1 = 0;
			}
			break;
		case 2:
			if (centrey1 < sm.getHeight()) {
				centrey1 += moveAmount;
			} else {
				centrey1 = 0;
			}
			break;
		case 3:
			if (centrex1 > 0) {
				centrex1 -= moveAmount;
			} else {
				centrex1 = sm.getWidth();
			}
			break;
		}
		switch (cDirection2) {
		case 0:
			if (centrey2 > 0) {
				centrey2 -= moveAmount;
			} else {
				centrey2 = sm.getHeight();
			}
			break;
		case 1:
			if (centrex2 < sm.getWidth()) {
				centrex2 += moveAmount;
			} else {
				centrex2 = 0;
			}
			break;
		case 2:
			if (centrey2 < sm.getHeight()) {
				centrey2 += moveAmount;
			} else {
				centrey2 = 0;
			}
			break;
		case 3:
			if (centrex2 > 0) {
				centrex2 -= moveAmount;
			} else {
				centrex2 = sm.getWidth();
			}
			break;
		}
		for (int x = 0; x < pathx1.size(); x++) {
			if (((centrex1 == pathx1.get(x)) && (centrey1 == pathy1.get(x)))
					|| ((centrex2 == pathx2.get(x)) && (centrey2 == pathy2.get(x)))
					|| ((centrex1 == pathx2.get(x)) && (centrey1 == pathy2.get(x)))
					|| ((centrex2 == pathx1.get(x)) && (centrey2 == pathy1.get(x)))) {
				System.exit(0);
			}
		}
		pathx1.add(centrex1);
		pathy1.add(centrey1);
		pathx2.add(centrex2);
		pathy2.add(centrey2);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, sm.getWidth(), sm.getHeight());
		for (int x = 0; x < pathx1.size(); x++) {
			g.setColor(Color.green);
			g.fillRect(pathx1.get(x), pathy1.get(x), 10, 10);
			g.setColor(Color.red);
			g.fillRect(pathx2.get(x), pathy2.get(x), 10, 10);
		}
	}

}
