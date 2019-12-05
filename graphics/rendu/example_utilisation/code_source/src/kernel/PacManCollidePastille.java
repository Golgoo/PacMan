package kernel;

import model.game.GameModel;
import model.game.entities.Entity;
import model.menu.MenuModel;
import singletons.*;

public class PacManCollidePastille implements CollisionTreatment{

	private int score = 20 ;
	
	@Override
	public void treatCollision(Entity pacman, Entity pastille) {
		int pastilleId = pastille.getGraphicId();
		
		Acessors.getPhysic().removeEntity(pastille);
		Acessors.getGctx().destroyEntity(pastilleId);
		GameModel model = Acessors.getGameModel() ;
		model.fruits.remove(pastille); 
		
		MenuModel menuModel = Acessors.getMenuModel();
		menuModel.addScore(score);
		Acessors.getMenuCtx().setText(menuModel.scoreEntity.getGraphicId(), menuModel.getScore()+"");

		if(model.fruits.isEmpty())
			model.gameWon = true;
	}

}
