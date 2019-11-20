package sample.Model.Entities;

public class FactoryCell {
    public enum EntityCode {Wall,FruitCell,EmptyCell,PacMan,Ghost};

    public static Entity getCell(EntityCode entityCode, Position position){

        if(entityCode == EntityCode.EmptyCell)
            return new EmptyEntity(position);
        if(entityCode == EntityCode.FruitCell)
            return new FruitEntity(position);
        if(entityCode == EntityCode.Wall)
            return new Wall(position);


        if(entityCode == EntityCode.PacMan)
            return new EmptyEntity(position);
        if(entityCode == EntityCode.Ghost)
            return new Ghost();

        return  null;

    }
}
