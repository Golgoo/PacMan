package examples.KissMethod2.sigletons;

import java.util.Timer;
import graphicmotor.GooContext;
import examples.KissMethod2.model.*;
import examples.KissMethod2.physic.*;

public class Acessors {

	private static Model model ;
	private static Motor physic;
	private static GooContext gctx;
	private static GooContext menuCtx ;
	
	private static Timer timer = new Timer();
	 
	public static Model getModel() {
		return model;
	}
	public static void setModel(Model model) {
		Acessors.model = model;
	}
	public static Motor getPhysic() {
		return physic;
	}
	public static void setPhysic(Motor physic) {
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
	
	
		
}
