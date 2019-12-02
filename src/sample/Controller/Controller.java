package sample.Controller;

import sample.Model.Model;
import sample.view.MainFrame;

public class Controller {

    private Model model;
    private boolean running;
    private MainFrame mainFrame;



    public Controller() {
        model = new Model();
        //gameView = new GameView();

        this.running = true;

        //gameView.update(model.getLevel());
    }

    public Controller(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        model = new Model(mainFrame.getWidth(), mainFrame.getHeight(), mainFrame.getGooContext());
        //gameView = new GameView();

        this.running = true;

        mainFrame.initialise(model.getLevel().getEntityList());

    }

    public Model getModel() {
        return model;
    }
}
