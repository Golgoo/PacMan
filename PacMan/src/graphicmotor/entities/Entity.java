package graphicmotor.entities;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public abstract class Entity {
	public abstract void init(GL2 gl);

	public abstract void render(GL2 gl, GLU glu, GLUT glut);
	
	//Method for Position AND Scale
	
	protected float [] buildTabVertex(float x, float y, float z) {
    	float[] v= new float [3];
    	v[0] = x ;
    	v[1] = y ;
    	v[2] = z ;
    	return v ;
    }
    
	protected void buildVertexFromTab(GL2 gl, float [] p) {
    	gl.glVertex3d(p[0], p[1], p[2]);
    }
}
