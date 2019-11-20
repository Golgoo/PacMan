package sample.Model.Entities;

import javafx.scene.image.Image;
import sample.Model.InputKey;

public class Ghost implements Entity, Moveable {

    DynamicMoveable dynamicGhost;


    @Override
    public String toString() {
        return "G";
    }

    @Override
    public Position getPosition() {
        return dynamicGhost.getPosition();
    }

    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public Image toImageView() {
        return null;
    }

    @Override
    public Entity move(InputKey.Direction direction) {
        return null;
    }
}
