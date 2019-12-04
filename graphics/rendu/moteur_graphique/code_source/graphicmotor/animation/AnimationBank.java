package graphicmotor.animation;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * AnimationBank basically act like a {@link Map}
 * 
 * @author goozi
 *
 * @param <KEY>
 */
public class AnimationBank<KEY>  {
	private Map<KEY, Animation> animationsMap = new HashMap<KEY, Animation>();
	
	/**
	 * 
	 * @param key key
	 * @param animation animation
	 */
	public void putAnimation(KEY key, Animation animation) {
		animationsMap.put(key, animation);
	}
	
	/**
	 * 
	 * @return the animation map
	 */
	public Map<KEY, Animation> getMap(){
		return animationsMap;
	}
}
