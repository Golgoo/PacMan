package model.game.factory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import graphicmotor.GooContext;
import kernel.Kernel;
import model.game.GameModel;
import physic.Dimension;
import physic.PhysicMotor;
import physic.Position;
import singletons.Acessors;

public class LabFactory {
	
	private static Map<Integer, EntityBuilder> entityBuilderMap ;
	private static EntityBuilder pacmanBuilder ;
    
    private static GooContext GCtx ;
    private static PhysicMotor phyMotor ;
    private static GameModel gameModel ;
    private static Kernel kernel ;
    
    private static String levelPath ;
    private static Dimension levelDimension ;
    
    private static Dimension canvasSize ;

	private static int xOffset, yOffset ;
	private static double stepX, stepY ;
	
	public static void createLab(Kernel kernel, String levelPath, Dimension canvasSize) {
		initialization(kernel);
		LabFactory.levelPath = levelPath ;
		LabFactory.canvasSize = canvasSize;
		computeLevelDimension();
		
		computeGeometricInfos();

        readFile();
        buildEntities();
	}
	
	private static void initialization(Kernel kernel) {
		accessMotors(kernel);
		initBuilders();
	}

	private static void accessMotors(Kernel kernel) {
		gameModel = Acessors.getGameModel();
		phyMotor = Acessors.getPhysic();
		GCtx = Acessors.getGctx();
		LabFactory.kernel = kernel ;
	}

	private static void initBuilders() {
		pacmanBuilder = new PacManBuilder(phyMotor, kernel, GCtx, gameModel);
		entityBuilderMap = new HashMap<Integer, EntityBuilder>();
		entityBuilderMap.put(0, new FruitBuilder(phyMotor, kernel, GCtx, gameModel));
		entityBuilderMap.put(1, new WallBuilder(phyMotor, kernel, GCtx, gameModel));
		entityBuilderMap.put(2, new SuperFruitBuilder(phyMotor, kernel, GCtx, gameModel));
		entityBuilderMap.put(3, pacmanBuilder);
		entityBuilderMap.put(4, new SteroidBuilder(phyMotor, kernel, GCtx, gameModel));
		entityBuilderMap.put(5, new BoundBuilder(phyMotor, kernel, GCtx, gameModel));
	}
	
	private static void computeLevelDimension() {
        BufferedReader lineReader = null;

        lineReader = new BufferedReader(new InputStreamReader(Thread.currentThread().getContextClassLoader().getResourceAsStream(levelPath)));
		
        levelDimension = countColumnsAndRows(lineReader);
        
        try {
			lineReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Dimension countColumnsAndRows(BufferedReader lineReader) {
		int rows = 0, columns = 0 ;
        try {
        	String line ;
			while((line = lineReader.readLine()) != null) {
			    rows ++ ;
			    Scanner lineScan = new Scanner(line);
			    if(columns == 0) {
			    	while(lineScan.hasNextInt()){
			    		lineScan.nextInt();
			    		columns++;
			    	}   	
			    }
			    lineScan.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        return new Dimension(columns, rows);
    }
	
	
	private static void computeGeometricInfos() {
        xOffset = 0 ; yOffset = 0 ;
        double relativeYStep = (double)canvasSize.getHeight() / (double)levelDimension.getHeight();
        double relativeXStep = (double)canvasSize.getWidth() / (double)levelDimension.getWidth();
        if(relativeYStep < relativeXStep) {
        	stepY = stepX = relativeYStep ;
        	xOffset = (int) ((canvasSize.getWidth() - levelDimension.getWidth()*stepX) / 2.0);
        }else {
        	stepY = stepX = relativeXStep ;
        	yOffset = (int) ((canvasSize.getHeight() - levelDimension.getHeight()*stepY) / 2.0) ;
        }

	}
	
	
	private static void readFile() {
		Scanner scanner = new Scanner(Thread.currentThread().getContextClassLoader().getResourceAsStream(levelPath));
        int readInt ;
        
        for (int j = 0; j < levelDimension.getHeight(); j++) {
        	for (int i = 0; i < levelDimension.getWidth(); i++) {
                if(scanner.hasNextInt()){
                	readInt = scanner.nextInt();
                	Position tmpP = new Position((int)(i * stepX) + xOffset,(int) (j * stepY) + yOffset);
                    EntityBuilder entityBuilder = entityBuilderMap.get(readInt);
                    if(entityBuilder != null) {
                    	entityBuilder.addItemToBuild(tmpP, stepX, stepY);
                    }
                }
            }
            if(scanner.hasNextLine())
                scanner.nextLine();
        }
        scanner.close();
	}

	private static void buildEntities() {
		pacmanBuilder.build();
		for(EntityBuilder entityBuilder : entityBuilderMap.values()) {
			if(entityBuilder == pacmanBuilder) continue;
			entityBuilder.build();
		}
	}
}
