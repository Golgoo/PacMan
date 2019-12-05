package model.game.entities;

import graphicmotor.GooContext;
import singletons.Acessors;

public class SuperFruit extends Entity {

	@Override
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		int ref = GCtx.createSimpleRect();
		GCtx.setEntityColorMask(ref, 0.0f, 0.0f, 1.0f);
		return ref;
	}

}
