package sample.view;

import graphicmotor.GooContext;
import sample.Model.Level;
import sample.Model.PhysicMotor;

import java.io.File;

public class MainGraphic {



    public static void main(String[] args) {

        GooContext gooCtx = new GooContext(1000, 1000);

        MainFrame mainFrame = new MainFrame(gooCtx,1000,1000);

        Level level = new Level(new File("src/levels/level1.txt"),mainFrame.getWidth(), mainFrame.getHeight(), mainFrame.getGooContext());

        mainFrame.initialise(level.getEntityList());

        PhysicMotor physicMotor = new PhysicMotor(level);

        mainFrame.setLevel(level);
        mainFrame.setPhysicMotor(physicMotor);

        physicMotor.startGame();



    }
}
