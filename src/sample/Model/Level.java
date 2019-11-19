package sample.Model;

import sample.Model.Entities.*;

import java.io.*;
import java.util.Scanner;

import static sample.Model.Entities.FactoryCell.*;

public class Level {
    int columns;
    int rows;
    Cell[][] grid;
    Pacman pacman;

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
        grid = new Cell[rows][columns];
        Scanner scanner = null;
        Cell newCell;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(scanner.hasNextInt()){
                    int result = scanner.nextInt();
                    grid[i][j] = FactoryCell.getCell(EntityCode.values()[result], new Position(i,j));
                    if(result == 3)
                        pacman = new Pacman(new DynamicEntity(this,new Position(i,j)));
                }
            }
            if(scanner.hasNextLine())
                scanner.nextLine();
        }
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

        for(Cell[] T : grid){
            s.append("\n");
            for(Cell elt: T)
                s.append(" ").append(elt.toString());
        }
        return "Level{" +
                "columns=" + columns +
                ", rows=" + rows +
                ", grid=" + s +
                '}';
    }

    public Cell getCell(Position position) {
        return grid[position.getxPos()][position.getyPos()];
    }
    public void setGridCell(Cell cell){
        grid[cell.getPosition().getxPos()][cell.getPosition().getyPos()] = cell;
    }

    public Pacman getPacman() {
        return pacman;
    }
}

