package graphicmotor.entities;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EntitiesBank implements Iterable<Entity>{
	private static List<Entity> entities = new ArrayList<>();

	@Override
	public Iterator<Entity> iterator() {
		return new Iterator<Entity>() {
			private int indice = 0 ;
			
			@Override
			public boolean hasNext() {
				return entities.size() != indice ;
			}

			@Override
			public Entity next() {
				return entities.get(indice++);
			}
		};
	}
	
	public static int addEntities(Entity entity) {
		if(entities.add(entity)) {
			return entities.size()-1;
		}
		return -1 ;
	}
	
	public static void removeEntities(int entityIndex) {
		if(entities.size() > entityIndex) {
			entities.set(0, null);
		}
	}
}
