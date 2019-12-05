package model.launcher;

import java.awt.Font;

import graphicmotor.GooContext;
import inputs.InputMotor;
import inputs.commands.CommandEnum;
import physic.Dimension;
import physic.Position;
import singletons.Acessors;
import util.loader.font.FontEnum;
import util.loader.font.FontLoader;

public class LauncherFactory {
	
	private static Font textFont ;
	private static float textSize = 50.0f ;
	
	private static Font keyFont ;
	private static float keySize = 50.0f ;
	
	private static Font titleFont ;
	private static float titleSize = 70.0f ;
	
	private static GooContext GCtx ;
	private static InputMotor inputMotor;
	private static GooContext MenuCTX ;
	
	private static Dimension canvasSize ;
	
	private static Position nextPosition ;
	private static int yStep ;
	
	private static int nbCommandToDisplay = 8 ;
	
	public static void createLauncher(Dimension canvasSize) {
		initialization(canvasSize);
		
		createLine(CommandEnum.Enum.MOVE_UP);
		createLine(CommandEnum.Enum.MOVE_DOWN);
		createLine(CommandEnum.Enum.MOVE_RIGHT);
		createLine(CommandEnum.Enum.MOVE_LEFT);
		createLine(CommandEnum.Enum.PLAY_PAUSE);
		createLine(CommandEnum.Enum.NEW_GAME);
		createLine(CommandEnum.Enum.REDUCE_PAC);
		createLine(CommandEnum.Enum.GROW_PAC);
	}

	private static void initialization(Dimension canvasSize) {
		GCtx = Acessors.getGctx();
		MenuCTX = Acessors.getMenuCtx();
		inputMotor = Acessors.getInputMotor();
		LauncherFactory.canvasSize = canvasSize;
		loadFonts();
		computeFirstPosition();
		computeYStep();
	}

	private static void loadFonts() {
		textFont = FontLoader.load(FontEnum.Enum.HEADLINE_FONT, textSize);
		keyFont = FontLoader.load(FontEnum.Enum.KEYBOARD_FONT, keySize);
		titleFont = FontLoader.load(FontEnum.Enum.PACMAN_FONT, titleSize);
	}

	private static void computeFirstPosition() {
		nextPosition = new Position(50, 50);
	}
	
	private static void computeNextPosition() {
		nextPosition = new Position(nextPosition.getX(), nextPosition.getY() + yStep);
	}

	private static void computeYStep() {
		yStep = canvasSize.getHeight() / nbCommandToDisplay ;
	}
	
	private static void createLine(CommandEnum.Enum commandEnum) {
		int keyRef = GCtx.createTextEntity(keyFont);
		GCtx.setText(keyRef, inputMotor.getKeyOf(commandEnum)+"");
		GCtx.setEntityPosition(keyRef, nextPosition.getX(), nextPosition.getY());
		GCtx.enableEntity(keyRef);
		
		int textRef = GCtx.createTextEntity(textFont);
		GCtx.setText(textRef, " : " + CommandEnum.getDescription(commandEnum));
		GCtx.setEntityPosition(textRef, nextPosition.getX() + 60, nextPosition.getY());
		GCtx.enableEntity(textRef);
		
		computeNextPosition();
	}

	
	
	public static void createTitle(Dimension menuSize) {
		int titleRef = MenuCTX.createTextEntity(titleFont);
		MenuCTX.setText(titleRef, "pacman");
		MenuCTX.setEntityPosition(titleRef, (int) (menuSize.getWidth() / 2 - ( (6 * (int)titleSize) / 2.66)), (int) (menuSize.getHeight() - (int)titleSize/2.66));
		MenuCTX.setEntityColorMask(titleRef, 1.0f, 1.0f, 0.0f);
		MenuCTX.enableEntity(titleRef);
	}


}
