package sample.Model.Test;

import junit.framework.TestCase;
import sample.Model.Entities.Position;
import sample.Model.Entities.Wall;
import sample.Model.Level;

import java.io.File;

public class LevelTest extends TestCase {
    public void testLevelConstructor(){
        Level level = new Level(new File("./src/levels/level1.txt"));

        Position position = new Position(1,9);

        assertEquals(1, level.getCell(position).getPosition().getxPos());
        assertEquals(9, level.getCell(position).getPosition().getyPos());

        assertEquals(new Wall(new Position(1,9)).toString(), level.getCell(position).toString());
    }
}
