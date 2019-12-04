package sample.Model.Entities;

import sample.Model.InputKey;


public class DynamicMoveable  {

    public Position computeNextWantedPosition(Position position, InputKey.Direction direction, int velocity) {
        if(direction == InputKey.Direction.Up)
            return new Position(position.getX(), position.getY()-velocity);
        else if(direction == InputKey.Direction.Down)
            return new Position(position.getX(), position.getY()+velocity);
        else if(direction == InputKey.Direction.Right)
            return new Position(position.getX()+velocity, position.getY());
        else if(direction == InputKey.Direction.Left)
            return new Position(position.getX()-velocity, position.getY());
        else if(direction == InputKey.Direction.None)
            return null;
        return null;
    }
}
