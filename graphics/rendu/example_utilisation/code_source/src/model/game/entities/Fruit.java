package model.game.entities;

import graphicmotor.GooContext;
import singletons.Acessors;
import util.loader.sprite.SpriteEnum;
import util.loader.sprite.SpriteLoader;

public class Fruit extends Entity{

	@Override
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		int ref = GCtx.createStaticEntity(SpriteLoader.getRessourceStream(SpriteEnum.Enum.FRUIT_IMAGE, Acessors.getGameModel().getSkin()));
		GCtx.setEntityColorMask(ref, 1.0f, 0.0f, 0.0f);
		return ref;
	}
}
