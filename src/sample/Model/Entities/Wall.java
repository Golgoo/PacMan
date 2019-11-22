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
    public String getSpritePath() {
        return "Game Files/Sprites/wall.png";
    }

    @Override
    public String toString() {
        return "W";
    }

    @Override
    public void resolveCollision(Collideable collideable) {

    }

    @Override
    public void resolveCollision(PacMan pacMan) {

    }

    @Override
    public void resolveCollision(Ghost ghost) {

    }

    @Override
    public void resolveCollision(FruitEntity fruitEntity) {

    }
}
