package kernel;

import kernel.state.SuperPacState;
import model.game.GameModel;
import model.game.entities.Entity;
import model.menu.MenuModel;
import singletons.Acessors;

public class PacManCollideSuperFruit implements CollisionTreatment {

	int score = -200 ;
	
	@Override
	public void treatCollision(Entity pacman, Entity superFruit) {
		int superFruitId = superFruit.getGraphicId();
		 
		Acessors.getPhysic().removeEntity(superFruit);
		Acessors.getGctx().destroyEntity(superFruitId);
		GameModel model = Acessors.getGameModel();
		model.superFruits.remove(superFruit);
		MenuModel menuModel = Acessors.getMenuModel();
		menuModel.addScore(score);
		Acessors.getMenuCtx().setText(menuModel.scoreEntity.getGraphicId(), menuModel.getScore()+"");
		
		model.superPacman = true ;
		
		pacman.getPrimalState().setState(new SuperPacState(pacman), 2000);
		
	}

}
