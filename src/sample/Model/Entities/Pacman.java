package sample.Model.Entities;

import javafx.scene.image.Image;
import sample.Model.InputKey;

public class Pacman implements Entity, Moveable {

    private DynamicMoveable dynamicPacman;

    private InputKey.Direction direction;

    public Pacman(DynamicMoveable dynamicPacman) {
        this.dynamicPacman = dynamicPacman;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public Entity move(InputKey.Direction direction) {
        Entity newEntity = dynamicPacman.move(direction);
        if(newEntity != null){
            System.out.println(getPosition());
            Collision.treatCollision(this, newEntity);
            ((Consumable) newEntity).use();
            System.out.println(dynamicPacman.getCurrentMap());
            return newEntity;
        }
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
    public Image toImageView() {
        return null;
    }
}
