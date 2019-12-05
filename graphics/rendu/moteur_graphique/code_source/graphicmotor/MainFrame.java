package graphicmotor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;


public class MainFrame extends JFrame { 

	private final int FPS = 60 ;
	
    public MainFrame(){
    	
    	Dimension defaultSize = new Dimension(600, 600);
        this.setSize(defaultSize);
      	this.setResizable(false);
       

        GooContext goo = new GooContext(600, 600);

        this.add(goo.getCanvas());

        String pathToSprites = "src/sprites_1.png" ;
        int nbSpritesInALine = 6 ;
        long animationScheduleTimeMs = 60 ;


        int entityReference2;
		try {
			entityReference2 = goo.createSingleAnimatedEntity(new Animation(new FileInputStream(new File(pathToSprites)), nbSpritesInALine, animationScheduleTimeMs*3/4));

	        goo.setEntityPosition(entityReference2, 300, 200);
	        goo.setEntitySize(entityReference2, 150, 180);
	        goo.setEntityColorMask(entityReference2, 1.0f, 0.4f, 0.1f);
	        goo.setZIndex(entityReference2, 3);

	        goo.enableEntity(entityReference2);
		} catch (FileNotFoundException e4) {
			e4.printStackTrace();
		}


        goo.start(FPS);
        
        this.setVisible(true);

		try {
			int entityReference;
			entityReference = goo.createSingleAnimatedEntity(new Animation(new FileInputStream(new File("src/360x640-pacman-spritesheet.png")), 5, animationScheduleTimeMs));
			goo.setEntityPosition(entityReference, 330, 150);
			goo.setEntitySize(entityReference, 0.3f, 0.35f);
			goo.setEntityColorMask(entityReference, 1.0f, 0.4f, 1.0f);
			goo.setZIndex(entityReference, 2);
			
			goo.enableEntity(entityReference);
		} catch (FileNotFoundException e3) {
			e3.printStackTrace();
		}

        
        AnimationBank<Integer> animationsBank = new AnimationBank<Integer>();
		
		try {
			animationsBank.putAnimation(1, new Animation(new FileInputStream(new File("src/360x640-pacman-spritesheet.png")), 5, 50));
			animationsBank.putAnimation(2, new Animation(new FileInputStream(new File("src/pac-down.png")), 5, 50));
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
		int ref = goo.createMultipleAnimatedEntity(animationsBank);
		goo.setEntityPosition(ref, 50, 50);
		goo.setEntitySize(ref, 50, 50);
		goo.enableEntity(ref);
		
		int textRef = goo.createTextEntity(new Font("Verdana", Font.BOLD, 16));
		goo.setEntityPosition(textRef, 200, 200);
		goo.setEntityColorMask(textRef, 0.4f, 0.2f, 0.6f);
		goo.setText(textRef, "Helloo");
		goo.enableEntity(textRef);
		
		
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        
        goo.clear();
        
        try {
			int r = goo.createStaticEntity(new FileInputStream(new File("src/360x640-pacman-spritesheet.png")));
			goo.setEntitySize(r, 150, 150);
			goo.setEntityPosition(r, 50, 50);
			goo.enableEntity(r);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        try {
			int r = goo.createStaticEntity(new FileInputStream(new File("src/360x640-pacman-spritesheet.png")));
			goo.setEntitySize(r, 150, 150);
			goo.setEntityPosition(r, 350, 50);
			goo.enableEntity(r);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
        try {
			int r = goo.createStaticEntity(new FileInputStream(new File("src/360x640-pacman-spritesheet.png")));
			goo.setEntitySize(r, 150, 150);
			goo.setEntityPosition(r, 200, 50);
			goo.enableEntity(r);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
            //	goo.destroyEntity(entityReference);
                goo.stop();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        });

        
    } 
    

    private static final long serialVersionUID = -1227038124975588633L; 

} 