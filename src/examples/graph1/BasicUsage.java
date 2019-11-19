package example.graph1;

import javax.swing.JFrame;

import graphicmotor.GooContext;

public class BasicUsage {
	
	private static int FPS = 60 ;
	
	
	
	public static void main(String args[]) {
		/*****************BASIC INIT **********************/
		GooContext gooCtx = new GooContext(600, 600);
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.add(gooCtx.getCanvas());
		
		frame.setVisible(true);
		
		/*****************BASIC SHAPE **********************/
		int rectRef = gooCtx.createSimpleRect();
		gooCtx.setEntitySize(rectRef, 50, 50);
		gooCtx.setEntityPosition(rectRef, 12, 6);
		gooCtx.setEntityColorMask(rectRef, 1.0f, 1.0f, 0.4f);
		gooCtx.enableEntity(rectRef);
		
		/*****************START FUNCTION********************/
		gooCtx.start(FPS);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/*****************BASIC ANIMATION **********************/
		String pathToSprites = "src/sprites_1.png" ;
        int nbSpritesInALine = 6 ;
        long animationScheduleTimeMs = 60 ;


        int entityReference2 = gooCtx.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs*3/4);

        gooCtx.setEntityPosition(entityReference2, 300, 200);
        gooCtx.setEntitySize(entityReference2, 150, 180);
        gooCtx.setEntityColorMask(entityReference2, 1.0f, 0.4f, 0.1f);
        gooCtx.setZIndex(entityReference2, 3);


        gooCtx.enableEntity(entityReference2);
        
        
        int entityReference = gooCtx.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs);

        gooCtx.setEntityPosition(entityReference, 330, 150);
        gooCtx.setEntitySize(entityReference, 0.3f, 0.35f);
        gooCtx.setEntityColorMask(entityReference, 1.0f, 0.4f, 1.0f);
        gooCtx.setZIndex(entityReference, 2);

        gooCtx.enableEntity(entityReference);
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

        gooCtx.destroyEntity(entityReference2);
	}
}

