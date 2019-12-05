package Model.Entities.Decorators;


import Model.Entities.MoveableIntellectualEntity;

public abstract class MoveableIntellectualEntityDecorator implements MoveableIntellectualEntity {
    protected MoveableIntellectualEntity decoratedEntity;

    public MoveableIntellectualEntityDecorator(MoveableIntellectualEntity decoratedEntity) {
        super();
        this.decoratedEntity = decoratedEntity;
    }
}
