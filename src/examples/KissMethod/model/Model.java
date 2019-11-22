package examples.KissMethod.model;


public class Model {
	public Entity PacMan ;
	public Entity pastille ;
	public Entity RightBound ;
	
	
	private int score = 0 ;
	
	public void addScore(int score) {
		this.score += score ;
	}
	
	public int getScore() {
		return score ;
	}
}
