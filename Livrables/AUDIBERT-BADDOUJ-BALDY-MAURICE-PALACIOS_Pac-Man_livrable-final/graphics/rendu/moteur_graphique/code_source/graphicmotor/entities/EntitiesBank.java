package graphicmotor.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;

import com.jogamp.opengl.GL2;

/**
 * 
 * Each context have its own EntityBank.<p>
 * The EntitiesBank is mainly used by : <p>
 * <ul>
 * <li>
 * {@link graphicmotor.GooContext} to save or delete entities into the context
 * </li>
 * <li>
 * {@link graphicmotor.MainGLEvent} to iterate over the entities of the context
 * </li>
 * </ul>
 * This class use many list to register entity smartly and be more performing for other GMotor's components
 * <p>
 * The index of an entity in the main list is represented with the id of this entity
 * 
 * @author goozi
 *
 */
public class EntitiesBank implements Iterable<Entity>{
	private List<Entity> entities = new ArrayList<>();
	
	private SortedSet<Integer> nextFreeIndex = new TreeSet<Integer>();
	
	private ConcurrentLinkedQueue<Entity> entitiesToInit = new ConcurrentLinkedQueue<Entity>(); 
	
	private ConcurrentMap<Integer, List<Entity>> zSortedEntity = new ConcurrentHashMap<Integer, List<Entity>>();

	@Override
	public Iterator<Entity> iterator() {
		
		return new Iterator<Entity>() {
			private int key = 0 ;
			private int indice = 0 ;
			
			private int nbKeys = zSortedEntity.keySet().size();
			private Integer[] keySet = initKeySet();
			private List<Entity> currentList ;
			

			private Integer[] initKeySet() {
				Integer[] keySet = new Integer[nbKeys];
				int i = 0 ;
				for(int value : zSortedEntity.keySet()) {
					keySet[i++] = value ;
				}
				return keySet ;
			}
			
			@Override
			public boolean hasNext() {
				if(key >= nbKeys) return false;
				currentList = zSortedEntity.get(keySet[key]);
				if(currentList == null) {
					return false;
				}
				while(indice == currentList.size()) {
					key++;
					if(key >= nbKeys) return false;
					currentList = zSortedEntity.get(keySet[key]);
					indice = 0 ;
				}
				return true ;
			}

			@Override
			public Entity next() {
				return currentList.get(indice++);
			}
		};
	}
	
	/**
	 * Add the entity to the context's bank.<p>
	 * 
	 * This function search the lower free Id for this entity.<p>
	 * If not such Id exist, it take the list.size() as Id<p>
	 * 
	 * The entity is now ready to be initialized with a GL context.
	 * 
	 * @param entity entity to add
	 * @return the index in the main list of entity as an Id
	 */
	public int addEntities(Entity entity) {
		int index = -1;
		if(nextFreeIndex.isEmpty()) {
			index = entities.size();
		}else {
			index = nextFreeIndex.first();
			nextFreeIndex.remove(index);
		}
		if(index < 0) return -1 ;
		entities.add(index, entity);
		entitiesToInit.add(entity);
		
		return index ;
	}
	
	/**
	 * Remove the entity.<p>
	 * the Id is now free for other entities' creation.
	 * @param entityId id of the entity
	 */
	public void removeEntities(int entityId) {
		if(entities.size() > entityId) {
			Entity e = entities.get(entityId);
			zSortedEntity.get(e.getZIndex()).remove(e);
			if(zSortedEntity.get(e.getZIndex()).isEmpty()) {
				zSortedEntity.remove(e.getZIndex());
			}
			if(entities.size() - 1 == entityId) {
				entities.remove(entityId);
			}else {
				entities.set(entityId, null);
				nextFreeIndex.add(entityId);
			}
		}
	}
	
	/**
	 * 
	 * Entity's assessor
	 * 
	 * @param entityId id of the entity
	 * @return the entity at this index
	 */
	public Entity get(int entityId) {
		return entities.get(entityId);
	}
	
	/**
	 * 
	 * Initialize any entity needed to be.
	 * <p>
	 * For each entity ready to be initialized, it call the method {@link graphicmotor.entities.Entity#init(GL2)} 
	 * <p>
	 * After it clear the list of the entity to initialize
	 * 
	 * @param gl valid GL context
	 */
	public void initEntities(GL2 gl) {
		while(! entitiesToInit.isEmpty()) {
			Entity entity = entitiesToInit.poll();
			entity.init(gl);
			if(zSortedEntity.containsKey(entity.getZIndex())) {
				zSortedEntity.get(entity.getZIndex()).add(entity);
			}else {
				zSortedEntity.put(entity.getZIndex(), new LinkedList<Entity>());
				zSortedEntity.get(entity.getZIndex()).add(entity);
			}
		}
	}

	/**
	 * Clear any entities.<p>
	 * 
	 * Now the EntitiesBank is empty and the next free Id is 0.
	 * 
	 */
	public void clear() {
		entities = new ArrayList<>();
		nextFreeIndex = new TreeSet<Integer>();
		entitiesToInit = new ConcurrentLinkedQueue<Entity>();
		zSortedEntity = new ConcurrentHashMap<Integer, List<Entity>>();
	}
}
