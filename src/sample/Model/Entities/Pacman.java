package sample.Model.Entities;

import javafx.scene.image.Image;
import sample.Model.InputKey;

public class Pacman implements Cell, Entity {

    private DynamicEntity dynamicPacman;

    private InputKey.Direction direction;

    public Pacman(DynamicEntity dynamicPacman) {
        this.dynamicPacman = dynamicPacman;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public Cell move(InputKey.Direction direction) {
        Cell newCell = dynamicPacman.move(direction);
        if(newCell != null){
            System.out.println(getPosition());
            Collision.treatCollision(this,newCell);
            ((Consumable)newCell).use();
            System.out.println(dynamicPacman.getCurrentMap());
            return newCell;
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
