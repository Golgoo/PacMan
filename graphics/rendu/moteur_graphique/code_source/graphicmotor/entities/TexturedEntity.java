package graphicmotor.entities;

import java.io.InputStream;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * 
 * A texturedEntity is always construct from an existing PNG resource.<p>
 * 
 * It permit users to create entity to using external graphics and FXs.<p>
 * 
 * Subclasses need to manipulate protected data to affect the rendering.<p>
 * 
 * @author goozi
 * @version 1.0
 */
public abstract class TexturedEntity extends Entity{

	protected InputStream stream ;
	protected float textureCoord[] = new float[4];
	
	protected int texture = 0 ;

	@Override
	public abstract void init(GL2 gl);

	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
    	
		gl.glBindTexture(GL2.GL_TEXTURE_2D, texture);
		
		gl.glColor3f(colorR, colorG, colorB);
				
	    gl.glBegin(GL2.GL_QUADS);
		
		gl.glTexCoord2d(textureCoord[0], 0);
		gl.glVertex3d(xPos, yPos - height, 1.0f); // Top-Left
		
		gl.glTexCoord2d(textureCoord[1], 1);
		gl.glVertex3d(xPos, yPos, 1.0f); // Bottom-Left
		
		gl.glTexCoord2d(textureCoord[2], 1);
		gl.glVertex3d(xPos + width, yPos, 1.0f); // Bottom-Right
		
		gl.glTexCoord2d(textureCoord[3], 0);
		gl.glVertex3d(xPos + width, yPos - height, 1.0f); // Top-Right
	    
	    gl.glEnd();
	}
}
