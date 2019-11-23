package sample.Model.Entities;


public interface Entity extends Collideable{
    Position getPosition();

    boolean isAccessible();

    int getId();

    Dimension getDimension();

    String getSpritePath();
    void setGraphicId(int graphicId);



}
