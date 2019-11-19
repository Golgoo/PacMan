package sample.Model.Entities;

import sample.Model.Level;

public class Collision {
    static Level level;

    public static void treatCollision (Pacman pacman, Cell cell){
        level.setGridCell(new EmptyCell(cell.getPosition()));
    }

    public static void setLevel(Level level) {
        Collision.level = level;
    }
}
