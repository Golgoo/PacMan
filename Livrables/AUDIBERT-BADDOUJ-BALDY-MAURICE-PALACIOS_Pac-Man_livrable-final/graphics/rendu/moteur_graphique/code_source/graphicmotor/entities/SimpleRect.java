package graphicmotor.entities;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;


/**
 * 
 * SimpleRect use basic GL methods to draw a rectangle using protected data in superclass {@link graphicmotor.entities.Entity}
 * @author goozi
 * @version 1.0
 */
public class SimpleRect extends Entity {
	

	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
		gl.glColor3f(colorR, colorG, colorB);
		
		gl.glBegin(GL2.GL_POLYGON);
		
		gl.glVertex3d(xPos, yPos - height, 1.0f); //Top-Left
		gl.glVertex3d(xPos, yPos, 1.0f); // Bottom-Left
		gl.glVertex3d(xPos + width, yPos, 1.0f); // Bottom-Right
		gl.glVertex3d(xPos + width, yPos - height, 1.0f); // Top-Right
		
		
		gl.glEnd();
		
	}

	@Override
	public void init(GL2 gl) {
		
	}
	
}
