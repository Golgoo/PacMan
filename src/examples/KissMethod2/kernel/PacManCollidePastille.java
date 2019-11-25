package examples.KissMethod2.kernel;

import examples.KissMethod2.model.Entity;
import examples.KissMethod2.model.Model;
import examples.KissMethod2.sigletons.*;

public class PacManCollidePastille implements CollisionTreatment{

	private int score = 20 ;
	
	@Override
	public void treatCollision(Entity pacman, Entity pastille) {
		int pastilleId = pastille.getGraphicId();
		
		Acessors.getPhysic().removeEntity(pastille);
		Acessors.getGctx().destroyEntity(pastilleId);
		Model model = Acessors.getModel() ;
		model.fruits.remove(pastille); 
		
		model.addScore(score);
		Acessors.getMenuCtx().setText(model.scoreEntity.getGraphicId(), model.getScore()+"");

		if(model.fruits.isEmpty())
			model.gameWon = true;
	}

}
