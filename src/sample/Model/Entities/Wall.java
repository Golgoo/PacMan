package sample.Model.Entities;


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
    public int getId() {
        return 0;
    }

    @Override
    public Context getGameContext() {
        return null;
    }

    @Override
    public String toString() {
        return "W";
    }
}
