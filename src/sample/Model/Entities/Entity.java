package sample.Model.Entities;


public interface Entity extends Collideable{
    Position getPosition();

    boolean isAccessible();

    int getId();

    Context getGameContext();

    String getSpritePath();
}
