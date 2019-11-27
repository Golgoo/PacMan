package sample.Model;

import sample.Model.Entities.Entity;
import sample.Model.Entities.PacMan;
import sample.Model.Entities.Position;

import java.util.ArrayList;
import java.util.List;

public class IntersectTool {
    public List<Entity> getEntitiesIntersecting(Entity entity, Position nextWantedPosition, List<Entity> entityList) {
        List<Entity> nextPositionEntities = new ArrayList<>();
        for(Entity e : entityList){
            if(!e.toString().equals("P")) {
                if (areEntitiesIntersected(entity, e, nextWantedPosition)) {
                    //System.out.println("INTERSTECTED");
                    nextPositionEntities.add(e);
                }
            }
        }
        return nextPositionEntities;
    }


    private boolean areEntitiesIntersected(Entity firstEntity, Entity secondEntity, Position nextPositionFirstEntity){
        int x1FirstEntity, x2FirstEntity, y1FirstEntity, y2FirstEntity;
        int x1SecondEntity, x2SecondEntity, y1SecondEntity, y2SecondEntity;

        x1FirstEntity = /*firstEntity.getPosition().getX()*/nextPositionFirstEntity.getX();
        x2FirstEntity = x1FirstEntity + firstEntity.getDimension().getWeight();
        y1FirstEntity = /*firstEntity.getPosition().getY()*/nextPositionFirstEntity.getY();
        y2FirstEntity = y1FirstEntity + firstEntity.getDimension().getHeight();

        x1SecondEntity = secondEntity.getPosition().getX();
        x2SecondEntity = x1SecondEntity + secondEntity.getDimension().getWeight();
        y1SecondEntity = secondEntity.getPosition().getY();
        y2SecondEntity = y1SecondEntity + secondEntity.getDimension().getHeight();

        if((x1FirstEntity >= x1SecondEntity && x1FirstEntity < x2SecondEntity) || ( x2FirstEntity > x1SecondEntity && x2FirstEntity <= x2SecondEntity) /*|| ( x1SecondEntity > x1FirstEntity && x1SecondEntity < x2FirstEntity) || (x2SecondEntity > x1FirstEntity && x2SecondEntity < x2FirstEntity) */) {
            if( y1FirstEntity <= y1SecondEntity && y2FirstEntity > y1SecondEntity) {

                //System.out.println(y1FirstEntity +" < "+ y1SecondEntity + "    "+ y2FirstEntity + "> "+y1SecondEntity);

                //System.out.println(secondEntity);
                return true;
            }
            //System.out.println(y1FirstEntity +" > "+ y1SecondEntity + "    "+ y1FirstEntity + "< "+y2SecondEntity);
            //System.out.println(secondEntity);
            return y1FirstEntity >= y1SecondEntity && y1FirstEntity < y2SecondEntity;
        }
        return false;
    }
}
