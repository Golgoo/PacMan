package examples.KissMethod2.model.factory;


import examples.KissMethod2.physic.*;
import examples.KissMethod2.sigletons.Acessors;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import graphicmotor.GooContext;
import examples.KissMethod2.kernel.CollisionTreatment;
import examples.KissMethod2.kernel.Kernel;
import examples.KissMethod2.kernel.PacManCollideBounds;
import examples.KissMethod2.kernel.PacManCollidePastille;
import examples.KissMethod2.kernel.PacManCollideSuperFruit;
import examples.KissMethod2.model.*;
import examples.KissMethod2.model.Model.InputKey;

public class LabFactory {

	private static List<PhisicDatas> wallToBuilds ;
	private static List<PhisicDatas> fruitToBuild ;
	private static List<PhisicDatas> superFruitToBuild;
	
	private static void buildWall(Kernel kernel, PhisicDatas phiData) {
		buildWall(kernel, phiData.getPosition(), phiData.getDimension(), phiData.getVelocity());
	}
	private static void buildWall(Kernel kernel, Position p, Dimension d, Velocity v) {
		Model model = Acessors.getModel();
		Motor phyMotor = Acessors.getPhysic();
		GooContext GCtx = Acessors.getGctx();
		Entity wall = new Wall();
		phyMotor.add(wall, new PhisicDatas(p, d, new Velocity(0, 0)));
		GCtx.setEntityPosition(wall.getGraphicId(), p.getX(), p.getY());
		GCtx.setEntitySize(wall.getGraphicId(), d.getWidth(), d.getHeight());
		GCtx.enableEntity(wall.getGraphicId());
		model.walls.add(wall);
		
		Collision colision = new Collision(model.PacMan, wall);
		CollisionTreatment colisionTreatment = new PacManCollideBounds();
		phyMotor.registerCollision(colision);
		kernel.addCollisionTreatment(colision, colisionTreatment);
	}
	


	private static void buildFruit(Kernel kernel, PhisicDatas phiData) {
		Model model = Acessors.getModel();
		Motor phyMotor = Acessors.getPhysic();
		GooContext GCtx = Acessors.getGctx();
		Entity fruit = new Pastille();
		model.fruits.add(fruit);
		phyMotor.add(fruit, phiData);
		GCtx.setEntityPosition(fruit.getGraphicId(), phiData.getPosition().getX(), phiData.getPosition().getY());
		GCtx.setEntitySize(fruit.getGraphicId(), phiData.getDimension().getWidth(), phiData.getDimension().getHeight());
		GCtx.enableEntity(fruit.getGraphicId());
		
		Collision colision = new Collision(model.PacMan, fruit);
		CollisionTreatment colisionTreatment = new PacManCollidePastille();
		phyMotor.registerCollision(colision);
		kernel.addCollisionTreatment(colision, colisionTreatment);
	}
	

	private static void buildSuperFruit(Kernel kernel, PhisicDatas phiData) {
		Model model = Acessors.getModel();
		Motor phyMotor = Acessors.getPhysic();
		GooContext GCtx = Acessors.getGctx();
		Entity superFruit = new SuperFruit();
		
		model.superFruits.add(superFruit);
		phyMotor.add(superFruit, phiData);
		GCtx.setEntityPosition(superFruit.getGraphicId(), phiData.getPosition().getX(), phiData.getPosition().getY());
		GCtx.setEntitySize(superFruit.getGraphicId(), phiData.getDimension().getWidth(), phiData.getDimension().getHeight());
		GCtx.enableEntity(superFruit.getGraphicId());
		
		Collision colision = new Collision(model.PacMan, superFruit);
		CollisionTreatment colisionTreatment = new PacManCollideSuperFruit();
		phyMotor.registerCollision(colision);
		kernel.addCollisionTreatment(colision, colisionTreatment);
	}
	
