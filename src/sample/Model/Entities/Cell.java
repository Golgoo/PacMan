package sample.Model.Entities;


import javafx.scene.image.Image;

public interface Cell {
    Position getPosition();

    boolean isAccessible();

    Image toImageView();
}
