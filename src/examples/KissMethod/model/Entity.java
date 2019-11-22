package examples.KissMethod.model;

import graphicmotor.GooContext;

public abstract class Entity {
	
	private int graphicId = -1 ;
	
	public abstract int initGraphic(GooContext GCtx);
	
	public Entity(GooContext GCtx) {
		graphicId = initGraphic(GCtx);
	}
	
	public int getGraphicId() {
		return graphicId;
	}
}
