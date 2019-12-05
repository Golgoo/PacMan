package model.game.factory;

import graphicmotor.GooContext;
import kernel.Kernel;
import kernel.PacManCollideBound;
import model.game.GameModel;
import model.game.PhisicDatas;
import model.game.entities.Bound;
import model.game.entities.Entity;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;
import physic.Velocity;

public class BoundBuilder extends EntityBuilder{

	public BoundBuilder(PhysicMotor phyMotor, Kernel kernel, GooContext GCtx, GameModel gameModel) {
		super(phyMotor, kernel, GCtx, gameModel);
	}

	@Override
	protected void buildItem(PhisicDatas phisicDatas) {
		Entity bound = new Bound();
		gameModel.bounds.add(bound);
		
		initEntity(bound, phisicDatas);
		
		addCollisionDetection(gameModel.pacman, bound, new PacManCollideBound());
	}

	@Override
	protected PhisicDatas computePhysicData(Position position, double stepX, double stepY) {
		return new PhisicDatas(position, new Dimension((int)(stepX + 1), (int)(stepY + 1)), new Velocity() ); 
	}

}
