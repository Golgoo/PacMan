package sample.Model.Entities;

import sample.Model.InputKey;

public interface Entity {
   Cell move(InputKey.Direction direction);
}
