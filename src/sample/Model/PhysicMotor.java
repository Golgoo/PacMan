package sample.Model;

import sample.Model.Entities.*;

import java.awt.event.KeyEvent;
import java.util.List;

public class PhysicMotor {
    volatile private KeyEvent keyPressed;
    private IntersectTool intersectTool = new IntersectTool();
    private InputKeysHandler inputKeysHandler = new InputKeysHandler();
    private Level level;

    public PhysicMotor(Level level) {
        this.level = level;
    }

    public void startGame() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while(true){
            if(keyPressed != null){
                moveEntity(inputKeysHandler.convertKeyToInputKey(keyPressed),level.getPacman());
            }
            level.computeGhostsNextMove();
            for(MoveableIntellectualEntity ghost : level.getGhosts()) {
                moveEntity(ghost.getDirection(), ghost);
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean moveEntity(InputKey.Direction direction, MoveableEntity entity){
        Position nextWantedPosition = entity.computeNextWantedPosition(direction);

        if(nextWantedPosition == null) {
            return false;
        }

        if(level.isOutsideMap(nextWantedPosition)) {
            System.out.println("outside Map");
            return false;
        }

        List<Entity> nextPositionEntities = intersectTool.getEntitiesIntersecting(entity,nextWantedPosition, level.getEntityList());

        if(level.areAccessibleEntities(nextPositionEntities)){
            entity.move(nextWantedPosition, nextPositionEntities);
            return true;
        }
        else{
            //System.out.println("position inaccessible");
            return false;
        }
    }

    public void proccessKeyPressed(KeyEvent keyEvent) {
        if(this.keyPressed == null || !inputKeysHandler.areSameKeys(this.keyPressed,keyEvent))
            this.keyPressed = keyEvent;
    }

    public void proccessKeyRealeased(KeyEvent keyEvent) {
        if(this.keyPressed != null && inputKeysHandler.areSameKeys(this.keyPressed,keyEvent))
            this.keyPressed = null;
    }

}
