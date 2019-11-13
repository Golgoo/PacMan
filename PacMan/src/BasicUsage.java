public class BasicUsage extends JFrame {

	private final int FPS = 60 ;

    public BasicUsage(){

      Dimension defaultSize = new Dimension(600, 600);
        this.setSize(defaultSize);
      	this.setResizable(false);


        GooContext goo = new GooContext(600, 600);

        this.add(goo.getCanvas());

        //The sprites path might change
        String pathToSprites = "src/sprites_1.png" ;
        int nbSpritesInALine = 6 ;
        long animationScheduleTimeMs = 60 ;


        int entityReference2 = goo.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs*1/2);

        goo.setEntityPosition(entityReference2, 300, 200);
        goo.setEntitySize(entityReference2, 150, 180);
        goo.setEntityColorMask(entityReference2, 1.0f, 0.4f, 0.1f);
        goo.setZIndex(entityReference2, 2);


        goo.enableEntity(entityReference2);

        goo.start(FPS);

        this.setVisible(true);

        int entityReference = goo.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs);

        goo.setEntityPosition(entityReference, 280, 150);
        goo.setEntitySize(entityReference, 150, 180);
        goo.setEntityColorMask(entityReference, 1.0f, 0.4f, 1.0f);
        goo.setZIndex(entityReference, 3);

        goo.enableEntity(entityReference);

        try {
  			     Thread.sleep(1000);
    		} catch (InterruptedException e1) {
    			   e1.printStackTrace();
    		}

        goo.disableEntity(entityReference);

        try {
  			     Thread.sleep(1000);
    		} catch (InterruptedException e1) {
    			   e1.printStackTrace();
    		}
        goo.enableEntity(entityReference);

        goo.setEntityColorMask(entityReference, 0.2f, 1.0f, 0.8f);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                goo.destroyEntity(entityReference);
                goo.destroyEntity(entityReference2);
                goo.stop();
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }

        });


  }


  private static final long serialVersionUID = -1227038124975588633L;
}
