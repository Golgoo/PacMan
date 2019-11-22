package sample.Model;


import java.io.File;

public class Model {

    private Level level;


    public Model() {
        this.initializeLevel();
    }

    private void initializeLevel() {
        level = new Level(new File("src/levels/level.txt"));
    }

    public Level getLevel() {
        return level;
    }
}

