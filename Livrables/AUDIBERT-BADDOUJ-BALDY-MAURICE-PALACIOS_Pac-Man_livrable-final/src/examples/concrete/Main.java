package examples.concrete;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import graphicmotor.GooContext;

public class Main {

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
		
		/**************BASIC ENTITY************************/
		
		PacMan pacman = new PacMan();
		physicPacWidth = 70 ;
		physicPacX = 200 ;
		pacman.initGraphic(GCtx);
		
		int pacGraphicRef = pacman.getGraphicReference();

		/** Physique update **/
		GCtx.setEntityPosition(pacGraphicRef, physicPacX, 200);
		GCtx.setEntitySize(pacGraphicRef, physicPacWidth, 70);
		
		/** Kernel/GP update */
		GCtx.setMultipledAnimatedEntityAnimation(pacGraphicRef, PacMan.Dir.DROITE);
		GCtx.startEntityAnimation(pacGraphicRef);
		GCtx.enableEntity(pacGraphicRef);

		/********* Scénario Basique Rebond Gauche<->Droite **/
		
		Timer timer = new Timer();


        TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//Entity direction vector ( toRight )
				if(toRight) {
					//PhisicTest
					if(physicPacX + physicPacWidth + stepX <= canvasWidth ) {
						physicPacX += stepX;
						GCtx.setEntityPosition(pacGraphicRef, physicPacX, 200);
					}else {
						//KernelDescision
						toRight = false;
						GCtx.setMultipledAnimatedEntityAnimation(pacGraphicRef, PacMan.Dir.GAUCHE);
					}
				}else {
					//PhisicTest
					if(physicPacX > 0 ) {
						physicPacX -= stepX;
						GCtx.setEntityPosition(pacGraphicRef, physicPacX, 200);
					}else {
						//KernelDescision
						toRight = true;
						GCtx.setMultipledAnimatedEntityAnimation(pacGraphicRef, PacMan.Dir.DROITE);
					}
				}
			}
		};
		timer.schedule(task, 500, 50);		
	}

}
