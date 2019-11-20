package sample.Model.Entities;

import sample.Model.InputKey;

import java.util.List;

public interface Moveable {
   List<Entity> move(InputKey.Direction direction);
}
