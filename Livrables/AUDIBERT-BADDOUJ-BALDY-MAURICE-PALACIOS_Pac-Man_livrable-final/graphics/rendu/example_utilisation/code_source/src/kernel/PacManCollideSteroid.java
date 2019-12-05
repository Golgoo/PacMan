package kernel;

import graphicmotor.GooContext;
import kernel.state.SteroidPacState;
import model.game.entities.Entity;
import singletons.Acessors;

public class PacManCollideSteroid implements CollisionTreatment {

	@Override
	public void treatCollision(Entity pacman, Entity steroid) {
		GooContext GCtx = Acessors.getGctx();
		
		GCtx.setEntityColorMask(pacman.getGraphicId(), 0.0f, 1.0f, 0.0f);
		
		
		GCtx.destroyEntity(steroid.getGraphicId());
		Acessors.getPhysic().removeEntity(steroid);
		Acessors.getGameModel().steroids.remove(steroid);
		
		pacman.getPrimalState().setState(new SteroidPacState(pacman), 1000);
	}

}
