package graphicmotor.entities;

import com.jogamp.opengl.GL2;

import graphicmotor.animation.Animation;

/**
 * 
 * SingleAnimatedEntity is the basic extension of an {@link AnimatedEntity}<p>
 * 
 * It just set the current animation at the construction and launch it at the initialization. 
 * 
 * @author goozi
 *
 */
public class SingleAnimatedEntity extends AnimatedEntity {

	/**
	 * 
	 * @param animation the entity animation
	 */
	public SingleAnimatedEntity(Animation animation) {
		currentAnimation = animation;
	}
	
	@Override
	public void init(GL2 gl) {
		currentAnimation.generateTexture(gl);
		texture = currentAnimation.getTexture();
		runAnimation();
	}

}
