package model.game.entities;

import kernel.state.DefaultPacmanState;
import kernel.state.PrimalState;
import model.game.PhisicDatas;
import physic.Dimension;
import physic.Position;
import physic.Velocity;

public abstract class Entity {
	
	private int graphicId = -1 ;
	
	private PhisicDatas phisicDatas ;
	
	public abstract int initGraphic();
	
	private PrimalState primalState ;
	
	public Entity() {
		graphicId = initGraphic();
		phisicDatas = new PhisicDatas(new Position(0, 0), new Dimension(0, 0), new Velocity(0, 0));
		primalState = new PrimalState(new DefaultPacmanState(this));
	}
	
	public PrimalState getPrimalState() {
		return primalState;
	}
		
	public int getGraphicId() {
		return graphicId;
	}
	
	public PhisicDatas getPhisicDatas() {
		return phisicDatas ;
	}
	
	public void setPhisicDatas(PhisicDatas phisicDatas) {
		this.phisicDatas = phisicDatas;
	}
	
	public void setPosition(Position p) {
		phisicDatas.setPosition(p);
	}
	
	public void setDimension(Dimension d) {
		phisicDatas.setDimension(d);
	}
	
	public void setVelocity(Velocity v) {
		phisicDatas.setVelocity(v);
	}

	public void setVelocity(int vX, int vY) {
		Velocity vel = phisicDatas.getVelocity();
		vel.setxVel(vX);
		vel.setyVel(vY);
	}
}
