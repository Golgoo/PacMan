package model.game.factory;

import graphicmotor.GooContext;
import kernel.Kernel;
import kernel.PacManCollidePastille;
import model.game.GameModel;
import model.game.PhisicDatas;
import model.game.entities.Entity;
import model.game.entities.Fruit;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;
import physic.Velocity;

public class FruitBuilder extends EntityBuilder {

	private double fruitRatio = 0.3 ;
	private double fruitOffset = 0.5 - ( fruitRatio / 2.0);
	
	public FruitBuilder(PhysicMotor phyMotor, Kernel kernel, GooContext GCtx, GameModel gameModel) {
		super(phyMotor, kernel, GCtx, gameModel);
	}

	@Override
	protected void buildItem(PhisicDatas phisicDatas) {
		Entity fruit = new Fruit();
		gameModel.fruits.add(fruit);

		initEntity(fruit, phisicDatas);
		
		addCollisionDetection(gameModel.pacman, fruit, new PacManCollidePastille());
	}

	@Override
	protected PhisicDatas computePhysicData(Position position, double stepX, double stepY) {
		position.setX(position.getX() + (int)(fruitOffset*stepX));
		position.setY(position.getY() + (int)(fruitOffset*stepY));
		return new PhisicDatas(position, new Dimension((int)(stepX * fruitRatio), (int)(stepY * fruitRatio)), new Velocity() );
	}

}
