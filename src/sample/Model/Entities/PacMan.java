package sample.Model.Entities;

import Sound.Sound;
import sample.Model.InputKey;
import sample.Model.Level;

import java.util.List;

public class PacMan implements Entity, Moveable, Living {

    private DynamicMoveable dynamicPacman;

    private InputKey.Direction direction;

    private boolean alive;
    private int graphicId;

    @Override
    public void setGraphicId(int graphicId) {
        this.graphicId = graphicId;
    }

    public PacMan(DynamicMoveable dynamicPacman) {
        this.dynamicPacman = dynamicPacman;
    }

    /*public PacMan(Position position) {
        this.dynamicPacman = new DynamicMoveable()
        this.dynamicPacman = dynamicPacman;
    }*/

    @Override
    public String toString() {
        return "P";
    }



    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        return dynamicPacman.computeNextWantedPosition(direction);
    }

    @Override
    public List<Entity> getEntitiesAt(Position position) {
        return dynamicPacman.getEntitiesAt(position);
    }

    @Override
    public List<Entity> move(InputKey.Direction direction) {
        System.out.println(direction);
        List<Entity> entitiesOnSamePosition = dynamicPacman.move(direction);
        if (entitiesOnSamePosition.isEmpty())
            return entitiesOnSamePosition;
        for(Entity entity : entitiesOnSamePosition)
            resolveCollision(entity);
        /*if(newEntity != null){
            System.out.println(getPosition());
            Collision.treatCollision(this, newEntity);
            ((Consumable) newEntity).consume();
            System.out.println(dynamicPacman.getCurrentMap());
            return newEntity;
        }*/
        return null;
    }

    @Override
    public Position getPosition() {
        return dynamicPacman.getPosition();
    }


    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public int getId() {
        return graphicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(50,50);
    }


    @Override
    public String getSpritePath() {
        return"src/ressources/pacmanDown.gif";
    }


    @Override
    public boolean isAlive() {
        return alive;
    }


    @Override
    public void resolveCollision(Collideable collideable) {
        collideable.resolveCollision(this);
    }

    @Override
    public void resolveCollision(PacMan pacMan) {

    }

    @Override
    public void resolveCollision(Ghost ghost) {

    }

    @Override
    public void resolveCollision(FruitEntity fruitEntity) {
        Level level = dynamicPacman.getLevel();
        level.setScore(level.getScore()+1);
        level.getEntityList().remove(fruitEntity);
        System.out.println("Remove " + fruitEntity.toString());
        System.out.println("Score : " + level.getScore());
    }
}
