package graphicmotor;
import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable; 
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

import graphicmotor.entities.EntitiesBank;
import graphicmotor.entities.Entity;


public class MainGLEvent implements GLEventListener { 

	private EntitiesBank entitiesBank = new EntitiesBank();
	
    
    private GLUT glut = new GLUT();
    private GLU glu = new GLU();
	
    @Override 
    public void init(GLAutoDrawable drawable) { 
    	final GL2 gl = drawable.getGL().getGL2();
    	
    	 gl.glShadeModel(GL2.GL_SMOOTH);
    	 gl.glClearColor(0f, 0f, 0f, 0f);
    	 gl.glClearDepth(1.0f);
    	 gl.glEnable(GL2.GL_DEPTH_TEST);
    	 gl.glDepthFunc(GL2.GL_LEQUAL);
    	 gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
    	 
    	 
    	 gl.glEnable(GL2.GL_TEXTURE_2D);
    	 
    	 gl.glEnable(GL.GL_BLEND);
    	 gl.glBlendFunc(GL.GL_ONE, GL.GL_ONE_MINUS_SRC_ALPHA);
    	 
    	 for(Entity entity : entitiesBank) {
    		 entity.init(gl);
    	 }	 
    }
    
    @Override 
    public void dispose(GLAutoDrawable drawable) { 
        // TODO Auto-generated method stub 
    }

    
    private boolean displayed = false;
    
    @Override 
    public void display(GLAutoDrawable drawable) {
    	
    	if(!displayed) {
    		System.out.println("Displayed !");
    		displayed = true;
    	}
    	
    	final GL2 gl = drawable.getGL().getGL2();
    	//long previousTime = System.currentTimeMillis();

    	gl.glClear (GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT );
    	
    	gl.glLoadIdentity();
    	
    	for(Entity entity : entitiesBank) {
    		if(entity!=null) {
    			entity.render(gl, glu, glut);
    		}
    	}

    	gl.glFlush();
    	
    	//long finishedTime = System.currentTimeMillis();
    	//pause(frameRate - ( finishedTime - previousTime ) );
    }
    
    @SuppressWarnings("unused")
	private final long frameRate = 200 ;
    
    @SuppressWarnings("unused")
	private void pause(long millisec) {
    	if(millisec > 0) {
    		try {
    			Thread.sleep(millisec);
    		} catch (InterruptedException e) {
    			System.err.println("In pause function : ");
    			e.printStackTrace();
    		}    		
    	}
	}

    @Override 
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    	System.out.println("Reshaped !" + " w : " + width + " -- h :" + height);
    } 

}
