package Model.Entities;

import Model.InputKey;
import Model.PathFinding.Node;
import Model.PathFinding.PathFindingAlgorithm;

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
