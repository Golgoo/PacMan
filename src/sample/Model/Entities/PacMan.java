package sample.Model.Entities;

import graphicmotor.GooContext;
import graphicmotor.animation.Animation;
import graphicmotor.animation.AnimationBank;
import sample.Model.InputKey;
import sample.Model.Level;

import java.util.List;

public class PacMan implements MoveableEntity {

    private int graphicId;


    private int velocity;

    private Position position;
    private Level level;

    private DynamicMoveable dynamicPacman;

    private int livesCount;



    @Override
    public void setGraphicId(int graphicId) {
        this.graphicId = graphicId;
    }

    @Override
    public void createGraphicEntity(GooContext gooContext) {

        AnimationBank<InputKey.Direction> animationsBank = new AnimationBank<InputKey.Direction>();
        int nbSprite = 5 ;
        long scheduleTime = 60 ;

        animationsBank.putAnimation(InputKey.Direction.Right, new Animation(getSpritePath()+"right.png", nbSprite, scheduleTime));
        animationsBank.putAnimation(InputKey.Direction.Down, new Animation(getSpritePath()+"down.png", nbSprite, scheduleTime));
        animationsBank.putAnimation(InputKey.Direction.Left, new Animation(getSpritePath()+"left.png", nbSprite, scheduleTime));
        animationsBank.putAnimation(InputKey.Direction.Up, new Animation(getSpritePath()+"up.png", nbSprite, scheduleTime));

        int ref = gooContext.createMultipleAnimatedEntity(animationsBank);


        setGraphicId(ref/*gooContext.createSingleAnimatedEntity(getSpritePath(), 5, 80)*/);
        gooContext.setEntityColorMask(getGraphicId(),1,1,0);
        gooContext.setEntityPosition(getGraphicId(), getPosition().getX() * 50, getPosition().getY() * 50);
        gooContext.setEntitySize(getGraphicId(), getDimension().getWeight(), getDimension().getHeight());
        setPosition(new Position(getPosition().getX() * 50, getPosition().getY() * 50));
        gooContext.setZIndex(getGraphicId(), 2);
        gooContext.enableEntity(getGraphicId());



    }

    public PacMan(DynamicMoveable dynamicPacman, Position position, Level level) {
        this.dynamicPacman = dynamicPacman;
        this.position = position;
        this.level = level;
        this.livesCount = 3;
        this.velocity = 2;
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
        return"src/ressources/pac-";
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


}
