package model.game.factory;

import graphicmotor.GooContext;
import kernel.Kernel;
import model.game.GameModel;
import model.game.PhisicDatas;
import model.game.entities.Entity;
import model.game.entities.PacMan;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;
import physic.Velocity;
import util.Direction;

public class PacManBuilder extends EntityBuilder{

	public PacManBuilder(PhysicMotor phyMotor, Kernel kernel, GooContext GCtx, GameModel gameModel) {
		super(phyMotor, kernel, GCtx, gameModel);
	}
	
	private double stepX ;

	@Override
	protected void buildItem(PhisicDatas phisicDatas) {
		Entity pacman = new PacMan();
		gameModel.pacman = pacman ;
		gameModel.minimumPacManDim = new Dimension(phisicDatas.getDimension().getWidth()/4, phisicDatas.getDimension().getHeight()/4);
		gameModel.maximumPacManDim = new Dimension(phisicDatas.getDimension().getWidth(), phisicDatas.getDimension().getHeight());
		initEntity(pacman, phisicDatas);
		
		GCtx.setEntityColorMask(pacman.getGraphicId(), 1.0f, 1.0f, 0.0f);
		GCtx.setMultipledAnimatedEntityAnimation(pacman.getGraphicId(), Direction.RIGHT);

        gameModel.pacmanSpeedVelocity = (int) (stepX / 12.0) ;
	}

	@Override
	protected PhisicDatas computePhysicData(Position position, double stepX, double stepY) {
		this.stepX = stepX ;
		position.setX(position.getX() + 1);
		position.setY(position.getY() + 1);
		return new PhisicDatas(position, new Dimension((int) (stepX * 0.7), (int) (stepY * 0.7) ), new Velocity());
	}
	
}
