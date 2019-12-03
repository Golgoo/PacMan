package sample.view;

import graphicmotor.GooContext;
import sample.Model.Level;
import sample.Model.PhysicMotor;

import java.io.File;

public class MainGraphic {



    public static void main(String[] args) {

        GooContext gooCtx = new GooContext(1000, 1000);

        MainFrame mainFrame = new MainFrame(gooCtx,1000,1000);

        //Controller controller = new Controller(mainFrame);
        Level level = new Level(new File("src/levels/level1.txt"),mainFrame.getWidth(), mainFrame.getHeight(), mainFrame.getGooContext());
        //gameView = new GameView();

        mainFrame.initialise(level.getEntityList());

        PhysicMotor physicMotor = new PhysicMotor(level);

        mainFrame.setLevel(level);
        mainFrame.setPhysicMotor(physicMotor);

        physicMotor.startGame();
        //mainFrame.setLevel(controller.getModel().getLevel());

        //TestFrame frame = new TestFrame();


    }
}
