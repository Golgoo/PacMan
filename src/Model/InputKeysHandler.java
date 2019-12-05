package Model;

import java.awt.event.KeyEvent;

public class InputKeysHandler {

    public InputKey.Direction convertKeyToInputKey(KeyEvent keyEvent) {
        if(keyEvent == null)
            return InputKey.Direction.None;
        if(keyEvent.getKeyCode() == KeyEvent.VK_DOWN)
            return InputKey.Direction.Down;
        if(keyEvent.getKeyCode() == KeyEvent.VK_UP)
            return InputKey.Direction.Up;
        if(keyEvent.getKeyCode() == KeyEvent.VK_LEFT)
            return InputKey.Direction.Left;
        if(keyEvent.getKeyCode() == KeyEvent.VK_RIGHT)
            return InputKey.Direction.Right;
        return null;
    }
    public boolean areSameKeys(KeyEvent keyEvent, KeyEvent secondKeyEvent) {
        return keyEvent.getKeyCode() == secondKeyEvent.getKeyCode();
    }
}
