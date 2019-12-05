package graphicmotor;

import java.awt.Canvas;
import java.awt.Font;
import java.io.InputStream;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;

import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;
import graphicmotor.entities.AnimatedEntity;
import graphicmotor.entities.EntitiesBank;
import graphicmotor.entities.Entity;
import graphicmotor.entities.MultipledAnimatedEntity;
import graphicmotor.entities.SimpleRect;
import graphicmotor.entities.SingleAnimatedEntity;
import graphicmotor.entities.StaticEntity;
import graphicmotor.entities.TextEntity;
import graphicmotor.factory.GLEventFactory;

/**
 * 
 * Main class to communicate and control a graphic motor using JOGL.
 * <p>
 * Users haven't to have any knowledge about the the other classes, expect the package graphicmotor.animation, to use the graphic motor.
 * <p>
 * Only know how integers work and have the this page of documentation is enough to use this graphic motor.
 * <p>
 * The idea is to make it as simple as possible to use for other developers, and will be the main line for further version.
 * 
 * <p>
 * This class is a context associated with an awt.Canvas, where users can create entity on it, and manipulate it via all those methods. 
 * 
 * <p>
 * Each instance of GooContext contains its own EntitiesBank and MainGLEvent.
 * 
 * @see graphicmotor.entities.EntitiesBank 
 * @see graphicmotor.MainGLEvent
 * @author Goozi
 * @version 1.0
 * 
 */
public class GooContext {
	
	private float width , height ;
	private float middleWidth, middleHeight ;
	
	private GLCanvas canvas ;
	private FPSAnimator animator ;
	
	private EntitiesBank entitiesBank ;
	
	public GLEventListener glListener ;
	
	/**
	 * 
	 * At the construction, a canvas associated with this context is build.
	 * Dimensions are not only bind to this canvas, but they are bind to the entire context
	 * 
	 * 
	 * @param width width of the context
	 * @param height height of the context
	 */
	public GooContext(int width, int height) {
		setDimension(width, height);
		entitiesBank = new EntitiesBank();
		canvas = buildCanvas();
	}
	
