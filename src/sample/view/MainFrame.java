package sample.view;



import graphicmotor.GooContext;
import sample.Model.Entities.Entity;
import sample.Model.Entities.Position;
import sample.Model.Level;
import sample.Model.PhysicMotor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.List;

public class MainFrame extends JFrame {

    GooContext gooContext;
    int width;
    int height;
    int graphicIdCount;
    Level level;
    PhysicMotor physicMotor;


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

        gooCtx.start(60);
        /*****************START FUNCTION********************/
    }

    public class KeyListenerMain implements  KeyListener{


        @Override
        public void keyTyped(KeyEvent keyEvent) {
        }

        @Override
        public void keyPressed(KeyEvent keyEvent) {
            //System.out.println("keyrpessed");
            physicMotor.proccessKeyPressed(keyEvent);
        }

        @Override
        public void keyReleased(KeyEvent keyEvent) {
            physicMotor.proccessKeyRealeased(keyEvent);
            /*InputKey.Direction direction = convertKeyToInputKey(keyEvent);
            if(direction != null){
                pacMan.move(direction);
            }*/
        }
    }

    public void setPhysicMotor(PhysicMotor physicMotor) {
        this.physicMotor = physicMotor;
    }

    public void initialise(List<Entity> entityList) {
        for(Entity entity : entityList) {
                createEntity(entity);
        }
    }
    public void createEntity(Entity entity){
        entity.createGraphicEntity(gooContext);
        /*if(entity.toString().substring(0, 1).equals("P")) {
            entity.setGraphicId(gooContext.createSingleAnimatedEntity(entity.getSpritePath(), 5, 80));
        }
        else{
            entity.setGraphicId(gooContext.createSingleAnimatedEntity(entity.getSpritePath(), 1, 400));
        }
        if(entity.toString().substring(0, 1).equals("F")){
            gooContext.setEntityPosition(entity.getGraphicId(), entity.getPosition().getX()*50 + ((50-entity.getDimension().getWeight())/2), entity.getPosition().getY()*50 + ((50-entity.getDimension().getHeight())/2));
            gooContext.setEntitySize(entity.getGraphicId(), entity.getDimension().getWeight(), entity.getDimension().getHeight());
            entity.setPosition(new Position(entity.getPosition().getX()*50 + ((50-entity.getDimension().getWeight())/2), entity.getPosition().getY()*50 + ((50-entity.getDimension().getHeight())/2)));
            gooContext.setZIndex(entity.getGraphicId(), 2);
            gooContext.enableEntity(entity.getGraphicId());
        }
        else {
            gooContext.setEntityPosition(entity.getGraphicId(), entity.getPosition().getX() * 50, entity.getPosition().getY() * 50);
            gooContext.setEntitySize(entity.getGraphicId(), entity.getDimension().getWeight(), entity.getDimension().getHeight());
            entity.setPosition(new Position(entity.getPosition().getX() * 50, entity.getPosition().getY() * 50));
            gooContext.setZIndex(entity.getGraphicId(), 2);
            gooContext.enableEntity(entity.getGraphicId());
        }*/
        //System.out.println("Created entity : " +entity.toString()+ "  x,y :"+entity.getPosition().getX()+" ,"+entity.getPosition().getY());
    }
}
