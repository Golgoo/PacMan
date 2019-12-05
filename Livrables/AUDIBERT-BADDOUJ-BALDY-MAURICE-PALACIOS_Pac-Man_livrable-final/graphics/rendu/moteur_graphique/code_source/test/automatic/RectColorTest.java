package test.automatic;

import java.nio.ByteBuffer;

import com.jogamp.opengl.GL2;

import graphicmotor.GooContext;
import test.Test;

public class RectColorTest extends Test {
	
	public RectColorTest (GooContext goo) {
		super(goo);
	}

	private int rectRef ;
	
	private int x = 250 ;
	private int y = 400 ;
	private int w = 100 ;
	private int h = 100 ;
	
	private float expectedR = 1.0f ;
	private float expectedG = 0.4f ;
	private float expectedB = 0.0f ;
	
	private float unexpectedR = 0.0f ;
	private float unexpectedB = 0.6f ;
	
	private float precision = 0.02f;
	
	@Override
	public void init() {
		rectRef = gooContext.createSimpleRect();
		
		gooContext.setEntityPosition(rectRef, x, y);
		gooContext.setEntitySize(rectRef, w, h);
		gooContext.setEntityColorMask(rectRef, expectedR, expectedG, expectedB);
		gooContext.enableEntity(rectRef);

	}
	
	@Override
	public void test(GL2 gl) {
		
    	ByteBuffer RGB = getColorAt(gl, x + w/2, y - h/2);
    	
    	float r, g, b ;
    	r = readR(RGB);
    	g = readG(RGB);
    	b = readB(RGB);
   	
    	assertInBounds(r, expectedR, precision);
    	assertInBounds(g, expectedG, precision);
    	assertInBounds(b, expectedB, precision);
    	
    	assertNotInBounds(r, unexpectedR, precision);
    	assertNotInBounds(g, unexpectedB, precision);
    	
    	gooContext.destroyEntity(rectRef);
	}

	
}
