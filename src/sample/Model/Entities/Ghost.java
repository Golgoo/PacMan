package sample.Model.Entities;

import javafx.scene.image.Image;
import sample.Model.InputKey;

import java.util.List;

public class Ghost implements Entity, Moveable, Living {

    DynamicMoveable dynamicGhost;
    private boolean alive;


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
    public int getId() {
        return 0;
    }

    @Override
    public Context getGameContext() {
        return null;
    }


    public Image toImageView() {
        return null;
    }


    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        return null;
    }

    @Override
    public List<Entity> getEntitiesAt(Position position) {
        return null;
    }

    @Override
    public List<Entity> move(InputKey.Direction direction) {

        return null;
    }

    @Override
    public boolean isAlive() {
        return alive;
    }
}
