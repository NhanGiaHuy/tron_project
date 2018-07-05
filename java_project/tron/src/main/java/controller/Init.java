package controller;

import java.awt.Color;
import java.util.ArrayList;

import main.GamePanel;
import model.Players;


public class Init {
	
	Players player1 = new Players(2, 2, Color.BLUE);
	Players player2 = new Players(GamePanel.WIDTH/2, GamePanel.HEIGHT/2, Color.RED);
	GamePanel paintComponent = new GamePanel();
	ArrayList<Integer> pathx1 = new ArrayList();
	ArrayList<Integer> pathy1 = new ArrayList();
	ArrayList<Integer> pathx2 = new ArrayList();
	ArrayList<Integer> pathy2 = new ArrayList();
	int moveAmount = 5;
	int centrex1;
	int centrey1;
	int centrex2;
	int centrey2;
	int cDirection1 = 1;
	int cDirection2 = 3;

}
