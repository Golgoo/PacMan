import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import debtool.DebugTool;
import debtool.Display;

import javax.swing.*;

public class main {
    public static void main(String[] args) {
        System.out.println("te");
        DebugTool.activeDebugTool(true,1);
        Display.infoDebug(2, "Salut");
        GLCapabilities glCapabilities = new GLCapabilities(GLProfile.getDefault());
        glCapabilities.setDoubleBuffered(true);
        GLCanvas glCanvas = new GLCanvas(glCapabilities);
        JFrame frame = new JFrame();
        frame.add(glCanvas);
        frame.setVisible(true);

    }
}
