package test.automatic;


import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import graphicmotor.GooContext;
import test.GLTest;

class DefaultTest {
	
	private static int FPS = 60 ;

	@Test
	void apparitionTest() {
		
		GooContext goo = new GooContext(600, 800);
		
		GLTest glTest = (GLTest) goo.glListener;
				
		goo.start(FPS);
		
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		frame.add(goo.getCanvas());
		frame.setVisible(true);
		
		glTest.addTest(new RectColorTest(goo));
		glTest.addTest(new StaticTexturedZIndexTest(goo));
				
		//Require time for tests
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}


}
