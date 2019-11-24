package sample.Model;


import graphicmotor.GooContext;
import sample.Controller.Controller;

import java.io.File;

public class Model {

    private Level level;


    public Model() {
        this.initializeLevel();
    }
    public Model(int width, int height) {
        this.initializeLevel(width,height);
    }


    public Model(int width, int height, GooContext gooContext) {
        level = new Level(new File("src/levels/level.txt"), width,height, gooContext);
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

