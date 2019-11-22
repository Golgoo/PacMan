package examples.KissMethod.model;

public class Model {
	public Entity PacMan ;
	public Entity pastille ;

	private int score = 0 ;
	
	public void addScore(int score) {
		this.score += score ;
	}
	
	public int getScore() {
		return score ;
	}
}
