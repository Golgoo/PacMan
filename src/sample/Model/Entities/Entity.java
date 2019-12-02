package sample.Model.Entities;


public interface Entity extends Collideable{
    Position getPosition();

    boolean isAccessible();



    Dimension getDimension();

    String getSpritePath();
    int getGraphicId();
    void setGraphicId(int graphicId);
    String toString();
    void setPosition(Position position);



}
