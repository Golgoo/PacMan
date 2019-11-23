package sample.Model.Entities;


public class Wall implements Entity {
    Position position;
    int graphicId;

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
        return graphicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(50,50);
    }

    @Override
    public void setGraphicId(int graphicId) {
        this.graphicId = graphicId;
    }

    @Override
    public String getSpritePath() {
        return "src/ressources/wall.png";
    }

    @Override
    public String toString() {
        return "W {"+ position.getxPos()+","+position.getyPos()+"}";
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
