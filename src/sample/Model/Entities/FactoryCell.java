package sample.Model.Entities;

public class FactoryCell {
    public enum EntityCode {Wall,FruitCell,EmptyCell,PacMan,Ghost};

    public static Cell getCell(EntityCode entityCode, Position position){

        if(entityCode == EntityCode.EmptyCell)
            return new EmptyCell(position);
        if(entityCode == EntityCode.FruitCell)
            return new FruitCell(position);
        if(entityCode == EntityCode.Wall)
            return new Wall(position);


        if(entityCode == EntityCode.PacMan)
            return new EmptyCell(position);
        if(entityCode == EntityCode.Ghost)
            return new Ghost();

        return  null;

    }
}
