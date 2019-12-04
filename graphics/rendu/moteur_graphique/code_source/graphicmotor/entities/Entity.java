package graphicmotor.entities;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * 
 * The class Entity define the main behavior of any entity, {@link graphicmotor.entities.Entity#init(GL2)} and {@link graphicmotor.entities.Entity#render(GL2, GLU, GLUT)}, and provide to any extension common data to refine them rendering  
 * 
 * @author goozi
 * @version 1.0
 */
public abstract class Entity{
	/**
	 * 
	 * Provide a valid GLcontext for any entity which need it to finish them initialization.
	 * <p>
	 * Some entity may need a valid GL context to achieve they initialization.
	 * <p>
	 * Entity guarantee that this method will be called before any {@link graphicmotor.entities.Entity#render(GL2, GLU, GLUT)} method.
	 * <p>
	 * @param gl current GL context
	 */
	public abstract void init(GL2 gl);

	/**
	 * 
	 * When an entity need to be render, this method will be call
	 * <p>
	 * Every required tools for any OpenGL rendering are provide as parameters
	 * 
	 * @param gl current GL context
	 * @param glu current GLU context
	 * @param glut current GLUT context
	 */
	public abstract void render(GL2 gl, GLU glu, GLUT glut);

	protected float xPos ;
	protected float yPos ;
	protected float width = 0.0f ;
	protected float height = 0.0f ;
	
	protected float colorR = 1.0f;
	protected float colorG = 1.0f;
	protected float colorB = 1.0f;
	
	protected int xPix ;
	protected int yPix ;
	
	private int zIndex = 0;
	
	private boolean enable = false ;

	/**
	 * Utility method to build a float tab with 3D coordinates.
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 * @param z z coordinate
	 * @return an new float tab associated associated with these coordinates 
	 */
	protected float [] buildVertexTab(float x, float y, float z) {
    	float[] v= new float [3];
    	v[0] = x ;
    	v[1] = y ;
    	v[2] = z ;
    	return v ;
    }
    
	/**
	 * 
	 * Build a vertex on the GL2 context using the vertexTab
	 * 
	 * @param gl GL2 context 
	 * @param vertexTab 
	 */
	protected void buildVertexFromTab(GL2 gl, float [] vertexTab) {
    	gl.glVertex3d(vertexTab[0], vertexTab[1], vertexTab[2]);
    }

	
	/**
	 * 
	 * Set the entity position
	 * 
	 * @param fX horizontal value
	 * @param fY vertical value
	 */
	public void setPosision(float fX, float fY) {
		xPos = fX ;
		yPos = fY ;
	}
	
	/**
	 * 
	 * Set the entity size
	 * 
	 * @param fW width of the entity
	 * @param fH height of the entity
	 */
	public void setSize(float fW, float fH) {
		width = fW ;
		height = fH ;
	}
	
	/**
	 * 
	 * Set the current top-left corner's pixel of the entity ( binded with the position )
	 * 
	 * @param xPix x pixel value
	 * @param yPix y pixel value
	 */
	public void setPix(int xPix, int yPix) {
		this.xPix = xPix;
		this.yPix = yPix;
	}

	/**
	 * 
	 * Set the color mask apply over the entity
	 * 
	 * @param r red value 0.0f -> 1.0f
	 * @param g green value 0.0f -> 1.0f
	 * @param b blue value 0.0f -> 1.0f
	 */
	public void setColorMask(float r, float g, float b) {
		this.colorR = r ;
		this.colorG = g ;
		this.colorB = b ;
	}
	
	/**
	 * 
	 * Enable or disable the entity
	 * 
	 * @param enable true to enable, false to disable
	 */
	public void setEnable(boolean enable) {
		this.enable = enable ;
	}

	/**
	 * 
	 * @return true if the entity is enabled else false
	 */
	public boolean enable() {
		return enable ;
	}

	/**
	 * Set the Z-Index of the entity
	 * @param zIndex
	 */
	public void setZIndex(int zIndex) {
		this.zIndex = zIndex ;
	}
	
	/**
	 * 
	 * @return the zIndex of the entity
	 */
	public int getZIndex() {
		return zIndex ;
	}
}
