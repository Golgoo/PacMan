package sample.Model.Entities;

import javafx.scene.image.Image;

public class Wall implements Cell {
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
    public Image toImageView() {
        return null;
    }

    @Override
    public String toString() {
        return "W";
    }
}
