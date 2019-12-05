package sample.Model.Entities.Decorators;


import sample.Model.Entities.*;
import sample.Model.InputKey;
import sample.Model.PathFinding.Node;
import sample.Model.PathFinding.PathFindingAlgorithm;

import java.util.List;
import java.util.Random;

public class DumbGhost extends MoveableIntellectualEntityDecorator {

    public DumbGhost(MoveableIntellectualEntity decoratedEntity) {
        super(decoratedEntity);
    }

    @Override
    public void setPathFindingAlgorithm(PathFindingAlgorithm pathFindingAlgorithm) {
        decoratedEntity.setPathFindingAlgorithm(pathFindingAlgorithm);
    }

    @Override
    public InputKey.Direction getDirection() {
        return decoratedEntity.getDirection();
    }

    @Override
    public void setDirection(InputKey.Direction direction) {
        decoratedEntity.setDirection(direction);
    }

    @Override
    public void setDirectionToTake(Position actualPosition, Position positionToGo) {
        decoratedEntity.setDirectionToTake(actualPosition,positionToGo);
    }

    @Override
    public PathFindingAlgorithm getPathFindingAlgorithm() {
        return decoratedEntity.getPathFindingAlgorithm();
    }

    @Override
    public List<Node> computePathToGivenEntity(Entity entity) {
        return decoratedEntity.computePathToGivenEntity(entity);
    }

    @Override
    public void computeDirectionToGivenEntity(Entity entity) {
        int rand = new Random().nextInt(5);
        setDirection(InputKey.Direction.values()[rand]);

        //decoratedEntity.computeDirectionToGivenEntity(entity);
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
    public String toString() {
        return decoratedEntity.toString();
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
        decoratedEntity.resolveCollision(ghost);
    }

    @Override
    public void resolveCollision(Fruit fruitEntity) {
        decoratedEntity.resolveCollision(fruitEntity);
    }


}
