package sample.Model;

import graphicmotor.GooContext;
import sample.Model.Entities.*;

import java.awt.event.KeyEvent;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static sample.Model.Entities.FactoryEntity.*;

public class Level {
    private int columns;
    private int rows;
    private int score;
    private List<Entity> entityList;
    private PacMan pacman;
    private GooContext gooContext;


    public Level(File file, int width, int height, GooContext gooContext) {
        columns = 0;
        rows = 0;
        this.gooContext = gooContext;

        Scanner scanner = null;
        BufferedReader lineReader = null;

        try {
            scanner = new Scanner(file);
            lineReader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        assert scanner != null;
        assert lineReader != null;

        countColumnsAndRows(scanner, lineReader);

        entityList = new ArrayList<>();
        this.score = 0;

        loadGrid(file);

        columns = width;
        rows = height;

        //inputKeysHandler = new InputKeysHandler();

        System.out.println(this);

    }

    public List<Entity> getEntityList() {
        return entityList;
    }


    private void loadGrid(File file) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(scanner.hasNextInt()){
                    int result = scanner.nextInt();
                    Entity entity = getEntity(result, new Position(j,i),this);
                    addEntityToEntityList(entity);

                    if(result == 3) {
                        pacman = (PacMan) entity;
                    }
                }
            }
            if(scanner.hasNextLine())
                scanner.nextLine();
        }
    }

    private void addEntityToEntityList(Entity entity) {
        if(entity != null)
            entityList.add(entity);
    }

    private void countColumnsAndRows(Scanner scanner, BufferedReader lineReader) {
        try {
            String line = lineReader.readLine();
            Scanner lineScan = new Scanner(line);

            while(lineScan.hasNextInt()){
                lineScan.nextInt();
                columns++;
            }
            lineScan.close();
            lineReader.close();

            while(scanner.hasNextLine()) {
                scanner.nextLine();
                rows++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println("col,row"+columns +" "+rows);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        for(Entity e : entityList)
            s.append(e.toString()).append(" ");
        /*for(Entity[] T : grid){
            s.append("\n");
            for(Entity elt: T)
                s.append(" ").append(elt.toString());
        }*/
        return "Level{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", Entities=" + s +
                '}';
    }



    public PacMan getPacman() {
        return pacman;
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
                System.out.println(e +"inaccessible");
                return false;
            }
        }
        return true;

    }
    public void setEntityPosition(int graphicId, int xPos, int yPos) {
        //System.out.println("setEntPos("+graphicId+",{"+xPos+","+yPos+"}");
        gooContext.setEntityPosition(graphicId, xPos, yPos);
    }

    public void removeEntity(int graphicId){
        gooContext.disableEntity(graphicId);
    }

}

