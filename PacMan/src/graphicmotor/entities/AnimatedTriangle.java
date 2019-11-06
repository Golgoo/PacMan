package graphicmotor.entities;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

public class AnimatedTriangle extends Entity {

	private float rotation = 0.0f; 
	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		gl.glRotatef( rotation, 1.0f, 1.0f, 0.0f );
    	
    	float sommet[] = buildTabVertex(0.0f, 0.5f, 0.0f);
    	float base1[] = buildTabVertex(-0.5f, -0.5f, 0.5f);
    	float base2[] = buildTabVertex(0.5f, -0.5f, 0.5f);
    	float base3[] = buildTabVertex(0.0f, -0.5f, -0.5f);
    	
    	gl.glBegin(GL2.GL_TRIANGLES);       
       
    	gl.glColor3f( 1.0f, 0.0f, 0.0f );

    	buildVertexFromTab(gl, sommet);
    	buildVertexFromTab(gl, base1);
    	buildVertexFromTab(gl, base2);
          
        gl.glColor3f( 0.0f, 1.0f, 0.0f );

        buildVertexFromTab(gl, sommet);
    	buildVertexFromTab(gl, base2);
    	buildVertexFromTab(gl, base3);
          
    	
        gl.glColor3f( 0.0f, 0.0f, 1.0f );
        buildVertexFromTab(gl, sommet);
    	buildVertexFromTab(gl, base3);
    	buildVertexFromTab(gl, base1);
    	
          
    	gl.glColor3f( 1.0f, 1.0f, 1.0f );
    	buildVertexFromTab(gl, base1);
    	buildVertexFromTab(gl, base2);
    	buildVertexFromTab(gl, base3);
		    
		gl.glEnd();
		
		rotation += 0.2f;
	}
	@Override
	public void init(GL2 gl) {
		// TODO Auto-generated method stub
		
	}

}
