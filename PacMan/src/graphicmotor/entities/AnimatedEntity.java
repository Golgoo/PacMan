package graphicmotor.entities;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

public class AnimatedEntity extends Entity {
	
	//int textures[] ;
	
	private int texture = 0 ;
	
	private File file ;
	private int nbSprites ;
	private long scheduleTime ;
	
	private float textureXCoord[] = new float[4];
	private float ratio ;
	private float currentSprite = 0 ;
		
	public AnimatedEntity(String spritesPath, int nbSprites, long scheduleTime) {
		file = new File(spritesPath);
		ratio = 1.0f / (float)nbSprites ;
		this.nbSprites = nbSprites ;
		this.scheduleTime = scheduleTime ;
		computeTextureXCoordFromCurrentSprite();
	}
	
	private void computeTextureXCoordFromCurrentSprite() {
		float left = ratio * currentSprite ;
		textureXCoord[0] = left ;
		textureXCoord[1] = left ;
		float right = ratio * ( currentSprite + 1 ) ;
		textureXCoord[2] = right ;
		textureXCoord[3] = right ;
	}
	
	
	
	@Override
	public void init(GL2 gl) {
		try {
			Texture t = TextureIO.newTexture(file, true);
			texture = t.getTextureObject();
			
		} catch (GLException | IOException e) {
			e.printStackTrace();
		}
		timer.schedule(new spriteScheduler(), 0, scheduleTime);
	}
	
	private Timer timer = new Timer();
	private class spriteScheduler extends TimerTask {
		@Override
		public void run() {
			currentSprite = ( currentSprite + 1 ) % nbSprites ;
			computeTextureXCoordFromCurrentSprite();
		}
	}
	
	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
    	
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		
	    gl.glBegin(GL2.GL_QUADS);
		
		gl.glTexCoord2d(textureXCoord[0], 0);
		gl.glVertex3d(-0.2f, -0.2f, 1.0f); // Top-Left
		
		gl.glTexCoord2d(textureXCoord[1], 1);
		gl.glVertex3d(-0.2f, 0.2f, 1.0f); // Bottom-Left
		
		gl.glTexCoord2d(textureXCoord[2], 1);
		gl.glVertex3d(0.2f, 0.2f, 1.0f); // Bottom-Right
		
		gl.glTexCoord2d(textureXCoord[3], 0);
		gl.glVertex3d(0.2f, -0.2f, 1.0f); // Top-Right
	    
	    gl.glEnd();
	}


}
