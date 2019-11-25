package examples.KissMethod2.model;

public abstract class Entity {
	
	private int graphicId = -1 ;
	
	public abstract int initGraphic();
	
	public Entity() {
		graphicId = initGraphic();
	}
	
	public int getGraphicId() {
		return graphicId;
	}
}
