package model.menu.factory;

import graphicmotor.GooContext;
import kernel.Kernel;
import model.menu.MenuModel;
import model.menu.component.ScoreEntity;
import physic.Dimension;
import singletons.Acessors;

public class MenuFactory {
	public static void createInGameMenu(Kernel kernel, Dimension menuSize) {
		MenuModel menuModel = Acessors.getMenuModel();
		
		GooContext menuGCtx = Acessors.getMenuCtx();

		menuModel.scoreEntity = new ScoreEntity();
		menuModel.setScore(0);
		
		int scoreGraphicId = menuModel.scoreEntity.getGraphicId();
		menuGCtx.setEntityPosition(scoreGraphicId, menuSize.getWidth() - 100, menuSize.getHeight()/2 + 15);
		menuGCtx.setText(scoreGraphicId, menuModel.getScore()+"");
		menuGCtx.enableEntity(scoreGraphicId);

		menuModel.highScoreEntity = new ScoreEntity();
		
		int hightScoreGId = menuModel.highScoreEntity.getGraphicId();
		menuGCtx.setEntityPosition(hightScoreGId, 20, menuSize.getHeight()/2 + 15);
		menuGCtx.setText(hightScoreGId, "HighScore : " +menuModel.currentHighScore+"");
		menuGCtx.enableEntity(hightScoreGId);
	}
}
