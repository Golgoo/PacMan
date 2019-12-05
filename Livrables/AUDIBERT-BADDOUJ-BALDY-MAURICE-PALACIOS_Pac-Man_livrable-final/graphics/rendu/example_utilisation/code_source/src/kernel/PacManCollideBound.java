package kernel;

import model.game.entities.Entity;

public class PacManCollideBound implements CollisionTreatment {

	@Override
	public void treatCollision(Entity pacman, Entity bound) {
		pacman.setVelocity(0, 0);
	}

}
