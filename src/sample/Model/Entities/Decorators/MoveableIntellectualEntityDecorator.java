package sample.Model.Entities.Decorators;


import sample.Model.Entities.MoveableIntellectualEntity;

public abstract class MoveableIntellectualEntityDecorator implements MoveableIntellectualEntity {
    protected MoveableIntellectualEntity decoratedEntity;

    public MoveableIntellectualEntityDecorator(MoveableIntellectualEntity decoratedEntity) {
        super();
        this.decoratedEntity = decoratedEntity;
    }
}
