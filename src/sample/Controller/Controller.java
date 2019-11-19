package sample.Controller;

import javafx.fxml.FXML;
import sample.view.GameView;
import sample.Model.Model;

public class Controller {

    private Model model;
    private KeyHandler keyHandler;
    @FXML private GameView gameView;
    private boolean running;

    public Controller() {
        model = new Model();
        gameView = new GameView();

        this.keyHandler = new KeyHandler(model.getLevel().getPacman());
        this.running = true;

        gameView.update(model.getLevel());
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }


}
