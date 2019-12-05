package model.game.entities;

import graphicmotor.GooContext;
import singletons.Acessors;

public class Bound extends Entity{

	@Override
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		int ref = GCtx.createSimpleRect();
		GCtx.setEntityColorMask(ref, 0.2f, 0.1f, 0.5f);
		return ref ;
	}

}
