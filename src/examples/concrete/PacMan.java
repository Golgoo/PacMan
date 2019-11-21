package examples.concrete;

import graphicmotor.GooContext;
import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;

public class PacMan {
	public enum Dir{
		HAUT, BAS, DROITE, GAUCHE
	}

	private int graphicReference = -1 ;
	
	public void initGraphic(GooContext GCtx) {
		AnimationBank<Dir> animationBank = loadAnimations();
		graphicReference = GCtx.createMultipleAnimatedEntity(animationBank);
	}

	private AnimationBank<Dir> loadAnimations() {
		AnimationBank<Dir> animationBank = new AnimationBank<Dir>();
		animationBank.putAnimation(Dir.DROITE, new Animation("Game Files/Sprites/PACMAN/360x640-pacman-spritesheet.png", 5, 100));
		animationBank.putAnimation(Dir.GAUCHE, new Animation("Game Files/Sprites/PACMAN/sprite_left.png", 3, 100));	
		return animationBank;
	}
	
	public int getGraphicReference() {
		return graphicReference ;
	}
		
}
