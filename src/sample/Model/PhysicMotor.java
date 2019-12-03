package sample.Model;

import sample.Model.Entities.Entity;
import sample.Model.Entities.Ghost;
import sample.Model.Entities.MoveableEntity;
import sample.Model.Entities.Position;

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
            for(Ghost ghost : level.getGhosts())
                moveEntity(ghost.getDirection(), ghost);
                //moveEntity(level.getGhosts().get(0).getDirection(), level.getGhosts().get(0));
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean moveEntity(InputKey.Direction direction, MoveableEntity entity){
        Position nextWantedPosition = entity.computeNextWantedPosition(direction);

        if(nextWantedPosition == null)
            return false;

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
        //InputKey.Direction direction = inputKeysHandler.convertKeyToInputKey(keyEvent);

        //if(direction != null){
        //System.out.println(direction);
        //pacman.move(direction);
        //moveEnt(direction);
        // moveEntityVelocityTimes(direction,pacman);

        //}
    }

    public void proccessKeyRealeased(KeyEvent keyEvent) {
        if(this.keyPressed != null && inputKeysHandler.areSameKeys(this.keyPressed,keyEvent))
            this.keyPressed = null;
    }




    /*private void moveEnt(InputKey.Direction direction) {
        if(direction == InputKey.Direction.Up)
            pacman.setVelocityPos(new Position(0,-pacman.getVelocity()));
        else if(direction == InputKey.Direction.Down)
            pacman.setVelocityPos(new Position(0,pacman.getVelocity()));
        else if(direction == InputKey.Direction.Right)
            pacman.setVelocityPos(new Position(pacman.getVelocity(),0));
        else if(direction == InputKey.Direction.Left)
            pacman.setVelocityPos(new Position(-pacman.getVelocity(),0));
    }*/

    /*private void moveEntityVelocityTimes(InputKey.Direction direction, Moveable entity) {
        for (int i = 0; i < entity.getVelocity(); i++) {
            if(!moveEntity(direction, entity))
                break;
        }
    }*/


    /*private boolean moveEntity(Moveable entity){
        System.out.println("move");
        Position nextWantedPosition = entity.computeNextWantedPosition();

        if(nextWantedPosition == null)
            return false;
        if(isOutsideMap(nextWantedPosition)) {
            System.out.println("outside Map");
            return false;
        }

        List<Entity> nextPositionEntities = intersectTool.getEntitiesIntersecting((Entity) entity,nextWantedPosition, entityList);

        if(areAccessibleEntities(nextPositionEntities)){
            entity.move(nextWantedPosition, nextPositionEntities);
            return true;
        }
        else{
            //System.out.println("position inaccessible");
            return false;
        }
    }*/

}
