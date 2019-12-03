package sample.Model.Entities;


public interface Entity extends Collideable{

    Position getPosition();
    void setPosition(Position position);

    boolean isAccessible();

    Dimension getDimension();
    String getSpritePath();
    int getGraphicId();
    void setGraphicId(int graphicId);

    String toString();

}
