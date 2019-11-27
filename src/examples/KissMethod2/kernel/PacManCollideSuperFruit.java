package examples.KissMethod2.kernel;

import examples.KissMethod2.model.Entity;
import examples.KissMethod2.model.Model;
import examples.KissMethod2.sigletons.Acessors;

public class PacManCollideSuperFruit implements CollisionTreatment {

	int score = -200 ;
	
	@Override
	public void treatCollision(Entity pacman, Entity superFruit) {
		int superFruitId = superFruit.getGraphicId();
		 
		Acessors.getPhysic().removeEntity(superFruit);
		Acessors.getGctx().destroyEntity(superFruitId);
		Model model = Acessors.getModel();
		model.superFruits.remove(superFruit);
		model.addScore(score);
		
		model.stopSuperPack.cancel();
		model.reloadStopSuperPackTask();
		Acessors.getTimer().schedule(model.stopSuperPack, 2000);
		Acessors.getGctx().setEntityColorMask(pacman.getGraphicId(), 0.1f, 0.02f, 1.0f);
	}

}
