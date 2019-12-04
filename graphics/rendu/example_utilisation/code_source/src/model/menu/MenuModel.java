package model.menu;

import model.game.entities.Entity;

public class MenuModel {
	
	public Entity scoreEntity ;
	private int score = 0 ;
	
	public Entity highScoreEntity ;
	public int currentHighScore = 0;
	
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
	
	public void init() {
		score = 0 ;
	}

	public int getHightScore() {
		return currentHighScore ;
	}
	
	public void setHighScore(int highscore) {
		this.currentHighScore = highscore ;
	}
}
