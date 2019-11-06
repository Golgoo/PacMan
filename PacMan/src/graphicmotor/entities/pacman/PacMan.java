package graphicmotor.entities.pacman;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

import graphicmotor.entities.Entity;

public class PacMan extends Entity{
	
	private float radius = 0.1f;
	
	private Direction currentDirection = Direction.HAUT;
	
	private int mouthSize = 25 ;
	
	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		
		gl.glBindTexture(GL2.GL_TEXTURE_2D, 0);
		
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
	    gl.glColor3f(0.0f, 0.0f, 1.0f);
	    gl.glVertex3d(-0.7f, 0.0f, 1.0f);
	    
	    int numSegments = (int)MouthBounds.numSegments;
	    float angle;
	    int start = MouthBounds.getStart(currentDirection, mouthSize);

	    int end = start + numSegments - mouthSize ;
	    for (int i = start ; i <= end; i++) {
	    	angle = (float) (i * 2.0f * Math.PI / numSegments);
	        gl.glVertex3d(Math.cos(angle) * radius - 0.7f, Math.sin(angle) * radius, 1.0f);
	    }
	    
	    gl.glEnd();
	}

	@Override
	public void init(GL2 gl) {
		// TODO Auto-generated method stub
		
	}
	
}
