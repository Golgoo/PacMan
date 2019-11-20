package sample.Model.Entities;

import sample.Model.InputKey;

public interface Moveable {
   List<Moveable> move(InputKey.Direction direction);
}
