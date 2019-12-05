package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

public interface MoveableEntity extends Entity {

   Position computeNextWantedPosition(InputKey.Direction direction);
   void move(Position nextWantedPosition, List<Entity> nextPositionEntities);
   int getVelocity();
}
