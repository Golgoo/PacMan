package graphicmotor.factory;

import com.jogamp.opengl.GLEventListener;

import graphicmotor.MainGLEvent;
import graphicmotor.entities.EntitiesBank;
import test.GLTest;

/**
 * 
 * GLEventFactory create is used to create GLEventListener. <p>
 * The main method {@link graphicmotor.factory.GLEventFactory#createGLEventListener(EntitiesBank)} vary depending of an environment variable call "env".<p>
 * If no such variable is defined, a default strategy is applied. <p>
 * 
 * @author goozi
 */
public class GLEventFactory {
	/**
	 * 
	 * Create the correct GLEventListener depending of the environment ( DEV / TEST / PROD ).
	 * <p>
	 * The default environment is DEV.
	 * <p>
	 * 
	 * If the environment is TEST so a {@link test.GLTest} is created<p>
	 * Else a {@link graphicmotor.MainGLEvent} is created.
	 * 
	 * @param entitiesBank entitiesBank associated with the context
	 * @return the {@link com.jogamp.opengl.GLEventListener} associated to the current environment
	 */
	public static GLEventListener createGLEventListener(EntitiesBank entitiesBank) {
		String env = System.getenv("env");
		if(env == null) {
			return new MainGLEvent(entitiesBank);
		}
		switch (env) {
		case "TEST":
			return new GLTest(new MainGLEvent(entitiesBank));
		case "DEV":
			return new MainGLEvent(entitiesBank);
		case "PROD":
			return new MainGLEvent(entitiesBank);
		default:
			return new MainGLEvent(entitiesBank);
		}
	}
}
