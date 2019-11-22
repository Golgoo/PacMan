package sample.Model.Entities;

public interface Collideable {
    void resolveCollision( Collideable collideable);

    void resolveCollision( PacMan pacMan );
    void resolveCollision( Ghost ghost );
    void resolveCollision( FruitEntity fruitEntity );
}
