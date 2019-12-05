package model.game.factory;

import graphicmotor.GooContext;
import kernel.Kernel;
import kernel.PacManCollideWall;
import model.game.GameModel;
import model.game.PhisicDatas;
import model.game.entities.Entity;
import model.game.entities.Wall;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;
import physic.Velocity;

public class WallBuilder extends EntityBuilder {

	public WallBuilder(PhysicMotor phyMotor, Kernel kernel, GooContext GCtx, GameModel gameModel) {
		super(phyMotor, kernel, GCtx, gameModel);
	}

	@Override
	protected void buildItem(PhisicDatas phisicDatas) {
		Entity wall = new Wall();
		gameModel.walls.add(wall);
		
		initEntity(wall, phisicDatas);
		
		addCollisionDetection(gameModel.pacman, wall, new PacManCollideWall());
	}

	@Override
	protected PhisicDatas computePhysicData(Position position, double stepX, double stepY) {
		return new PhisicDatas(position, new Dimension((int)(stepX + 1), (int)(stepY + 1)), new Velocity(0,0) ); 
	}

}
