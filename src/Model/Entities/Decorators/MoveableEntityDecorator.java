package Model.Entities.Decorators;

import Model.Entities.MoveableEntity;

public abstract class MoveableEntityDecorator implements MoveableEntity {
    protected MoveableEntity decoratedEntity;

    public MoveableEntityDecorator(MoveableEntity decoratedEntity) {
        super();
        this.decoratedEntity = decoratedEntity;
    }
}
