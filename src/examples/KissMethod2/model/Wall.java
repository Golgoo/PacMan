package examples.KissMethod2.model;

import graphicmotor.GooContext;
import examples.KissMethod2.sigletons.Acessors;

public class Wall extends Entity{

	@Override
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		int ref = GCtx.createSimpleRect();
		GCtx.setEntityColorMask(ref, 0.4f, 0.2f, 1.0f);
		return ref ;
	}

}
