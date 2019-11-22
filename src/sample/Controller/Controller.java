package sample.Controller;

import sample.Model.Model;

public class Controller {

    private Model model;
    private KeyHandler keyHandler;
    private boolean running;

    public Controller() {
        model = new Model();

        this.keyHandler = new KeyHandler(model.getLevel().getPacman());
        this.running = true;

    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }


}
