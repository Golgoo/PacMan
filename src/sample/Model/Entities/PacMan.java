package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

import graphicmotor.GooContext;
import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;

public class PacMan implements Entity, Moveable, Living, Drawable {

    private DynamicMoveable dynamicPacman;

    private InputKey.Direction direction;

    private int graphicId = -1 ;
    
    private boolean alive;

    public PacMan(DynamicMoveable dynamicPacman) {
        this.dynamicPacman = dynamicPacman;
    }
    
	@Override
	public void generateGraphicId(GooContext GCtx) {
		AnimationBank<InputKey.Direction> animations = new AnimationBank<InputKey.Direction>();
		animations.putAnimation(InputKey.Direction.Right, new Animation("Game Files/Sprites/PACMAN/360x640-pacman-spritesheet.png", 5, 100));
		animations.putAnimation(InputKey.Direction.Left, new Animation("Game Files/Sprites/PACMAN/sprite_left.png", 3, 100));	
		graphicId = GCtx.createMultipleAnimatedEntity(animations);
	}

	@Override
	public int getGraphicId() {
		return graphicId ;
	}

    /*public PacMan(Position position) {
        this.dynamicPacman = new DynamicMoveable()
        this.dynamicPacman = dynamicPacman;
    }*/
    @Override
    public String toString() {
        return "P";
    }



    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        return dynamicPacman.computeNextWantedPosition(direction);
    }

    @Override
    public List<Entity> getEntitiesAt(Position position) {
        return dynamicPacman.getEntitiesAt(position);
    }

    @Override
    public List<Entity> move(InputKey.Direction direction) {
        List<Entity> entitiesOnSamePosition = dynamicPacman.move(direction);
        /*if(newEntity != null){
            System.out.println(getPosition());
            Collision.treatCollision(this, newEntity);
            ((Consumable) newEntity).consume();
            System.out.println(dynamicPacman.getCurrentMap());
            return newEntity;
        }*/
        return null;
    }

    @Override
    public Position getPosition() {
        return dynamicPacman.getPosition();
    }


    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Context getGameContext() {
        return null;
    }


    @Override
    public boolean isAlive() {
        return alive;
    }

}
