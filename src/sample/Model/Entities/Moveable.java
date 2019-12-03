package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

public interface Moveable {

   Position computeNextWantedPosition(InputKey.Direction direction);
   void move(Position nextWantedPosition, List<Entity> nextPositionEntities);
   int getVelocity();
}
