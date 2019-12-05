package sample.Model.Tools;

import sample.Model.Entities.Position;
import sample.Model.PathFinding.Node;

import java.util.List;

public class PathConverter {

    public Position convertPathToPosition(List<Node> path){
        if(path.size() <= 1) {
            //positionToGo = position;
            return null;
        }
        return new Position(path.get(1).x, path.get(1).y);
    }
}