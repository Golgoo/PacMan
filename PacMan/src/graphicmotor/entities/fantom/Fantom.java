package graphicmotor.entities.fantom;

import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

import graphicmotor.entities.Entity;

public class Fantom extends Entity {

	private int currentTexture = -1 ;
	
	@Override
	public void init(GL2 gl) {
		File im = new File("src/spirtes_test.png");
		try {
			Texture t = TextureIO.newTexture(im, true);
			currentTexture = t.getTextureObject();
		} catch (GLException | IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		
		gl.glBindTexture(GL2.GL_TEXTURE_2D, currentTexture);
    	
		gl.glColor3f(1.0f, 1.0f, 1.0f);
				
	    gl.glBegin(GL2.GL_QUADS);
		
		gl.glTexCoord2d(0, 2.0f/3.0f);
		gl.glVertex3d(-0.2f, -0.2f, 1.0f); // Top-Left
		
		gl.glTexCoord2d(0 , 3.0f/3.0f);
		gl.glVertex3d(-0.2f, 0.2f, 1.0f); // Bottom-Left
		
		gl.glTexCoord2d(1.0f/6.0f, 3.0f/3.0f);
		gl.glVertex3d(0.2f, 0.2f, 1.0f); // Bottom-Right
		
		gl.glTexCoord2d(1.0f/6.0f, 2.0f/3.0f);
		gl.glVertex3d(0.2f, -0.2f, 1.0f); // Top-Right
		
		
		gl.glEnd();
	}


}
