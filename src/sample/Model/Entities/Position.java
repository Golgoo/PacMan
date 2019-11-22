package sample.Model.Entities;

import java.util.Comparator;

public class Position implements Comparator<Position> {
    int xPos, yPos;

    public Position(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public int getyPos() {return yPos;  }

    @Override
    public String toString() {
        return "Position{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                '}';
    }


    @Override
    public int compare(Position position, Position t1) {
        return 0;
    }
}
