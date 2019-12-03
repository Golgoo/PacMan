package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

import java.util.List;

public class Ghost implements Entity, Moveable {


    private int graphicId;

    private boolean alive;
    private int velocity;

    private Position position;
    private Level level;

    private DynamicMoveable dynamicGhost;

    public Ghost(DynamicMoveable dynamicGhost, Position position, Level level) {
        this.dynamicGhost = dynamicGhost;
        this.position = position;
        this.level = level;
        this.velocity = 5;
    }

    @Override
    public String toString() {
        return "G";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isAccessible() {
        return true;
    }

    @Override
    public int getGraphicId() {
        return graphicId;
    }

    public void setGraphicId(int grapicId) {
        this.graphicId = grapicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(40,40);
    }


    @Override
    public String getSpritePath() {
        return "src/ressources/redghost.gif";
    }


    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        return null;
    }

    @Override
    public List<Entity> getEntitiesIntersecting(Position position) {
        return null;
    }

    @Override
    public void move(Position nextWantedPosition, List<Entity> nextPositionEntities) {

    }

    @Override
    public int getVelocity() {
        return velocity;
    }

    @Override
    public Position computeNextWantedPosition() {
        return null;
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
