package examples.KissMethod.sigletons;

import graphicmotor.GooContext;
import examples.KissMethod.model.*;
import examples.KissMethod.physic.*;

public class Acessors {
	private static Model model ;
	private static Motor physic;
	private static GooContext gctx;
	
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
	
		
}
