package sample.Model.Entities;


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
    public String getSpritePath() {
        return "Game Files/Sprites/smalldot.png";
    }


    @Override
    public String toString() {
        return "FruitEntity" +
                " " + position.toString() +
                '}';
    }

    @Override
    public void resolveCollision(Collideable collideable) {
        collideable.resolveCollision(this);
    }

    @Override
    public void resolveCollision(PacMan pacMan) {
        pacMan.resolveCollision(this);
    }

    @Override
    public void resolveCollision(Ghost ghost) {

    }

    @Override
    public void resolveCollision(FruitEntity fruitEntity) {

    }
}
