package Model.Entities.Decorators;

import Model.Entities.*;

public abstract class EntityDecorator implements Entity {

    protected Entity decoratedEntity;

    public EntityDecorator(Entity decoratedEntity) {
        super();
        this.decoratedEntity = decoratedEntity;
    }

}
