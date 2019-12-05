package kernel;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import graphicmotor.GooContext;
import model.game.GameModel;
import model.game.entities.Entity;
import model.game.factory.LabFactory;
import model.launcher.LauncherModel;
import model.launcher.LauncherFactory;
import model.menu.MenuModel;
import model.menu.factory.MenuFactory;
import physic.*;
import singletons.Acessors;
import util.Direction;
import util.loader.font.FontEnum;
import util.loader.font.FontLoader;

public class Kernel {
	
	private PhysicMotor pyMotor;
	private GameModel gameModel;
	private LauncherModel launcherModel;
	private GooContext GCtx;
	private GooContext MenuCtx ;
	
	private MenuModel menuModel;
	
	private Map<Collision, CollisionTreatment> collisionTreatmentMap = new HashMap<Collision, CollisionTreatment>();
	
	private String levelsPath [] ;
	
	private Dimension menuSize ;
	private Dimension canvasSize ;
	
	public Kernel(Dimension menuSize, Dimension canvasSize) {
		this.pyMotor = Acessors.getPhysic() ;
		this.gameModel = Acessors.getGameModel() ;
		this.GCtx = Acessors.getGctx() ;
		this.launcherModel = Acessors.getLauncherModel() ;
		this.MenuCtx = Acessors.getMenuCtx();
		this.menuModel = Acessors.getMenuModel();
		this.menuSize = menuSize;
		this.canvasSize = canvasSize ;
	}
	
	public void setLevels(String ...levelsPath) {
		this.levelsPath = levelsPath ;
	}

	public void addCollisionTreatment(Collision colision, CollisionTreatment collisionTreatment) {
		this.collisionTreatmentMap.put(colision, collisionTreatment);
	}
	
	public void setPacmanDirection(Direction direction) {
		
		if(! gameModel.gamePaused && gameModel.gameIsRunning) {
			Entity pacman = gameModel.pacman ;
			
			GCtx.setMultipledAnimatedEntityAnimation(pacman.getGraphicId(), direction);
			
			int velocity = gameModel.pacmanSpeedVelocity ;
			switch (direction) {
			case UP:
				pacman.setVelocity(0, -velocity);
				break;
			case DOWN:
				pacman.setVelocity(0, velocity);
				break;
			case LEFT:
				pacman.setVelocity(-velocity, 0);
				break;
			case RIGHT:
				pacman.setVelocity(velocity, 0);
			}
		}			
	}
	
	public void startRequire() {
		launcherModel.startRequired = true ;
	}
	
	private Velocity lastVelocity ;

	public void pauseGame() {
		if(gameModel.gameIsRunning) {
			gameModel.gamePaused =  ! gameModel.gamePaused ;
			
			Entity pacman = gameModel.pacman ;
			if(gameModel.gamePaused) {
				GCtx.stopEntityAnimation(pacman.getGraphicId());
				Velocity PacVelocity = pacman.getPhisicDatas().getVelocity();
				lastVelocity = new Velocity(PacVelocity.getxVel(), PacVelocity.getyVel());
				pacman.setVelocity(0, 0);
				
				pacman.getPrimalState().pause();
				
			}else {
				GCtx.startEntityAnimation(pacman.getGraphicId());
				pacman.setVelocity(lastVelocity.getxVel(), lastVelocity.getyVel());
				
				pacman.getPrimalState().resume();
			}	
		}
	}
		
	public void movePacman() {
		Entity pacman = gameModel.pacman;
		List<Collision> collisions = pyMotor.getFutureCollisions(pacman);
		for(Collision c : collisions) {
			collisionTreatmentMap.get(c).treatCollision(c.getSrc(), c.getDst());
		}
		pyMotor.move(pacman);
		Position pacPos = pacman.getPhisicDatas().getPosition();
		GCtx.setEntityPosition(pacman.getGraphicId(), pacPos.getX(), pacPos.getY());
	}
	
