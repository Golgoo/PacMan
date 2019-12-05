package model.game.factory;

import java.util.LinkedList;
import java.util.List;

import graphicmotor.GooContext;
import kernel.CollisionTreatment;
import kernel.Kernel;
import model.game.GameModel;
import model.game.PhisicDatas;
import model.game.entities.Entity;
import physic.Collision;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;

public abstract class EntityBuilder {
	
	protected PhysicMotor phyMotor ;
	protected Kernel kernel ;
	protected GooContext GCtx ;
	protected GameModel gameModel ;
	
	public EntityBuilder(PhysicMotor phyMotor, Kernel kernel, GooContext GCtx, GameModel gameModel) {
		this.phyMotor = phyMotor;
		this.kernel = kernel;
		this.GCtx = GCtx;
		this.gameModel = gameModel;
	}
	
	List<PhisicDatas> itemsToBuild = new LinkedList<PhisicDatas>();
	
	public void addItemToBuild(Position position, double stepX, double stepY) {
		itemsToBuild.add(computePhysicData(position, stepX, stepY));
	}
	
	protected abstract PhisicDatas computePhysicData(Position position, double stepX, double stepY);
	
	public void build() {
		for(PhisicDatas phiData : itemsToBuild) {
			buildItem(phiData);
		}
	}
	
	protected abstract void buildItem(PhisicDatas phisicDatas);

	protected void addCollisionDetection(Entity src, Entity dst, CollisionTreatment collisionTreatment) {
		Collision colision = new Collision(src, dst);
		phyMotor.registerCollision(colision);
		kernel.addCollisionTreatment(colision, collisionTreatment);
	}
	
	protected void initEntity(Entity entity, PhisicDatas phisicDatas) {
		initEntityPhisic(entity, phisicDatas);
		initEntityGraphic(entity);
	}
    
	private void initEntityPhisic(Entity entity, PhisicDatas phisicDatas) {
		entity.setPhisicDatas(phisicDatas);
		phyMotor.add(entity);
	}

	private void initEntityGraphic(Entity entity) {
		int entityGraphicId = entity.getGraphicId();
		Position entityPosition = entity.getPhisicDatas().getPosition();
		Dimension entityDimension = entity.getPhisicDatas().getDimension();
		
		GCtx.setEntityPosition(entityGraphicId, entityPosition.getX(), entityPosition.getY());
		GCtx.setEntitySize(entityGraphicId, entityDimension.getWidth(), entityDimension.getHeight());
		GCtx.enableEntity(entityGraphicId);
	}
}
