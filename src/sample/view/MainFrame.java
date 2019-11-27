package sample.view;



import graphicmotor.GooContext;
import sample.Model.Entities.Entity;
import sample.Model.Entities.PacMan;
import sample.Model.Entities.Position;
import sample.Model.InputKey;
import sample.Model.Level;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class MainFrame extends JFrame {


    PacMan pacMan;
    GooContext gooContext;
    int width;
    int height;
    int graphicIdCount;
    Level level;

    public void setLevel(Level level) {
        this.level = level;
    }

    public GooContext getGooContext() {
        return gooContext;
    }

    public MainFrame(GooContext gooCtx, int width, int height) throws HeadlessException {
        graphicIdCount = 0;
        gooContext = gooCtx;

        this.width = width;
        this.height = height;
        this.setSize(width, height);
        gooCtx.getCanvas().addKeyListener(new KeyListenerMain());
        gooCtx.getCanvas().setFocusable(true);
        gooCtx.getCanvas().setFocusTraversalKeysEnabled(false);

        this.add(gooCtx.getCanvas());

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*****************START FUNCTION********************/



    }

    public class KeyListenerMain implements  KeyListener{

        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            level.proccessKeyPressed(keyEvent);
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            /*InputKey.Direction direction = convertKeyToInputKey(keyEvent);
            if(direction != null){
                pacMan.move(direction);
            }*/
        }
    }


    public void setPacMan(PacMan pacMan) {
        this.pacMan = pacMan;
    }

    public void initialise(List<Entity> entityList) {
        int count= 0;
        for(Entity entity : entityList) {
                createEntity(entity);
        }
    }
    public void createEntity(Entity entity){
        entity.setGraphicId(gooContext.createSingleAnimatedEntity(entity.getSpritePath(), 1, 400));
        gooContext.setEntityPosition(entity.getId(), entity.getPosition().getX()*50, entity.getPosition().getY()*50);
        gooContext.setEntitySize(entity.getId(), entity.getDimension().getWeight(), entity.getDimension().getHeight());
        entity.setPosition(new Position(entity.getPosition().getX()*50, entity.getPosition().getY()*50));
        gooContext.setZIndex(entity.getId(), 2);
        gooContext.enableEntity(entity.getId());
        System.out.println("Created entity : " +entity.toString()+ "  x,y :"+entity.getPosition().getX()+" ,"+entity.getPosition().getY()) ;
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
