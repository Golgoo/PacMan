package test;

import java.util.LinkedList;
import java.util.Queue;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

/**
 * 
 * A GLTest have to be built construct with an operational GLEventListener. It will decorate this GLEventListener<p>
 * Any GLTest method override from GLEventListener will just the binded GLEventListener<p>
 * 
 * At each frame, if no test is running, it will pop a test from its queue of Tests and call test.#{@link test.Test#init()}. Now Their is a test running<p>
 * If a test is running it will call the method test.{@link test.Test#test(GL2)}. Now their is no test running.
 * 
 * @author goozi
 * @version 1.0
 */
public class GLTest implements GLEventListener{
	
	private GLEventListener bindedListener;
	
	private Queue<Test> testQueue  = new LinkedList<Test>();
	
	private Test currentTest = null ;
	
	/**
	 * @param glEventListener the bindedGLEvent 
	 */
	public GLTest(GLEventListener glEventListener) {
		bindedListener = glEventListener ;
	}
	
	/**
	 * Add a Test to do.
	 * @param test Test to do
	 */
	public void addTest(Test test) {
		testQueue.add(test);
	}
	
	private void doTests(GL2 gl) {
		if(currentTest == null) {
			currentTest = testQueue.poll();
			if(currentTest != null) currentTest.init();
		}
		else {
			currentTest.test(gl) ;
			currentTest = null ;
		}
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		bindedListener.display(drawable);
		final GL2 gl = drawable.getGL().getGL2();
		doTests(gl);
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		bindedListener.dispose(drawable);
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		bindedListener.init(drawable);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		bindedListener.reshape(drawable, x, y, width, height);
	}
}
