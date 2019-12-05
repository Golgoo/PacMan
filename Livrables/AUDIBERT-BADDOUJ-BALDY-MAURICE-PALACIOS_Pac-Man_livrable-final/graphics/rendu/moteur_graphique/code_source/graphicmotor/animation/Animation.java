package graphicmotor.animation;

import java.io.IOException;
import java.io.InputStream;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

/**
 * 
 * Animation class is used to initialized any AnimatedEntity.<p>
 * 
 * Note that users shouldn't have to use any method of this class except the constructor.
 * 
 * @author goozi
 */
public class Animation {
	
	private int texture = 0 ;
	
	private InputStream streamToSprite ;
	private int nbSprites ;
	private long scheduleTime ;
	private float ratio ;
	
	/**
	 * 
	 * Create an animation.<p>
	 * 
	 * @param streamToSprite InputStream to the specified resource
	 * @param nbSprites The number of sprite for this animation
	 * @param scheduleTime The time between each animation step
	 */
	public Animation(InputStream streamToSprite, int nbSprites, long scheduleTime) {
		this.streamToSprite = streamToSprite;
		this.nbSprites = nbSprites;
		this.scheduleTime = scheduleTime ;
		this.ratio = 1.0f / (float)nbSprites ;
	}
	
	/**
	 * Generate a {@link Texture} associated with this animation.<p>
	 * @param gl GL Context
	 */
	public void generateTexture(GL2 gl) {
		try {
			Texture t = TextureIO.newTexture(streamToSprite, true, "PNG");
			texture = t.getTextureObject();
			
		} catch (GLException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * return the Id of this texture.
	 * @return the Id of this texture.
	 */
	public int getTexture() {
		return texture;
	}

	/**
	 * return the number of sprite of this animation
	 * @return the number of sprite of this animation
	 */
	public int getNbSprites() {
		return nbSprites;
	}

	/**
	 * return the schedule time of this animation
	 * @return the schedule time of this animation
	 */
	public long getScheduleTime() {
		return scheduleTime;
	}

	/**
	 * Set the schedule time of this animation
	 * @param scheduleTime new schedule time
	 */
	public void setScheduleTime(long scheduleTime) {
		this.scheduleTime = scheduleTime;
	}

	/**
	 * A ratio is just the result of : (ressourcesPNG.width / nbSprites)
	 * @return this ratio
	 */
	public float getRatio() {
		return ratio;
	}
}
