package examples.KissMethod.physic;

public class Velocity {
	private int xVel, yVel;

	public Velocity(int xVel, int yVel) {
		super();
		this.xVel = xVel;
		this.yVel = yVel;
	}

	public int getxVel() {
		return xVel;
	}

	public void setxVel(int xVel) {
		this.xVel = xVel;
	}

	public int getyVel() {
		return yVel;
	}

	public void setyVel(int yVel) {
		this.yVel = yVel;
	}
}
