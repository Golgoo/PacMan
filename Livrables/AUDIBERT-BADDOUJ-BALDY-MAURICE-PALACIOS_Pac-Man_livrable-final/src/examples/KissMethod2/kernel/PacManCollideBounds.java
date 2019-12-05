package examples.KissMethod2.kernel;

import examples.KissMethod2.model.Entity;
import examples.KissMethod2.sigletons.Acessors;

public class PacManCollideBounds implements CollisionTreatment {

	@Override
	public void treatCollision(Entity pacman, Entity Bounds) {
		Acessors.getPhysic().setVelocity(pacman, 0, 0);
		//Acessors.getGctx().setEntityColorMask(pacman.getGraphicId(), 1.0f, 0.5f, 0.5f);
	}
 
}
