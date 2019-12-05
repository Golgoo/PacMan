package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.nio.ByteBuffer;

import com.jogamp.opengl.GL2;

import graphicmotor.GooContext;

/**
 * 
 * Any test are execute with two phases : the initialization and the tests on the GL context
 * 
 * <p>
 * 
 * It's important to note that if {@link test.Test#init()} is call at the frame x, the {@link test.Test#test(GL2)} will be call at the frame x+1. And the next test will init at frame x+2 and be test at frame x+3
 * <p>
 * Tests are independent: Any test cannot affect the validation of another test
 * 
 * <p>
 * Test module based on time isn't yet implements and will be accessible on version 1.2
 * 
 * @author goozi
 * @version 1.0
 */
public abstract class Test {
	
	protected GooContext gooContext ;
	
	/**
	 * 
	 * @param gooContext the GooContext associated to this test
	 */
	public Test (GooContext gooContext) {
		this.gooContext = gooContext ;
	}
	
	private ByteBuffer RGB = null ;
	
	protected ByteBuffer getColorAt(GL2 gl, int x, int y) {
		if(RGB == null)
			RGB = ByteBuffer.allocateDirect(3);
    	gl.glReadPixels(x, y, 1, 1, GL2.GL_RGB, GL2.GL_BYTE, RGB);
    	return RGB;
	}
	
	protected float readR(ByteBuffer buffer) {
		return (RGB.get(0)* 2)/255f;
	}
	protected float readG(ByteBuffer buffer) {
		return (RGB.get(1)* 2)/255f;
	}
	protected float readB(ByteBuffer buffer) {
		return (RGB.get(2)* 2)/255f;
	}
	
	protected void assertInBounds(float actual, float expected, float precision) {
		assertTrue(actual >= expected - precision && actual <= expected + precision);
	}
	

	protected void assertNotInBounds(float actual, float unexpected, float bound) {
		assertFalse(actual >= unexpected - bound && actual <= unexpected + bound);
	}

	/**
	 * Initialization method for the future test.<p>
	 * 
	 */
	public abstract void init();
	/**
	 * 
	 * Test if the initialization was correctly done on this GL context.<p>
	 * 
	 * Users shall implements a way to prove that the init method was done successfully
	 * 
	 * @param gl GL context
	 */
	public abstract void test(GL2 gl);
}
