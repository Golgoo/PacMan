package graphicmotor.entities;

import com.jogamp.opengl.GL2;

import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;

/**
 * 
 * A multipledAnimatedEntity is simply working with an {@link graphicmotor.animation.AnimationBank} <p>
 * It provide a method to set the current animation of the animated entity
 * 
 * @author goozi
 *
 * @param <KEY>
 * @version 1.0
 */
public class MultipledAnimatedEntity<KEY> extends AnimatedEntity{
	
	private AnimationBank<KEY> animationBank ;
	
	/**
	 * 
	 * @param animationBank the bank of animations that can be use for this entity
	 */
	public MultipledAnimatedEntity(AnimationBank<KEY> animationBank){
		this.animationBank = animationBank ;
		currentAnimation = (Animation) animationBank.getMap().values().toArray()[0];
	}
	
	/**
	 * 
	 * @param animationKey the bank of animations that will be use for this entity
	 */
	public void setAnimation(KEY animationKey) {
		currentAnimation = animationBank.getMap().get(animationKey);
		texture = currentAnimation.getTexture();
	}
	
	@Override
	public void init(GL2 gl) {
		for(Animation animation : animationBank.getMap().values())
			animation.generateTexture(gl);
		texture = currentAnimation.getTexture();
		runAnimation();
	}

}
