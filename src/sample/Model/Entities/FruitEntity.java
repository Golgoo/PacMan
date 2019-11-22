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
    public void consume() {

    }

    @Override
    public boolean isAccessible() {
        return true;
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
    public String toString() {
        return "F";
    }
}
