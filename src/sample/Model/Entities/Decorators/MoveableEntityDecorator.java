package sample.Model.Entities.Decorators;

import sample.Model.Entities.MoveableEntity;

public abstract class MoveableEntityDecorator implements MoveableEntity {
    protected MoveableEntity decoratedEntity;

    public MoveableEntityDecorator(MoveableEntity decoratedEntity) {
        super();
        this.decoratedEntity = decoratedEntity;
    }
}
