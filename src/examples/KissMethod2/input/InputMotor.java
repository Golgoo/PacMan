package examples.KissMethod2.input;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import examples.KissMethod2.model.Model;
import examples.KissMethod2.physic.Motor;
import examples.KissMethod2.sigletons.Acessors;
import graphicmotor.GooContext;

public class InputMotor implements KeyListener {

    /**
     * TODO Map
     */

    @Override
    public void keyTyped(KeyEvent e) {
        Model model = Acessors.getModel();
        Motor phyMotor = Acessors.getPhysic();
        GooContext GCtx = Acessors.getGctx();
        int velocity = model.PacManVelocity ;
        if(e.getKeyChar() == 'z') {
            phyMotor.setVelocity(model.PacMan, 0, -velocity);
            GCtx.setMultipledAnimatedEntityAnimation(model.PacMan.getGraphicId(), Model.InputKey.Up);
        }else if(e.getKeyChar() == 'd') {
            phyMotor.setVelocity(model.PacMan, velocity, 0);
            GCtx.setMultipledAnimatedEntityAnimation(model.PacMan.getGraphicId(), Model.InputKey.Right);
        }else if(e.getKeyChar() == 'q') {
            phyMotor.setVelocity(model.PacMan, -velocity, 0);
            GCtx.setMultipledAnimatedEntityAnimation(model.PacMan.getGraphicId(), Model.InputKey.Left);
        }else if(e.getKeyChar() == 's') {
            phyMotor.setVelocity(model.PacMan, 0, velocity);
            GCtx.setMultipledAnimatedEntityAnimation(model.PacMan.getGraphicId(), Model.InputKey.Down);
        }
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
