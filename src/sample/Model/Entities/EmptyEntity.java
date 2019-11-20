package sample.Model.Entities;


import javafx.scene.image.Image;

public class EmptyEntity implements Entity,Consumable {

    Position position;

    public EmptyEntity(Position position) {
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
    public Image toImageView() {
        return null;
    }

    @Override
    public String toString() {
        return "E";
    }
}
