package kernel.state;

import model.game.entities.Entity;

public class SteroidPacState extends State {

	public SteroidPacState(Entity entity) {
		super(entity);
	}

	@Override
	public void activate() {
		gameModel.steroidPacMan = true;
		gameCtx.setEntityColorMask(entity.getGraphicId(), 0.0f, 1.0f, 0.0f);
	}

	@Override
	public void released() {
		gameModel.steroidPacMan = false;
	}

}
