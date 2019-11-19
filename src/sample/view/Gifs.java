package sample.view;

import javafx.scene.image.Image;

public class Gifs {

    private Image pacmanRight;
    private Image pacmanUp;
    private Image pacmanDown;
    private Image pacmanLeft;
    private Image ghost1;
    private Image ghost2;
    private Image blueGhost;

    public Image getPacmanRight() {
        return pacmanRight;
    }

    public Image getPacmanUp() {
        return pacmanUp;
    }

    public Image getPacmanDown() {
        return pacmanDown;
    }

    public Image getPacmanLeft() {
        return pacmanLeft;
    }

    public Image getGhost1() {
        return ghost1;
    }

    public Image getGhost2() {
        return ghost2;
    }

    public Image getBlueGhost() {
        return blueGhost;
    }

    public Image getWall() {
        return wall;
    }

    public Image getBigDot() {
        return bigDot;
    }

    public Image getSmallDot() {
        return smallDot;
    }

    private Image wall;
    private Image bigDot;
    private Image smallDot;

    public Gifs() {
        this.pacmanRight = new Image(getClass().getResourceAsStream("/ressources/pacmanRight.gif"));
        this.pacmanUp = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.pacmanDown = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.pacmanLeft = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.ghost1 = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.ghost2 = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.blueGhost = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.wall = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.bigDot = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
        this.smallDot = new Image(getClass().getResourceAsStream("/ressources/pacmanUp.gif"));
    }

}
