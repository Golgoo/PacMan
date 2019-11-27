package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

public class Ghost implements Entity, Moveable, Living {

    DynamicMoveable dynamicGhost;

    private int graphicId;

    private boolean alive;


    @Override
    public String toString() {
        return "G";
    }

    @Override
    public void setPosition(Position position) {
        this.dynamicGhost.setPosition(position);
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
        return graphicId;
    }

    public void setGraphicId(int grapicId) {
        this.graphicId = grapicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(30,30);
    }


    @Override
    public String getSpritePath() {
        return "Game Files/Sprites/Blue_up.png";
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
