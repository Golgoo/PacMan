package sample.Model.PathFinding;

import java.util.List;

public interface PathFindingAlgorithm {
    List<Node> findPathFromTo(int startX, int startY, int xend, int yend);
}
