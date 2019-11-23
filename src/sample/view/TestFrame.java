package sample.view;

import examples.KissMethod.sigletons.Acessors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class TestFrame extends JFrame implements KeyListener {

    public TestFrame() throws HeadlessException {
        this.setSize(1000, 1000);
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        System.out.println("test");
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        System.out.println("test");
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
