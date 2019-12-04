package sample.Model.Entities;

import sample.Model.PathFinding.Node;
import sample.Model.PathFinding.PathFindingAlgorithm;

import java.util.List;

public interface PathFinder {

    PathFindingAlgorithm getPathFindingAlgorithm();

    List<Node> computePathToGivenEntity(Entity entity);

    void computeDirectionToGivenEntity(Entity entity);
}
