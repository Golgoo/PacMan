package sample.view;

import examples.KissMethod.physic.Dimension;
import examples.KissMethod.physic.Position;
import examples.KissMethod.physic.Velocity;
import examples.KissMethod.sigletons.Acessors;
import graphicmotor.GooContext;
import sample.Model.Entities.Entity;
import sample.Model.Entities.PacMan;
import sample.Model.InputKey;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

public class MainFrame extends JFrame implements KeyListener  {

    static examples.KissMethod.physic.Dimension pacManDim = new examples.KissMethod.physic.Dimension(50, 50);
    static Position pacManPos = new Position(100, 280);
    static Velocity pacManVel = new Velocity(0, 0);

    static examples.KissMethod.physic.Dimension pastilleDim = new Dimension(20, 20);
    static Position pastillePos = new Position(500, 300);
    static Velocity pastilleVel = new Velocity(0, 0);

    PacMan pacMan;
    GooContext gooContext;
    int width;
    int height;

    public MainFrame(GooContext gooCtx, int width, int height) throws HeadlessException {
        gooContext = gooCtx;
        Acessors.setGctx(gooContext);

        this.width = width;
        this.height = height;
        this.setSize(width, height);
        this.add(gooCtx.getCanvas());

        this.add(gooCtx.getCanvas());
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*****************START FUNCTION********************/
        gooCtx.start(60);

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("Test");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("Test");
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
            createEntity(entity);
        }
    }
    public void createEntity(Entity entity){
        entity.setGraphicId(gooContext.createSingleAnimatedEntity(entity.getSpritePath(), 1, 1));
        gooContext.setEntityPosition(entity.getId(), entity.getPosition().getxPos()*50, entity.getPosition().getyPos()*50);
        gooContext.setEntitySize(entity.getId(), entity.getDimension().getWeight(), entity.getDimension().getHeight());
        gooContext.setZIndex(entity.getId(), 2);
        gooContext.enableEntity(entity.getId());
        System.out.println("Created entity : " +entity.toString()+ "  x,y :"+entity.getPosition().getxPos()*50+" ,"+entity.getPosition().getyPos()*50) ;
    }
}
