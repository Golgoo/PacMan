package sample.Model.Entities.Decorators;

import sample.Model.Entities.*;

import java.io.InputStream;

public class AccessibilityDecorator extends EntityDecorator {
    boolean isAccessible;

    public AccessibilityDecorator(Entity decoratedEntity, boolean isAccessible) {
        super(decoratedEntity);
        this.isAccessible = isAccessible;
    }


    @Override
    public Position getPosition() {
        return decoratedEntity.getPosition();
    }

    @Override
    public void setPosition(Position position) {
        decoratedEntity.setPosition(position);
    }

    @Override
    public boolean isAccessible() {
        return isAccessible;
    }

    @Override
    public Dimension getDimension() {
        return decoratedEntity.getDimension();
    }

    @Override
    public String getSpritePath() {
        return decoratedEntity.getSpritePath();
    }

    @Override
    public int getGraphicId() {
        return decoratedEntity.getGraphicId();
    }

    @Override
    public void setGraphicId(int graphicId) {
        decoratedEntity.setGraphicId(graphicId);
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
    public void resolveCollision(Fruit fruitEntity) {

    }
}
