package model.game;

import physic.Dimension;
import physic.Position;
import physic.Velocity;

public class PhisicDatas {
	private Position position ;
	private Dimension dimension ;
	private Velocity velocity ;
	
	public PhisicDatas(Position position, Dimension dimension, Velocity velocity) {
		this.position = position;
		this.dimension = dimension;
		this.velocity = velocity;
	}
	public Position getPosition() {
		return position;
	}
	public void setPosition(Position position) {
		this.position = position;
	}
	public Dimension getDimension() {
		return dimension;
	}
	public void setDimension(Dimension dimension) {
		this.dimension = dimension;
	}
	public Velocity getVelocity() {
		return velocity;
	}
	public void setVelocity(Velocity velocity) {
		this.velocity = velocity;
	}
	
}
