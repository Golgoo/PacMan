package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

public interface Moveable {

   Position computeNextWantedPosition(InputKey.Direction direction);
   List<Entity> getEntitiesIntersecting(Position position);
   void move(Position nextWantedPosition, List<Entity> nextPositionEntities);
   int getVelocity();
   Position computeNextWantedPosition();
}
