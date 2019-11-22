package sample.Controller;


import sample.Model.InputKey;

public class KeyHandler implements EventHandler<KeyEvent> {
    PacMan pacman;
    //static volatile boolean isMoving;

    public KeyHandler(PacMan pacman) {
        this.pacman = pacman;
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        InputKey.Direction direction = convertKeyToInputKey(keyEvent);
        if(direction != null){
            System.out.println(direction);
            pacman.move(direction);
        }
    }

    private InputKey.Direction convertKeyToInputKey(KeyEvent keyEvent) {
        if(keyEvent.getCode() == KeyCode.DOWN)
            return InputKey.Direction.Down;
        if(keyEvent.getCode() == KeyCode.UP)
            return InputKey.Direction.Up;
        if(keyEvent.getCode() == KeyCode.LEFT)
            return InputKey.Direction.Left;
        if(keyEvent.getCode() == KeyCode.RIGHT)
            return InputKey.Direction.Right;
        return null;
    }
}

