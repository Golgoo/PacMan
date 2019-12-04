package singletons;

import java.util.Timer;
import graphicmotor.GooContext;
import inputs.InputMotor;
import model.game.GameModel;
import model.launcher.LauncherModel;
import model.menu.MenuModel;
import physic.PhysicMotor;

public class Acessors {

	private static GameModel gameModel ;
	private static MenuModel menuModel ;
	private static LauncherModel launcherModel ;
	
	private static PhysicMotor physic;
	
	private static InputMotor inputMotor ;
	
	private static GooContext gctx;
	private static GooContext menuCtx ;
	
	private static Timer timer = new Timer();
	 
	public static GameModel getGameModel() {
		return gameModel;
	}
	public static void setGameModel(GameModel model) {
		Acessors.gameModel = model;
	}
	public static MenuModel getMenuModel() {
		return menuModel ;
	}
	public static void setMenuModel(MenuModel menuModel) {
		Acessors.menuModel = menuModel ;
	}
	public static PhysicMotor getPhysic() {
		return physic;
	}
	public static void setPhysic(PhysicMotor physic) {
		Acessors.physic = physic;
	}
	public static GooContext getGctx() {
		return gctx;
	}
	public static void setGctx(GooContext gctx) {
		Acessors.gctx = gctx;
	}
	public static GooContext getMenuCtx() {
		return menuCtx;
	}
	public static void setMenuCtx(GooContext menuCtx) {
		Acessors.menuCtx = menuCtx;
	}
	
	public static Timer getTimer() {
		return timer ;
	}
	
	public static LauncherModel getLauncherModel() {
		return launcherModel;
	}
	public static void setLauncherModel(LauncherModel launcherModel) {
		Acessors.launcherModel = launcherModel;
	}
	public static InputMotor getInputMotor() {
		return inputMotor;
	}
	public static void setInputMotor(InputMotor inputMotor) {
		Acessors.inputMotor = inputMotor;
	}

	
	
		
}
