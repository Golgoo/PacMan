package model.game.entities;

import graphicmotor.GooContext;
import singletons.Acessors;

public class Wall extends Entity{

	@Override
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		int ref = GCtx.createSimpleRect();
		GCtx.setEntityColorMask(ref, 0.4f, 0.2f, 1.0f);
		return ref ;
	}

}
