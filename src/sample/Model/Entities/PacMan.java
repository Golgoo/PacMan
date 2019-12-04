package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.Level;

import java.util.List;

public class PacMan implements MoveableEntity {

    private int graphicId;

    private Position velocityPos;

    private int velocity;

    private Position position;
    private Level level;

    private DynamicMoveable dynamicPacman;

    private int livesCount;



    @Override
    public void setGraphicId(int graphicId) {
        this.graphicId = graphicId;
    }

    public PacMan(DynamicMoveable dynamicPacman, Position position, Level level) {
        this.dynamicPacman = dynamicPacman;
        this.position = position;
        this.level = level;
        this.livesCount = 3;
        this.velocity = 2;
        this.velocityPos = new Position(0,0);
    }


    @Override
    public String toString() {
        return "P";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }


    @Override
    public Position computeNextWantedPosition(InputKey.Direction direction) {
        return dynamicPacman.computeNextWantedPosition(position,direction,getVelocity());
    }

    @Override
    public Position getPosition() {
        return position;
    }


    @Override
    public boolean isAccessible() {
        return true;
    }

    @Override
    public int getGraphicId() {
        return graphicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(40,40);
    }


    @Override
    public String getSpritePath() {
        return"src/ressources/pacmanRight.gif";
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
        livesCount--;
        System.out.println("vie perdue" +livesCount);
    }

    @Override
    public void resolveCollision(Fruit fruitEntity) {
        fruitEntity.consume(this,level);
    }

    public void move(Position nextWantedPosition, List<Entity> nextPositionEntities) {
        setPosition(nextWantedPosition);
        level.setEntityPosition(this.getGraphicId(), getPosition().getX(), getPosition().getY());
        for(Entity entity : nextPositionEntities)
            resolveCollision(entity);
    }

    @Override
    public int getVelocity() {
        return velocity;
    }

    public void setVelocityPos(Position velocityPos){
        this.velocityPos = velocityPos;
    }

}
