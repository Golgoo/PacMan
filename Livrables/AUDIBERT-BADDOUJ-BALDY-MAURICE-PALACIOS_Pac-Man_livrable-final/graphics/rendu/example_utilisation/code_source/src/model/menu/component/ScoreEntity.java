package model.menu.component;

import java.awt.Font;
import graphicmotor.GooContext;
import model.game.entities.Entity;
import singletons.Acessors;
import util.loader.font.FontEnum;
import util.loader.font.FontLoader;

public class ScoreEntity extends Entity {
	
	@Override
	public int initGraphic() {
		GooContext menuCtx = Acessors.getMenuCtx();
		
		Font font = FontLoader.load(FontEnum.Enum.HEADLINE_FONT, 45.0f);
		
		int textRef = menuCtx.createTextEntity(font);
		
		menuCtx.setEntityColorMask(textRef, 1.0f, 1.0f, 1.0f);
		menuCtx.setZIndex(textRef, 2);
		
		
		return textRef;
	}

}
