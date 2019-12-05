package kernel;

import model.game.GameModel;
import model.game.entities.Entity;
import singletons.Acessors;

public class PacManCollideWall implements CollisionTreatment {

	@Override
	public void treatCollision(Entity pacman, Entity wall) {
		GameModel model = Acessors.getGameModel();
		if(model.steroidPacMan) {
			Acessors.getPhysic().removeEntity(wall);
			model.walls.remove(wall);
			Acessors.getGctx().destroyEntity(wall.getGraphicId());
		}else {
			pacman.setVelocity(0, 0);
		}
	}
 
}
