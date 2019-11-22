package sample.Model.Test;

import junit.framework.TestCase;
import sample.Model.Entities.Entity;
import sample.Model.Entities.PacMan;
import sample.Model.Entities.Position;
import sample.Model.InputKey;
import sample.Model.Level;

import java.io.File;

public class PacManTest extends TestCase {
    public void testMove(){
        Level level = new Level(new File("./src/levels/level1.txt"));

        PacMan pacman = level.getPacman();

        /*Position lastPos = pacman.getPosition();
        pacman.move(InputKey.Direction.Up);
        assertEquals(lastPos,pacman.getPosition());


        Entity entityBeforeMove = pacman.move(InputKey.Direction.Right);
        assertNotSame(lastPos,pacman.getPosition());
        assertNotSame(level.getCell(pacman.getPosition()), entityBeforeMove);

        lastPos = pacman.getPosition();
        entityBeforeMove = pacman.move(InputKey.Direction.Left);
        assertNotSame(lastPos,pacman.getPosition());
        assertSame(level.getCell(pacman.getPosition()).toString(), entityBeforeMove.toString());*/



    }
}
