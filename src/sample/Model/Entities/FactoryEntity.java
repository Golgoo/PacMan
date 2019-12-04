package sample.Model.Entities;

import sample.Model.Entities.Decorators.AccessibilityDecorator;
import sample.Model.Entities.Decorators.DumbGhost;
import sample.Model.Level;

public class FactoryEntity {

    public static class EntityCode {

        public static int getWallCode(){
            return 0;
        }
        public static int getFruitEntityCode(){
            return 1;
        }
        public static int getPacManCode(){
            return 3;
        }
        public static int getGhostCode(){
            return 4;
        }


    };

    public static Entity getEntity(int entityCode, Position position, Level level){

        if(entityCode == EntityCode.getFruitEntityCode())
            return new Fruit(position);
        if(entityCode == EntityCode.getWallCode())
            return /*new AccessibilityDecorator(*/new Wall(position)/*,true)*/;

        if(entityCode == EntityCode.getPacManCode()) {
            PacMan pacMan = new PacMan(new DynamicMoveable(), position, level);
            level.setPacman(pacMan);
            return pacMan;
        }
        if(entityCode == EntityCode.getGhostCode()) {
            MoveableIntellectualEntity ghost = new Ghost(new DynamicMoveable(), position, level);
            level.getGhosts().add(ghost);
            System.out.println("Added ghost");
            return ghost;
        }


        return  null;

    }
}
