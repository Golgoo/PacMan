package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

import java.util.List;

public class PacMan implements Entity, Moveable, Living {

    private DynamicMoveable dynamicPacman;

    private boolean alive;

    private int graphicId;

    public int getGraphicId() {
        return graphicId;
    }

    @Override
    public void setGraphicId(int graphicId) {
        this.graphicId = graphicId;
    }

    public PacMan(DynamicMoveable dynamicPacman) {
        this.dynamicPacman = dynamicPacman;
    }


    @Override
    public String toString() {
        return "P";
    }

    @Override
    public void setPosition(Position position) {
        this.dynamicPacman.setPosition(position);
    }


    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        return dynamicPacman.computeNextWantedPosition(direction);
    }

    @Override
    public List<Entity> getEntitiesIntersecting(Position position) {
        return null;
    }


    @Override
    public List<Entity> move(InputKey.Direction direction) {
        //System.out.println(direction);
        List<Entity> entitiesOnSamePosition = dynamicPacman.move(direction);

        dynamicPacman.getLevel().setEntityPosition(this.getGraphicId(), getPosition().getX(), getPosition().getY());


        if (entitiesOnSamePosition.isEmpty()) {
            //System.out.println("Pas de collision");
            return entitiesOnSamePosition;
        }

        for(Entity entity : entitiesOnSamePosition)
            resolveCollision(entity);

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
        fruitEntity.consume(this,dynamicPacman.getLevel());
    }

    public void moveMove(Position nextWantedPosition, List<Entity> nextPositionEntities) {
        setPosition(nextWantedPosition);

        dynamicPacman.getLevel().setEntityPosition(this.getGraphicId(), getPosition().getX(), getPosition().getY());

        for(Entity entity : nextPositionEntities)
            resolveCollision(entity);
    }
}
