import java.awt.Dimension;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;

import javax.swing.JFrame; 


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


        int entityReference2 = goo.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs*3/4);

        goo.setEntityPosition(entityReference2, 300, 200);
        goo.setEntitySize(entityReference2, 150, 180);
        goo.setEntityColorMask(entityReference2, 1.0f, 0.4f, 0.1f);
        goo.setZIndex(entityReference2, 3);


        goo.enableEntity(entityReference2);

        goo.start(FPS);
        
        this.setVisible(true);

       int entityReference = goo.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs);

        goo.setEntityPosition(entityReference, 330, 150);
        goo.setEntitySize(entityReference, 0.3f, 0.35f);
        goo.setEntityColorMask(entityReference, 1.0f, 0.4f, 1.0f);
        goo.setZIndex(entityReference, 2);

        goo.enableEntity(entityReference);
        
        try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
        
        
        goo.destroyEntity(entityReference2);


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
