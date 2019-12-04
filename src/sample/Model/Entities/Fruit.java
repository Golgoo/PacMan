package sample.Model.Entities;


import sample.Model.Level;

import java.io.InputStream;

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
