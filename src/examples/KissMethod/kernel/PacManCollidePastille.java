package examples.KissMethod.kernel;

import graphicmotor.GooContext;
import examples.KissMethod.model.*;
import examples.KissMethod.sigletons.*;


public class PacManCollidePastille implements CollisionTreatment{

	private GooContext gctx ;
	
	private Model model ;
	
	
	private int score = 20 ;
	
	public PacManCollidePastille(GooContext gctx, Model model) {
		this.gctx = gctx ;
		this.model = model;
	}
	
	@Override
	public void treatCollision(Entity pacman, Entity pastille) {
		int pastilleId = pastille.getGraphicId();
		Acessors.getPhysic().removeEntity(pastille);
		gctx.destroyEntity(pastilleId);
		model.addScore(score);
	}

}
