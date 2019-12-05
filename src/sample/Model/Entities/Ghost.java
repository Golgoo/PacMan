package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;
import sample.Model.PathFinding.Node;
import sample.Model.PathFinding.PathFindingAlgorithm;

import java.util.List;

public class Ghost implements MoveableIntellectualEntity {


    private int graphicId;

    private int velocity;

    private Position position;

    private Level level;

    private DynamicMoveable dynamicGhost;

    private InputKey.Direction direction;

    private PathFindingAlgorithm pathFindingAlgorithm;

    public void setDirection(InputKey.Direction direction) {
        this.direction = direction;
    }

    public Ghost(DynamicMoveable dynamicGhost, Position position, Level level) {
        this.dynamicGhost = dynamicGhost;
        this.position = position;
        this.level = level;
        this.velocity = 1;
        direction = InputKey.Direction.None;
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
        return dynamicGhost.computeNextWantedPosition(position,direction, getVelocity());
    }


    @Override
    public void move(Position nextWantedPosition, List<Entity> nextPositionEntities) {
        position = nextWantedPosition;
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


    private Position toMazePosition(Position position) {
        float xFloat = (float) position.getX();
        float yFloat = (float) position.getY();
        return new Position(Math.round(xFloat/50), Math.round(yFloat/50));
    }

    private Position toPixelPosition(Position position) {
        return new Position(position.getX()*50,position.getY()*50);
    }

    public InputKey.Direction getDirection() {
        return direction;
    }

    @Override
    public PathFindingAlgorithm getPathFindingAlgorithm() {
        return pathFindingAlgorithm;
    }

    @Override
    public void setPathFindingAlgorithm(PathFindingAlgorithm pathFindingAlgorithm) {
        this.pathFindingAlgorithm = pathFindingAlgorithm;
    }


    @Override
    public List<Node> computePathToGivenEntity(Entity entity) {
        return null;
    }

    @Override
    public void computeDirectionToGivenEntity(Entity entity) {

    }

    public void setDirectionToTake(Position actualPosition ,Position positionToGo){
        if(actualPosition.getX() < positionToGo.getX())
            direction = InputKey.Direction.Right;
        else if(actualPosition.getX() > positionToGo.getX())
            direction = InputKey.Direction.Left;
        else if(actualPosition.getY() > positionToGo.getY())
            direction = InputKey.Direction.Up;
        else if(actualPosition.getY() < positionToGo.getY())
            direction = InputKey.Direction.Down;
    }
}
