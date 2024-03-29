package Model;

import graphicmotor.GooContext;
import Model.Entities.*;
import Model.Entities.Decorators.AStarGhost;
import Model.Entities.Decorators.DumbGhost;
import Model.Tools.LevelGeneratorFromTxt;
import Model.PathFinding.AStar;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Level {
    private int columns;
    private int rows;
    private int score;
    private List<Entity> entityList;
    private PacMan pacman;
    private List<MoveableIntellectualEntity> ghosts;
    private GooContext gooContext;
    private int[][] maze;


    public Level(File file, int width, int height, GooContext gooContext) {
        columns = 0;
        rows = 0;
        this.gooContext = gooContext;
        LevelGeneratorFromTxt levelGeneratorFromTxt = new LevelGeneratorFromTxt(file,this);

        entityList = new ArrayList<>();
        ghosts = new ArrayList<>();

        levelGeneratorFromTxt.countColumnsAndRows();

        maze = new int[rows][columns];

        this.score = 0;

        levelGeneratorFromTxt.loadEntities();

        columns = width;
        rows = height;

        decorateGhostsBehaviour();

        System.out.println(this);

    }

    public List<Entity> getEntityList() {
        return entityList;
    }



    public void decorateGhostsBehaviour() {
        int count = 0;
        List<MoveableIntellectualEntity> newGhosts = new ArrayList<>();
        for(MoveableIntellectualEntity ghost : ghosts){
            if(count % 2 == 1)
                newGhosts.add(new DumbGhost(ghost));
            else
                newGhosts.add(new AStarGhost(ghost, this));
            count++;
        }
        ghosts = newGhosts;
    }

    public void addToMaze(int number, int i, int j){
        if(number == 0)
            maze[i][j] = 100;
        else
            maze[i][j] = 0;
    }

    public void addEntityToEntityList(Entity entity) {
        if(entity != null)
            entityList.add(entity);
    }



    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Entity e : entityList)
            s.append(e.toString()).append(" ");

        return "Level{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", Entities=" + s +
                '}';
    }



    public PacMan getPacman() {
        return pacman;
    }

    public void setPacman(PacMan pacman) {
        this.pacman = pacman;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    protected boolean isOutsideMap(Position nextWantedPosition) {
        if(nextWantedPosition.getX() < 0 || nextWantedPosition.getX() > columns+1)
            return true;
        return nextWantedPosition.getY() < 0 || nextWantedPosition.getY() > rows + 1;
    }


    protected boolean areAccessibleEntities(List<Entity> nextPositionEntities) {
        for(Entity e : nextPositionEntities) {
            if (!e.isAccessible()) {
                return false;
            }
        }
        return true;

    }
    public void setEntityPosition(int graphicId, int xPos, int yPos) {
        gooContext.setEntityPosition(graphicId, xPos, yPos);
    }

    public void removeEntity(int graphicId){
        gooContext.disableEntity(graphicId);
    }

    public List<MoveableIntellectualEntity> getGhosts() {
        return ghosts;
    }

    public void computeGhostsNextMove() {
        for(MoveableIntellectualEntity ghost : ghosts)
            ghost.computeDirectionToGivenEntity(pacman);
    }

    public int[][] getMaze() {
        return maze;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public GooContext getGooContext() {
        return gooContext;
    }
}

