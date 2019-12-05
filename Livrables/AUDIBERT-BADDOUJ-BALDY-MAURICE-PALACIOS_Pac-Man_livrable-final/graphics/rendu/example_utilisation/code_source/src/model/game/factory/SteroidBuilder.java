package model.game.factory;

import graphicmotor.GooContext;
import kernel.Kernel;
import kernel.PacManCollideSteroid;
import model.game.GameModel;
import model.game.PhisicDatas;
import model.game.entities.Entity;
import model.game.entities.Steroid;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;
import physic.Velocity;

public class SteroidBuilder extends EntityBuilder {

	private double steroidRatio = 0.4;
	private double steroidOffset = 0.5 -( steroidRatio / 2.0 );;
	
	public SteroidBuilder(PhysicMotor phyMotor, Kernel kernel, GooContext GCtx, GameModel gameModel) {
		super(phyMotor, kernel, GCtx, gameModel);
	}

	@Override
	protected void buildItem(PhisicDatas phisicDatas) {
		Entity steroid = new Steroid();
		gameModel.steroids.add(steroid);
		
		initEntity(steroid, phisicDatas);
		
		addCollisionDetection(gameModel.pacman, steroid, new PacManCollideSteroid());
	}

	@Override
	protected PhisicDatas computePhysicData(Position position, double stepX, double stepY) {
		position.setX(position.getX() + (int)(steroidOffset*stepX));
		position.setY(position.getY() + (int)(steroidOffset*stepY));
    	return new PhisicDatas(position, new Dimension((int)(stepX * steroidRatio), (int)(stepY * steroidRatio)), new Velocity()) ;
	}

}
