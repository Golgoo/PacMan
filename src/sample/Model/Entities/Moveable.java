package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

public interface Moveable {

   Position computeNextWantedPosition(InputKey.Direction direction);
   List<Entity> getEntitiesIntersecting(Position position);
   List<Entity> move(InputKey.Direction direction);
}
