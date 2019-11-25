package examples.KissMethod2.model;

import java.awt.Font;
import graphicmotor.GooContext;
import examples.KissMethod2.sigletons.Acessors;
import examples.KissMethod2.util.FontLoader;

public class ScoreEntity extends Entity {
	
	@Override
	public int initGraphic() {
		
		String fontName = "examples/KissMethod2/HeadlinerNo45-59y8.ttf";
		
		GooContext MenuCtx = Acessors.getMenuCtx();
		
		Font font = FontLoader.load("src/"+fontName, 38.0f);
		
		int textRef = MenuCtx.createTextEntity(font);
		
		MenuCtx.setText(textRef, "0");
		MenuCtx.setZIndex(textRef, 3);
		
		/*TODO :
		 * Put this block somewhere else
		 */
		MenuCtx.enableEntity(textRef);
		MenuCtx.setEntityPosition(textRef, 400, 74);
		MenuCtx.setEntityColorMask(textRef, 0.2f, 0.0f, 1.0f);
		/*
		 * 
		 */
		
		return textRef;
	}

}