	private GLCanvas buildCanvas() {
		GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault()); 
        glCapabilities.setDoubleBuffered(true);
        GLCanvas glCanvas = new GLCanvas(glCapabilities);
        glCanvas.setSize((int)width, (int)height);
        glListener = GLEventFactory.createGLEventListener(entitiesBank);
        glCanvas.addGLEventListener(glListener);
		return glCanvas;
	}
	
	/**
	 * 
	 * @return the canvas associated with this context
	 */
	public Canvas getCanvas() {
		return this.canvas ;
	}

	/**
	 * Start the graphic context.
	 * <p>
	 * The main loop is launched with the specified FPS, any enabled entity or animation will be shown.
	 *
	 * @since 1.0
	 * 
	 * @param FPS frame per seconds
	 */
	public void start(int FPS) {
		animator = new FPSAnimator(canvas, FPS);
		animator.start();
	}
	
	/**
	 * 
	 * Stop the graphic context.
	 * <p>
	 * No further operation can be achieve after that call.
	 * <p>
	 * Any enabled entity will still be shown, but animations will be frozen
	 * 
	 * @since 1.0
	 */
	public void stop() {
		animator.stop();
	}
	
	/**
	 * 
	 * Set the current dimension of the context.
	 * <p>
	 * If canvas' dimension is updated, the context need to be bind to such update.
	 * 
	 * @param width new width
	 * @param height new height
	 * 
	 * @since 1.0
	 */
	public void setDimension(int width, int height) {
		this.width = width ;
		this.height = height ;
		this.middleWidth = width / 2;
		this.middleHeight = ( height  ) / 2 ;
	}

	/**
	 * 
	 * Create a basic animated entity.
	 * <p>
	 * This method will horizontally cut the sprite into nbSprite equal slice.
	 * <p>
	 * A TimerTask will schedule every animationScheduleTimeMs milliseconds, and change the current slice.
	 * <p>
	 * To achieve coherent results, the sprite resources have to be horizontal width the same width.
	 * 
	 * A special module will be implemented for version 1.2
	 * 
	 * @param animation animation associated with this entity
	 * 
	 * @return an ID to reference this entity for further modifications
	 * 
	 * @since 1.0
	 */
	public int createSingleAnimatedEntity(Animation animation) {
		int reference = entitiesBank.addEntities(new SingleAnimatedEntity(animation));
		return reference ;
	}
	
	/**
	 * 
	 * Create a multiple animated entity.
	 * <p>
	 * If an entity may change its animation during its lifetime, users shall create it via this method.
	 * <p>
	 * Each animation will be loaded at the initialization.
	 * <p>
	 * Users just need to ask to change the current animation using the Key associated to it.
	 * 
	 * @param <KEY> the generic type associated to the animationBank
	 * @param animationBank animation bank with the specified KEY
	 * @return an ID to reference this entity for further modifications
	 * 
	 * @since 1.0
	 */
	public <KEY> int createMultipleAnimatedEntity(AnimationBank<KEY> animationBank) {
		MultipledAnimatedEntity<KEY> entity = new MultipledAnimatedEntity<KEY>(animationBank);
		int reference = entitiesBank.addEntities(entity);
		return reference;
	}
	
	/**
	 * 
	 * Create a static entity.
	 * <p>
	 * A static entity will not support animations methods.
	 * 
	 * @param streamToSprite InputStream to the specified resource
	 * @return an ID to reference this entity for further modifications
	 * 
	 * @since 1.0
	 */
	public int createStaticEntity(InputStream streamToSprite) {
		int reference = entitiesBank.addEntities(new StaticEntity(streamToSprite));
		return reference ;
	}
	
	/**
	 * 
	 * Create an exclusive text entity.
	 * <p>
	 * 
	 * A text entity has the same behavior that a static entity.
	 * <p>
	 * But they are use to display text.
	 * 
	 * @param font the required font
	 * @return an ID to reference this entity for further modifications
	 * 
	 * @since 1.0
	 */
	public int createTextEntity(Font font) {
		int reference = entitiesBank.addEntities(new TextEntity((int)width, (int)height, font));
		return reference;
	}
	
	/**
	 * 
	 * Set the animation previously specified with such key.
	 * <p>
	 * 
	 * If users want to change the current animation of a multiple animated entity.
	 * <p>
	 * They can call this method with the key they used to identify such animation at the creation of this entity.
	 * 
	 * 
	 * @param <KEY> the generic type associated to the animationBank
	 * @param entityId the ID of the multipledAnimatedEntity
	 * @param key the key associated with the animation we want to set
	 * 
	 * @since 1.0
	 */
	@SuppressWarnings("unchecked")
	public <KEY> void setMultipledAnimatedEntityAnimation(int entityId, KEY key) {
		Entity entity = entitiesBank.get(entityId);
		if(entity instanceof MultipledAnimatedEntity<?>) {
			((MultipledAnimatedEntity<KEY>) entity).setAnimation(key);
		}
	}
	
	/**
	 * 
	 * Start the entity's animation.
	 * <p>
	 * 
	 * If an entity has been created as animated, the animation can start like this.
	 * 
	 * 
	 * @param entityId the ID of the animatedEntity
	 * 
	 * @since 1.0
	 */
	public void startEntityAnimation(int entityId) {
		Entity entity = entitiesBank.get(entityId);
		if(entity instanceof AnimatedEntity) {
			((AnimatedEntity) entity).runAnimation();
		}
	}
	
	/**
	 * 
	 * Stop the entity's animation.
	 * <p>
	 * 
	 * As users can start an entity's animation, they can stop it with this method
	 * 
	 * @param entityId the ID of the animatedEntity
	 * 
	 * @since 1.0
	 */
	public void stopEntityAnimation(int entityId) {
		Entity entity = entitiesBank.get(entityId);
		if(entity instanceof AnimatedEntity) {
			((AnimatedEntity) entity).stopAnimation();
		}
	}
	
	private float computeFloatPos(float p, float middle) {
		float f = 1.0f;
		
		if( p >= middle) {
			p -= middle ;
			f = p / middle ;
		}else {
			f = -((middle - p) / (middle));
		}
		
		return f ;
	}
	
	/**
	 * 
	 * Set the position of an entity.
	 * <p>
	 * 
	 * This function translate pixel position into float position, then call the optimized method.
	 * <p>
	 * The translation use divisions.
	 * <p>
	 * An entity position relates its top-left corner.
	 * 
	 * @param entityId the ID of the entity
	 * @param x horizontal pixel in the canvas from left to right 
	 * @param y vertical pixel in the canvas from top to bottom
	 * 
	 * @since 1.0
	 */
	public void setEntityPosition(int entityId, int x, int y) {
		Entity entity = entitiesBank.get(entityId);
		float fX = computeFloatPos(x, middleWidth);
		float fY = computeFloatPos((height) - y , middleHeight);
		entity.setPosision(fX, fY);
		entity.setPix(x, (int)height - y);
	}
	
	/**
	 * 
	 * Set the position of an entity.
	 * <p>
	 * 
	 * Optimized method to update an entity position.
	 * 
	 * @param entityId the ID of the entity
	 * @param fX horizontal float position in the canvas left : -1.0f -> 1.0 : right
	 * @param fY vertical float position in the canvas top : 1.0f -> -1.0 : bottom  
	 * 
	 * @since 1.0
	 */
	public void setEntityPosition(int entityId, float fX, float fY) {
		Entity entity = entitiesBank.get(entityId);
		entity.setPosision(fX, fY);
	}
	
	private float computeFloatSize(float p, float middle) {
		float f = 1.0f;
		
		if( p >= middle) {
			p -= middle ;
			f = p / middle + 1.0f;
		}else {
			f = (p / middle);
		}
		
		return f ;
	}

	/**
	 * Set the dimension of an entity.
	 * <p>
	 * 
	 * This function translate dimensions into floats, then call the optimized method.
	 * 
	 * @param entityId the ID of the entity
	 * @param w width in pixel
	 * @param h height in pixel
	 * 
	 * @since 1.0
	 */
	public void setEntitySize(int entityId, int w, int h) {
		Entity entity = entitiesBank.get(entityId);
		float fW = computeFloatSize(w, middleWidth);
		float fH = computeFloatSize(h, middleHeight);
		entity.setSize(fW, fH);
	}
	
	/**
	 * Set the dimension of an entity
	 * <p>
	 * 
	 * Optimized method to update an entity dimension.
	 * <p>
	 * Note that use negative values will apply a mirror to the entity
	 * 
	 * @param entityId the ID of the entity
	 * @param fW width in float : canvas width : 2.0,
	 * @param fH height in float : canvas height : 2.0,
	 * 
	 * @since 1.0
	 */
	public void setEntitySize(int entityId, float fW, float fH) {
		Entity entity = entitiesBank.get(entityId);
		entity.setSize(fW, fH);
	}
	
	/**
	 * 
	 * Add a color mask to the entity.
	 * 
	 * <p>
	 * This method, just apply an additive color synthesis between the resource colors and the color specified in parameters.
	 * <p>
	 * If users really want to control the color of an entity using this method, they have to use grey shadows on resources.
	 * 
	 * @param entityId the ID of the entity
	 * @param r red value 0.0f -> 1.0f
	 * @param g green value 0.0f -> 1.0f
	 * @param b blue value 0.0f -> 1.0f
	 * 
	 * @since 1.0
	 */
	public void setEntityColorMask(int entityId, float r, float g, float b) {
		Entity entity = entitiesBank.get(entityId);
		entity.setColorMask(r, g ,b);
	}

	/**
	 * Enable the entity to be render on the canvas.
	 * <p>
	 * By default, an entity disabled and will not be render.
	 * <p>
	 * Users shall call this method to enable a disabled entity, and allow the graphic context to render it.
	 * <p>
	 * If the entity is already enable, this method won't have any effect. 
	 * 
	 * @param entityId the ID of the entity
	 * 
	 * @since 1.0
	 */
	public void enableEntity(int entityId) {
		Entity entity = entitiesBank.get(entityId);
		entity.setEnable(true);
	}
	
	/**
	 * Disable the entity to be render on the canvas.
	 * <p>
	 * By default, an entity is disabled and will not be render.
	 * <p>
	 * Users shall call this method to disable an enabled entity, and forbid the graphic context to render it.
	 * <p>
	 * If the entity is already disable, this method won't have any effect.
	 * 
	 * @param entityId the ID of the entity
	 * 
	 * @since 1.0
	 */
	public void disableEntity(int entityId) {
		Entity entity = entitiesBank.get(entityId);
		entity.setEnable(false);
	}
	
	/**
	 * 
	 * Destroy an entity.
	 * <p>
	 * This method will destroy the entity and free its associate space.
	 * <p>
	 * Its ID is now free for the creation of another entity.
	 * <p>
	 * After this method, trying to manipulate the destroyed entity will not have the desired effect and can manipulated another entity or throws a NullPointerException
	 * 
	 * @param entityId the ID of the entity
	 * 
	 * @since 1.0
	 */
	public void destroyEntity(int entityId) {
		entitiesBank.removeEntities(entityId);
	}
	
	/**
	 * 
	 * Clear the context.
	 * <p>
	 * This method will just destroy every entity
	 * 
	 * @since 1.0
	 */
	public void clear() {
		entitiesBank.clear();
	}

	/**
	 * Set the Z index of an entity.
	 * <p>
	 * During the rendering, entity may intersect each other. The ZIndex is the order to superimpose entities.
	 * <p>
	 * If an entity A intersect another entity B with a lower ZIndex, the entityA will be display over the entityB.
	 * <p>
	 * If Z-index are equals, it's random but the order will not change from a frame to an other one.
	 * 
	 * @param entityId the ID of the entity
	 * @param zIndex zIndex
	 * 
	 * @since 1.0
	 */
	public void setZIndex(int entityId, int zIndex) {
		Entity entity = entitiesBank.get(entityId);
		entity.setZIndex(zIndex);
	}
	
	/**
	 * Set the text of a text entity.
	 * <p>
	 * 
	 * An text entity can change its content with this method.
	 * 
	 * @param entityId the ID of the text entity
	 * @param text text to be display
	 * 
	 * @since 1.0
	 */
	public void setText(int entityId, String text) {
		Entity entity = entitiesBank.get(entityId);
		if(entity instanceof TextEntity) {
			((TextEntity) entity).setText(text);
		}
	}

	/**
	 * Create a rectangular entity.
	 * <p>
	 * Create a white rectangle considered as an entity.
	 * 
	 * @return an ID to reference this entity for further modifications
	 * 
	 * @since 1.0
	 */
	public int createSimpleRect() {
		return entitiesBank.addEntities(new SimpleRect());
	}

}
