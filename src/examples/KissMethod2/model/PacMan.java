package examples.KissMethod2.model;

import graphicmotor.GooContext;
import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;
import examples.KissMethod2.model.Model.InputKey;
import examples.KissMethod2.sigletons.Acessors;


public class PacMan extends Entity{
	
	@Override 
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		
		AnimationBank<InputKey> animationsBank = new AnimationBank<InputKey>();
		String skin = "classic" ;
		int nbSprite = 5 ;
		long scheduleTime = 50 ;
		String folder = "src/examples/KissMethod2/pacman/" + skin + "/"; 
		
		animationsBank.putAnimation(InputKey.Right, new Animation(folder + "pac-right.png", nbSprite, scheduleTime));
		animationsBank.putAnimation(InputKey.Down, new Animation(folder + "pac-down.png", nbSprite, scheduleTime));
		animationsBank.putAnimation(InputKey.Left, new Animation(folder + "pac-left.png", nbSprite, scheduleTime));
		animationsBank.putAnimation(InputKey.Up, new Animation(folder + "pac-up.png", nbSprite, scheduleTime));
		
		int ref = GCtx.createMultipleAnimatedEntity(animationsBank);
				
		return ref ;
	}

}
