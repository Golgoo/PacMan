package model.game;

import java.util.LinkedList;
import java.util.List;

import model.game.entities.Entity;
import physic.Dimension;

public class GameModel {
	public enum InputKey {
		Right, Left, Up, Down;
	}
	
	private String skin ;

	public Entity pacman ;
	public int pacmanSpeedVelocity;
	public boolean superPacman ;
	
	public Dimension minimumPacManDim;
	public Dimension maximumPacManDim;
	
	public List<Entity> fruits ;
	public List<Entity> superFruits ;
	public List<Entity> walls ;
	public List<Entity> steroids;
	public List<Entity> bounds;
	
	public boolean gameWon ;
	
	public boolean gamePaused ;
	public boolean gameIsRunning;

	public boolean steroidPacMan;

	public void init() {
		fruits = new LinkedList<Entity>() ;
		superFruits = new LinkedList<Entity>();
		walls = new LinkedList<Entity>();
		steroids = new LinkedList<Entity>();
		bounds = new LinkedList<Entity>();
		gameWon = false ;
		gamePaused = false ;
		superPacman = false ;
		gameIsRunning = false ;
		steroidPacMan = false ;
	}
	
	public void setSkin(String skin) {
		this.skin = skin ;
	}

	public String getSkin() {
		return skin ;
	}
}
