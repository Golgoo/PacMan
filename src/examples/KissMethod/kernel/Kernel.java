package examples.KissMethod.kernel;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import graphicmotor.GooContext;
import examples.KissMethod.model.*;
import examples.KissMethod.physic.*;

public class Kernel {
	
	private Motor pyMotor;
	private Model model;
	private GooContext GCtx;
	
	private Map<Collision, CollisionTreatment> collisionTreatmentMap = new HashMap<Collision, CollisionTreatment>();
	
	public Kernel(Motor phisicMotor, Model model, GooContext GCtx) {
		this.pyMotor = phisicMotor;
		this.model = model ;
		this.GCtx = GCtx;
	}
	
	public void addCollisionTreatment(Collision colision, CollisionTreatment collisionTreatment) {
		this.collisionTreatmentMap.put(colision, collisionTreatment);
	}
	
	public void movePacman() {
		Entity pacman = model.PacMan;
		List<Collision> collisions = pyMotor.getFutureCollisions(pacman);
		for(Collision c : collisions) {
			collisionTreatmentMap.get(c).treatCollision(c.getSrc(), c.getDst());
		}
		pyMotor.move(pacman);
		GCtx.setEntityPosition(pacman.getGraphicId(), pyMotor.getPosition(pacman).getX(), pyMotor.getPosition(pacman).getY());
	}
}
