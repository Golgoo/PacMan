package examples.KissMethod;

import javax.swing.JFrame;


import graphicmotor.GooContext;
import examples.KissMethod.model.*;
import examples.KissMethod.physic.*;
import examples.KissMethod.sigletons.*;
import examples.KissMethod.kernel.*;

public class Main {
	
	private static int FPS = 60 ;
	
	private static GooContext GCtx ;
	private static Model model ;
	private static Motor phyMotor ;
	private static Kernel kernel ;
	
	static Dimension pacManDim = new Dimension(50, 50);
	static Position pacManPos = new Position(200, 280);
	static Velocity pacManVel = new Velocity(0, 0);
	
	static Dimension pastilleDim = new Dimension(20, 20);
	static Position pastillePos = new Position(500, 300);
	static Velocity pastilleVel = new Velocity(0, 0);

	
	public static void main(String[] args) {
		
		initGraphic();
		
		initModel();
		initPhysic();
		bindPhysicToGraphic();
		
		kernel = new Kernel(phyMotor, model, GCtx);
		Collision collision = new Collision(model.PacMan, model.pastille);
		CollisionTreatment collisionTreatment = new PacManCollidePastille(GCtx, model);
		kernel.addCollisionTreatment(collision, collisionTreatment);
		phyMotor.registerCollision(collision);
		
		Collision collision2 = new Collision(model.PacMan, model.RightBound);
		CollisionTreatment collisionTreatment2 = new PacManCollideBounds();
		kernel.addCollisionTreatment(collision2, collisionTreatment2);
		phyMotor.registerCollision(collision2);
		
		//User Input Right => 
		phyMotor.setVelocity(model.PacMan, 2, 0);
		
		long previousTime ;
		long finishedTime ;
		while(true) {
			previousTime = System.currentTimeMillis();
			
			kernel.movePacman();
			
			finishedTime = System.currentTimeMillis() ;
	    	pause(frameRate - ( finishedTime - previousTime ) );
		}
	}
	private final static long frameRate = 17 ;
    
	private static void pause(long millisec) {
    	if(millisec > 0) {
    		try {
    			Thread.sleep(millisec);
    		} catch (InterruptedException e) {
    			System.err.println("In pause function : ");
    			e.printStackTrace();
    		}
    	}
	}

	private static void initGraphic() {
		GCtx = new GooContext(600, 600);
		Acessors.setGctx(GCtx);
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.add(GCtx.getCanvas());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GCtx.start(FPS);
	}
	
	private static void initModel() {
		model = new Model();
		Acessors.setModel(model);
		model.PacMan = new PacMan(GCtx);
		model.pastille = new Pastille(GCtx);
		model.RightBound = new Bounds(GCtx);
	}
	
	private static void initPhysic() {
		phyMotor = new Motor();
		Acessors.setPhysic(phyMotor);
		phyMotor.add(model.PacMan, new PhisicDatas(pacManPos, pacManDim, pacManVel));
		phyMotor.add(model.pastille, new PhisicDatas(pastillePos, pastilleDim, pastilleVel));
		phyMotor.add(model.RightBound, new PhisicDatas(new Position(599, 0), new Dimension(1, 600), new Velocity(0, 0)));
	}

	private static void bindPhysicToGraphic() {
		int pacRef = model.PacMan.getGraphicId();
		
		GCtx.setEntityPosition(pacRef, pacManPos.getX(), pacManPos.getY());
		GCtx.setEntitySize(pacRef, pacManDim.getWeight(), pacManDim.getHeight());
		GCtx.setZIndex(pacRef, 2);
		GCtx.enableEntity(pacRef);
		
		int pastilleRef = model.pastille.getGraphicId();
		GCtx.setEntityPosition(pastilleRef, pastillePos.getX(), pastillePos.getY());
		GCtx.setEntitySize(pastilleRef, pastilleDim.getWeight(), pastilleDim.getHeight());
		GCtx.setZIndex(pastilleRef, 1);
		GCtx.enableEntity(pastilleRef);
	}

}
