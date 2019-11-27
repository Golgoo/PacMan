package sample.view;

import graphicmotor.GooContext;
import sample.Controller.Controller;
import sample.Model.Entities.PacMan;
import sample.view.MainFrame;

import javax.swing.*;

public class MainGraphic {



    public static void main(String[] args) {

        GooContext gooCtx = new GooContext(1000, 1000);

        MainFrame mainFrame = new MainFrame(gooCtx,1000,1000);

        Controller controller = new Controller(mainFrame);
        gooCtx.start(60);
        mainFrame.setLevel(controller.getModel().getLevel());

        //TestFrame frame = new TestFrame();


    }
}
