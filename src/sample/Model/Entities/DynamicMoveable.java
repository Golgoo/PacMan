package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

public class DynamicMoveable implements Moveable {

    private volatile Level currentMap;

    private Position previousPosition;
    private Position position;

    private static boolean isMoving = false;

    public DynamicMoveable(Level currentMap, Position position) {
        this.currentMap = currentMap;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public Entity move(InputKey.Direction direction){

        /*if(isMoving && !wantsToGoBack(direction))
            return null;

        isMoving = true;*/

        Entity nextEntity = getNextCell(direction);
        if(nextEntity.isAccessible()){
            previousPosition = position;
            position = nextEntity.getPosition();
            //isMoving = false;
            return nextEntity;
        }

        return null;
    }

    private boolean wantsToGoBack(InputKey.Direction direction) {
        return previousPosition == getNextCell(direction).getPosition();
    }

    public void setPosition(Position position) {
        this.position = position;
    }



    public Entity getNextCell(InputKey.Direction direction){
        if(direction == InputKey.Direction.Up)
            return getCell(position.getxPos()-1, position.getyPos());
        else if(direction == InputKey.Direction.Down)
            return getCell(position.getxPos()+1, position.getyPos());
        else if(direction == InputKey.Direction.Right)
            return getCell(position.getxPos(), position.getyPos()+1);
        else if(direction == InputKey.Direction.Left)
            return getCell(position.getxPos(), position.getyPos()-1);

        return null;
    }

    public Entity getCell(int xPos, int yPos){
        return currentMap.getCell(new Position(xPos, yPos));
    }


    public Level getCurrentMap() {
        return currentMap;
    }
}
