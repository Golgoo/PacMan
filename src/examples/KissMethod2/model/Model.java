package examples.KissMethod2.model;

import java.util.LinkedList;
import java.util.List;
import java.util.TimerTask;

import examples.KissMethod2.sigletons.Acessors;

public class Model {
	public enum InputKey {
		Right, Left, Up, Down; 
	}

	public Entity PacMan ;
	public int PacManVelocity = 3 ;
	
	public TimerTask stopSuperPack ;
	
	public List<Entity> fruits = new LinkedList<Entity>() ;
	
	public List<Entity> superFruits = new LinkedList<Entity>();

	public List<Entity> walls = new LinkedList<Entity>();
	
	public boolean gameWon = false;
	
	public Entity scoreEntity ;
	private int score = 0 ;
	
	
	public void addScore(int score) {
		this.score += score ;
		if(this.score < 0) this.score = 0 ;
	}
	
	public int getScore() {
		return score ;
	}

	public void setScore(int score) {
		this.score = score ;
	}
	
	public void reloadStopSuperPackTask() {
		stopSuperPack = new TimerTask() {
			
			@Override
			public void run() {
				Acessors.getGctx().setEntityColorMask(PacMan.getGraphicId(), 1.0f, 1.0f, 0.0f);
			}
		};
	}
}
