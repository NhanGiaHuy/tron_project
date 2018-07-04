package model;

import java.util.ArrayList;

import view.ScreenManager;

public class Vars {
	
	protected ScreenManager sm;
	private boolean running;
	public int cDirection1 = 1;
	public int cDirection2 = 3;
	protected int centrex1 = 40;
	protected int centrey1 = 40;
	protected int centrex2 = 600;
	protected int centrey2 = 440;
	protected int moveAmount = 5;
	protected ArrayList<Integer> pathx1 = new ArrayList();
	protected ArrayList<Integer> pathy1 = new ArrayList();
	protected ArrayList<Integer> pathx2 = new ArrayList();
	protected ArrayList<Integer> pathy2 = new ArrayList();

}