	private static void buildPacMan(Kernel kernel, Position position, Dimension dimension) {
		Model model = Acessors.getModel();
		Motor phyMotor = Acessors.getPhysic();
		GooContext GCtx = Acessors.getGctx();
		
		model.PacMan = new PacMan();
		phyMotor.add(model.PacMan, new PhisicDatas(position, dimension, new Velocity(0, 0)));
		GCtx.setEntityPosition(model.PacMan.getGraphicId(), position.getX(), position.getY());
		GCtx.setEntitySize(model.PacMan.getGraphicId(), dimension.getWidth(), dimension.getHeight());
		GCtx.enableEntity(model.PacMan.getGraphicId());
		GCtx.setEntityColorMask(model.PacMan.getGraphicId(), 1.0f, 1.0f, 0.0f);
		GCtx.setMultipledAnimatedEntityAnimation(model.PacMan.getGraphicId(), InputKey.Right);
	}

	
	public static void buildLab(Kernel kernel, String labPath, Dimension frameSize) {
		Model model = Acessors.getModel();
		model.scoreEntity = new ScoreEntity();
		model.setScore(0);
		
		wallToBuilds = new LinkedList<PhisicDatas>();
		fruitToBuild = new LinkedList<PhisicDatas>();
		superFruitToBuild = new LinkedList<PhisicDatas>();
		
		File file = new File(labPath);
		
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

        Dimension totalSize = countColumnsAndRows(scanner, lineReader);
        double ratio ;
        int xOffset = 0, yOffset = 0 ;
        if(totalSize.getWidth() < totalSize.getHeight()) {
        	ratio = (double)frameSize.getHeight() / (double)totalSize.getHeight();
        	xOffset = (int) ((totalSize.getHeight() - totalSize.getWidth()) * ratio/2.0);
        	
        }else {
        	ratio = (double)frameSize.getWidth() / (double)totalSize.getWidth() ;
        	yOffset = (int) ((totalSize.getWidth() - totalSize.getHeight()) * ratio/2.0);
        }
        double stepX = ratio;
        double stepY = ratio;
        model.PacManVelocity = (int) (ratio / 12) ;
        
        
        scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace() ;
        }
        int result ;
        for (int i = 0; i < totalSize.getHeight(); i++) {
            for (int j = 0; j < totalSize.getWidth(); j++) {
                if(scanner.hasNextInt()){
                	result = scanner.nextInt();
                	Position tmpP = new Position((int)(j * stepX) + xOffset,(int) (i * stepY) + yOffset); 
                    if(result == 1) {
                    	wallToBuilds.add(new PhisicDatas(tmpP, new Dimension((int)(stepX + 1), (int)(stepY + 1)), new Velocity(0, 0) ) );
                    }else if(result == 0) {
                    	tmpP.setX(tmpP.getX() + (int)(0.3*stepX));
                    	tmpP.setY(tmpP.getY() + (int)(0.3*stepY));
                    	fruitToBuild.add(new PhisicDatas(tmpP, new Dimension((int)(stepX * 0.4), (int)(stepY * 0.4)), new Velocity(0, 0) ) );
                    }
                    else if(result == 3) {
                    	buildPacMan(kernel, new Position(tmpP.getX() + 1, tmpP.getY() + 1), new Dimension((int) (stepX * 0.7), (int) (stepY * 0.7) ) );
                    }
                    else if(result == 2) {
                    	tmpP.setX(tmpP.getX() + (int)(0.3*stepX));
                    	tmpP.setY(tmpP.getY() + (int)(0.3*stepY));
                    	superFruitToBuild.add(new PhisicDatas(tmpP, new Dimension((int)(stepX * 0.4), (int)(stepY * 0.4)), new Velocity(0, 0)));
                    }
                }
            }
            if(scanner.hasNextLine())
                scanner.nextLine();
        }
        for(PhisicDatas phiData : wallToBuilds) {
        	buildWall(kernel, phiData);
        }
        for(PhisicDatas phiData : fruitToBuild) {
        	buildFruit(kernel, phiData);
        }
        for(PhisicDatas phiData : superFruitToBuild) {
        	buildSuperFruit(kernel, phiData);
        }
        
	}

	private static Dimension countColumnsAndRows(Scanner scanner, BufferedReader lineReader) {
		int rows = 0, columns = 0 ;
        try {
            String line = lineReader.readLine();
            Scanner lineScan = new Scanner(line);

            while(lineScan.hasNextInt()){
                lineScan.nextInt();
                rows++;
            }
            lineScan.close();
            lineReader.close();

            while(scanner.hasNextLine()) {
                scanner.nextLine();
                columns++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new Dimension(rows, columns);
    }
}
