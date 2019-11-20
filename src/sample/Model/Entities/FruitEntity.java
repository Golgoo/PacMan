package sample.Model.Entities;

import javafx.scene.image.Image;

public class FruitEntity implements Entity, Consumable {

    Position position;

    public FruitEntity(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void use() {

    }

    @Override
    public boolean isAccessible() {
        return true;
    }


    @Override
    public String toString() {
        return "F";
    }
}