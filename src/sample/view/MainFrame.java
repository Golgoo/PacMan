package sample.view;

import graphicmotor.GooContext;
import javafx.scene.input.KeyCode;
import sample.Controller.KeyHandler;
import sample.Model.Entities.Entity;
import sample.Model.Entities.PacMan;
import sample.Model.InputKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class MainFrame extends JFrame implements KeyListener  {
    PacMan pacMan;
    GooContext gooContext;
    public MainFrame(GooContext gooCtx) throws HeadlessException {
        gooContext = gooCtx;

        this.setSize(600, 600);
        this.add(gooCtx.getCanvas());

        this.add(gooCtx.getCanvas());
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*****************START FUNCTION********************/
        gooCtx.start(60);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        InputKey.Direction direction = convertKeyToInputKey(keyEvent);
        if(direction != null){
            System.out.println(direction);
            pacMan.move(direction);
        }
    }

    private InputKey.Direction convertKeyToInputKey(KeyEvent keyEvent) {
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
            return InputKey.Direction.Down;
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
            return InputKey.Direction.Up;
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            return InputKey.Direction.Left;
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            return InputKey.Direction.Right;
        return null;
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

    public void setPacMan(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    public void initialise(List<Entity> entityList) {
        for(Entity entity : entityList) {
            String pathToSprites = entity.getSpritePath();
            int nbSpritesInALine = 6;
            long animationScheduleTimeMs = 60;


            int entityReference2 = -1/*gooContext.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs * 3 / 4)*/;

            gooContext.setEntityPosition(entityReference2, entity.getPosition().getxPos()*10, entity.getPosition().getyPos()*10);
            gooContext.setEntitySize(entityReference2, 10, 10);
            gooContext.setEntityColorMask(entityReference2, 1.0f, 0.4f, 0.1f);
            gooContext.setZIndex(entityReference2, 3);


            gooContext.enableEntity(entityReference2);


            /*int entityReference = gooContext.createAnimatedEntity(pathToSprites, nbSpritesInALine, animationScheduleTimeMs);

            gooContext.setEntityPosition(entityReference, 330, 150);
            gooContext.setEntitySize(entityReference, 0.3f, 0.35f);
            gooContext.setEntityColorMask(entityReference, 1.0f, 0.4f, 1.0f);
            gooContext.setZIndex(entityReference, 2);

            gooContext.enableEntity(entityReference);*/
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        //gooContext.destroyEntity(entityReference2);
    }
}
