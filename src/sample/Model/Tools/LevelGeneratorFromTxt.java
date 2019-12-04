package sample.Model.Tools;

import sample.Model.Entities.Entity;
import sample.Model.Entities.Position;
import sample.Model.Level;

import java.io.*;
import java.util.Scanner;

import static sample.Model.Entities.FactoryEntity.getEntity;

public class LevelGeneratorFromTxt {
    int rows;
    int columns;
    Scanner scanner;
    BufferedReader lineReader;
    File file;
    Level level;


    public LevelGeneratorFromTxt(File file, Level level) {
        rows = 0;
        columns = 0;

        this.file = file;
        this.level = level;


        /*Scanner scanner = null;
        BufferedReader lineReader = null;*/

        try {
            scanner = new Scanner(file);
            lineReader = new BufferedReader(new FileReader(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void loadEntities() {
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < level.getRows(); i++) {
            for (int j = 0; j < level.getColumns(); j++) {
                if(scanner.hasNextInt()){
                    int result = scanner.nextInt();
                    Entity entity = getEntity(result, new Position(j,i),level);
                    level.addEntityToEntityList(entity);

                    level.addToMaze(result,i ,j);
                }
            }
            if(scanner.hasNextLine())
                scanner.nextLine();
        }
    }

    public void countColumnsAndRows() {
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
        level.setColumns(columns);
        level.setRows(rows);
        System.out.println("col,row"+columns +" "+rows);
    }
}
