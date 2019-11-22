package sample.Model.Entities;

import javafx.scene.image.Image;
import sample.Model.InputKey;

import java.util.List;

public class PacMan implements Entity, Moveable, Living {

    private DynamicMoveable dynamicPacman;

    private InputKey.Direction direction;

    private boolean alive;

    public PacMan(DynamicMoveable dynamicPacman) {
        this.dynamicPacman = dynamicPacman;
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
