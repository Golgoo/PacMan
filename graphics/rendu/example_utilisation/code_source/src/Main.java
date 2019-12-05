
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import graphicmotor.GooContext;
import inputs.InputMotor;
import model.game.GameModel;
import model.launcher.LauncherModel;
import model.menu.MenuModel;
import physic.*;
import singletons.*;
import kernel.*;


public class Main {
		
	private static GooContext GCtx ;
	private static GooContext menuCTX;
	
	private static GameModel gameModel ;
	private static MenuModel menuModel ;
	private static LauncherModel launcherModel ;
	
	private static PhysicMotor phyMotor ;
	
	private static InputMotor inputMotor ;
	
	private static Kernel kernel ;
	
	private static JFrame mainFrame ;
	
	private static int frameWidth = 720;
	
	private static int canvasHeight = 500 ;
	private static int menuHeight = 120 ;
	
	private static int frameHeight = canvasHeight + menuHeight ;
	
	private static Dimension canvasSize = new Dimension(frameWidth, canvasHeight);
	private static Dimension menuSize = new Dimension(frameWidth, menuHeight);
	
	private static int nbLevels = 4 ;
	
	public static void main(String[] args) {
		
		initGraphicCtx();
		
		initAWTLayout();
		
		initModel();
		
		initPhysic();
		
		initKernel();
				
		initInputMotor();

		GCtx.start(60);
		menuCTX.start(100);

		kernel.displayLauncher();
		
		GCtx.stop();
		menuCTX.stop();
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
		
		mainFrame.setMinimumSize(new java.awt.Dimension(frameWidth, frameHeight + 25));
		mainFrame.setMaximumSize(new java.awt.Dimension(frameWidth, frameHeight + 25));
		
		mainFrame.setVisible(true);
		mainFrame.setResizable(false);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void initInputMotor() {
		inputMotor = new InputMotor(kernel);
		mainFrame.addKeyListener(inputMotor);
		Acessors.setInputMotor(inputMotor);
	}
	
	private static void initModel() {
		gameModel = new GameModel();
		Acessors.setGameModel(gameModel);
		
		menuModel = new MenuModel();
		Acessors.setMenuModel(menuModel);
		
		launcherModel = new LauncherModel();
		Acessors.setLauncherModel(launcherModel);
	}
	
	private static void initPhysic() {
		phyMotor = new PhysicMotor();
		Acessors.setPhysic(phyMotor);
	}
	
	private static void initKernel() {
		kernel = new Kernel(menuSize, canvasSize);
		String [] levels = new String[nbLevels];
		for(int i = 1 ; i <= nbLevels ; i ++) {
			levels[i-1] = "ressources/levels/level"+i+".txt" ;
		}
		kernel.setLevels(levels);
	}

}
