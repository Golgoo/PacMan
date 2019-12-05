package test.automatic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;

import com.jogamp.opengl.GL2;

import graphicmotor.GooContext;
import graphicmotor.animation.Animation;
import test.Test;

public class StaticTexturedZIndexTest extends Test {

	public StaticTexturedZIndexTest(GooContext goo) {
		super(goo);
	}
	
	private int xG = 250 ;
	private int yG = 400 ;
	private int wG = 150 ;
	private int hG = 100 ;
	private int zG = 2 ;
	
	private int xR = 250 ;
	private int yR = 400 ;
	private int wR = 100 ;
	private int hR = 100 ;
	private int zR = 3 ;
	
	private float precision = 0.02f;
	
	private int redRef ;
	private int greenRef ;
	
	@Override
	public void init() {
		try {
			redRef = gooContext.createSingleAnimatedEntity(new Animation(new  FileInputStream(new File("src/red.png")), 1, 200));
			
			gooContext.setEntityPosition(redRef, xR, yR);
			gooContext.setEntitySize(redRef, wR, hR);
			gooContext.setZIndex(redRef, zR);
			gooContext.enableEntity(redRef);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		try {
			greenRef = gooContext.createSingleAnimatedEntity(new Animation(new FileInputStream(new File("src/green.png")), 1, 200));

			gooContext.setEntityPosition(greenRef, xG, yG);
			gooContext.setEntitySize(greenRef, wG, hG);
			gooContext.setZIndex(greenRef, zG);
			gooContext.enableEntity(greenRef);	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void test(GL2 gl) {
		ByteBuffer buffer = getColorAt(gl, xR + wR/2, yR - hR/2);
		
		float r = readR(buffer);
		float g = readG(buffer);
		
		assertInBounds(r, 1.0f, precision);
		assertInBounds(g, 0.0f, precision);
		
		buffer = getColorAt(gl, xG + wG - 5, yG - hG/2 );
		
		r = readR(buffer);
		g = readG(buffer);
		
		assertNotInBounds(r, 1.0f, precision);
		assertInBounds(g, 1.0f, precision);
		
		gooContext.destroyEntity(redRef);
		gooContext.destroyEntity(greenRef);
	}

}
