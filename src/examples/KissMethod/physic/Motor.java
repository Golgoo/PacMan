package examples.KissMethod.physic;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import examples.KissMethod.model.Entity;

public class Motor {
	private Map<Entity, PhisicDatas> physicMap = new HashMap<>();
	
	private Map<Entity, List<Collision>> colisionsMap = new HashMap<Entity, List<Collision>>();
	
	public void move(Entity entity) {
		PhisicDatas pDatas = physicMap.get(entity);
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
		
		PhisicDatas pDatas = physicMap.get(entity);
		Position currentPosition = pDatas.getPosition();
		Velocity velocity = pDatas.getVelocity();
		
		Position nextPosition = new Position(currentPosition.getX() + velocity.getxVel(), currentPosition.getY()+velocity.getyVel());
		Dimension currentDimension = pDatas.getDimension();
		
		PhisicDatas otherDatas ;
		for(Collision collision : registeredCollisions) {
			otherDatas = physicMap.get(collision.getDst());
			if(intersect(nextPosition, currentDimension, otherDatas.getPosition(), otherDatas.getDimension()))
				concreteCollisions.add(collision);
		}
		return concreteCollisions;
	}
	
	private boolean intersect(Position ap, Dimension ad, Position bp, Dimension bd) {
		int ax1, ax2, ay1, ay2;
		int bx1, bx2, by1, by2;
		
		ax1 = ap.getX();
		ax2 = ax1 + ad.getWeight();
		ay1 = ap.getY();
		ay2 = ay1 + ad.getHeight();
		
		bx1 = bp.getX();
		bx2 = bx1 + bd.getWeight();
		by1 = bp.getY();
		by2 = bx2 + bd.getHeight();
		
		if((ax1 > bx1 && ax1 < bx2) || ( ax2 > bx1 && ax2 < bx2 ) || ( bx1 > ax1 && bx1 < ax2) || (bx2 > ax1 && bx2 < ax2) ) {
			if((ay1 > by1 && ay1 < by2) || (ay2 < by2 && ay2 > by1) || (ay1 < by1 && ay2 > by2)) {
				return true;
			}
		}
		return false;
	}
	
	public void registerCollision (Collision colision) {
		colisionsMap.get(colision.getSrc()).add(colision);
	}
	
	public void add(Entity entity, PhisicDatas phisicDatas) {
		physicMap.put(entity, phisicDatas);
		colisionsMap.put(entity, new LinkedList<Collision>());
	}
	
	public void setPosition(Entity entity, int x, int y) {
		Position p = physicMap.get(entity).getPosition();
		p.setX(x);
		p.setY(y);
	}
	
	public void setDimension(Entity entity, int width, int height) {
		Dimension d = physicMap.get(entity).getDimension();
		d.setWeight(width);
		d.setHeight(height);
	}
	
	public void setVelocity(Entity entity, int xVel, int yVel) {
		Velocity v = physicMap.get(entity).getVelocity();
		v.setxVel(xVel);
		v.setyVel(yVel);
	}

	public Position getPosition(Entity entity) {
		return physicMap.get(entity).getPosition();
	}

	public void removeEntity(Entity entity) {
		physicMap.remove(entity);
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

		
}
