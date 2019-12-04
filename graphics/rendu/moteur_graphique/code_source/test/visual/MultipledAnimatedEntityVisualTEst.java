package test.visual;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

import graphicmotor.GooContext;
import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;

class MultipledAnimatedEntityVisualTEst {

	@Test
	void test() {
		
		GooContext goo = new GooContext(600, 800);
		
		
		JFrame frame = new JFrame();
		frame.setSize(600, 800);
		frame.add(goo.getCanvas());
		frame.setVisible(true);
		
		AnimationBank<Integer> animationBank = new AnimationBank<Integer>();
		try {
			animationBank.putAnimation(1, new Animation(new FileInputStream(new File("src/sprites_1.png")), 6, 80));
			animationBank.putAnimation(2, new Animation(new FileInputStream(new File("src/sprites_1.png")), 3, 80));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		int ref = goo.createMultipleAnimatedEntity(animationBank);
		goo.setEntityPosition(ref, 250, 350);
		goo.setEntitySize(ref, 100, 100);
		goo.enableEntity(ref);
		
		
		
		goo.start(60);
		
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		goo.setMultipledAnimatedEntityAnimation(ref, 2);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		goo.stopEntityAnimation(ref);
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
