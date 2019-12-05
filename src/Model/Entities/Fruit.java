package Model.Entities;


import graphicmotor.GooContext;
import Model.Level;

public class Fruit implements Entity, Consumable {

    Position position;
    int graphicId;

    public Fruit(Position position) {
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
    public void createGraphicEntity(GooContext gooContext) {
        setGraphicId(gooContext.createStaticEntity(getSpritePath()));
        gooContext.setEntityPosition(getGraphicId(), getPosition().getX()*50 + ((50-getDimension().getWeight())/2), getPosition().getY()*50 + ((50-getDimension().getHeight())/2));
        gooContext.setEntitySize(getGraphicId(), getDimension().getWeight(), getDimension().getHeight());
        setPosition(new Position(getPosition().getX()*50 + ((50-getDimension().getWeight())/2), getPosition().getY()*50 + ((50-getDimension().getHeight())/2)));
        gooContext.setZIndex(getGraphicId(), 0);
        gooContext.enableEntity(getGraphicId());
    }

    @Override
    public boolean isAccessible() {
        return true;
    }

    @Override
    public int getGraphicId() {
        return graphicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(20,20);
    }

    @Override
    public String getSpritePath() {
        return "src/ressources/whitedot.png";
    }


    @Override
    public String toString() {
        return "FruitEntity" +
                " " + position.toString() +
                '}';
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
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
    public void resolveCollision(Fruit fruitEntity) {

    }

    public void consume(PacMan pacMan, Level level) {
        level.setScore(level.getScore()+1);
        level.getEntityList().remove(this);
        level.removeEntity(this.graphicId);
        System.out.println("Remove " + this.toString());
        System.out.println("Score : " + level.getScore());
    }
}
