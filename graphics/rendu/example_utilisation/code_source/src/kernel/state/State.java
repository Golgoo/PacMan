package kernel.state;

import graphicmotor.GooContext;
import model.game.GameModel;
import model.game.entities.Entity;
import model.menu.MenuModel;
import physic.PhysicMotor;
import singletons.Acessors;

public abstract class State {

	protected Entity entity ;
	
	protected GameModel gameModel ;
	protected MenuModel menuModel ;
	protected GooContext menuCtx ;
	protected GooContext gameCtx ;
	protected PhysicMotor phyMotor ;

	
	public State(Entity entity) {
		this.entity = entity ;
		initAcessors();
	}
	
	private void initAcessors() {
		gameModel = Acessors.getGameModel();
		menuCtx = Acessors.getMenuCtx();
		gameCtx = Acessors.getGctx();
		phyMotor = Acessors.getPhysic();
		menuModel = Acessors.getMenuModel();
	}

	public abstract void activate();

	public abstract void released();
	
}
