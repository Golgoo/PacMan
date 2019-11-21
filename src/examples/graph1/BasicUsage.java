package examples.graph1;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;


import graphicmotor.GooContext;

public class BasicUsage {
	
	private static int FPS = 60 ;
	
	private static int xPos = 300;
	private static int entityWidth = 30 ;
	private static int stepX = 5 ;
	private static int canvasWidth = 600 ;
	
	public static void main(String args[]) {
		/*****************BASIC INIT **********************/
		GooContext gooCtx = new GooContext(600, 600);
		JFrame frame = new JFrame();
		frame.setSize(600, 600);
		frame.add(gooCtx.getCanvas());
		
		frame.setVisible(true);
		
		
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		/*****************BASIC ANIMATION 1 **********************/
		String pathToSprites = "Game Files/Sprites/PACMAN/360x640-pacman-spritesheet.png" ;
        int nbSpritesInALine = 5 ;
        long animationScheduleTimeMs = 50 ;


        int entityReference1 = gooCtx.createSingleAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs);

        gooCtx.setEntityPosition(entityReference1, xPos, 200);
        gooCtx.setEntitySize(entityReference1, entityWidth, entityWidth);
        gooCtx.setEntityColorMask(entityReference1, 1.0f, 1.0f, 1.0f);
        gooCtx.setZIndex(entityReference1, 3);


        gooCtx.enableEntity(entityReference1);
        
        
        /*****DEPLACEMENT VERS LA DROITE TANT QUE POSSIBLE********/
        
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
			
			@Override
			public void run() {
				if(xPos + entityWidth + stepX <= canvasWidth ) {
					xPos += stepX;
					gooCtx.setEntityPosition(entityReference1, xPos, 200);
				}
			}
		};
		timer.schedule(task, 1000, 40);
        
		
        
        /*****************BASIC ANIMATION 2 **********************/
        String pathToSprites2 = "Game Files/Sprites/PACMAN/sprite_right.png" ;
        int nbSpritesInALine2 = 3 ;
        long animationScheduleTimeMs2 = 100 ;


        int entityReference2 = gooCtx.createSingleAnimatedEntity(pathToSprites2, nbSpritesInALine2, animationScheduleTimeMs2);

        gooCtx.setEntityPosition(entityReference2, 200, 200);
        gooCtx.setEntitySize(entityReference2, 70, 70);
        gooCtx.setEntityColorMask(entityReference2, 1.0f, 1.0f, 1.0f);
        gooCtx.setZIndex(entityReference2, 3);


        gooCtx.enableEntity(entityReference2);
        
		
		/*****************START FUNCTION********************/
		gooCtx.start(FPS);
       
	}
}

