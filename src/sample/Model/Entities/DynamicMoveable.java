package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

import java.util.ArrayList;
import java.util.List;

public class DynamicMoveable  {

    public Position computeNextWantedPosition(Position position,InputKey.Direction direction) {
        if(direction == InputKey.Direction.Up)
            return new Position(position.getX(), position.getY()-1);
        else if(direction == InputKey.Direction.Down)
            return new Position(position.getX(), position.getY()+1);
        else if(direction == InputKey.Direction.Right)
            return new Position(position.getX()+1, position.getY());
        else if(direction == InputKey.Direction.Left)
            return new Position(position.getX()-1, position.getY());
        else if(direction == InputKey.Direction.None)
            return null;
        return null;
    }
}
