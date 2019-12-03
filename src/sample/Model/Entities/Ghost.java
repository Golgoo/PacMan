package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;
import sample.Model.PathFinding.AStar;

import java.util.List;

public class Ghost implements MoveableEntity {


    private int graphicId;

    private boolean alive;
    private int velocity;

    private Position position;

    private Level level;

    private DynamicMoveable dynamicGhost;

    private InputKey.Direction direction;
    private Position positionToGo;

    public Ghost(DynamicMoveable dynamicGhost, Position position, Level level) {
        this.dynamicGhost = dynamicGhost;
        this.position = position;
        this.level = level;
        this.velocity = 1;
        direction = InputKey.Direction.None;
        positionToGo = position;
    }

    @Override
    public String toString() {
        return "G";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
        this.positionToGo = position;
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

    public void computeShortestPathToGivenEntity(AStar aStar, int [][] maze, Entity entity){
        if(positionToGo.getX() != position.getX() || positionToGo.getY() != position.getY())
            return;

        System.out.println("ghost"+position);
        Position ghostPositionMaze = toMazePosition(position);
        Position entityPositionMaze = toMazePosition(entity.getPosition());
        System.out.println(ghostPositionMaze);
        AStar as = new AStar(maze, ghostPositionMaze.getX(), ghostPositionMaze.getY(), false);
        List<AStar.Node> path = as.findPathTo(entityPositionMaze.getX(), entityPositionMaze.getY());

        if(path.size() <= 1) {
            //positionToGo = position;
            direction = InputKey.Direction.None;
            return;
        }


        Position nextPosition = new Position(path.get(1).x, path.get(1).y);

        positionToGo = new Position(nextPosition.getX()*50,nextPosition.getY()*50);


        setDirectionToTake(ghostPositionMaze,nextPosition);

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

    private Position toMazePosition(Position position) {
        float xFloat = (float) position.getX();
        float yFloat = (float) position.getY();
        return new Position(Math.round(xFloat/50), Math.round(yFloat/50));
    }

    public InputKey.Direction getDirection() {
        return direction;
    }

}
