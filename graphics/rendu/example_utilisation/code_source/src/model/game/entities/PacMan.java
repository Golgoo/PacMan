package model.game.entities;

import graphicmotor.GooContext;
import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;
import singletons.Acessors;
import util.Direction;
import util.loader.sprite.SpriteEnum;
import util.loader.sprite.SpriteLoader;


public class PacMan extends Entity{
	
	@Override 
	public int initGraphic() {
		GooContext GCtx = Acessors.getGctx();
		
		AnimationBank<Direction> animationsBank = new AnimationBank<Direction>();
		String skin = Acessors.getGameModel().getSkin() ;
		int nbSprite = 5 ;
		long scheduleTime = 60 ;
		
		animationsBank.putAnimation(Direction.RIGHT, new Animation(SpriteLoader.getRessourceStream(SpriteEnum.Enum.PAC_RIGHT_SPRITES, skin), nbSprite, scheduleTime));
		animationsBank.putAnimation(Direction.DOWN, new Animation(SpriteLoader.getRessourceStream(SpriteEnum.Enum.PAC_DOWN_SPRITES, skin), nbSprite, scheduleTime));
		animationsBank.putAnimation(Direction.LEFT, new Animation(SpriteLoader.getRessourceStream(SpriteEnum.Enum.PAC_LEFT_SPRITES, skin), nbSprite, scheduleTime));
		animationsBank.putAnimation(Direction.UP, new Animation(SpriteLoader.getRessourceStream(SpriteEnum.Enum.PAC_UP_SPRITES, skin), nbSprite, scheduleTime));
		
		int ref = GCtx.createMultipleAnimatedEntity(animationsBank);
				
		return ref ;
	}


}
