package sample;

import javax.swing.JFrame;


import graphicmotor.GooContext;
import sample.Model.InputKey;
import sample.Model.Entities.DynamicMoveable;
import sample.Model.Entities.PacMan;

public class Main{

private static int FPS = 60 ;
	
	private static int physicPacWidth = 70 ;
	private static int physicPacX = 200 ;
	
	private static boolean toRight = true ;
	 
	private static int canvasWidth = 600 ;
	
	private static int stepX = 7 ;
	
	public static void main(String[] args) {
		/*****************BASIC INIT **********************/
		GooContext GCtx = new GooContext(canvasWidth, 600);
		JFrame frame = new JFrame();
		frame.setSize(canvasWidth, 600);
		frame.add(GCtx.getCanvas());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GCtx.start(FPS);
		
		/**************BASIC ENTITY Creation *************/
		
		PacMan pacman = new PacMan(null);
		physicPacWidth = 70 ;
		physicPacX = 200 ;
		
		pacman.generateGraphicId(GCtx);
		int pacGraphicRef = pacman.getGraphicId();

		/**************Physique Motor MAJ ****************/
		GCtx.setEntityPosition(pacGraphicRef, physicPacX, 200);
		GCtx.setEntitySize(pacGraphicRef, physicPacWidth, 70);
		
		/************* Kernel/GP/Controller decision ****/
		GCtx.setMultipledAnimatedEntityAnimation(pacGraphicRef, InputKey.Direction.Right);
		GCtx.startEntityAnimation(pacGraphicRef);
		GCtx.enableEntity(pacGraphicRef);
		
	}
}
