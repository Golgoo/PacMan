package kernel.state;

import model.game.entities.Entity;

public class SuperPacState extends State{

	public SuperPacState(Entity entity) {
		super(entity);
	}
	
	@Override
	public void activate() {
		int entityId = entity.getGraphicId();
		gameCtx.setEntityColorMask(entityId, 0.0f, 0.0f, 1.0f);
		gameModel.superPacman = true ;
	}

	@Override
	public void released() {
		gameModel.superPacman = false ;
	}

}
