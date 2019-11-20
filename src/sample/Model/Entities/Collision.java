package sample.Model.Entities;

import sample.Model.Level;

public class Collision {
    static Level level;

    public static void treatCollision (Pacman pacman, Entity entity){
        level.setGridCell(new EmptyEntity(entity.getPosition()));
    }

    public static void setLevel(Level level) {
        Collision.level = level;
    }
}
