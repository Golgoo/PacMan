package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

import java.util.ArrayList;
import java.util.List;

public class DynamicMoveable implements Moveable, Entity {

    private volatile Level level;

    private Position position;
    private double vitesse;

    public DynamicMoveable(Level currentMap, Position position) {
        this.level = currentMap;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(50,50);
    }


    @Override
    public String getSpritePath() {
        return " ";
    }

    @Override
    public void setGraphicId(int graphicId) {

    }



    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        if(direction == InputKey.Direction.Up)
            return new Position(position.getX(), position.getY()-1);
        else if(direction == InputKey.Direction.Down)
            return new Position(position.getX(), position.getY()+1);
        else if(direction == InputKey.Direction.Right)
            return new Position(position.getX()+1, position.getY());
        else if(direction == InputKey.Direction.Left)
            return new Position(position.getX()-1, position.getY());
        return null;
    }

    @Override
    public List<Entity> getEntitiesIntersecting(Position position) {
        //return level.getEntitiesIntersecting(this,position);
        List<Entity> nextPositionEntities = new ArrayList<>();
        for(Entity e : level.getEntityList()){
            if(!e.toString().equals("P")) {
                if (areEntitiesIntersected(this, e, position)) {
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

    private boolean haveSamePositions(Position position, Position position1) {
        return position.getY() == position1.getY() && position.getX() == position1.getX();
    }

    public List<Entity> move(InputKey.Direction direction){

        Position nextWantedPosition = computeNextWantedPosition(direction);

        if(isOutsideMap(nextWantedPosition)) {
            System.out.println("outside Map");
            return new ArrayList<Entity>();
        }

        List<Entity> nextPositionEntities = getEntitiesIntersecting(nextWantedPosition);

        if(areAccessibleEntities(nextPositionEntities)){
            position = nextWantedPosition;
            //System.out.println(position.toString());
            //isMoving = false;
            return nextPositionEntities;
        }
        else{
            //System.out.println("position inaccessible");
            return new ArrayList<>();
        }
    }

    private boolean isOutsideMap(Position nextWantedPosition) {
        return level.isOutsideMap(nextWantedPosition);
    }

    private boolean areAccessibleEntities(List<Entity> nextPositionEntities) {
        for(Entity e : nextPositionEntities) {
            if (!e.isAccessible()) {
                System.out.println(e +"inaccessible");
                return false;
            }
        }
        return true;

    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Level getLevel() {
        return level;
    }

    public double getVitesse() {
        return vitesse;
    }

    public void setVitesse(double vitesse) {
        this.vitesse = vitesse;
    }

    @Override
    public void resolveCollision(Collideable collideable) {

    }

    @Override
    public void resolveCollision(PacMan pacMan) {

    }

    @Override
    public void resolveCollision(Ghost ghost) {

    }

    @Override
    public void resolveCollision(FruitEntity fruitEntity) {

    }
}
