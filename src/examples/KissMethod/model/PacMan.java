package examples.KissMethod.model;

import graphicmotor.GooContext;

public class PacMan extends Entity{

	public PacMan(GooContext GCtx) {
		super(GCtx);
	}
	
	@Override
	public int initGraphic(GooContext GCtx) {
		int ref = GCtx.createSingleAnimatedEntity("src/examples/KissMethod/360x640-pacman-spritesheet.png", 5, 50);
		
		return ref ;
	}

}
