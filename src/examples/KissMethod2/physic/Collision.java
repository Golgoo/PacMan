package examples.KissMethod2.physic;

import examples.KissMethod2.model.*;

public class Collision {
	private Entity src, dst ;
	
	public Collision(Entity src, Entity dst) {
		super();
		this.src = src;
		this.dst = dst;
	}

	public Entity getSrc() {
		return src;
	}

	public Entity getDst() {
		return dst;
	}
	
	
}
