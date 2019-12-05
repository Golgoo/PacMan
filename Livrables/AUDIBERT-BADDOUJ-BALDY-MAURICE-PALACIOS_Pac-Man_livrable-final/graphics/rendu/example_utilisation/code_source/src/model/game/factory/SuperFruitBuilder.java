package model.game.factory;

import graphicmotor.GooContext;
import kernel.Kernel;
import kernel.PacManCollideSuperFruit;
import model.game.GameModel;
import model.game.PhisicDatas;
import model.game.entities.Entity;
import model.game.entities.SuperFruit;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;
import physic.Velocity;

public class SuperFruitBuilder extends EntityBuilder {

	private double superFruitRatio = 0.4 ;
	private double superFruitOffset = 0.5 -( superFruitRatio / 2.0 );
	
	public SuperFruitBuilder(PhysicMotor phyMotor, Kernel kernel, GooContext GCtx, GameModel gameModel) {
		super(phyMotor, kernel, GCtx, gameModel);
	}

	@Override
	protected void buildItem(PhisicDatas phisicDatas) {
		Entity superFruit = new SuperFruit();
		gameModel.superFruits.add(superFruit);

		initEntity(superFruit, phisicDatas);
		
		addCollisionDetection(gameModel.pacman, superFruit, new PacManCollideSuperFruit());
	}

	@Override
	protected PhisicDatas computePhysicData(Position position, double stepX, double stepY) {
		position.setX(position.getX() + (int)(superFruitOffset*stepX));
		position.setY(position.getY() + (int)(superFruitOffset*stepY));
		return new PhisicDatas(position, new Dimension((int)(stepX * superFruitRatio), (int)(stepY * superFruitRatio)), new Velocity());
	}

}
