package sample.Model.Entities;

import sample.Model.InputKey;
import sample.Model.PathFinding.Node;
import sample.Model.PathFinding.PathFindingAlgorithm;

import java.util.List;

public interface MoveableIntellectualEntity extends MoveableEntity{

    PathFindingAlgorithm getPathFindingAlgorithm();
    void setPathFindingAlgorithm(PathFindingAlgorithm pathFindingAlgorithm);

    List<Node> computePathToGivenEntity(Entity entity);

    void computeDirectionToGivenEntity(Entity entity);

    void setDirection(InputKey.Direction direction);
    void setDirectionToTake(Position actualPosition ,Position positionToGo);

    InputKey.Direction getDirection();

}
