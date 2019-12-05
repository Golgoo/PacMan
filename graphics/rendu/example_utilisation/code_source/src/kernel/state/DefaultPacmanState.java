package kernel.state;

import model.game.entities.Entity;

public class DefaultPacmanState extends State {

	public DefaultPacmanState(Entity entity) {
		super(entity);
	}

	@Override
	public void activate() {
		gameCtx.setEntityColorMask(entity.getGraphicId(), 1.0f, 1.0f, 0.0f);
	}
	
	@Override
	public void released() {
		
	}
}
