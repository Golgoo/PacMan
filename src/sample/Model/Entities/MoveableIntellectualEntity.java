package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.PathFinding.Node;
import sample.Model.PathFinding.PathFindingAlgorithm;

import java.util.List;

public interface MoveableIntellectualEntity extends MoveableEntity{

    PathFindingAlgorithm getPathFindingAlgorithm();

    List<Node> computePathToGivenEntity(Entity entity);

    void computeDirectionToGivenEntity(Entity entity);

    void setDirection(InputKey.Direction direction);
    InputKey.Direction getDirection();

}
