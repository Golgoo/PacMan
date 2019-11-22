package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

public interface Moveable {

   Position computeNextWantedPosition(InputKey.Direction direction);
   List<Entity> getEntitiesAt(Position position);
   List<Entity> move(InputKey.Direction direction);
}
