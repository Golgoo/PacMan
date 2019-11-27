package examples.KissMethod2.model;

import examples.KissMethod2.sigletons.Acessors;
import graphicmotor.GooContext;

public class Pastille extends Entity{

	@Override
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		int ref = GCtx.createStaticEntity("src/examples/KissMethod2/whitedot.png");

		GCtx.setEntityColorMask(ref, 1.0f, 0.0f, 0.0f);

		return ref ;
	}
 
}