	public void reducePacmanSize() {
		if(gameModel.gameIsRunning) {
			Entity pacman = gameModel.pacman;
			Dimension pacDim = pacman.getPhisicDatas().getDimension();
			pacDim.setWidth(Math.max(gameModel.minimumPacManDim.getWidth(), pacDim.getWidth()/2));
			pacDim.setHeight(Math.max(gameModel.minimumPacManDim.getWidth(), pacDim.getHeight()/2));
			GCtx.setEntitySize(pacman.getGraphicId(), pacDim.getWidth(), pacDim.getHeight());
		}
	}

	public void growPacmanSize() {
		if(gameModel.gameIsRunning) {
			Entity pacman = gameModel.pacman;
			Dimension pacDim = pacman.getPhisicDatas().getDimension();
			pacDim.setWidth(Math.min(gameModel.maximumPacManDim.getWidth(),pacDim.getWidth()*2));
			pacDim.setHeight(Math.min(gameModel.maximumPacManDim.getHeight(),pacDim.getHeight()*2));
			List<Collision> collisions = pyMotor.getFutureCollisions(pacman);
			for(Collision c : collisions) {
				if(gameModel.walls.contains(c.getDst())) {
					pacDim.setWidth(Math.max(gameModel.minimumPacManDim.getWidth(), pacDim.getWidth()/2));
					pacDim.setHeight(Math.max(gameModel.minimumPacManDim.getWidth(), pacDim.getHeight()/2));
					break;
				}
			}
			GCtx.setEntitySize(pacman.getGraphicId(), pacDim.getWidth(), pacDim.getHeight());
		}
	}

	private void startGame() {
		MenuFactory.createInGameMenu(this, menuSize);
		for(String gamePath : levelsPath) {
			newLevel(gamePath);
			clearGameData();
		}
		if(menuModel.getScore() > menuModel.getHightScore()) {
			menuModel.setHighScore(menuModel.getScore());
		}
		MenuCtx.clear();
	}
		
	private void newLevel(String levelPath) {
		LabFactory.createLab(this, levelPath, canvasSize);
		countdown();
		gameModel.gameIsRunning = true ;
		gameLoop();
		gameModel.gameIsRunning = false ;
	}

	private void clearGameData() {
		gameModel.init();
		gameModel.setSkin("classic");
		pyMotor.init();
		GCtx.clear();
	}
	
	private void countdown() {
		int countdownSize = 258 ;
		int countDown = 3 ;
		int ref = GCtx.createTextEntity(FontLoader.load(FontEnum.Enum.HEADLINE_FONT, (float)countdownSize));
		GCtx.setEntityPosition(ref, canvasSize.getWidth()/2 - countdownSize / 8, canvasSize.getHeight()/2 + countdownSize / 4);
		GCtx.setZIndex(ref, 2);
		GCtx.enableEntity(ref);
		while(countDown > 0) {
			GCtx.setText(ref, ""+countDown);
			try { Thread.sleep(1000);} catch (InterruptedException e) {e.printStackTrace();}
			countDown -- ;
		}
		GCtx.destroyEntity(ref);
	}

	private void gameLoop() {
		long previousTime ;
		long finishedTime ;
		
		while(true) {
			previousTime = System.currentTimeMillis();
									
			this.movePacman();
			
			if(gameModel.gameWon) {
				break;
			}
			
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

	public void congrats() {
		System.out.println("Congrats !");
	}

	
	public void displayLauncher() {
		clearGameData();
		LauncherFactory.createLauncher(canvasSize);
		LauncherFactory.createTitle(menuSize);
		launcherLoop();
	}

	private void launcherLoop() {
		long previousTime ;
		long finishedTime ;
		while(true) {
			previousTime = System.currentTimeMillis();
			
			if(launcherModel.startRequired) {
				GCtx.clear();
				MenuCtx.clear();
				startGame();
				launcherModel.init();
				LauncherFactory.createLauncher(canvasSize);
				LauncherFactory.createTitle(menuSize);
			}
			
			finishedTime = System.currentTimeMillis() ;
	    	pause(frameRate - ( finishedTime - previousTime ) );
		}
	}
}
