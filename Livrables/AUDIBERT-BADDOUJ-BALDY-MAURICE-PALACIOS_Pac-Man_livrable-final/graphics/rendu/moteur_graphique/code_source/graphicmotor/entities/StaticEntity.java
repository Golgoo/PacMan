package graphicmotor.entities;

import java.io.IOException;
import java.io.InputStream;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLException;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.TextureIO;

/**
 * 
 * A static entity render the resource specified at the constructor
 * 
 * @author goozi
 *
 */
public class StaticEntity extends TexturedEntity{
	
	/**
	 * 
	 * @param streamToResource
	 */
	public StaticEntity(InputStream streamToResource) {
		this.stream = streamToResource ;
		textureCoord[0] = 0.0f;
		textureCoord[1] = 0.0f;
		textureCoord[2] = 1.0f;
		textureCoord[3] = 1.0f;
	}
	
	@Override
	public void init(GL2 gl) {
		try {
			Texture t = TextureIO.newTexture(stream, true, "PNG");
			texture = t.getTextureObject();
			
		} catch (GLException | IOException e) {
			e.printStackTrace();
		}
	}
}
