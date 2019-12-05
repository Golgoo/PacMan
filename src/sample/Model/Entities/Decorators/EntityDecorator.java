package sample.Model.Entities.Decorators;

import sample.Model.Entities.*;

public abstract class EntityDecorator implements Entity {

    protected Entity decoratedEntity;

    public EntityDecorator(Entity decoratedEntity) {
        super();
        this.decoratedEntity = decoratedEntity;
    }

}
