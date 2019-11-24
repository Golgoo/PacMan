package sample.Controller;

import graphicmotor.GooContext;
import javafx.fxml.FXML;
import sample.view.GameView;
import sample.Model.Model;
import sample.view.MainFrame;

public class Controller {

    private Model model;
    private KeyHandler keyHandler;
    @FXML private GameView gameView;
    private boolean running;
    private MainFrame mainFrame;



    public Controller() {
        model = new Model();
        //gameView = new GameView();

        this.keyHandler = new KeyHandler(model.getLevel().getPacman());
        this.running = true;

        //gameView.update(model.getLevel());
    }

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        model = new Model(mainFrame.getWidth(), mainFrame.getHeight(), mainFrame.getGooContext());
        //gameView = new GameView();

        this.keyHandler = new KeyHandler(model.getLevel().getPacman());
        this.running = true;

        mainFrame.initialise(model.getLevel().getEntityList());

    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public Model getModel() {
        return model;
    }
}
