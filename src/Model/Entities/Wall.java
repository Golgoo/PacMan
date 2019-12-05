package Model.Entities;


import graphicmotor.GooContext;

public class Wall implements Entity {

    private Position position;
    private int graphicId;

    public Wall(Position position) {
        this.position = position;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public boolean isAccessible() {
        return false;
    }

    @Override
    public int getGraphicId() {
        return graphicId;
    }

    @Override
    public Dimension getDimension() {
        return new Dimension(50,50);
    }

    @Override
    public void setGraphicId(int graphicId) {
        this.graphicId = graphicId;
    }

    @Override
    public void createGraphicEntity(GooContext gooContext) {
        setGraphicId(gooContext.createStaticEntity(getSpritePath()));
        gooContext.setEntityPosition(getGraphicId(), getPosition().getX() * 50, getPosition().getY() * 50);
        gooContext.setEntitySize(getGraphicId(), getDimension().getWeight(), getDimension().getHeight());
        setPosition(new Position(getPosition().getX() * 50, getPosition().getY() * 50));
        gooContext.setZIndex(getGraphicId(), 2);
        gooContext.enableEntity(getGraphicId());
    }

    @Override
    public String getSpritePath() {
        return "src/ressources/wall.png";
    }

    @Override
    public String toString() {
        return "W {"+ position.getX()+","+position.getY()+"}";
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }


    @Override
    public void resolveCollision(Collideable collideable) {

    }

    @Override
    public void resolveCollision(PacMan pacMan) {

    }

    @Override
    public void resolveCollision(Ghost ghost) {

    }

    @Override
    public void resolveCollision(Fruit fruitEntity) {

    }
}
