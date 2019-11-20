package sample.Model.Entities;



public class EmptyEntity implements Entity,Consumable {

    Position position;

    public EmptyEntity(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void use() {

    }

    @Override
    public boolean isAccessible() {
        return true;
    }


    @Override
    public String toString() {
        return "E";
    }
}
