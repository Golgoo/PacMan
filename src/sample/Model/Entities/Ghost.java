package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

import java.util.List;

public class Ghost implements MoveableEntity {


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
        return dynamicGhost.computeNextWantedPosition(position,direction);
    }


    @Override
    public void move(Position nextWantedPosition, List<Entity> nextPositionEntities) {
        setPosition(nextWantedPosition);
        level.setEntityPosition(this.getGraphicId(), getPosition().getX(), getPosition().getY());
        for(Entity entity : nextPositionEntities)
            resolveCollision(entity);
    }

    @Override
    public int getVelocity() {
        return velocity;
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
}
