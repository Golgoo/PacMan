package graphicmotor.entities;

import java.awt.Font;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.awt.TextRenderer;
import com.jogamp.opengl.util.gl2.GLUT;

/**
 * 
 * TextEntity is a class able to render text on the context
 * 
 * 
 * @author goozi
 *
 */
public class TextEntity extends Entity {

	private TextRenderer renderer ;
	
	private int CtxWidth ;
	private int CtxHeight;
	private String text = "";
	
	/**
	 * 
	 * If the text is bigger than the windows that contain it, the overflow will be hidden
	 *  
	 * @param width width of the windows containing the text
	 * @param height width of the windows containing the text
	 * @param font font of the text
	 */
	public TextEntity(int width, int height, Font font) {
		this.CtxWidth = width;
		this.CtxHeight = height;
		renderer = new TextRenderer(font);
	}
	
	@Override
	public void init(GL2 gl) {
	}

	@Override
	public void render(GL2 gl, GLU glu, GLUT glut) {
		renderer.beginRendering(CtxWidth, CtxHeight);
    	renderer.setColor(colorR, colorG, colorB, 1.0f);
    	renderer.setSmoothing(true);

    	renderer.draw(text, xPix, yPix);
    	renderer.endRendering();
	}

	public void setText(String text) {
		this.text = text ;
	}
	

}
