package examples.KissMethod.model;

import graphicmotor.GooContext;

public class Bounds extends Entity{

	public Bounds(GooContext GCtx) {
		super(GCtx);
	}

	//No graphic for frame bounds but collision
	@Override
	public int initGraphic(GooContext GCtx) {
		return 0;
	}
	
	
	
}
