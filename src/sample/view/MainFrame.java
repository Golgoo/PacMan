package sample.view;


import examples.KissMethod.sigletons.Acessors;
import graphicmotor.GooContext;
import sample.Model.Entities.Entity;
import sample.Model.Entities.PacMan;
import sample.Model.Entities.Position;
import sample.Model.InputKey;

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

    public GooContext getGooContext() {
        return gooContext;
    }

    public MainFrame(GooContext gooCtx, int width, int height) throws HeadlessException {
        graphicIdCount = 0;
        gooContext = gooCtx;
        Acessors.setGctx(gooContext);

        this.width = width;
        this.height = height;
        this.setSize(width, height);
        gooCtx.getCanvas().addKeyListener(new KeyListenerHandler());
        gooCtx.getCanvas().setFocusable(true);
        gooCtx.getCanvas().setFocusTraversalKeysEnabled(false);
        this.add(gooCtx.getCanvas());

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        /*****************START FUNCTION********************/
        gooCtx.start(60);

    }

    public class KeyListenerHandler implements  KeyListener{

        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            InputKey.Direction direction = convertKeyToInputKey(keyEvent);
            if(direction != null){
                //System.out.println(direction);
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
        for(Entity entity : entityList) {
            createEntity(entity);
        }
    }
    public void createEntity(Entity entity){
        entity.setGraphicId(graphicIdCount++);
        entity.setGraphicId(gooContext.createSingleAnimatedEntity(entity.getSpritePath(), 1, 1));
        gooContext.setEntityPosition(entity.getId(), entity.getPosition().getX()*50, entity.getPosition().getY()*50);
        gooContext.setEntitySize(entity.getId(), entity.getDimension().getWeight(), entity.getDimension().getHeight());
        entity.setPosition(new Position(entity.getPosition().getX()*50, entity.getPosition().getY()*50));
        gooContext.setZIndex(entity.getId(), 2);
        gooContext.enableEntity(entity.getId());
        System.out.println("Created entity : " +entity.toString()+ "  x,y :"+entity.getPosition().getX()+" ,"+entity.getPosition().getY()) ;
    }
}
