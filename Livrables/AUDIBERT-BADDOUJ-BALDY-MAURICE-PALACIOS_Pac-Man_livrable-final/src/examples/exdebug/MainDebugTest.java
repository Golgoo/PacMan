package examples.exdebug;

import debtool.*;

public class MainDebugTest {
    public static void main(String[] args) {
        DebugTool.activeDebugTool(true, 2);
        Integer x ;
        //Calcul sur x
        x = 28;
        Display.infoDebug(1, x.toString());
        Pause.getcharDebug(2);
        Assertion.debug(2,true,1);
    }
}
