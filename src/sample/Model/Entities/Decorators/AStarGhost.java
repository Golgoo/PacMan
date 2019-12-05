package sample.Model.Entities.Decorators;

import graphicmotor.GooContext;
import sample.Model.Entities.*;
import sample.Model.Tools.PathConverter;
import sample.Model.InputKey;
import sample.Model.Level;
import sample.Model.PathFinding.AStar;
import sample.Model.PathFinding.Node;
import sample.Model.PathFinding.PathFindingAlgorithm;

import java.util.List;

public class AStarGhost extends MoveableIntellectualEntityDecorator {

    private Position positionToReach;
    private Level level;


    public AStarGhost(MoveableIntellectualEntity decoratedEntity, Level level) {
        super(decoratedEntity);
        //positionToReach = new Position(decoratedEntity.getPosition());
        this.level = level;
    }


    @Override
    public PathFindingAlgorithm getPathFindingAlgorithm() {
        return decoratedEntity.getPathFindingAlgorithm();
    }

    @Override
    public void setPathFindingAlgorithm(PathFindingAlgorithm pathFindingAlgorithm) {
        decoratedEntity.setPathFindingAlgorithm(pathFindingAlgorithm);
    }

    @Override
    public List<Node> computePathToGivenEntity(Entity entity) {
        if(positionToReach == null)
            positionToReach = decoratedEntity.getPosition();

        if(positionToReach.getX() != decoratedEntity.getPosition().getX() || positionToReach.getY() != decoratedEntity.getPosition().getY())
            return null;


       // System.out.println("ghost"+decoratedEntity.getPosition());

        Position ghostPositionMaze = toMazePosition(decoratedEntity.getPosition());
        Position entityPositionMaze = toMazePosition(entity.getPosition());

       // System.out.println(ghostPositionMaze);


        return decoratedEntity.getPathFindingAlgorithm().findPathFromTo(ghostPositionMaze.getX(),ghostPositionMaze.getY(),entityPositionMaze.getX(), entityPositionMaze.getY());
    }

    @Override
    public void computeDirectionToGivenEntity(Entity entity) {
        setPathFindingAlgorithm(new AStar(level.getMaze(),false));

        List<Node> path = computePathToGivenEntity(entity);

        if(path == null) {
            return;
        }


        Position nextPosition = new PathConverter().convertPathToPosition(path);


        if(nextPosition == null){
            decoratedEntity.setDirection(InputKey.Direction.None);
            return;
        }

        positionToReach = toPixelPosition(nextPosition);

        decoratedEntity.setDirectionToTake(toMazePosition(decoratedEntity.getPosition()),nextPosition);
    }


    @Override
    public void setDirection(InputKey.Direction direction) {
        decoratedEntity.setDirection(direction);
    }

    @Override
    public void setDirectionToTake(Position actualPosition, Position positionToGo) {
        decoratedEntity.setDirectionToTake(actualPosition,positionToGo);
    }

    private Position toMazePosition(Position position) {
        float xFloat = (float) position.getX();
        float yFloat = (float) position.getY();
        return new Position(Math.round(xFloat/50), Math.round(yFloat/50));
    }

    private Position toPixelPosition(Position position) {
        return new Position(position.getX()*50,position.getY()*50);
    }

    @Override
    public InputKey.Direction getDirection() {
        return decoratedEntity.getDirection();
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
