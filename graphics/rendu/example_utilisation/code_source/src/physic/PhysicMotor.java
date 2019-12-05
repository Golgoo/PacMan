package physic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.game.PhisicDatas;
import model.game.entities.Entity;

public class PhysicMotor {
	
	private Map<Entity, List<Collision>> colisionsMap ;
	
	public void move(Entity entity) {
		PhisicDatas pDatas = entity.getPhisicDatas();
		Position p = pDatas.getPosition();
		Velocity v = pDatas.getVelocity();
		p.setX(p.getX() + v.getxVel());
		p.setY(p.getY() + v.getyVel());
	}
	
	public List<Collision> getFutureCollisions(Entity entity){
		List<Collision> concreteCollisions = new LinkedList<Collision>();

		List<Collision> registeredCollisions = colisionsMap.get(entity);
		if(registeredCollisions == null || registeredCollisions.size() == 0) 
			return concreteCollisions;
		
		PhisicDatas pDatas = entity.getPhisicDatas();
		Position currentPosition = pDatas.getPosition();
		Velocity velocity = pDatas.getVelocity();
		
		Position nextPosition = new Position(currentPosition.getX() + velocity.getxVel(), currentPosition.getY()+velocity.getyVel());
		Dimension currentDimension = pDatas.getDimension();
		
		PhisicDatas otherDatas ;
		for(Collision collision : registeredCollisions) {
			otherDatas = collision.getDst().getPhisicDatas();
			if(intersect(nextPosition, currentDimension, otherDatas.getPosition(), otherDatas.getDimension()))
				concreteCollisions.add(collision);
		}
		return concreteCollisions;
	}
	
	private boolean intersect(Position ap, Dimension ad, Position bp, Dimension bd) {
		int ax1, ax2, ay1, ay2;
		int bx1, bx2, by1, by2;
		
		ax1 = ap.getX();
		ax2 = ax1 + ad.getWidth();
		ay1 = ap.getY();
		ay2 = ay1 + ad.getHeight();
		
		bx1 = bp.getX();
		bx2 = bx1 + bd.getWidth();
		by1 = bp.getY();
		by2 = by1 + bd.getHeight();
		
		int maxgauche = Math.max(ax1, bx1);
		int mindroit = Math.min(ax2, bx2);
		int maxbas = Math.max(ay1, by1);
		int	minhaut = Math.min(ay2, by2);

		return (maxgauche < mindroit && maxbas < minhaut);
	}
	
	public void registerCollision (Collision colision) {
		colisionsMap.get(colision.getSrc()).add(colision);
	}
	
	public void add(Entity entity) {
		colisionsMap.put(entity, new LinkedList<Collision>());
	}

	public void removeEntity(Entity entity) {
		colisionsMap.remove(entity);
		for(List<Collision> collisions : colisionsMap.values()) {
			for(int i = 0 ; i < collisions.size() ; i ++) {
				if(collisions.get(i).getDst() == entity) {
					collisions.remove(i);
					i--;
				}
			}
		}
	}

	public void init() {
		colisionsMap = new HashMap<Entity, List<Collision>>();
	}

		
}
