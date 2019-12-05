package graphicmotor;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

import graphicmotor.entities.EntitiesBank;
import graphicmotor.entities.Entity;


/**
 * 
 * MainGLEvent is a basic implementation of the interface {@link com.jogamp.opengl.GLEventListener} provide by JOGL
 * <p>
 * 
 * It has to use an entityBank to know which entity he has to work with
 * 
 * @see com.jogamp.opengl.GLEventListener
 * @author goozi
 * @version 1.0
 */
public class MainGLEvent implements GLEventListener { 

	private EntitiesBank entitiesBank ;
	
	/**
	 * 
	 * Main constructor
	 * 
	 * @param entitiesBank  
	 */
	public MainGLEvent(EntitiesBank entitiesBank) {
		this.entitiesBank = entitiesBank ;
	}
	
    
    private GLUT glut = new GLUT();
    private GLU glu = new GLU();
	
    /**
     * see : {@link com.jogamp.opengl.GLEventListener#init(GLAutoDrawable)}.
     * <p>
     * This function will initialize the GL context as needed
     */
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
   	 
    }
    
    /**
     * see : {@link com.jogamp.opengl.GLEventListener#dispose(GLAutoDrawable)}.
     */
    @Override 
    public void dispose(GLAutoDrawable drawable) { 
        // TODO Auto-generated method stub 
    }

    
    /**
     * see : {@link com.jogamp.opengl.GLEventListener#display(GLAutoDrawable)}.
     * <p>
     * This method will:
     * <ul>
     * 	<li>
     * 	 paint the canvas in black
     *  </li>
     *  <li>
     *    Entity may need a valid GL instance to be initialized and it's not such easy to create this kind of instance.
     *    <p>
     *    So we launch the {@link graphicmotor.entities.Entity#init(GL2)} method to init entities who need to.
     *   </li>
     * 	 <li>
     * 	   Iterate the entities of its {@link graphicmotor.entities.EntitiesBank} and call method {@link graphicmotor.entities.Entity#render(GL2, GLU, GLUT)} for each enabled entity
     * 	 </li>
     *   <li>
     *   	And finally swap the buffers
     *    </li>
     *    </ul>
     */
    @Override 
    public void display(GLAutoDrawable drawable) {
    	
    	final GL2 gl = drawable.getGL().getGL2();
    	
    	//long previousTime = System.currentTimeMillis();

    	gl.glClear (GL2.GL_COLOR_BUFFER_BIT |  GL2.GL_DEPTH_BUFFER_BIT );
    	
    	gl.glLoadIdentity();
    	
    	entitiesBank.initEntities(gl);
    	
    	for(Entity entity : entitiesBank) {
    		if(entity.enable()) {
    			entity.render(gl, glu, glut);
    		}
    	}

    	gl.glFlush();
    	
    	//long finishedTime = System.currentTimeMillis() ;
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

    /**
     * see : {@link com.jogamp.opengl.GLEventListener#reshape(GLAutoDrawable, int, int, int, int)}.
     */
    @Override 
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
    	//System.out.println("Reshaped !" + " w : " + w + " -- h :" + h);
    } 

}
