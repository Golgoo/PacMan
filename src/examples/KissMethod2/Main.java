package examples.KissMethod2;


import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import examples.KissMethod2.input.InputMotor;
import graphicmotor.GooContext;
import examples.KissMethod2.model.*;
import examples.KissMethod2.model.Model.InputKey;
import examples.KissMethod2.model.factory.LabFactory;
import examples.KissMethod2.physic.*;
import examples.KissMethod2.sigletons.*;
import examples.KissMethod2.kernel.*;


public class Main {
	
	private static int FPS = 60 ;
	
	private static GooContext GCtx ;
	private static GooContext menuCTX;
	private static Model model ;
	private static Motor phyMotor ;
	
	private static JFrame mainFrame ;
	
	private static int frameWidth = 600;
	
	private static int canvasHeight = 600 ;
	private static int menuHeight = 120 ;
	
	private static int frameHeight = canvasHeight + menuHeight ;
		
	
	public static void main(String[] args) {
		
		initGraphicCtx();

		initAWTLayout();
		
		initInputMotor();
		
		initModel();
		
		initPhysic();
		
		Kernel kernel = new Kernel(phyMotor, model, GCtx);
		
		LabFactory.buildLab(kernel, "src/examples/KissMethod2/level.txt", new Dimension(frameWidth, canvasHeight));
		
		long previousTime ;
		long finishedTime ;

		GCtx.start(FPS);
		menuCTX.start(FPS);

		while(true) {
			previousTime = System.currentTimeMillis();
			
			kernel.movePacman();
			
			if(model.gameWon) {
				break;
			}
			
			finishedTime = System.currentTimeMillis() ;
	    	pause(frameRate - ( finishedTime - previousTime ) );
		}
		
		//TODO Phisic.clean()
		//TODO Clean && load.
		//TODO GCtx.clean()

		GCtx.stop();
		menuCTX.stop(); 
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

	private static void initGraphicCtx() {
		GCtx = new GooContext(frameWidth, canvasHeight);
		Acessors.setGctx(GCtx);


		menuCTX = new GooContext(frameWidth, menuHeight);
		Acessors.setMenuCtx(menuCTX);
	}
	

	private static void initAWTLayout() {
		mainFrame = new JFrame();
		mainFrame.setSize(frameWidth, frameHeight);

		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		
		panel.add(menuCTX.getCanvas());
		
		panel.add(GCtx.getCanvas());
		
		panel.setMinimumSize(new java.awt.Dimension(frameWidth, frameHeight));
		panel.setMaximumSize(new java.awt.Dimension(frameWidth, frameHeight));
		
		mainFrame.add(panel);
		
		mainFrame.setMinimumSize(new java.awt.Dimension(frameWidth, frameHeight + 25));//bout de scotch
		mainFrame.setMaximumSize(new java.awt.Dimension(frameWidth, frameHeight + 25));
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void initInputMotor() {
		mainFrame.addKeyListener(new InputMotor());
	}
	
	private static void initModel() {
		model = new Model();
		Acessors.setModel(model);
		model.reloadStopSuperPackTask();
	}
	
	private static void initPhysic() {
		phyMotor = new Motor();
		Acessors.setPhysic(phyMotor);
	}

}
