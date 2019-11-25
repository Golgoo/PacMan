package examples.KissMethod2.model;

import examples.KissMethod2.sigletons.Acessors;

public class Pastille extends Entity{

	@Override
	public int initGraphic() {
		return Acessors.getGctx().createStaticEntity("src/examples/KissMethod2/red.png");
	}
 
}
