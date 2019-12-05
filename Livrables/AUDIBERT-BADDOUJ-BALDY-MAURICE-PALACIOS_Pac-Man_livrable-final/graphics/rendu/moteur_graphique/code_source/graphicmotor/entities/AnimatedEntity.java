package graphicmotor.entities;

import java.util.Timer;
import java.util.TimerTask;

import graphicmotor.animation.Animation;

/**
 * 
 * An AnimatedEntity work with an {@link graphicmotor.animation.Animation} as the current Animation and the index of the current sprite.<p>
 * 
 * When the animation is running, a {@link TimerTask} will schedule and will just update the value of the current sprite.<p>
 * 
 * @author goozi
 *
 */
public abstract class AnimatedEntity extends TexturedEntity {

	protected Animation currentAnimation ;
	protected float currentSprite = 0 ;
	
	private Timer timer = new Timer();
	private class spriteScheduler extends TimerTask {
		@Override
		public void run() {
			currentSprite = ( currentSprite + 1 ) % currentAnimation.getNbSprites() ;
			computeTextureXCoordFromCurrentSprite();
		}
	}
	private TimerTask currentTask = null;
	
	private void computeTextureXCoordFromCurrentSprite() {
		float left = currentAnimation.getRatio() * currentSprite ;
		textureCoord[0] = left ;
		textureCoord[1] = left ;
		float right = currentAnimation.getRatio() * ( currentSprite + 1 ) ;
		textureCoord[2] = right ;
		textureCoord[3] = right ;
	}
	
	/**
	 * Run the animation.<p>
	 * By default an AnimatedEntity is running.
	 */
	public void runAnimation() {
		currentTask = new spriteScheduler();
		timer.schedule(currentTask, 0, currentAnimation.getScheduleTime());
	}
	
	/**
	 * Stop the animation
	 */
	public void stopAnimation() {
		if(currentTask != null)
			currentTask.cancel();
	}

	
}
