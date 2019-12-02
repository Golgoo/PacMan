package sample.Model.Entities;

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
            return new FruitEntity(position);
        if(entityCode == EntityCode.getWallCode())
            return new Wall(position);
        if(entityCode == EntityCode.getPacManCode())
            return new PacMan(new DynamicMoveable(),position,level);
        if(entityCode == EntityCode.getGhostCode())
            return new Ghost(new DynamicMoveable(),position,level);


        return  null;

    }
}
