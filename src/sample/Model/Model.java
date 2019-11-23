package sample.Model;


import java.io.File;

public class Model {

    private Level level;


    public Model() {
        this.initializeLevel();
    }
    public Model(int width, int height) {

        this.initializeLevel(width,height);
    }
    private void initializeLevel() {
        level = new Level(new File("src/levels/level.txt"));
    }

    private void initializeLevel(int width, int height) {
        level = new Level(new File("src/levels/level.txt"), width,height);
    }

    public Level getLevel() {
        return level;
    }
}

