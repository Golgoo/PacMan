package examples.KissMethod2.model;

import graphicmotor.GooContext;
import examples.KissMethod2.sigletons.Acessors;

public class SuperFruit extends Entity {

	@Override
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		int ref = GCtx.createSimpleRect();
		GCtx.setEntityColorMask(ref, 0.0f, 0.0f, 1.0f);
		return ref;
	}

}
