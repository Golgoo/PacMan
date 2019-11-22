package examples.KissMethod.model;

import graphicmotor.GooContext;

public class Pastille extends Entity{

	public Pastille(GooContext GCtx) {
		super(GCtx);
	}

	@Override
	public int initGraphic(GooContext GCtx) {
		return GCtx.createStaticEntity("src/examples/KissMethod/red.png");
	}

}
