package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

import java.util.ArrayList;
import java.util.List;

public class DynamicMoveable implements Moveable, Entity {

    private volatile Level level;

    private Position previousPosition;
    private Position position;

    private static boolean isMoving = false;

    public DynamicMoveable(Level currentMap, Position position) {
        this.level = currentMap;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Context getGameContext() {
        return null;
    }


    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        if(direction == InputKey.Direction.Up)
            return new Position(position.getxPos(), position.getyPos()-1);
        else if(direction == InputKey.Direction.Down)
            return new Position(position.getxPos(), position.getyPos()+1);
        else if(direction == InputKey.Direction.Right)
            return new Position(position.getxPos()+1, position.getyPos());
        else if(direction == InputKey.Direction.Left)
            return new Position(position.getxPos()-1, position.getyPos());
        return null;
    }

    @Override
    public List<Entity> getEntitiesAt(Position position) {
        List<Entity> nextPositionEntities = new ArrayList<>();
        for(Entity e : level.getEntityList()){
            if(haveSamePositions(e.getPosition(), position))
                nextPositionEntities.add(e);
        }
        return nextPositionEntities;
    }

    private boolean haveSamePositions(Position position, Position position1) {
        return position.getyPos() == position1.getyPos() && position.getxPos() == position1.getxPos();
    }

    public List<Entity> move(InputKey.Direction direction){

        Position nextWantedPosition = computeNextWantedPosition(direction);
        List<Entity> nextPositionEntities = getEntitiesAt(nextWantedPosition);
        if(areAccessibleEntities(nextPositionEntities)){
            previousPosition = position;
            position = nextWantedPosition;
            //isMoving = false;
            return nextPositionEntities;
        }

        return null;
    }

    private boolean areAccessibleEntities(List<Entity> nextPositionEntities) {
        for(Entity e : nextPositionEntities) {
            if (!e.isAccessible())
                return false;
        }
        return true;

    }

    public void setPosition(Position position) {
        this.position = position;
    }


    public Level getCurrentMap() {
        return level;
    }
}
