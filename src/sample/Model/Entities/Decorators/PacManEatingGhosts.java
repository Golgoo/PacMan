package sample.Model.Entities.Decorators;

import graphicmotor.GooContext;
import sample.Model.Entities.*;
import sample.Model.InputKey;

import java.util.List;

public class PacManEatingGhosts extends MoveableEntityDecorator{

    public PacManEatingGhosts(MoveableEntity decoratedEntity) {
        super(decoratedEntity);
    }

    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        return decoratedEntity.computeNextWantedPosition(direction);
    }

    @Override
    public void move(Position nextWantedPosition, List<Entity> nextPositionEntities) {
        decoratedEntity.move(nextWantedPosition, nextPositionEntities);
    }

    @Override
    public int getVelocity() {
        return decoratedEntity.getVelocity();
    }

    @Override
    public Position getPosition() {
        return decoratedEntity.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        decoratedEntity.setPosition(position);
    }

    @Override
    public boolean isAccessible() {
        return decoratedEntity.isAccessible();
    }

    @Override
    public Dimension getDimension() {
        return decoratedEntity.getDimension();
    }

    @Override
    public String getSpritePath() {
        return decoratedEntity.getSpritePath();
    }

    @Override
    public int getGraphicId() {
        return decoratedEntity.getGraphicId();
    }

    @Override
    public void setGraphicId(int graphicId) {
        decoratedEntity.setGraphicId(graphicId);
    }

    @Override
    public void createGraphicEntity(GooContext gooContext) {
        decoratedEntity.createGraphicEntity(gooContext);
    }

    @Override
    public void resolveCollision(Collideable collideable) {
        decoratedEntity.resolveCollision(collideable);
    }

    @Override
    public void resolveCollision(PacMan pacMan) {
        decoratedEntity.resolveCollision(pacMan);
    }

    @Override
    public void resolveCollision(Ghost ghost) {
    }

    @Override
    public void resolveCollision(Fruit fruitEntity) {
        decoratedEntity.resolveCollision(fruitEntity);
    }
}
