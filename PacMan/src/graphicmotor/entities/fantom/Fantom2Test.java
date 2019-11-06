package graphicmotor.entities.fantom;

import java.io.File;
import java.io.IOException;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureData;
import com.jogamp.opengl.util.texture.TextureIO;

import graphicmotor.entities.Entity;

public class Fantom2Test extends Entity {
TextureData textureData = null ;
	
	int currentTexture = -1 ;

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
		
		gl.glTexCoord2d(0, 0); // Top-Left
		gl.glVertex3d(-0.3f, -0.3f, 0.5f); 
		
		gl.glTexCoord2d(0 , 1);  // Bottom-Left
		gl.glVertex3d(-0.3f, 0.1f, 0.5f);
		
		gl.glTexCoord2d(1 , 1); // Bottom-Right
		gl.glVertex3d(0.1f, 0.1f, 0.5f); 
		
		gl.glTexCoord2d(1 , 0); // Top-Right
		gl.glVertex3d(0.1f, -0.3f, 0.5f); 
		
		
		gl.glEnd();

	}

}
