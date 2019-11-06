package graphicmotor.entities;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class SimpleRect extends Entity {

	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		gl.glBegin(GL2.GL_POLYGON);
		
		float p1 [] = buildTabVertex(-1.0f, 1.0f, 1.0f);
		float p2 [] = buildTabVertex(-1.0f, 0.8f, 1.0f);
		float p3 [] = buildTabVertex(-0.8f, 0.8f, 1.0f);
		float p4 [] = buildTabVertex(-0.8f, 1.0f, 1.0f);
		
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		
		buildVertexFromTab(gl, p1);
		buildVertexFromTab(gl, p2);
		buildVertexFromTab(gl, p3);
		buildVertexFromTab(gl, p4);
		
		gl.glEnd();
	}

	@Override
	public void init(GL2 gl) {
		// TODO Auto-generated method stub
		
	}
	
}
