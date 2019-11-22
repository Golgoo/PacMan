package sample.Model;

import sample.Model.Entities.*;

import java.io.*;
import java.util.List;
import java.util.Scanner;

import static sample.Model.Entities.FactoryEntity.*;

public class Level {
    int columns;
    int rows;
    Entity[][] grid;
    List<Entity> entityList;
    PacMan pacman;

    public List<Entity> getEntityList() {
        return entityList;
    }

    public Level(File file) {
        columns = 0;
        rows = 0;

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

        loadGrid(file);

        Collision.setLevel(this);

        System.out.println(this);
    }

    private void loadGrid(File file) {
        grid = new Entity[rows][columns];
        Scanner scanner = null;
        Entity newEntity;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(scanner.hasNextInt()){
                    int result = scanner.nextInt();
                    Entity entity = getEntity(result, new Position(j,i));
                    addEntityToEntityList(entity);

                    /*grid[i][j]*/
                    if(result == 3) {
                        pacman = new PacMan(new DynamicMoveable(this, new Position(j, i)));
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
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for(Entity[] T : grid){
            s.append("\n");
            for(Entity elt: T)
                s.append(" ").append(elt.toString());
        }
        return "Level{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", grid=" + s +
                '}';
    }

    public Entity getCell(Position position) {
        return grid[position.getxPos()][position.getyPos()];
    }
    public void setGridCell(Entity entity){
        grid[entity.getPosition().getxPos()][entity.getPosition().getyPos()] = entity;
    }

    public PacMan getPacman() {
        return pacman;
    }
}

