package graphicmotor;


import java.awt.Dimension;
import java.awt.event.WindowAdapter; 
import java.awt.event.WindowEvent;
import java.io.File;

import com.jogamp.opengl.GLCapabilities; 
import com.jogamp.opengl.GLProfile; 
import com.jogamp.opengl.awt.GLCanvas; 
import javax.swing.JFrame; 

import com.jogamp.opengl.util.FPSAnimator;

import graphicmotor.entities.*;

public class MainFrame extends JFrame { 

    public MainFrame(){ 
        
        Dimension defaultSize = new Dimension(600, 600);
        setSize(defaultSize);

        /**
         * This is the graphic motor part start
         */
        GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault()); 
        glCapabilities.setDoubleBuffered(true);
        GLCanvas glCanvas = new GLCanvas(glCapabilities);
        MainGLEvent glListener = new MainGLEvent();
        glCanvas.addGLEventListener(glListener);
        
        /*
         * This function called by who want to
         */
		EntitiesBank.addEntities(new AnimatedEntity("PacMan/src/sprites_1.png", 6, 60));
       // EntitiesBank.addEntities(new Fantom());
		
        final FPSAnimator animator = new FPSAnimator(glCanvas, 60);
        animator.start();
        /**
         * This is the end of the graphic motor
         */
        
        add(glCanvas);

        addWindowListener(new WindowAdapter() { 

            @Override 
            public void windowClosing(WindowEvent e) { 
                animator.stop(); 
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } 

        }); 

        setResizable(false);
    } 

    private static final long serialVersionUID = -1227038124975588633L; 

} 