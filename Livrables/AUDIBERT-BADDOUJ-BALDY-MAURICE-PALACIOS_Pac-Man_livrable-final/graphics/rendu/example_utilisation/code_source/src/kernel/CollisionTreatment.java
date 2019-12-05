package kernel;

import model.game.entities.Entity;

public interface CollisionTreatment {
	public void treatCollision (Entity src, Entity dst);
}
  