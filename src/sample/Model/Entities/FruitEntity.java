package sample.Model.Entities;


public class FruitEntity implements Entity, Consumable {

    Position position;
    int graphicId;

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

    public void setGraphicId(int graphicId) {
        this.graphicId = graphicId;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }

    @Override
    public int getId() {
        return graphicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(20,20);
    }

    @Override
    public String getSpritePath() {
        return "src/ressources/smalldot.png";
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
