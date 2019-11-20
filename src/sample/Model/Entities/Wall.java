package sample.Model.Entities;

import javafx.scene.image.Image;

public class Wall implements Entity {
    Position position;

    public Wall(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public String toString() {
        return "W";
    }
}