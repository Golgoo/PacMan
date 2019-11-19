package sample.Model.Test;

import junit.framework.TestCase;
import sample.Model.Entities.Cell;
import sample.Model.Entities.DynamicEntity;
import sample.Model.Entities.Pacman;
import sample.Model.Entities.Position;
import sample.Model.InputKey;
import sample.Model.Level;

import java.io.File;

public class PacmanTest extends TestCase {
    public void testMove(){
        Level level = new Level(new File("./src/levels/level1.txt"));

        Pacman pacman = level.getPacman();

        Position lastPos = pacman.getPosition();
        pacman.move(InputKey.Direction.Up);
        assertEquals(lastPos,pacman.getPosition());


        Cell cellBeforeMove = pacman.move(InputKey.Direction.Right);
        assertNotSame(lastPos,pacman.getPosition());
        assertNotSame(level.getCell(pacman.getPosition()), cellBeforeMove);

        lastPos = pacman.getPosition();
        cellBeforeMove = pacman.move(InputKey.Direction.Left);
        assertNotSame(lastPos,pacman.getPosition());
        assertSame(level.getCell(pacman.getPosition()).toString(), cellBeforeMove.toString());



    }
}
